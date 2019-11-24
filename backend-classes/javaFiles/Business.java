package backend_classes;
import java.util.*;

public class Business {
	private int businessId;
	private String name;
	private ArrayList<Integer> products;
	// constructor
	Business(int id, String name_) {
		setBusinessId(id);
		setName(name_);
		setProducts(new ArrayList<Integer>());
	}
	// getters and setters
	public void addProduct(Product p) {
		System.out.println("adding prudcut");
	}
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<Integer> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Integer> products) {
		this.products = products;
	}
	
	
}
