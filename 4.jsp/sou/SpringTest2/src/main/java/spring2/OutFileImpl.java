package spring2;

import java.io.FileWriter;
import java.io.IOException;

public class OutFileImpl implements OutFile {

	private String filePath;//경로명 및 만들어질 파일명저장
	
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		System.out.println("setFilePath()호출됨!"+filePath);
	}

	@Override
	public void out(String message) throws IOException {
		// TODO Auto-generated method stub
         //한글데이터 저장->FileOutputStream,FileWriter
		FileWriter fw=new FileWriter(filePath);
		fw.write(message);
		fw.close();
	}
	
	

}






