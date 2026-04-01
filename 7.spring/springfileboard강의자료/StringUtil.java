package com.board.util;

public class StringUtil {
	public static String parseBr(String msg){
		
		if(msg == null) return null;
		
		return msg.replace("\r\n", "<br>")
                  .replace("\n", "<br>");
	}
}