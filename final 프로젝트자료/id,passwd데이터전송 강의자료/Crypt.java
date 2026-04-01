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
       
    }

    //codeID->복호화를 희망하는 문자열,String->복호화된 ID
    public static String decrypt(String codedID) throws Exception{
      
    }

    //파일대칭 암호화->infile(암호화을 희망하는 파일명),outfile(암호화된 파일명)
    public static void encryptFile(String infile, String outfile) throws Exception {
       
    }

    //infile(복호화를 희망하는 파일명),outfile(복호화된 파일명)
    public static void decryptFile(String infile, String outfile) throws Exception {
      
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


