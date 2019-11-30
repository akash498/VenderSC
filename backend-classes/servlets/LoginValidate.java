

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import backend_classes.Business;

/**
 * Servlet implementation class LoginValidate
 */
@WebServlet("/LoginValidate")
public class LoginValidate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginValidate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String next = "/Login.jsp";
		String error = "";
		Connection conn = null;
		Statement st = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			
			ps = conn.prepareStatement("SELECT * FROM Users WHERE username = ?");
			ps.setString(1,username);
			rs = ps.executeQuery();
			//if username doesnt exist in user table, then check business table
			if (!rs.next()){    
				ps = conn.prepareStatement("SELECT * FROM Business WHERE username = ?");
				ps.setString(1,username);
				rs = ps.executeQuery();
				//this username does not exist in either table
				if (!rs.next()){ 
					request.setAttribute( "error", "This user does not exist");
					next = "/Login.jsp";
				}
				//this username exists in the business table
				else {
					String storedPassword = (String) rs.getObject("password");
					//wrong password for business username
					if (!password.contentEquals(storedPassword)) {
						request.setAttribute( "error", "Incorrect password");
						next = "/Login.jsp";
					}
					//correct password for business username; login business user
					else {
						next = "/BusinessHomePage.jsp";
						session.setAttribute("loggedIn", "true");
						session.setAttribute("username", username);
						session.setAttribute("favorite", "true");
						request.setAttribute("error", "");
						Business business = new Business(username);
						session.setAttribute("business", business);
						System.out.println("herererererererererererstuck");
					}
				}
			}
			// username exists in the user table, so check password
			else {
				String storedPassword = (String) rs.getObject("password");
				if (!password.contentEquals(storedPassword)) {
					request.setAttribute( "error", "Incorrect password");
					next = "/Login.jsp";
				}
				else {
					next = "/UserHomePage.jsp";
					session.setAttribute("loggedIn", "true");
					session.setAttribute("username", username);
					session.setAttribute("favorite", "true");
					request.setAttribute("error", "true");
				}
			}	
		}
		catch (SQLException sqle) {  
			System.out.println(sqle.getMessage());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatch = getServletContext().getRequestDispatcher(next);
		try {
			dispatch.forward(request, response);
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		catch(ServletException e) {
			e.printStackTrace();
		}
	
	
		
		
		
	}

}
