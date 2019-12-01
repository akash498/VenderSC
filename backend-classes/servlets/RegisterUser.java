

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

import backend_classes.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
public class RegisterUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterUser() {
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
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String confirm = request.getParameter("confirm");
		
		String imageLocation = request.getParameter("logo");
		if (imageLocation == null) imageLocation = "";
		
		String next = "/RegisterUser.jsp";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		boolean cont = true;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Business WHERE username = '"+username+"'");
			
			if (username == null || password == null|| confirm == null || username == "" || password == ""|| confirm == "" ) {
				request.setAttribute( "error", "All fields must be filled");
				cont = false;

			}
			
			
			else if (!password.contentEquals(confirm)) {
				request.setAttribute( "error", "The passwords do not match");
				cont = false;

			}
			else if (rs.next()) {    
				request.setAttribute( "error", "This username is already taken");
				cont = false;

			}
			
			
			if (cont) {
			
			
			
				rs = st.executeQuery("SELECT * FROM Users WHERE username = '"+username+"'");
			
				if (username == null || password == null|| confirm == null || username == "" || password == ""|| confirm == "" ) {
					request.setAttribute( "error", "All fields must be filled");
				}
			
			
				else if (!password.contentEquals(confirm)) {
					request.setAttribute( "error", "The passwords do not match");
				}
				else if (rs.next()) {    
					request.setAttribute( "error", "This username is already taken");
				}
				else {
				
					ps = conn.prepareStatement("INSERT INTO Users (username, email, password, name, imageLocation ) VALUES (?,?,?,?,?)");
					ps.setString(1, username);
					ps.setString(2, email);
					ps.setString(3, password);
					ps.setString(4, name);
					ps.setString(5, imageLocation);
					ps.execute();
					next = "/UserHomePage.jsp";
					session.setAttribute("loggedIn", "true");
					session.setAttribute("username", username);
					User user = new User(username);
					session.setAttribute("user", user);
				}
			}
			
		}
		catch (SQLException sqle) {  
			System.out.println(sqle.getMessage());
			
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
