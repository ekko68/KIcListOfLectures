package j0620;
//<?> 와일드 카드를 이용한 제너릭 방법=>메서드 호출시 매개변수값을 전달
import java.util.*;

public class WildTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //1.문자열을 저장
		//ArrayList<String> list=new ArrayList<String>();
		List<String> list=new ArrayList();
		list.add("테스트1"); list.add("테스트2"); list.add("테스트3");
		printData(list);
		
		//2.정수형저장
		List<Integer> list2=new ArrayList();
		//자동 boxing 기능(int->Integer)
		list2.add(100); list2.add(200); list2.add(new Integer(300));
		printData(list2);
		
		//3.소수점값 저장
		List<Double> list3=new ArrayList();
		list3.add(12.5); list3.add(45.6); list3.add(78.9);
		printData(list3);
		
	}
	//<?> 매개변수를 전달받을때 자료형은 그때그때 마다 바뀔수 있다.
	//                                        (List<Object> list) 대용
	public static void printData(List<?>  list) {  //(ArrayList  list)
		for(Object obj:list)
			System.out.println(obj);//obj.toString()->문자로 출력
	}
	
	
	//값을 입력을 받아서 처리해주는 메서드 작성->반환형 X, 매개변수 O
	/*public static void printData(List<String>  list) {  //(ArrayList  list)
		for(String obj:list)
			System.out.println(obj);//obj.toString()->문자로 출력
	}
	//정수형
	public static void printData2(List<Integer>  list) {  //(ArrayList  list)
		for(Integer obj:list)
			System.out.println(obj);//obj.toString()->문자로 출력
	}
	//소수점
	public static void printData3(List<Double>  list) {  //(ArrayList  list)
		for(Double obj:list)
			System.out.println(obj);//obj.toString()->문자로 출력
	}*/
	
}



