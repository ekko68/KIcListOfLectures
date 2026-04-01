package com.spring.anno2;

import javax.inject.Inject;//pom.xml에서 다운로드 받은거

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;

//문자를 전송->기간을 정하기
public class SystemMoniter {
   
	private long periodTime;//기간
	//has a 관계
	//@Autowired(required=false)
	@Inject
	private SmsSender sender;
	//
	public void setPeriodTime(long periodTime) {
		this.periodTime = periodTime;
	}
	
	/*
	@Autowired
	@Required
	public void setSender(SmsSender sender) {
		this.sender = sender;
		System.out.println("setSender()호출됨=>"+sender);
	} */
	
	public String toString() {
		return "Systemoniter[periodTime="+periodTime+",sender="+sender+"]";
	}
}




