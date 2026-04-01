package j0619;

import java.util.*;

public class ArrayListTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Vector->메모리를 많이 차지->ArrayList,LinkedList
		//ArrayList<String> list=new ArrayList<String>();
		LinkedList<String> list=new LinkedList<String>();
        list.add("포도");//0-->뒤에다 추가-->수정 포도->오렌지
        list.add("딸기");//1
        //키위----------->2
        list.add("복숭아");//2->3
        //중간에 삽입->add(삽입할 위치,삽입할 객체명)
        list.add(2,"키위");
        //수정->set(수정할 위치,수정할 값)
        list.set(0, "오렌지");
        //삭제->remove(삭제할 데이터명) or remove(인덱스번호)=>중복데이터
        list.remove("키위");
        //배열->검색방법1
        for(int i=0;i<list.size();i++) {  //get(인덱스번호)
        	String temp=list.get(i);  //제너릭이 적용된 컬렉션은 꺼내올때 형변환필요X
        	System.out.println("temp=>"+list.get(i));
        }
        //검색방법2=>확장 for문->배열이나 컬렉션객체의 값을 꺼내올때
        System.out.println("==확장 for문==");
        for(String s:list)  //for(자료형 출력변수명:배열 또는 컬렉션객체명)
        	System.out.println(s);
	}
}



