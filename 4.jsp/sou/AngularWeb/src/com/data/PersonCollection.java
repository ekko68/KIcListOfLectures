package com.data;

import java.util.ArrayList;
import java.util.HashMap;
//Person클래스의 데이터를 저장 or 꺼내오는 역할만 클래스

public class PersonCollection {

	private static ArrayList<Person> list; //저장된 데이터를 웹상에 꺼낼 목적
	private static PersonCollection instance;//정적 멤버변수

    //생성자->자동적으로 데이터를 저장
	private PersonCollection() {
	    list = new ArrayList<>();
	    //DB에 접속해서 데이터를 가져와서 저장시켜주는 구문
	    list.add(new Person("1", "홍길동", 20));
	    list.add(new Person("2", "이순신", 30));
	    list.add(new Person("3", "유관순", 40));
	    list.add(new Person("4", "강감찬", 50));
	}
   //DBConnectionMgr
	public static PersonCollection getInstance() {
		if (instance == null) {//객체가 생성되어있지 않다면
			instance = new PersonCollection();//PersonCollection객체를 생성
		}
		return instance;
	}
    //저장된 회원목록을 반환
	public static ArrayList<Person> getList() {
		return list;
	}
   //웹상에서 입력을 받아서 저장(입력,수정)
	public static void setList(ArrayList<Person> list) {
		PersonCollection.list = list;
	}
}
