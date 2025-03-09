package action;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Customer;
import dao.LikesDAO;

public class WhoLikesAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//クリックしたboardのidを取得
		request.setCharacterEncoding("UTF-8");
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		
		LikesDAO likesDAO = new LikesDAO();
		List<Customer> whoLikesList = likesDAO.findByBoardId(boardId);
		request.setAttribute("whoLikesList", whoLikesList);
		System.out.println(whoLikesList.size());
		return "/WEB-INF/whoLikesList-out.jsp";
	}

}
