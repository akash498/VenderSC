package backend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditProductPageServlet
 */
@WebServlet("/EditProductPageServlet")
public class EditProductPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// check to make sure that all fields contain valid information
		if(request.getParameter("prodName")==null || request.getParameter("prodDesc")==null || request.getParameter("prodName").trim().compareTo("")==0 
			|| request.getParameter("prodDesc").trim().compareTo("")==0 || request.getParameter("ratable").trim().compareTo("")==0 
			|| request.getParameter("image").trim().compareTo("")==0) {
					
			// redirect the business back to the page
			response.sendRedirect("EditProductPage.jsp?index=" + request.getSession().getAttribute("index") + "&Error=blankFields");
			return;
					
		}
				
				
		// The image needs to be saved in a folder located in WebContent called "images". Then the absolute path needs to be saved to
		// a variable called imgPath
				
		// Business b = request.getBusiness();
		// b.addProduct(request.getParameter("prodName"), request.getParameter("prodDesc"), imgPath, request.getParameter("ratable"));
				
		// redirect the business back to their homepage if successful
		response.sendRedirect("BusinessHomePage.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
