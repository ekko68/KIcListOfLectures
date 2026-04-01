package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// /deletePro.do->num,pageNum,passwd->deleteArticle호출

import lys.board.*;

public class DeleteProAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		String pageNum=request.getParameter("pageNum");
        int num=Integer.parseInt(request.getParameter("num"));
        String passwd=request.getParameter("passwd");
        System.out.println ("deletePro.do의 pageNum="+pageNum+
                                                         ",num="+num+",passwd="+passwd);
        //삭제메서드 호출
        BoardDAO dbPro=new BoardDAO();
        //select passwd from board where num=? ->dbpasswd 저장
        //if(dbpasswd.equals(passwd){ delete from board where num=?)
        int check=dbPro.deleteArticle(num,passwd);//삭제성공유무
        
        //요청을 받아서 처리하는 동안만 메모리상에 공유
        request.setAttribute("pageNum", pageNum);
        request.setAttribute("check", check);
        //로그인 하는 동안 계속해서 메모리상에 공유
        //session.setAttribute("pageNum",pageNum);
        
		return "/deletePro.jsp";
	}

}
