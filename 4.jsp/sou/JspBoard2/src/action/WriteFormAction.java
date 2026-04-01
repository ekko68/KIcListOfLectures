package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// /writeForm.do->요청을 처리해주는 클래스(액션클래스)->그 결과->jsp넘겨줌
public class WriteFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//1.요청에 따른 처리 결과 수행
		 //list.jsp(글쓰기)->신규글   ,content.jsp(글상세보기)->글쓰기(답변글)
		 int num=0,ref=1,re_step=0,re_level=0;  //writePro.jsp전달
		  
		  //content.do에서 num이하가 넘어온 것이라면 답변글이다
		  if(request.getParameter("num")!=null){
			  num=Integer.parseInt(request.getParameter("num"));
			  ref=Integer.parseInt(request.getParameter("ref"));
			  re_step=Integer.parseInt(request.getParameter("re_step"));
			  re_level=Integer.parseInt(request.getParameter("re_level"));
			  System.out.println("content.jsp에서 넘어온 매개변수값 확인");
			  System.out.println
			   ("num="+num+",ref="+ref+",re_step="+re_step+",re_level="+re_level);
		  }
		 
		//2.수행결과(변수 선언,매개변수)->request영역에 저장
		request.setAttribute("num", num);//${num}
		request.setAttribute("ref", ref);
		request.setAttribute("re_step", re_step);
		request.setAttribute("re_level", re_level);
		//3. return 경로포함해서 이동할 페이지명
		return "/writeForm.jsp";
	}
}




