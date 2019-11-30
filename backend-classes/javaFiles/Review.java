package backend_classes;

public class Review {
	String reviewText;
	int userID;
	int productID;
	double rating;
	public Review(String reviewText, int userID, int productID, double rating) {
		this.reviewText = reviewText;
		this.userID = userID;
		this.productID = productID;
		this.rating = rating;
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
