package com.board.util;

public class StringUtil {
	//글내용을 볼때 엔터-><br>로 바꿔주는 클래스
	public static String parseBr(String msg){
		
		if(msg == null) return null;
		
		return msg.replace("\r\n", "<br>")
                  .replace("\n", "<br>");
	}
}