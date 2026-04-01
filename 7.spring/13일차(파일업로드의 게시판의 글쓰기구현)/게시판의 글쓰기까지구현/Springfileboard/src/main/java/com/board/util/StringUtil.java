package com.board.util;

//글내용 ->enter가 포함->웹에 출력(enter-><br>로 변경)
//<pre></pre>로 대용
public class StringUtil {
	public static String parseBr(String msg){
		
		if(msg == null) return null;
		return msg.replace("\r\n", "<br>")
                          .replace("\n", "<br>");
	}
}