/**
 * Copyright(c) 2001 iSavvix Corporation (http://www.isavvix.com/)
 *
 *                        All rights reserved
 *
 * Permission to use, copy, modify and distribute this material for
 * any purpose and without fee is hereby granted, provided that the
 * above copyright notice and this permission notice appear in all
 * copies, and that the name of iSavvix Corporation not be used in
 * advertising or publicity pertaining to this material without the
 * specific, prior written permission of an authorized representative of
 * iSavvix Corporation.
 *
 * ISAVVIX CORPORATION MAKES NO REPRESENTATIONS AND EXTENDS NO WARRANTIES,
 * EXPRESS OR IMPLIED, WITH RESPECT TO THE SOFTWARE, INCLUDING, BUT
 * NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 * FITNESS FOR ANY PARTICULAR PURPOSE, AND THE WARRANTY AGAINST
 * INFRINGEMENT OF PATENTS OR OTHER INTELLECTUAL PROPERTY RIGHTS.  THE
 * SOFTWARE IS PROVIDED "AS IS", AND IN NO EVENT SHALL ISAVVIX CORPORATION OR
 * ANY OF ITS AFFILIATES BE LIABLE FOR ANY DAMAGES, INCLUDING ANY
 * LOST PROFITS OR OTHER INCIDENTAL OR CONSEQUENTIAL DAMAGES RELATING
 * TO THE SOFTWARE.
 *
 */
package lys.board;

import java.sql.*;
import java.util.Properties;
import java.util.Vector;

/**
 * Manages a java.sql.Connection pool.
 *
 * @author  Anil Hemrajani
 */
public class DBConnectionMgr {

    //Ŀ�ؼ�Ǯ�� ���ͷ� ����
	//private MemberDBMgr mem =null;
    private Vector connections = new Vector(10);
    
    /*   MySQL  */
    
	private String _driver = "org.gjt.mm.mysql.Driver",
    _url = "jdbc:mysql://127.0.0.1:3307/mydb?useUnicode=true&characterEncoding=UTF-8",
    _user = "root",
    _password = "1234"; 
     
    /*
      private String _driver = "oracle.jdbc.driver.OracleDriver",
    _url = "jdbc:oracle:thin:@localhost:1521:orcl",
    _user = "test1",//scott
    _password = "t1234"; */ //tiger

    private boolean _traceOn = false;
    private boolean initialized = false;
	
	//Ŀ�ؼ��� 10�� �غ�
    private int _openConnections = 10;

    //Ŀ�ؼ�Ǯ��ü�� ����
    private static DBConnectionMgr instance = null;

    public DBConnectionMgr() {
    }

    /** Use this method to set the maximum number of open connections before
     unused connections are closed.
     */
  
    //Ŀ�ؼ�Ǯ�� ������ �����޼ҵ�
    public static DBConnectionMgr getInstance() {
        //Ŀ�ؼ�Ǯ�� ������ �ȵǾ��ִٸ�
		if (instance == null) {
            synchronized (DBConnectionMgr.class) {
                //������ �ȵǾ��ִٸ�
				if (instance == null) {
					//��ü����
                    instance = new DBConnectionMgr();
                }
            }
        }
        return instance;//ȣ���� Ŭ���������� ��ȯ
    }

    public void setOpenConnectionCount(int count) {
        _openConnections = count;
    }


    public void setEnableTrace(boolean enable) {
        _traceOn = enable;
    }


    /** Returns a Vector of java.sql.Connection objects */
    public Vector getConnectionList() {
        return connections;
    }


    /** Opens specified "count" of connections and adds them to the existing pool */
    //�ʱ⿡ ���ᰴü�� �������ִ� �޼ҵ�

	public synchronized void setInitOpenConnections(int count)
            throws SQLException {

        Connection c = null;//������ ��ü
        ConnectionObject co = null;//������ ���ᰴü
		                           //�������ִ� ��ü

        for (int i = 0; i < count; i++) {
			//count������ŭ ���ᰴü�� ����
            c = createConnection();
			//���Ϳ� ����� ���ᰴü,�뿩����
            co = new ConnectionObject(c, false);
             //���������� ���Ϳ� ���ᰴü�� �߰�
            connections.addElement(co);
            trace("ConnectionPoolManager: Adding new DB connection to pool (" + connections.size() + ")");
        }
    }


    /** Returns a count of open connections */
    public int getConnectionCount() {
        return connections.size();
    }


    /** Returns an unused existing or new connection.  */
    //���ᰴü�� ������ �޼ҵ�

