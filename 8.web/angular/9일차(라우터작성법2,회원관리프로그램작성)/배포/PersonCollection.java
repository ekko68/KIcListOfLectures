package com.data;

import java.util.ArrayList;
import java.util.HashMap;

public class PersonCollection {

	private static ArrayList<Person> list;
	private static PersonCollection instance;


	private PersonCollection() {
	    list = new ArrayList<>();
	    list.add(new Person("1", "홍길동", 20));
	    list.add(new Person("2", "이순신", 30));
	    list.add(new Person("3", "유관순", 40));
	    list.add(new Person("4", "강감찬", 50));
	    
	}

	public static PersonCollection getInstance() {
		if (instance == null) {
			instance = new PersonCollection();
		}
		return instance;
	}

	public static ArrayList<Person> getList() {
		return list;
	}

	public static void setList(ArrayList<Person> list) {
		PersonCollection.list = list;
	}
	
	
}
