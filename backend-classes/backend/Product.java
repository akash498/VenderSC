package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
	private String imagePath;
	private ArrayList<Review> reviews;
	// constructor
	Product(String name_, String shortDescription_, String description_, int businessId_, int productId_, int ratable_, String imagePath_) {
		setName(name_);
		setShortDescription(shortDescription_);
		setDescription(description_);
		setBusinessId(businessId_);
		setProductId(productId_);
		setRatable(ratable_);
		setImagePath(imagePath_);
		// set the reviews and rating using the rating table in database
		setReviews();
	}
	// constructor - takes in productId and fills in the rest of members from product table
	public Product(int productId_) {
		productId = productId_;
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM Product WHERE productID = "+ productId);
			if (rs.next()) {
			name = rs.getString("name");
			description = rs.getString(("longDescription"));
			shortDescription = rs.getString("shortDescription");
			ratable = rs.getInt("ratable");
			businessId = rs.getInt("businessID");
			imagePath = rs.getString("imageLocation");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		setReviews();
	}
	
	// getters and setters
	public ArrayList<Review> getReviews() {
		return reviews;
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
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public double getRating() {
		if(reviews.size()==0) {
			return -1;
		}
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
			rs = st.executeQuery("SELECT * FROM Rating WHERE productID = "+ this.productId);
			// adds new reviews to be parsed
			while (rs.next()) {
				// TODO - see if fields are correct when database is not suspended
				reviews_.add(new Review(rs.getString("text"), rs.getInt("userID"),rs.getInt("productID"), rs.getInt("rating")));
				sumOfRatings += rs.getInt("rating");
				numOfRatings++;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				
				if(st!=null) {
					st.close();
				}
				if(rs!=null) {
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		reviews = reviews_;
		rating = sumOfRatings / numOfRatings;
	}
	
	// add a review for this product, must take in a user's id
	public void addReview(int userId, String reviewText, int rating) {
		Connection conn = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			ps = conn.prepareStatement("INSERT INTO Rating (userID, productID, rating, text) VALUES (?, ?, ?, ?)");
			ps.setInt(1, userId);
			ps.setInt(2, productId);
			ps.setInt(3, rating);
			ps.setString(4, reviewText);
			
			ps.execute();
			
			// add new review to be parsed
		    reviews.add(new Review(reviewText, userId, this.productId, rating));
		
		} catch (SQLException e) {
			System.out.println("Product Insertion Error " + e);
		}
		finally {
			try {
				if(conn!=null) {
					conn.close();
				}
				
				if(ps!=null) {
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		
	}
	
	public int getRatable() {
		return ratable;
	}
	public void setRatable(int ratable) {
		this.ratable = ratable;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}