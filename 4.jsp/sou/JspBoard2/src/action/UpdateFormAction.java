package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//추가
import lys.board.*;

// /updateForm.do?num=13&pageNum=2
public class UpdateFormAction implements CommandAction {

	@Override
	public String requestPro(HttpServletRequest request, HttpServletResponse response) throws Throwable {
		// TODO Auto-generated method stub
		    int num=Integer.parseInt(request.getParameter("num"));
		    String pageNum=request.getParameter("pageNum");
		    BoardDAO dbPro=new BoardDAO();
		    //select * from board where num=?
		    BoardDTO article=dbPro.updateGetArticle(num);
		    
		    //메모리에 저장->공유해서 이동(forward)
		    request.setAttribute("pageNum", pageNum);//${pageNum}
		    request.setAttribute("article", article);//num->getNum()
		    
		return "/updateForm.jsp";
	}
}






