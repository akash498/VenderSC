package backend;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductPageServlet
 */
@WebServlet("/ProductPageServlet")
public class ProductPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("userSearch")!=null) {
			if(request.getParameter("filter")==null) {
				response.sendRedirect("ProductPage.jsp?prodIndex=" + request.getParameter("prodIndex"));
			}
			
			response.sendRedirect("SearchServlet?userSearch=" + request.getParameter("userSearch") + "&filter=" + request.getParameter("userSearch"));
			
		}
		else if(request.getParameter("logout")!=null) {
			
			request.getSession().setAttribute("user", null);
			response.sendRedirect("GuestHomePage.jsp");
			
		}
		else if(request.getParameter("purchase")!=null) {
			
			// process the purchase
			// send email
			// add user to list of owners
			
		}
		
		else if(request.getParameter("submitReview")!=null) {
			
			// would be nice to tell user to add rating for review to be valid
			if(request.getParameter("rating")==null) {
				response.sendRedirect("ProductPage.jsp?prodIndex=" + request.getParameter("prodIndex"));
				return;
			}
			
			int id = ((User)request.getSession().getAttribute("user")).getUserID();
			int rating = Integer.parseInt(request.getParameter("rating"));
			int index = Integer.parseInt(request.getParameter("prodIndex"));
			Product p = ((ArrayList<Product>)request.getSession().getAttribute("products")).get(index);
			p.addReview(id, request.getParameter("reviewText"), rating);
			
			response.sendRedirect("ProductPage.jsp?prodIndex=" + request.getParameter("prodIndex"));
			
			
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
