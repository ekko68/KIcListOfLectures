package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//추가
import lys.board.*;

// conent.do?num=2&pageNum=1
public class ContentAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		//list.jsp에서 링크 content.do?num=3&pageNum=1
		  int num=Integer.parseInt(request.getParameter("num"));
		  String pageNum=request.getParameter("pageNum");
		  
		  BoardDAO dbPro=new BoardDAO();
		  //update board set readcount=readcount+1 where num=?
		  //select * from board where num=?
		  BoardDTO article=dbPro.getArticle(num);
		  //링크문자열의 길이를 줄이기위해서
		  int ref=article.getRef();
		  int re_step=article.getRe_step();
		  int re_level=article.getRe_level();
		  System.out.println("content.do의 매개변수");
		  System.out.println("ref->"+ref+",re_step->"+re_step+",re_level->"+re_level);
		 
		  request.setAttribute("num", num);
		  request.setAttribute("pageNum", pageNum);
		  request.setAttribute("article", article);
		  //ref,re_step,re_level 도 전달 X 코딩X->article안에 포함되어있기 때문에
		return "/content.jsp";
	}
}




