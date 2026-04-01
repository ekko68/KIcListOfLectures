package com.apik.liket.command;

import java.sql.Date;

public class LiketCommand {
	private String id;
	private int cosnum;
	private Date day;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCosnum() {
		return cosnum;
	}
	public void setCosnum(int cosnum) {
		this.cosnum = cosnum;
	}
	public Date getDay() {
		return day;
	}
	public void setDay(Date day) {
		this.day = day;
	}
	
	
}
