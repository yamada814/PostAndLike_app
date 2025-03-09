package controller;



import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import action.Action;
import bean.Customer;
/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns=("*.action"))
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {		
			HttpSession session = request.getSession(false);
			//セッションが存在しない場合(セッションタイムアウトとか)
			if(session == null || session.isNew()) {
				response.sendRedirect("session-error.jsp");
				return;
			}
			Customer customer = (Customer)session.getAttribute("customer");
			String path = request.getServletPath().substring(1);
			String className = path.replace(".a", "A").replace("/", ".");
			
			//Login.action以外のリクエストの場合
			if(customer == null && !className.equals("LoginAction") && !className.equals("LoginAgainAction")) {
				response.sendRedirect("invalid-access.jsp");
				return;
			}
			if(customer != null && customer.getRole().equals("GENERAL") && 
					(className.equals("RegisterAction") || className.equals("RegisterFormAction") || className.equals("AccountListAction"))){
//						response.setStatus(HttpServletResponse.SC_NOT_FOUND);
				request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
				return;
			}
			String fqcn = "action." + className;
			Action action = (Action)Class.forName(fqcn).getDeclaredConstructor().newInstance();	
			String url = action.execute(request,response);
			request.getRequestDispatcher(url).forward(request, response);				
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
