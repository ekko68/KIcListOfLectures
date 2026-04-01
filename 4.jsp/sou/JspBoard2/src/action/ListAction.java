package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//
import lys.board.*;
import java.util.*;

// /list.do=actionListAction(���ó��Ŭ����=������(�׼�)
public class ListAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		
		   String pageNum=request.getParameter("pageNum");
		   //�߰�(�˻��о�,�˻���)
		   String search=request.getParameter("search");
		   String searchtext=request.getParameter("searchtext");
		   
		   int count=0;//�ѷ��ڵ��
		   List articleList=null;//ȭ�鿡 ����� ���ڵ嵥����
		   
		   BoardDAO dbPro=new BoardDAO();
		   count=dbPro.getArticleSearchCount(search,searchtext);
		   System.out.println("���� �˻��ȼ�(count)=>"+count);
		   
		   Hashtable<String,Integer> pgList=dbPro.pageList(pageNum, count);
		   if(count > 0){
			 System.out.println(pgList.get("startRow")+","+pgList.get("endRow"));
			 articleList=dbPro.getBoardArticles(pgList.get("startRow"), 
					                                             pgList.get("pageSize"), 
					                                             search, searchtext);
		   }else {
			   articleList=Collections.EMPTY_LIST;//�ƹ��͵� ���ٴ� ǥ��
		   }
		  
		   //2.ó�����->request��ü�� ���屸��
		   request.setAttribute("search", search);//�˻��о�
		   request.setAttribute("searchtext", searchtext);//�˻���
		   request.setAttribute("pgList", pgList);//����¡ó�� 10������
		   request.setAttribute("articleList", articleList);//${articleList}
		   
		   //3.�������� forward�� �̵�
		return "/list.jsp";  //  /board/list.jsp
	}
}



