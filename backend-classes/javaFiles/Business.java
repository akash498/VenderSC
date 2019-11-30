package backend_classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.*;

public class Business {
	private int businessId;
	private String name;
	private String description;
	private String imagePath;
	private ArrayList<Product> products;
	private Boolean emailOn;
	// constructor - takes in business id and fills in other members from database
	public Business(String username) {
		//businessId = id;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			ps = conn.prepareStatement("SELECT * FROM Business WHERE username =?");
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				System.out.println("here1?");
				name = rs.getString("name");
				System.out.println("here2?");
				description = rs.getString("longDescription");
				System.out.println(description);
				businessId = rs.getInt("businessID");
				imagePath = rs.getString("imageLocation");
				// TODO - create new emailOn column in database
				emailOn = true;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		setProducts();
	}
	// getters and setters
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int id) {
		businessId = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	// retrieve products from product table in database for the business id
	public void setProducts() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Product> prods = new ArrayList<Product>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Product WHERE businessID = "+ this.businessId);
			while (rs.next()) {
				prods.add(new Product(rs.getString("name"), rs.getString("shortDescription"),rs.getString("longDescription"), rs.getInt("businessID"), rs.getInt("productID"), rs.getInt("ratable"), rs.getString("imageLocation")));
			}
		} catch (SQLException e) {
			System.out.println("erorrr");
		}
		products = prods;
	}
	// adds a product to the product table in the database with the business id
	public void addProduct(String name, String description, String imagePath, int ratable) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			st = conn.createStatement();
			st.executeUpdate("INSERT INTO Product (businessID, name, shortDescription, longDescription, imageLocation, ratable) VALUES ("+ businessId + ", '" + name +"', 'do we want a short descrip', '" + description + "', '" + imagePath + "', " + Integer.toString(ratable) + ")");
		} catch (SQLException e) {
			System.out.println("erorrr");
		}
		setProducts();
	}
	// removes a product from the product table in the database with the business id
	public void removeProduct(int productId) {
		Connection conn = null;
		Statement st = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			st = conn.createStatement();
			st.executeUpdate("DELETE FROM Product WHERE productID = "+ Integer.toString(productId) + ")");
		} catch (SQLException e) {
			System.out.println("erorrr");
		}
		setProducts();
	}
	public Boolean getEmailOn() {
		return emailOn;
	}
	public void setEmailOn() {
		this.emailOn = !this.emailOn;
	}
	
}
