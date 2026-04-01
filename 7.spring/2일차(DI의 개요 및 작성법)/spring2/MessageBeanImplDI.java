package spring2;

//MessageBeanDI을 상속받아서 자식클래스 작성
public class MessageBeanImplDI implements MessageBeanDI {

	private String name1,name2;//생성자를 값을 저장
	private String greeting;//Setter Method
	
	//-----has a 관계----------------------------------------
	private OutFile outF; //인터페이스형으로 받아옴
	
	public void setOutF(OutFile outF) {
		this.outF = outF;
		System.out.println("setOutF()호출됨(outF)=>"+outF);
	}
    //----------------------------------------------------------
	//1.멤버변수의 값을 초기화->생성자를 사용
	//<constructor-arg>태그를 통해서 값을 임의로 지정해서 값을 전달
	public MessageBeanImplDI(String name1, String name2) {
		this.name1 = name1;//this.name1="대한민국"
		this.name2 = name2;//this.name2="서울"
		System.out.println("MessageBeanImplDi 생성자 호출됨!");
	}
	
	//2.Setter Method-><property>태그
	public void setGreeting(String greeting) {
		this.greeting=greeting;//this.greeting("안녕,");
		System.out.println("setGreeting() 호출됨!");
	}

	@Override
	public void sayHello() {
		// TODO Auto-generated method stub
       String message=greeting+name1+","+name2+"!";
       System.out.println("message=>"+message);
       //파일에 내용을 출력
       try {
    	   outF.out(message);
       }catch(Exception e) {
    	   e.printStackTrace();
       }
       //-------------------------------
	}

}





