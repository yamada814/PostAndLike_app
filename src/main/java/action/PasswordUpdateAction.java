package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Customer;
import dao.CustomerDAO;

public class PasswordUpdateAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
	
		request.setCharacterEncoding("UTF-8");
		String password = request.getParameter("password");
		if(password == null || password.equals("")) {
			return "/WEB-INF/password-in.jsp"; 
		}
		
		CustomerDAO dao = new CustomerDAO();
		int result = dao.updatePassword(password,customer);
		
		return "/WEB-INF/password-out.jsp";

	}

}
