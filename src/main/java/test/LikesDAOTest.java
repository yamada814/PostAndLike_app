package test;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Customer;
import dao.LikesDAO;

/**
 * Servlet implementation class LikesDAOTest
 */
@WebServlet("/LikesDAOTest")
public class LikesDAOTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		testFindByBoardId();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	void testFindByBoardId() {
		LikesDAO dao = new LikesDAO();
		try {
			List<Customer> customerList = dao.findByBoardId(98);
			for(Customer customer : customerList) {
				System.out.println(customer.getLoginId());
			}
					
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
