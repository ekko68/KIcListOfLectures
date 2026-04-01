package com.board.util;

import java.io.File;

//파일업로드시 업로드 할 경로지정 및 파일의 새이름을 부여(공통 모듈)

public class FileUtil {
    //업로드 및 다운로드 경로
	public static final String UPLOAD_PATH="C:/webtest/4.jsp/sou/Springfileboard/src/main/webapp/upload";
	
	//탐색기의 원본파일명만 받는 역할(test.txt)
	public static String rename(String filename) throws Exception {
		if(filename==null) return null; //업로드 X 이름변경X
		//새이름 규칙->시스템날짜+랜덤숫자(0~49)
		String newName=Long.toString(System.currentTimeMillis())+
				                   (int)(Math.random()*50);
		System.out.println("newName(난수)=>"+newName);
		return rename(filename,newName);
	}
	//실제로 새로운 파일명을 변경하는 역할(확장자 구분->변경된이름만 구해서)
	//ex) testkiamaaaaaa.txt(뒤에서 검색)->1234aDSDDA.TXT
	public static String rename(String filename,String newName) throws Exception{
		if(filename==null) return null; 
		//확장자 구하기
		int idx=filename.lastIndexOf("."); //못찾으면 -1을 리턴
		String extention="";//확장자를 저장
		String newFileName="";//새파일명을 저장
		if(idx!=-1) { //찾았다면
			extention=filename.substring(idx);
			System.out.println("extention=>"+extention);
		}
		//새파일명
		int newIdx=newName.lastIndexOf(".");//확장자를 포함한 변경된 파일명
		if(newIdx!=-1) {
			newName=newName.substring(0,newIdx);//0은 포함->newIdx-1
			System.out.println("newName(변경된파일명)=>"+newName);
		}
		newFileName=newName+extention.toLowerCase();//확장자(대)->소문자로
		return newFileName;//실질적으로 업로드된 파일명
	}
	//글수정->업로드된 파일도 수정->기존업로드된 파일 삭제->새로 업로드됨
	//파일 삭제->수정목적
	public static void removeFile(String filename) {
		File file=new File(UPLOAD_PATH,filename);//경로명,파일명
		if(file.exists())  file.delete();//파일이 이경로에 존재한다면 삭제시켜라
	}
}









