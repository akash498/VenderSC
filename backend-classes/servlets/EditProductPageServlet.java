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
			|| request.getParameter("myfile").trim().compareTo("")==0) {
					
			// redirect the business back to the page
			response.sendRedirect("BusinessHomePage.jsp?index=" + ((String) request.getSession().getAttribute("index")));
			return;
					
		}
				
				
		// The image needs to be saved in a folder located in WebContent called "images". Then the absolute path needs to be saved to
		// a variable called imgPath
				
		Business b = (Business)request.getSession().getAttribute("business");
		int rate = -1;
		if(request.getParameter("ratable").compareTo("yes")==0) {
			rate = 1;
		}
		else {
			rate = 0;
		}
		int index = Integer.parseInt((String) request.getSession().getAttribute("index"));
		Product p = b.getProducts().get(index);
		p.setName(request.getParameter("prodName"));
		p.setDescription(request.getParameter("prodDesc"));
		p.setRatable(rate);
		
				
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
