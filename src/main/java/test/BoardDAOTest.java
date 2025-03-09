package test;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Board;
import dao.BoardDAO;

/**
 * Servlet implementation class BoardDAOTest
 */
@WebServlet("/BoardDAOTest")
public class BoardDAOTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	testFindMyLikeList();
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	void testFindMyLikeList() {
		String loginId = "wanibuchi";
		BoardDAO boardDAO = new BoardDAO();
		try {
			List<Board> boardList = boardDAO.findMyLikeList(loginId);	
			for(Board board: boardList) {
				System.out.println(board);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
