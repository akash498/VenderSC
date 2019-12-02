package backend;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.regex.Pattern;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class AddProductPageServlet
 */
@WebServlet("/AddProductPageServlet")
@MultipartConfig() 
public class AddProductPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddProductPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		// check to make sure that all fields contain valid information
		if(request.getPart("prodName")==null || request.getPart("prodDesc")==null || request.getParameter("prodName").trim().compareTo("")==0 
				|| request.getParameter("prodDesc").trim().compareTo("")==0
				|| request.getParameter("ratable").trim().compareTo("")==0 || request.getPart("image").getSize() == 0) {
				//redirect the business back to the page
				
				response.sendRedirect("AddProductPage.jsp?Error=blankFields");
		}

		// The image needs to be saved in a folder located in WebContent called "images". Then the absolute path needs to be saved to
		// a variable called imgPath

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
			// Store the absolute path of the newly written image
			
			
			System.out.println(imgPath);
			
			Business b = (Business)request.getSession().getAttribute("business");
			int rate = -1;
			if(request.getParameter("ratable").compareTo("yes")==0) {
				rate = 1;
			}
			else {
				rate = 0;
			}
			b.addProduct(request.getParameter("prodName"), request.getParameter("prodDesc"), imgPath, rate);

			// redirect the business back to their homepage if successful
			response.sendRedirect("BusinessHomePage.jsp");
		}

	}

}
