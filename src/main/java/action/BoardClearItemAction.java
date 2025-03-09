package action;

import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Board;
import dao.BoardDAO;

public class BoardClearItemAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		int id = Integer.parseInt(request.getParameter("id"));
		
		HttpSession session = request.getSession();
		String account = (String)session.getAttribute("account");
		
		ServletContext application = request.getServletContext();
		List<Board> boardList = (List<Board>)application.getAttribute("boardList");
					
		BoardDAO dao = new BoardDAO();
		dao.clearById(id);
		if(account == null) {
			boardList = dao.findAll();
		}else {
			boardList = dao.findbyLoginId(account);
		}
		application.setAttribute("boardList",boardList);
		return "/WEB-INF/login-out.jsp";
	}
}
