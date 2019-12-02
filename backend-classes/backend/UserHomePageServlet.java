package backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserHomePageServlet
 */
@WebServlet("/UserHomePageServlet")
public class UserHomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserHomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// if the user clicked purchase
		if(request.getParameter("purchase")!=null) {
			
			// redirect the user to the product page
			response.sendRedirect("ProductPage.jsp?prodIndex=" + request.getParameter("prodIndex"));
			
		}
		
		else if(request.getParameter("business")!=null) {
			
			// redirect the user to the product page
			response.sendRedirect("Business.jsp?busiIndex=" + request.getParameter("busiIndex"));
			
		}
		
		else if(request.getParameter("logout")!=null) {
			
			request.getSession().setAttribute("user", null);
			
			// redirect the business back to their homepage
			response.sendRedirect("GuestHomePage.jsp");
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
