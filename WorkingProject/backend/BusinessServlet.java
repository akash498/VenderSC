package backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BusinessServlet
 */
@WebServlet("/BusinessServlet")
public class BusinessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("logout")!=null) {
			request.getSession().setAttribute("user", null);
			
			// redirect the business back to their homepage
			response.sendRedirect("GuestHomePage.jsp");
		}
		
		else if(request.getParameter("userSearch")!=null) {
			if(request.getParameter("filter")==null) {
				response.sendRedirect("Business.jsp?busiIndex=" + request.getParameter("busiIndex"));
			}
			
			response.sendRedirect("SearchServlet?userSearch=" + request.getParameter("userSearch") + "&filter=" + request.getParameter("userSearch"));
		}
		
		else if(request.getParameter("prodNum")!=null) {
			
			System.out.println(request.getParameter("prodNum"));
			
			// is not working, idk why
			response.sendRedirect("ProductPage.jsp?prodNum=" + request.getParameter("prodNum"));
			
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
