package j0612;

//도형을 선택(원,직사각형)->공통으로 사용되는 멤버변수,메서드필요

public abstract class Shape {
     public double res=0;//면적을 저장할 변수(모든 도형에서 공통으로 사용하는 면적)
     //원
     public abstract double area(int r);//r*r*3.14~
     //직사각형
     public abstract double area(int w,int h);
     //? 삼각형
     //일반메서드
     public void printArea() {
    	 System.out.println("도형의 면적은"+res+"입니다.");
     }
}




