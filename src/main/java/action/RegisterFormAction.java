package action;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RegisterFormAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		return "/WEB-INF/regist-in.jsp";
	}


}
