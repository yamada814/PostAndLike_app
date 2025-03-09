package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.CustomerDAO;

public class RegisterAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		String loginId = request.getParameter("userId");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		
		if(loginId == null || password == null || role == null) {
			return "/WEB-INF/regist-error.jsp";
		}
		CustomerDAO dao = new CustomerDAO();
		boolean result = dao.register(loginId,password,role);
		
		if(result) {
			return "/WEB-INF/regist-out.jsp";
		}
		return "/WEB-INF/regist-error.jsp";
		
	}


}
