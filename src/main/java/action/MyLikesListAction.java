package action;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Board;
import bean.Customer;
import dao.BoardDAO;

public class MyLikesListAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		HttpSession session = request.getSession();
		Customer  customer = (Customer)session.getAttribute("customer");
		
		BoardDAO boardDAO = new BoardDAO();
		List<Board> mylikeList = boardDAO.findMyLikeList(customer.getLoginId());
//		System.out.println("*****");
//		for(Board board : likeList) {
//			System.out.println(board);
//		}
		request.setAttribute("mylikeList", mylikeList);
		
		return "/WEB-INF/myLikeList-out.jsp";
	}

}
