package backend_classes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Product {
	private String name;
	private String shortDescription;
	private String description;
	private int businessId;
	private double rating;
	private int productId;
	private Boolean ratable;
	private ArrayList<Review> reviews;
	// constructor
	Product(String name_, String shortDescription_, String description_, int businessId_, int productId_) {
		setName(name_);
		setShortDescription(shortDescription_);
		setDescription(description_);
		setBusinessId(businessId_);
		setProductId(productId_);
		// set the reviews and rating using the rating table in database
		
	}
	// constructor - takes in productId and fills in the rest of members from product table
	Product(int productId_) {
		productId = productId_;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("url");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM vendorDB.Product WHERE productID = "+ productId);
			name = rs.getString("name");
			description = rs.getString(("longDescription"));
			shortDescription = rs.getString("shortDescription");
			if (rs.getInt("ratable") == 0 ) {
				ratable = false;
			} else {
				ratable = true;
			}
			businessId = rs.getInt("businessID");
		} catch (SQLException e) {
			System.out.println("erorrr");
		}
		setReviews();
	}
	// getters and setters
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
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	// sets the reviews for this product by calling the rating database and finds the average rating 
	public void setReviews() {
		
	}
	
	// add a review for this product, must take in a user's id
	public void addReview(int userId) {
		
	}
	
}