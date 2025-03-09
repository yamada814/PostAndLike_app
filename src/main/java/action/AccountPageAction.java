package action;

import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Board;
import dao.BoardDAO;

public class AccountPageAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("account");
		
		BoardDAO dao = new BoardDAO();
		List<Board> boardList =  dao.findbyLoginId(account);
		
		ServletContext application = request.getServletContext();
		application.setAttribute("boardList", boardList);
		
		HttpSession session = request.getSession();
		session.setAttribute("account", account);
		
		return "/WEB-INF/login-out.jsp";
	}

}
