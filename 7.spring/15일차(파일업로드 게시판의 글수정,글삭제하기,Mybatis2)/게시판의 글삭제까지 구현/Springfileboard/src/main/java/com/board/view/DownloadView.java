package com.board.view;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.AbstractView;

//다운로드를 따로 처리해줄 수 있는 전용뷰 클래스

public class DownloadView extends AbstractView {

	public DownloadView() {//생성자
		//다운로드 받는 화면으로 전환
		setContentType("application/download");//text/html
	}
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		//return new ModelAndView("downloadView","downloadFile",downloadFile);
		//다운로드 받을 파일의 정보 얻어오기
		File file=(File)model.get("downloadFile");
		System.out.println("file=>"+file);
		//다운받을 파일의 타입,크기를 지정
		response.setContentType(getContentType());
        response.setContentLength((int)file.length());//다운로드 받을파일의 길이
        //브라우저별로 한글처리=>브라우저이름을 알수 있다.(User-Agent)
        String userAgent=request.getHeader("User-Agent");
        System.out.println("userAgent=>"+userAgent);
        boolean ie=userAgent.indexOf("MSIE") > -1;//못찾으면 -1 리턴
        String fileName=null;
        if(ie) {//IE라면->한글처리(다운로드 받는 파일의 한글처리부분)
        	fileName=URLEncoder.encode(file.getName(),"utf-8");
        }else {//영문인 경우 //한글->영문
        	fileName=new String(file.getName().getBytes("utf-8"),"iso-8859-1");
        }
        //대화상자에서 원하는 위치를 다운로드 대화상자에서 지정
        //Content-Disposition=>다운로드 받는위치,
        //"attachment;filename=다운로드 받을 파일명
        //exe,bat->이진파일도 다운->Content-Transfer-Encoding(속성키)
        response.setHeader("Content-Disposition",
        		                        "attachment;filename=\""+fileName+"\";" );
        response.setHeader("Content-Transfer-Encoding", "binary");
        //입출력객체를 만들어서 전송을 받는 구문
        OutputStream out=response.getOutputStream();//new OutputStream();
        FileInputStream fis=null;
        try {
        	fis=new FileInputStream(file);
        	//서버로부터 파일을 읽어들여서 다운로드 받음
        	FileCopyUtils.copy(fis, out);//다운로드받는쪽 입력객체명,출력객체명
        }catch(IOException e) {
        	e.printStackTrace();
        }finally { //예외처리와 상관없이 항상 처리해할 기능->메모리해제(DB연결해제)
        	if(fis!=null)
        		try {
        			fis.close();
        		}catch(IOException e) {}
        }
        out.flush();//입출력->양이 될때까지 그대로 버퍼에 보관X=>flush()->바로 출력
	}
}



