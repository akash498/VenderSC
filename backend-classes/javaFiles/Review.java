package backend_classes;

public class Review {
	String reviewText;
	int USerID;
	int ProductID;
	double rating;

	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	public int getUSerID() {
		return USerID;
	}
	public void setUSerID(int uSerID) {
		USerID = uSerID;
	}
	public int getProductID() {
		return ProductID;
	}
	public void setProductID(int productID) {
		ProductID = productID;
	}
	public double getRating() {
		return rating;
	}
	public void setRating(double rating) {
		this.rating = rating;
	}


}
