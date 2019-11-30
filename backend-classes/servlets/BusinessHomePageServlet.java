package backend;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import backend.Email_Thread;

/**
 * Servlet implementation class BusinessHomePageServlet
 */
@WebServlet("/BusinessHomePageServlet")
public class BusinessHomePageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BusinessHomePageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * All of our requests from the BusinessHomePage will be handled here. We will have a condition to check for each button.
	 * So far I am planning on setting each name and value of the submit button to something unique that can be identified in 
	 * the url. If you would like to change this behavior, feel free.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// This is done to check if the servlet was called by the email button
		if(request.getParameter("email")!=null && request.getParameter("email").compareTo("email")==0) {
			
			// TODO - Below is the pseudo code that needs to be translated
			
			// Business b = request.getBusiness();
			// b.flipEmailsOn();
			// if(b.areEmailsOn()){
			// 	Email_Thread et = new Email_Thread(b.getEmail(), "Your email notifications have been turned on!", "Email Notifications - VendorSC" );
			// }
			// else {
			// 	Email_Thread et = new Email_Thread(b.getEmail(), "Your email notifications have been turned off!", "Email Notifications - VendorSC" );
			// }
			
			Email_Thread et = new Email_Thread("samskates.chase@gmail.com", "Your email notifications have been turned on!", "Email Notifications - VendorSC" );
			
			// redirect the business back to their homepage
			response.sendRedirect("BusinessHomePage.jsp");
			
			
		}
		
		// This should take the input text from this form and set it as the new bio for the business
		// the parameter name for the new bio is "bioText"
		else if(request.getParameter("editBio")!=null && request.getParameter("editBio").compareTo("editBio")==0) {
			
			// Business b = request.getBusiness();
			// b.setDescription();
			
			// redirect the business back to their homepage
			response.sendRedirect("BusinessHomePage.jsp");
			
		}
		
		// redirect the user to the edit product page
		else if(request.getParameter("editProduct")!=null) {
			
			// int index = Integer.parseInt(request.getParameter("removeProduct"));
			
			// redirect the business back to their homepage
			// response.sendRedirect("EditProductPage.jsp?product=" + index);
			
			response.sendRedirect("EditProductPage.jsp");
			
		}
		
		// remove the product and redirect back to the home page
		else if(request.getParameter("removeProduct")!=null) {
			
			// int index = Integer.parseInt(request.getParameter("removeProduct"));
			
			// Business b = request.getBusiness();
			// b.removeProduct(index);
			
			// redirect the business back to their homepage
			response.sendRedirect("BusinessHomePage.jsp");
			
		}
		
		// redirect to add product page
		else if(request.getParameter("addProduct")!=null && request.getParameter("addProduct").compareTo("addProduct")==0) {
			
			// redirect the business back to their homepage
			response.sendRedirect("AddProductPage.jsp");
			
		}
		
		// log the user out and redirect to guest login page
		else if(request.getParameter("logout")!=null && request.getParameter("logout").compareTo("logout")==0) {
			
			// Business b = request.getBusiness();
			// b.logout();
			
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
