package com.apik.person.util;

//글 내용 -> enter가 포함 -> web에 출력 (enter -> <br>로 변경하는 구문)
//현재는 <pre></pre> 태그안에 문자열을 입력하면, 공백도 모두 포함하기 때문에 잘 사용하지 않음.
public class StringUtil {
	public static String parseBr(String msg){
		
		if(msg == null) return null;
		
		return msg.replace("\r\n", "<br>")
                  .replace("\n", "<br>");
	}
}