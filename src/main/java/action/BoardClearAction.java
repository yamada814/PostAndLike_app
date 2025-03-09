package action;

import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Board;
import bean.Customer;
import dao.BoardDAO;

public class BoardClearAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		String account = (String)session.getAttribute("account");
		
		ServletContext application = request.getServletContext();
		List<Board> boardList = (List<Board>)application.getAttribute("boardList");
		
		Board board = new Board();
		board.setLoginId(customer.getLoginId());
		BoardDAO dao = new BoardDAO();
		dao.clearByLoginId(board);

		boardList = dao.findbyLoginId(account);
		application.setAttribute("boardList", boardList);

		return "/WEB-INF/login-out.jsp";
	}	

}
