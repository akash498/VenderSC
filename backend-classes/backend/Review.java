package backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Review {
	String reviewText;
	int userID;
	int productID;
	String username;
	double rating;
	
	// needs to be modified so the username is accessible, not just the user ID
	public Review(String reviewText, int userID, int productID, double rating) {
		this.reviewText = reviewText;
		this.userID = userID;
		this.productID = productID;
		this.rating = rating;
	}
	public String getUsername() {
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			ps = conn.prepareStatement("SELECT * FROM Users WHERE userID =?");
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			if (rs.next()) {

				return rs.getString("username");
				
			}
		
		} catch (SQLException e) {
			System.out.println("Error getting the username.");
		}
		
		return "Could not find User";
	}
	public String getUserImage() {
		
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement ps = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			ps = conn.prepareStatement("SELECT * FROM Users WHERE userID =?");
			ps.setInt(1, userID);
			rs = ps.executeQuery();
			if (rs.next()) {

				return rs.getString("imageLocation");
				
			}
		
		} catch (SQLException e) {
			System.out.println("Could not find the user Image");
		}
		
		return "Could not find User";
		
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public int getUserID() {
		return userID;
	}
	public void setUserID(int userID) {
		this.userID = userID;
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}
}
