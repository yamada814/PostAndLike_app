package action;

import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Board;
import bean.Customer;
import dao.BoardDAO;

public class BoardPostAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		
		ServletContext application = request.getServletContext();
		List<Board> boardList = (List<Board>)application.getAttribute("boardList");
		
		request.setCharacterEncoding("UTF-8");
		String contents = request.getParameter("contents");
		
		BoardDAO dao = new BoardDAO();
		if(contents == null || contents.equals("")) {
			boardList = dao.findAll();
			application.setAttribute("boardList", boardList);
			return "/WEB-INF/login-out.jsp";
		}
		if(contents.length() > 50) {
			return "/WEB-INF/board-error.jsp";
		}

		Board board = new Board();
		board.setLoginId(customer.getLoginId());
		board.setContents(contents);
		int result = dao.save(board);
		if(result != 1) {
			return "/WEB-INF/board-error.jsp";
		}else {
//			board = dao.findByLoginIdAndContents(customer.getLoginId(), contents);
//			request.setAttribute("board", board);
//			return "/WEB-INF/post.jsp";
			boardList = dao.findAll();
			application.setAttribute("boardList", boardList);
			return "/WEB-INF/login-out.jsp";
		}
	}
}
