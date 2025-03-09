package action;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Customer;
import dao.CustomerDAO;

public class AccountListAction implements Action{
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		CustomerDAO dao = new CustomerDAO();
		List<Customer> customerList = dao.findAll();
		
		HttpSession session = request.getSession();
		session.setAttribute("customerList", customerList);
		
		if(customerList != null) {
			return "/WEB-INF/accountList-out.jsp";
		}else {
			return "/WEB-INF/accountList-error.jsp";
		}
	}

}
