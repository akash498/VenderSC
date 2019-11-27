package backend_classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class Business {
	private int businessId;
	private String name;
	private String description;
	private ArrayList<Product> products;
	// constructor - takes in business id and fills in other members from database
	Business(int id) {
		businessId = id;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("url");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM vendorDB.Business WHERE businessID = "+ businessId);
			name = rs.getString("name");
			description = rs.getString(("longDescription"));
		} catch (SQLException e) {
			System.out.println("erorrr");
		}
		setProducts();
	}
	// getters and setters
	public void addProduct(Product p) {
		System.out.println("adding prudcut");
	}
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
			conn = DriverManager.getConnection("url");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM vendorDB.Product WHERE businessID = "+ businessId);
			while (rs.next()) {
				rs.getInt("productID");
				prods.add(new Product(rs.getString("name"), rs.getString("shortDescription"),rs.getString("longDescription"), rs.getInt("businessID"), rs.getInt("productID")));
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
			conn = DriverManager.getConnection("url here");
			st = conn.createStatement();
			st.executeUpdate("INSERT INTO vendorDB.Product (businessID, name, shortDescription, longDescription, imageLocation, ratable) VALUES ("+ businessId + ", '" + name +"', 'do we want a short descrip', '" + description + "', '" + imagePath + "', " + Integer.toString(ratable) + ")");
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
			conn = DriverManager.getConnection("url here");
			st = conn.createStatement();
			st.executeUpdate("DELETE FROM vendorDB.Product WHERE productID = "+ Integer.toString(productId) + ")");
		} catch (SQLException e) {
			System.out.println("erorrr");
		}
		setProducts();
	}
	
}
