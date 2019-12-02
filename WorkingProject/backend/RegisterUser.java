package backend;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import backend.User;

/**
 * Servlet implementation class RegisterUser
 */
@WebServlet("/RegisterUser")
@MultipartConfig() 
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
		
		if(request.getPart("image").getSize() == 0) {
			request.setAttribute( "error", "You must upload an image!");
			response.sendRedirect("RegisterBusiness.jsp");
			return;
		}
		
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
					
					// The image needs to be saved in a folder located in WebContent called "images". Then the absolute path needs to be saved to
					// a variable called imgPath

					// UPDATE This to the absolute path of the images folder in the master project
					File uploads = new File("c:\\Users\\Sam\\eclipse-workspace\\Final_Project_CSCI201\\WebContent\\images");
					
					Part filePart = request.getPart("image");
					String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
					String imgPath = "images/" + fileName;
					File file = new File(uploads, fileName);

					// Check to see if a file with this name already exists if it does, give it a unique name
					// instead of overwriting the existing file.
					if(file.exists()) {

						int pos = fileName.lastIndexOf(".");
						if (pos > 0 && pos < (fileName.length() - 1)) {
						    fileName = fileName.substring(0, pos);
						}

						String extension = filePart.getContentType();
						extension ="." + extension.substring(extension.lastIndexOf("/")+1);
						file = File.createTempFile(fileName + "-", extension, uploads);
					}

					// Write the file to the image folder.
					try (InputStream input = filePart.getInputStream()) {
					    Files.copy(input, file.toPath(), StandardCopyOption.REPLACE_EXISTING);
					}
				
					ps = conn.prepareStatement("INSERT INTO Users (username, email, password, name, imageLocation ) VALUES (?,?,?,?,?)");
					ps.setString(1, username);
					ps.setString(2, email);
					ps.setString(3, password);
					ps.setString(4, name);
					ps.setString(5, imgPath);
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
