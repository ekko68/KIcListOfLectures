package j0616;

import java.lang.Thread;

public class ThreadTest {

	//내부적->메인쓰레드
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       //Thread의 이름->getName(),고유의 id로 구분->getId()
		//내부적으로 메인메서드를 실행시켜주는 원동력 쓰레드
		System.out.println(Thread.currentThread().getName());//main
		System.out.println(Thread.currentThread().getId());//1
		while(true) { //무한루프도 쓰레드의 일종
			System.out.println("main Thread 실행중");
		}
	}
}
