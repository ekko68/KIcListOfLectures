package j0526;

public class Op3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println("관계,논리연산자");//boolean
        int l1=3,l2=5,l3=7;
        int l4;
        boolean b1,b2,b3; //주황색->변수는 선언되어있지만 아직값이 저장X
        boolean b4=true; //(3>2);
        //(3>5)
        System.out.println("(l1>l2)=>"+(l1>l2));//false
        //(5<7)
        System.out.println("(l2<l3)=>"+(l2<l3));//true
        //논리연산자,관계연산자
        b1=(l1>l2) && (l2<l3);
        System.out.println("(l1>l2) && (l2<l3)=>"+b1);
        //
        b2=(l1>l2) || (l2<l3);
        System.out.println("(l1>l2) || (l2<l3)=>"+b2);
        //b3
        b3=!b4;
        System.out.println("!b4=>"+b3);
        //모두 평가(&,|,^)
        b1=(l1>l2) & (l2<l3);
        System.out.println("(l1>l2) & (l2<l3)=>"+b1);//false
        
        b2=(l1>l2) | (l2<l3);
        System.out.println("(l1>l2) | (l2<l3)=>"+b2);//true
         //  T T ,F F->F 서로 값이 달라지면 참
        b3=(l1>l2) ^ (l2<l3);  // F ^ T  or T ^ F ->T
        System.out.println("(l1>l2) ^ (l2<l3)=>"+b3);//true
        
	}
}








