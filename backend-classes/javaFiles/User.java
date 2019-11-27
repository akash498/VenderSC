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
	int public getUserID() {
		return UserID;
	}
	void public setUserID(int ID) {
		UserID = ID;
	}
	//Username getters and setters
	String public getUsername() {
		return Username;
	}
	void public setUsername(String username) {
		Username = username;
	}
	//Password getters and setters
	String public getPassword() {
		return Password;
	}
	void public setPassword(String pass) {
		Password = pass;
	}
	//Email getters and setters
	String public getEmail() {
		return Email;
	}
	void public setEmail(String e) {
		Email = e;
	}
	//Name getters and setters
	String public getName() {
		return Name;
	}
	void public setName(String n) {
		Name = n;
	}
	//getter and setter(adding to arraylist) for ProductsPurchased 
	ArrayList<Integer> public getProductsPurchased {
		return ProductsPurchased;
	}
	void public addProduct(int p) {
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
	}
	
	//hasPurchased member function that checks if a product has been purchased by this user
	boolean public hasPurchased(Product p) {
		int productID = p.getProductId();
		if (this.ProductsPurchased.contains(productID) {
			return true;
		}
		return false;
	}

}
