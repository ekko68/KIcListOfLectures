package com.spring.anno3;

import org.springframework.beans.factory.annotation.Required;

public class Camera {

	private int number;//카메라 수

	@Required
	public void setNumber(int number) {
		this.number = number;
		System.out.println("setNumber()호출"+number);
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Camera[number="+number+"]";
	}
}


