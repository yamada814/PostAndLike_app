package action;

import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Board;
import bean.Customer;
import dao.BoardDAO;

public class BoardHomeAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		String account = (String)session.getAttribute("account");
		if(account != null) {
			session.removeAttribute("account");
		}
		Customer customer = (Customer)session.getAttribute("customer");
		
		ServletContext application = request.getServletContext();
		List<Board> boardList = (List<Board>)application.getAttribute("boardList");

		BoardDAO dao = new BoardDAO();
		boardList = dao.findAll();
		application.setAttribute("boardList", boardList);
		return "/WEB-INF/login-out.jsp";
	}

}
