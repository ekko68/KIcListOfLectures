package j0609;

//메서드의 반환형을 통해서 객체를 얻어오는 방법->자바프로그램->메모리사용량

public class GCCollector {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //Runtime클래스->API문서->생성자 먼저->생성자X->new연산자 사용X
	   //Runtime r=new Runtime();
		byte test[]=new byte[1024];
		test[1]=20; test[2]=34;//,,,
		System.out.println("test=>"+test);
		Runtime r=Runtime.getRuntime();//100-30=70
		System.out.println
		           ("사용메모리양:"+(r.totalMemory()-r.freeMemory())/1024+"K");
		test=null;//주소값이 지워진다.
		//수동으로 메모리를 제거->gc()
		System.gc();//수동으로 제거->System.exit(0)//프로그램 종료
		System.out.println
        ("사용메모리양:"+(r.totalMemory()-r.freeMemory())/1024+"K");
	}
}







