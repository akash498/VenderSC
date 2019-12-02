package backend;

import backend.Product;
import backend.Business;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	public static ArrayList<Product> productResults;
	public static ArrayList<Business> businessResults;


	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String searchText=request.getParameter("userSearch");
		String searchType= request.getParameter("filter");
		
		
		if((searchText==null || (searchText.contentEquals("")) )) {
			searchText = "";
		}
				
		if(searchType == null || searchType.contentEquals("")) {
			searchType="product";
			System.out.println("HERE");
		}
		
		else {
		String[] searchTerms= searchText.split(" ");
	
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		boolean cont = true;
		productResults= new ArrayList<Product>();
		businessResults= new ArrayList<Business>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");

			st = conn.createStatement();
			if(searchType.contentEquals("product") ) { //for products
				ps = conn.prepareStatement("SELECT * FROM Product WHERE name=?");
				ps.setString(1, searchText);
				rs = ps.executeQuery();
				Set<String> set = new HashSet<String>();
				while(rs.next()) {//AND search
					String name=rs.getString("name");
					String shortDescription=rs.getString("shortDescription");
					String description= rs.getString("longDescription");
					int businessID=rs.getInt("businessID");
					int productID=rs.getInt("productID");
					int ratable=rs.getInt("ratable");
					String imageLocation=rs.getString("imageLocation");
					Product product= new Product(name, shortDescription, description, businessID, productID, ratable, imageLocation);
					if (!set.contains(product.getName())) {
						set.add(product.getName());
						productResults.add(product);

					}
				}

				for(int i=0; i<searchTerms.length; i++) {//OR search for Products
					ps = conn.prepareStatement("SELECT * FROM Product WHERE name=?");

					ps.setString(1, searchText);
					rs = ps.executeQuery();
					while(rs.next()) {
						String name=rs.getString("name");
						String shortDescription=rs.getString("shortDescription");
						String description= rs.getString("longDescription");
						int businessID=rs.getInt("businessID");
						int productID=rs.getInt("productID");
						int ratable=rs.getInt("ratable");
						String imageLocation=rs.getString("imageLocation");
						Product product= new Product(name, shortDescription, description, businessID, productID, ratable, imageLocation);

						if (!set.contains(product.getName())) {
							set.add(product.getName());
							productResults.add(product);

						}

				}

				}
			}
			else if(searchType.contentEquals("business") ) { //AND search for business
				ps = conn.prepareStatement("SELECT * FROM Business WHERE name=?");
				ps.setString(1, searchText);
				rs = ps.executeQuery();
				Set<String> set = new HashSet<String>();

				while(rs.next()) {
					String name=rs.getString("name");

					Business business= new Business(name);

					if (!set.contains(name)) {
						set.add(name);
						businessResults.add(business);
					}
				}

				for(int i=0; i<searchTerms.length; i++) {//OR search for business
					ps = conn.prepareStatement("SELECT * FROM Product WHERE name=?");

					ps.setString(1, searchTerms[i]);
					rs = ps.executeQuery();
					while(rs.next()) {
						String name=rs.getString("name");

						Business business= new Business(name);

						if (!set.contains(name)) {
							set.add(name);
							businessResults.add(business);
						}

				}

				}
			}

			response.sendRedirect("SearchResults.jsp?searchType="+searchType+"&userSearch="+searchText);
		}
		catch (SQLException sqle) {
			System.out.println(sqle.getMessage());

		}
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
