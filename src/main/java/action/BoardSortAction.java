package action;

import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Board;
import dao.BoardDAO;

public class BoardSortAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String value = request.getParameter("sort");
		BoardDAO boardDAO = new BoardDAO();
		List<Board> boardList = null;
		switch(value) {
			case "new" -> {boardList = boardDAO.sortByDateNew();}
			case "old" -> {boardList = boardDAO.sortByDateOld();}
			case "like" ->{boardList = boardDAO.sortByLikes();}
		}
		ServletContext application = request.getServletContext();
		application.setAttribute("boardList", boardList);
		
		return "/WEB-INF/login-out.jsp";
	}
}
