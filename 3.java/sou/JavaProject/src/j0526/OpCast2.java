package j0526;

public class OpCast2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int num1=20,num2=30;
        //printf(출력양식,출력할대상자) %d->정수값,%c(문자),%s(문자열),%f(소수점)
        System.out.printf("첫번째숫자=%d,두번째숫자=%d", num1,num2);
        System.out.println(); //줄바꿈
        System.out.print('\n');//특수기호를 이용
        //예외 조항->byte->short->int->long
        //                           char->int(자동형변환 X),명시적인 형변환 O
        //char->int로 데이터로 저장(자동형변환)
        //char 출력할때 int로 출력->(int)-명시적인 형변환을 줘야된다. 
        
        char ch='A';
        System.out.printf("문자 %c의 유니코드값은 %d\n",ch,(int)ch);
        //-------------------------------------------------------
        int ch2=ch;//자동형변환->char->int
        System.out.println("ch2="+ch2);
        //-------------------------------------------------------
        int java=90,jsp=85,oracle=70;
        //총점
        int sum=java+jsp+oracle;
        System.out.printf("sum=%d입니다.",sum);
        
        //평균
        int avg=sum/3;//소수점이 있어도 버리고 정수만 계산(int)
        double avg2=sum/3;//int->double형변환->82->82.0
        double avg3=(double)sum/3;
        System.out.println("avg="+avg+",avg2="+avg2);
        System.out.println("avg3="+avg3);//avg3=81.66666666666667
        //형식=>%f->%.소수점자리수f->%.2f
        System.out.printf("평균(avg3):%.2f",avg3);
	}
}
