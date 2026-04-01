package utils;
public class UiUtils {
	public static String toUnicode(String str){
	    if(str==null){
	    	return null;
	    }
		try{
			byte[] b=str.getBytes("ISO-8859-1");
			return new String(b);			
		}catch(java.io.UnsupportedEncodingException uee){
			uee.printStackTrace();
			return null;
		}
	}
	public static String toLatin(String str){
		if(str==null){
	    	return null;
	    }
		try{
			byte[] b=str.getBytes();
			return new String(b, "ISO-8859-1");			
		}catch(java.io.UnsupportedEncodingException uee){
			uee.printStackTrace();
			return null;
	}
}
}