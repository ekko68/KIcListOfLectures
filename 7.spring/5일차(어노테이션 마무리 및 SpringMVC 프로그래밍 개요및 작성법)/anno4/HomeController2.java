package com.spring.anno4;

import javax.annotation.*;

// 빈즈객체를 가져올때 호출되는 메서드(SetCamera())
//@
public class HomeController2 {

	private Camera camera;//new Camera();
	
	@Resource(name="camera5")
	public void setCamera(Camera camera) {
		this.camera = camera;
		System.out.println("camera5이름을 가진 setCamera()호출됨");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("빈즈객체 생성전에 초기화작업(init)호출됨");
	}
	
	@PreDestroy
	public void close() {
		System.out.println("빈즈객체 생성후에 메모리해제(close)호출됨");
	}
	
	
	
	
	
	
	
}