	public synchronized Connection getConnection()
            throws Exception {
        if (!initialized) {
			//������ DB�� ����̹��� �޸𸮿� �ε�
            Class c = Class.forName(_driver);
			//�ڵ� ���(����̹�Ŭ����)
            DriverManager.registerDriver((Driver) c.newInstance());

            initialized = true;//���ӻ��� 
        }


        Connection c = null;
        ConnectionObject co = null;
		//��������� ���� ���ᰴü
        boolean badConnection = false;


        for (int i = 0; i < connections.size(); i++) {
			//���Ϳ� �� ���ᰴü�� �����´�.
            co = (ConnectionObject) connections.elementAt(i);

            // If connection is not in use, test to ensure it's still valid!
            if (!co.inUse) {//�������� ���� ���¶�� 
                try {
					//�������� ������ ���ᰴü ����
                    badConnection = co.connection.isClosed();
                    if (!badConnection)
                        badConnection = (co.connection.getWarnings() != null);
                } catch (Exception e) {
                    badConnection = true;
                    e.printStackTrace();
                }

                // Connection is bad, remove from pool
                if (badConnection) { //�����ʰ� ������
				    //���Ϳ��� �����϶�
                    connections.removeElementAt(i);
                    trace("ConnectionPoolManager: Remove disconnected DB connection #" + i);
                    continue;
                }

                c = co.connection;
                co.inUse = true;//������ ����

                trace("ConnectionPoolManager: Using existing DB connection #" + (i + 1));
                break;
            }
        }
        //��û�� ���´ٸ�(�����ϴٸ�)
        if (c == null) {
            c = createConnection();
            co = new ConnectionObject(c, true);
            connections.addElement(co);//���Ϳ��߰�

            trace("ConnectionPoolManager: Creating new DB connection #" + connections.size());
        }

        return c;//��ȯ
    }


    /** Marks a flag in the ConnectionObject to indicate this connection is no longer in use */
    //�ݳ����ִ� �޼ҵ�
	public synchronized void freeConnection(Connection c) {
        if (c == null)//�ݳ����ִ� ���ᰴü�� ������
            return;

        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.elementAt(i);
            //�ݳ��� ���ᰴü==�޸𸮻��� ã�� ��ü
			if (c == co.connection) {
                co.inUse = false;//�ݳ�ó��
                break;
            }
        }

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.elementAt(i);
            //10�̻��� �Ѱų� 
			//������� ������ ���ᰴü�� ������
			if ((i + 1) > _openConnections && !co.inUse)
                removeConnection(co.connection);
        }
    }

    public void freeConnection(Connection c, PreparedStatement p, ResultSet r) {
        try {
            if (r != null) r.close();
            if (p != null) p.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, Statement s, ResultSet r) {
        try {
            if (r != null) r.close();
            if (s != null) s.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, PreparedStatement p) {
        try {
            if (p != null) p.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void freeConnection(Connection c, Statement s) {
        try {
            if (s != null) s.close();
            freeConnection(c);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /** Marks a flag in the ConnectionObject to indicate this connection is no longer in use */
    public synchronized void removeConnection(Connection c) {
        if (c == null)
            return;

        ConnectionObject co = null;
        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.elementAt(i);
            if (c == co.connection) {
                try {
                    c.close();
                    connections.removeElementAt(i);
                    trace("Removed " + c.toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;
            }
        }
    }


    private Connection createConnection()
            throws SQLException {
        Connection con = null;

        try {
            if (_user == null)
                _user = "";
            if (_password == null)
                _password = "";

            Properties props = new Properties();
            props.put("user", _user);
            props.put("password", _password);

            con = DriverManager.getConnection(_url, props);
        } catch (Throwable t) {
            throw new SQLException(t.getMessage());
        }

        return con;
    }


    /** Closes all connections and clears out the connection pool */
    public void releaseFreeConnections() {
        trace("ConnectionPoolManager.releaseFreeConnections()");

        Connection c = null;
        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.elementAt(i);
            if (!co.inUse)
                removeConnection(co.connection);
        }
    }


    /** Closes all connections and clears out the connection pool */
    public void finalize() {
        trace("ConnectionPoolManager.finalize()");

        Connection c = null;
        ConnectionObject co = null;

        for (int i = 0; i < connections.size(); i++) {
            co = (ConnectionObject) connections.elementAt(i);
            try {
                co.connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            co = null;
        }

        connections.removeAllElements();
    }


    private void trace(String s) {
        if (_traceOn)
            System.err.println(s);
    }

}

//inner class�� ����
class ConnectionObject {
	//������ ���ᰴü
    public java.sql.Connection connection = null;
    public boolean inUse = false;//�뿩����

    public ConnectionObject(Connection c, boolean useFlag) {
        connection = c;
        inUse = useFlag;
    }
}
