package backend_classes;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class User {
	//Member Variables
	private int UserID;
	private String Username;
	private String Password;
	private String Email;
	private String Name;
	private ArrayList<Integer> ProductsPurchased;

	//UserID getters and setters
	public int getUserID() {
		return UserID;
	}
	public void setUserID(int ID) {
		UserID = ID;
	}
	//Username getters and setters
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	//Password getters and setters
	 public String getPassword() {
		return Password;
	}
	 public void setPassword(String pass) {
		Password = pass;
	}
	//Email getters and setters
	public String getEmail() {
		return Email;
	}
	public void setEmail(String e) {
		Email = e;
	}
	//Name getters and setters
	public String getName() {
		return Name;
	}
	public void setName(String n) {
		Name = n;
	}
	//getter and setter(adding to arraylist) for ProductsPurchased
	public ArrayList<Integer> getProductsPurchased(){
		return ProductsPurchased;
	}
	public void addProduct(int p) {
		ProductsPurchased.add(p);
	}

	//constructor
	User(int ID) {
		UserID = ID;
		//fill the rest of the member variables by calling the database using JDBC
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
			ps = conn.prepareStatement("SELECT * FROM vendorDB.? WHERE UserID = ?");
			ps.setString(1, "Purchase");
			ps.setString(2, Integer.toString(UserID));
			rs = ps.executeQuery();
			//filling the productsPurchased ArrayList
			while (rs.next()) {
				ProductsPurchased.add(Integer.parseInt(rs.getString("ProductID")));
			}
			//reusing the prepared statement with different params to get other member variables
			ps.setString(1, "User");
			ps.setString(2, Integer.toString(UserID));
			rs = ps.executeQuery();
			Username = rs.getString("username");
			Password = rs.getString("password");
			Email = rs.getString("email");
			Name = rs.getString("name");

			//I am done with the connection and prepared statement. I have gathered all the data I want from the DB
			conn.close();
			ps.close();
		}
		catch (SQLException e) {
			System.out.println("ERROR");
		}
		catch (ClassNotFoundException e) {
			System.out.println("ERROR");
		}
	}

	//hasPurchased member function that checks if a product has been purchased by this user
	public boolean hasPurchased(Product p) {
		int productID = p.getProductId();
		if (this.ProductsPurchased.contains(productID)) {
			return true;
		}
		return false;
	}

}
