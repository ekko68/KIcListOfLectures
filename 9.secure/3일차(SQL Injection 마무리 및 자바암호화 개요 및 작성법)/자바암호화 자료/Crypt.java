package db;

public class Crypt{
     //파일암호화에 쓰이는 버퍼 크기 지정
    public static final int kBufferSize = 8192;
    public static java.security.Key key = null;
    public static final String defaultkeyfileurl = "defaultkey.key";
  
    /**
    * 비밀키 생성메소드
    * @return void
    * @exception java.io.IOException,java.security.NoSuchAlgorithmException
    */
    public static java.io.File makekey()
    throws java.io.IOException,java.security.NoSuchAlgorithmException {
        return makekey(defaultkeyfileurl);
    }

    public static java.io.File makekey(String filename) 
    throws java.io.IOException,java.security.NoSuchAlgorithmException {
        java.io.File tempfile = new java.io.File(".",filename);
        //대칭형 암호 -대칭형 암호화(DES 알고리즘 이용)1.암호화에 사용할 키를 생성
        javax.crypto.KeyGenerator generator = 
        		javax.crypto.KeyGenerator.getInstance("DES");
        generator.init(new java.security.SecureRandom());
        java.security.Key key = generator.generateKey();
        
    }

    /**
    * 지정된 비밀키를 가지고 오는 메서드
    * @return Key 비밀키 클래스
    * @exception Exception
    */
    private static java.security.Key getKey() throws Exception {
       
    }

    private static java.security.Key getKey(String fileurl) throws Exception {
        if(key == null) {
            java.io.File file = new java.io.File(fileurl);
            if(!file.exists()) { //키가 존재하지 않으면 만들어서 다시 가져온다.
                file = makekey();
            }
            if(file.exists()) {//파일이 존재한다면 객체직렬화를 통해서 불러온다.
                java.io.ObjectInputStream in = 
      new java.io.ObjectInputStream(new java.io.FileInputStream(fileurl));
                key = (java.security.Key)in.readObject();
                in.close();
            } else {
                throw new Exception("암호키객체를 생성할 수 없습니다.");
            }
        }
        return key;
    }

    //문자열 대칭 암호화->id(비밀키 암호화를 희망하는 문자열),반환(암호화된 ID)
    public static String encrypt(String ID) throws Exception {
         //매개변수값이 입력하지 않았다면 처리하지 않음
    	if(ID==null || ID.length()==0) return "";
    	//1.Chiper객체를 생성->byte[] (암호화)
    	//패딩->암호화시킬때 모자란부분->임의의문자열입력
    	Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
    	//2.Chiper초기화(암호화 옵션,키)
    	cipher.init(Cipher.ENCRYPT_MODE, getKey());
    	//3.암호화할 문자열->byte[]->암호화->byte[]
    	String test=ID; //UTF-8->한글데이터
    	byte[] inputBytes1=test.getBytes("UTF-8");
    	byte[] outputBytes1=cipher.doFinal(inputBytes1);
    	//4.BASE64Encoder클래스->문자열끝을 보완
    	BASE64Encoder encoder=new BASE64Encoder();
    	String outputStr1=encoder.encode(outputBytes1);
    	return outputStr1;
    }

    //codeID->복호화를 희망하는 문자열,String->복호화된 ID
    public static String decrypt(String codedID) throws Exception{
      
    }

    //파일대칭 암호화->infile(암호화을 희망하는 파일명),outfile(암호화된 파일명)
    public static void encryptFile(String infile, String outfile) throws Exception {
       
    }

    //infile(복호화를 희망하는 파일명),outfile(복호화된 파일명)
    public static void decryptFile(String infile, String outfile) throws Exception {
      Cipher cipher=Cipher.getInstance("DES/ECB/PKCS5Padding");
    	//2.Chiper초기화(암호화 옵션,키)
    	cipher.init(Cipher.DECRYPT_MODE, getKey());
    	//3.복호화을 희망하는 파일명->FileInputStream
    	FileInputStream in=new FileInputStream(infile);
    	FileOutputStream fileOut=
    			           new FileOutputStream(outfile);
    	//4.cipher객체->복호화시킬 파일생성(파일객체,cipher객체명)
    	CipherOutputStream out=
    			new CipherOutputStream(fileOut,cipher);
    	//파일에 암호화시킬 내용을 출력
    	byte[] buffer=new byte[kBufferSize];
    	int length;
    	while((length=in.read(buffer))!=-1)
    		out.write(buffer,0,length);//배열,0,배열크기까지
    	
    	in.close();
    	out.close();
    }

    public static void main(String[] ars) throws Exception {
        if(ars.length < 2) {
            System.out.println("USE : java com.crypto.Crypto [-d  -e  -fd  -fe] [text  inputfilename outputfilename]");
            System.exit(0);
        }

        if(ars[0].equals("-d"))
            System.out.println(Crypt.decrypt(ars[1]));

        if(ars[0].equals("-e"))
            System.out.println(Crypt.encrypt(ars[1]));

        if(ars[0].equals("-fd"))
            Crypt.decryptFile(ars[1], ars[2]);

        if(ars[0].equals("-fe"))
            Crypt.encryptFile(ars[1], ars[2]);
    }
}


