package backend_classes;

public class Product {
	private String name;
	private String price;
	private String description;
	private int businessId;
	private double rating;
	private int productId;
	private ArrayList<Review> reviews;
	Product(String name_, String price_, String description_, int businessId_, int productId_) {
		setName(name_);
		setPrice(price_);
		setDescription(description_);
		setBusinessId(businessId_);
		setProductId(productId_);
		
		
	}
	// getters and setters
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
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
	public void addReview() {
		
	}
	
}
