package j0602;
//성적처리->국,영,수->총점->평균->등급(=학점)->출력
public class MethodEx {

	//int kor,eng,mat;
	
	//1.총점->계산목적->매개변수 O ,반환값 O ->MethodEx.calcSum(~)
	static int calcSum(int kor,int eng,int mat) {
		int t=kor+eng+mat;
		return t; //return (kor+eng+mat);
	}
	
	//2.평균->총점/과목수(정해져 있는 경우)
	static double calcAve(int tot) {
		return (double)(tot/3);
	}
	
	//2-2)평균->과목수가 변경이 있을 경우
	static double calcAve(int tot,int su) {
		return (double)(tot/su);
	}
	
	//3.등급(=학점)=>평균->등급
	char calcGrade(double a) {
		if(a<=100 && a>=90) return 'A';
		else if(a<90 && a>=80) return 'B';
		else if(a<80 && a>=70) return 'C';
		else if(a<70 && a>=60) return 'D';
		else return 'F';
	}
	//4.총점,평균,등급을 모두 출력->단순,반복->매개변수 O, 반환값X
	void display(int sum,double ave,char grade) {
		System.out.println("합계(sum)=>"+sum);
		System.out.println("평균(ave)=>"+ave);
		System.out.println("등급(grade)=>"+grade);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
         int kor=89;
         int eng=45;
         int mat=34;
         //객체생성
         MethodEx me=new MethodEx();
         //1.총점
         int tot=MethodEx.calcSum(kor, eng, mat);//클래스명.정적메서드명(~)
         //2.평균
         double ave=MethodEx.calcAve(tot);//3과목
         //3.등급->일반메서드
         char grade=me.calcGrade(ave);
         //4.계산된 모든값을 출력
         me.display(tot, ave, grade);
	}
}








