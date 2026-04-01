package j0616;

//사원정보를 입력->파일로 저장
//자바의 자료형에 맞게 저장->DataInputStream,DataOutputStream
import java.io.*;

public class Sawon {
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
       String mem_name=null;//이름
       String mem_id=null;//사번
       String mem_pwd=null;//암호
       String mem_gender=null;//성별
       String mem_age=null;//나이->int mem_age->"23"
       String mem_phone=null;//전번
       //한글로 입력
       BufferedReader br=new BufferedReader
    		                    (new InputStreamReader(System.in));
       //한글로 데이터를 저장->파일저장(FileOutputStream(영문),FileWriter(한글))
       File f=new File("c:/webtest/3.java/sawon.txt");
       FileWriter fw=new FileWriter(f,true);//파일객체명,추가모드 적용유무(true)
       System.out.println("===회원정보 입력하기===");
       //이름
       System.out.println("이름>>");
       mem_name=br.readLine();
       //ID
       System.out.println("ID>>");
       mem_id=br.readLine();
       //pwd
       System.out.println("비번>>");
       mem_pwd=br.readLine();
       //성별
       System.out.println("성별>>");
       mem_gender=br.readLine();
       //나이
       System.out.println("나이>>");
       mem_age=br.readLine();
       //전번
       System.out.println("전번>>");
       mem_phone=br.readLine();
       //파일에 저장->FileWriter<->FileReader
       fw.write(mem_name);fw.write("\r\n");//줄바꿈
       fw.write(mem_id);fw.write("\r\n");
       fw.write(mem_pwd);fw.write("\r\n");
       fw.write(mem_gender);fw.write("\r\n");
       fw.write(mem_age);fw.write("\r\n");
       fw.write(mem_phone);fw.write("\r\n");
       //입력,출력(X)->메모리 해제
       fw.close(); br.close();
	}
}




