package action;

import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Board;
import bean.Customer;
import dao.BoardDAO;
import dao.LikesDAO;

public class BoardLikeItemAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{

		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		
		ServletContext application = request.getServletContext();
		List<Board> boardList = (List<Board>)application.getAttribute("boardList");
		
		request.setCharacterEncoding("UTF-8");
		// いいねをしたboardのidとloginIdを取得
		int boardId = Integer.parseInt(request.getParameter("boardId"));
		String boardLoginId = request.getParameter("boardLoginId");
		
		// ハートの塗りつぶし判定用　
		// いいねした -> true, いいねを外した -> false
		boolean heartFill = false;
		
		BoardDAO boardDAO = new BoardDAO();
		LikesDAO likesDAO = new LikesDAO();
		// 自分のをいいねしてないか 
		if(!customer.getLoginId().equals(boardLoginId)) {
			boolean exist = likesDAO.search(boardId,customer.getLoginId());
			// いいね済ではない -> like + 1 ,　ハート塗りつぶす
			if(!exist) {				
				boardDAO.CountUpLike(boardId);
				likesDAO.save(boardId, customer.getLoginId());
				heartFill = true;
			// いいね済の時 -> like - 1　,　ハートの塗りつぶし解除
			}else{
				boardDAO.CountDownLike(boardId);
				likesDAO.delete(boardId, customer.getLoginId());
				heartFill = false;
			}
		}
		// 自分の投稿をいいねしたときは何もしない
		
		Board board = boardDAO.findByBoardId(boardId);
		request.setAttribute("board", board);
		request.setAttribute("heartFill", heartFill);
		return "/WEB-INF/like-out.jsp";	
		}
}
