package j0614;

import j0614.abc.*;

public class Test2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
           Chongmu ch=new Chongmu();
           ch.print();//변경전 str출력
           ch.str="라이브러리연습";
           ch.print();//변경후 str출력
           Developer de=new Developer();
           de.setStr2("라이브러리연습");
           de.print2();
	}
}




