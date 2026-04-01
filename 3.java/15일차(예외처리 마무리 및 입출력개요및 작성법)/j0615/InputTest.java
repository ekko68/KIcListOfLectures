package j0615;

import java.util.Scanner;

//이름,국어점수->평가
public class InputTest {
    //String name,int kor; 선언 ->메서드 작성할때 매개변수 X, 반환값 O or X
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          //Scanner sc=new Scanner(System.in);//getScan()
		  InputTest it=new InputTest();//메서드 호출할려고
		  Scanner sc=it.getScan();
		  System.out.println("반환받은 객체(sc)=>"+sc);
		  it.setScan(sc);
		  
          /*System.out.println("이름?");  //setScan()
          String name=sc.next();
          System.out.println("국어?");
          int kor=sc.nextInt();*/
          
          //점수에 따라서
         /* String grade;//수우미양가 평가=>gradePrint
          if(kor>=90)
        	  grade="수";
          else if(kor>=80)
        	  grade="우";
          else if(kor>=70)
        	  grade="미";
          else if(kor>=60)
        	  grade="양";
          else 
        	  grade="가";
          System.out.println(name+"의 등급은 "+grade+"입니다.");*/
	}
	
	public Scanner getScan() {   //public String getString(){  return "dddd";}
		/*Scanner sc=new Scanner(System.in);
		return sc;*/
		return new Scanner(System.in);
	}
	public void setScan(Scanner sc) {
		System.out.println("이름?");  //setScan()
        String name=sc.next();
        System.out.println("국어?");
        int kor=sc.nextInt();
        //일반->일반메서드 호출->객체명을 생략하고 메서드명(~)
        gradePrint(name,kor);
	}
	public void gradePrint(String name,int kor) {
		 String grade;//수우미양가 평가=>gradePrint
         if(kor>=90)
       	  grade="수";
         else if(kor>=80)
       	  grade="우";
         else if(kor>=70)
       	  grade="미";
         else if(kor>=60)
       	  grade="양";
         else 
       	  grade="가";
         System.out.println(name+"의 등급은 "+grade+"입니다.");
	}
	
}




