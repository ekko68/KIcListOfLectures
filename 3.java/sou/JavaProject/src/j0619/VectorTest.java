package j0619;

import java.util.*;//Scanner ,java.io.*(입출력)

public class VectorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//클래스명<자료형>-->꺼내올때 형변환할 필요가 없다.
		Vector v=new Vector();
         //Vector<String> v=new Vector<String>();//new Vector(1,1); //초기값,증가치
         v.add("테스트");//v.add(new String("테스트"));->0
         //v.add(100);//->v.add(new Integer(100)); 자동 boxing
         v.addElement("임시테스트2");
         v.add("테스트2");
         System.out.println("v의 크기(size)=>"+v.size());
         //값출력
         for(int i=0;i<v.size();i++) {
        	 String temp=(String)v.elementAt(i);
        	 System.out.println("temp=>"+temp);
        	 //System.out.println("temp=>"+v.elementAt(i));//자동형변환
         }
         //다양한 값을 저장
         Vector v2=new Vector();
         v2.add(new Character('a'));//v2.add('c');//0
         //3.141592->1
         v2.addElement(100);//1->2-->100->"Set"
         //중간에 값을 추가(insert)
         v2.insertElementAt(3.141592, 1);//저장할 객체명,삽입할 인덱스번호
        //수정->setElementAt(수정할 객체명,수정할 인덱스위치)
         v2.setElementAt("Set",2);
         //출력
         for(int i=0;i<v2.size();i++) {
        	 System.out.println("v2의 값=>"+v2.elementAt(i));
         }
	}
}






