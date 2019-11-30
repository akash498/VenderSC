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
	private int ratable;
	private ArrayList<Review> reviews;
	// constructor
	Product(String name_, String shortDescription_, String description_, int businessId_, int productId_, int ratable) {
		setName(name_);
		setShortDescription(shortDescription_);
		setDescription(description_);
		setBusinessId(businessId_);
		setProductId(productId_);
		setRatable(ratable);
		// set the reviews and rating using the rating table in database
		setReviews();
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
			ratable = rs.getInt("ratable");
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
		double sumOfRatings = 0;
		double numOfRatings = 0;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		ArrayList<Review> reviews_ = new ArrayList<Review>();
		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Ratings WHERE productID = "+ this.productId);
			// adds new reviews to be parsed
			while (rs.next()) {
				// TODO - see if fields are correct when database is not suspended
				reviews_.add(new Review(rs.getString("reviewText"), rs.getInt("userID"),rs.getInt("productID"), rs.getInt("rating")));
				sumOfRatings += rs.getInt("rating");
				numOfRatings++;
			}
		} catch (SQLException e) {
			System.out.println("erorrr");
		}
		reviews = reviews_;
		rating = sumOfRatings / numOfRatings;
	}
	
	// add a review for this product, must take in a user's id
	public void addReview(int userId, String reviewText, int rating) {
		Connection conn = null;
		Statement st = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			st = conn.createStatement();
			// TODO - put correct SQL string when database is not suspended
			st.executeUpdate("INSERT INTO Rating ");
			// add new review to be parsed
		    reviews.add(new Review(reviewText, userId, this.productId, rating));
		
		} catch (SQLException e) {
			System.out.println("erorrr");
		}
	}
	
	public int getRatable() {
		return ratable;
	}
	public void setRatable(int ratable) {
		this.ratable = ratable;
	}
	
}