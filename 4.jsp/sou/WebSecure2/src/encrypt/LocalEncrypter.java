package encrypt;

//암호화->패키지(java.security패키지)
import java.security.*;//Key,InvalidKeyException(키 에러발생시)
import javax.crypto.*;//BadPaddingException(패딩에러 유발) Cipher,KeyGenerator

//패딩시켜주는 클래스 Base64Encoder,Base64Decoder
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class LocalEncrypter {

	//1.암호화시 사용되는 최대 키사이즈를 지정
	private static String algorithm="DESede";//종류 ->대칭,비대칭
	//2.암호화할때 키가 필요(평문-->암호화 할때 내부적으로 필요로하는 비밀정보)
	private static Key key=null;
	//3.암호화 초기화(Cipher)
	private static Cipher cipher=null;
	
	//1.키를 만들어주는 메서드 필요->KeyGenerator객체를 통해서 키를 생성
	private static void setUp() throws Exception {
		key=KeyGenerator.getInstance(algorithm).generateKey();
		cipher=Cipher.getInstance(algorithm);
		System.out.println("cipher=>"+cipher+",key=>"+key);
	}
	
	//2.암호화시켜주는 메서드(평문(String)->byte[]->암호문(String)(패딩된 상태)
	//패딩->암호화시켜주고 남는 문자열 부분을 무작위 입력
	private static byte[] encrypt(String input) //안녕하세요
	  throws InvalidKeyException,BadPaddingException,IllegalBlockSizeException{
		//init(암호화옵션,키이름)
		cipher.init(Cipher.ENCRYPT_MODE, key);//서명
		//input(평문)==>byte[](암호화시키기위해서 담기위해서)
		byte[] inputBytes=input.getBytes();//바꾸기전의 byte[]
		//doFinal(암호화시킬 byte[] )
		//바뀐긴후 byte[] ->byte[] str=cipher.doFinal(inputBytes);
        //return str;
		return cipher.doFinal(inputBytes);//aadakgagga#as
	}
	
	//3.복호화 시켜주는 메서드(암호화->평문으로 변환)
	private static String decrypt(byte[] encryptionBytes)// aadakgagga#as
	 throws InvalidKeyException,BadPaddingException,IllegalBlockSizeException{
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] recoveredBytes=cipher.doFinal(encryptionBytes);
		//복호화된 byte[]->String으로 변환->웹에 출력
		String recovered=new String(recoveredBytes);
		return recovered;//안녕하세요
	}
	
	//4.입력받은 문자열->BASE64Encoder->String(웹상에 출력)암호화
	//returnEncryptCode(안녕)->setUp(키,cipher생성)->encrypt()호출
	public static String returnEncryptCode(String str) throws Exception {
		byte[] encryptionBytes=null;//암호화시켜서 담을 배열
		setUp();//key,cipher
		encryptionBytes=encrypt(str);
		//패딩작업
		BASE64Encoder encoder=new BASE64Encoder();
		//암호화된 byte[]값을 ->String으로 변환(패딩작업)
		String encodeString=encoder.encode(encryptionBytes);
		return encodeString;
	}
	
	//5.입력받은 문자열->BASE64Decoder->String(decoder)해주는 복호화 메서드
	public static String returnDecryptCode(String str) throws Exception{
		BASE64Decoder decoder=new BASE64Decoder();
		//복호화 된 문자열을 그대로 문자열X
		String decode=decrypt(decoder.decodeBuffer(str));
		//String decode=decrypt(str);//1.복호화된 문자열을 받음(패딩X)
		//return decoder.decodeBuffer(decode);//2.패딩작업(O)
		return decode;
	}
}











