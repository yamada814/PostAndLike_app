package action;

import java.util.List;
import java.util.Optional;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Board;
import bean.Customer;
import dao.BoardDAO;
import dao.CustomerDAO;

public class LoginAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		//ログイン済みユーザーはチェック不要
		if(customer != null) {
			return "/WEB-INF/login-out.jsp";
		}
		
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		
		CustomerDAO customerDAO = new CustomerDAO();
		Optional<Customer> opCustomer = customerDAO.search(loginId,password);
		if(opCustomer.isPresent()) {
			session.setAttribute("customer", opCustomer.get());
			//boradListの取得
			ServletContext application = request.getServletContext();
			List<Board> boardList = (List<Board>)application.getAttribute("boardList");
			BoardDAO boardDAO = new BoardDAO();
			boardList = boardDAO.findAll();		
			application.setAttribute("boardList", boardList);
			return "/WEB-INF/login-out.jsp";
		}
	return "/WEB-INF/login-error.jsp";

}
}

