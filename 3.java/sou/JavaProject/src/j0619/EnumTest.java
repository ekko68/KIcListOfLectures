package j0619;

import java.util.*;

//제너릭?, Map(Hashtable,HashMap)+검색(Enumeration,Iterator)

public class EnumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         Vector<String> v=new Vector<String>();
         v.add("test1"); v.add("test2"); v.add("test3");
         System.out.println("해쉬테이블(Map)");
         //Hashtable<Integer,String> h=new Hashtable<Integer,String>();
         HashMap<Integer,String> h=new HashMap<Integer,String>();
         h.put(1,"홍길동"); h.put(2, "테스트");h.put(3, "010-1234-8976");
         String tel=h.get(3);//get(검색할 키명)->키를 알고 있으면 검색속도가 제일 빠르다
         System.out.println("tel=>"+tel);
         
         //1.공통으로 검색(Enumeration->배열의 값을 출력)
         Enumeration<String> eu=v.elements();//String->(String)Object
         while(eu.hasMoreElements()) //검색해서 꺼내올 객체가 존재한다면
        	 System.out.println(eu.nextElement());
         //2.Iterator->책꽂이에 들어가 있는 책을 연상->책을 꺼내올때 순서중요X
         Iterator<String> ih=v.iterator();
         while(ih.hasNext())//검색해서 꺼내올 객체가 존재한다면
        	 System.out.println(ih.next());
         System.out.println("hashtable에서의 iterator를 이용");
         /*Collection c=h.values();//메서드의 반환형을 통해서 
         Iterator<String> ih2=c.iterator();*/
         Iterator<String> ih2=h.values().iterator();
         //Iterator<String> ih3=new Iterator<String>();
         while(ih2.hasNext())
        	 System.out.println(ih2.next());
	}
}





