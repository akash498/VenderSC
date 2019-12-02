<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ page import = "backend.Business"%>
<%@ page import = "backend.Product"%>
<%@ page import = "backend.User"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>VendorSC</title>
	<link rel="stylesheet" type="text/css" href="css/UserHomePage.css">
	<!-- 	Icon Library	 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>
<%User user = (User)session.getAttribute("user"); %>
<!-- Start of Header Div -->
	<div id="header">
	
			<img id="headerLogo" src="images/vendorSClogowithbackground.png" alt="vendorSC logo">
			<div id="header-divider"></div> 
			<div id="search-form">
			
				<form action = "Search" method="GET">
					<input type="hidden" name="UserSearch" value="hi"/>
					<div id="searchBar">
						<input type="text" name="userSearch" class="form-control" id="search-id" placeholder="SEARCH FOR PRODUCT OR BUSINESS">
						<button type="submit" id="submit-button"><i class="fa fa-search"></i>Search</button><br>
						<label class="radButton"><input type="radio" name="filter" value="business"> Business</label>
						<label class="radButton"><input type="radio" name="filter" value="product"> Product</label>
					</div>
					
				</form>
				
			
			</div>
			
			
				
				<div id="logout">	
					
					<img id="signoutLogo" src="images/ProfileIIcon.png" alt="vendorSC logo">
					<form action="UserHomePageServlet" method="GET">
						<button type="submit" name="logout" id="logoutButton">Logout</button><br>
					</form>	
				</div>
				
	</div>
<!-- End of Header Div -->


<!-- Start of Body Div -->

	<div id="innerDiv">
	

<!-- Product Section Start -->
		<div id="prodDiv">
		
		
			<div class="headDiv">
			
				<h1 class="head">RECOMMENDED PRODUCTS</h1>
			
			</div>
			
			<div class="bodyDiv">
			
<!-- EXAMPLE PRODUCTS START -->
				<%Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				ArrayList <Product> products = new ArrayList <Product>();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
					ps = conn.prepareStatement("SELECT * FROM Product");
					rs = ps.executeQuery();
					while (rs.next()) {				
						Product prod = new Product(rs.getInt("productID"));
						products.add(prod);
					}
				}
				finally {conn.close();
				ps.close();}
				
				session.setAttribute("products", products);
				int count = 0;
				ArrayList<Integer> indices = new ArrayList <Integer>();
				if (products.size() == 0){%>
					<div class="productBody">
				
					<h1>No Recommended Products Available </h1>
				
				</div>
				<% }
				else{
					while (count < products.size()){
				
					int number = (int) (Math.random() * products.size()-1);
					if (indices.contains(number) || user.hasPurchased(products.get(number))){
						count++;
						continue;
					}
					else{
					indices.add(number);
					%>
					
					<div class="productBody">
				
					<img class="prodLogo" src="<%=products.get(number).getImagePath()%>" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="prodName">PRODUCT NAME: <%=products.get(number).getName() %> </h1>
						<h1 class="prodCat">PRODUCT CATEGORY: <%=products.get(number).getName() %></h1>
						<% if(products.get(number).getRating()<0){ %>
							<h1 class="prodCat">RATING: NOT YET RATED!</h1>
						<%} 
						else{%>
							<h1 class="prodCat">RATING: <%=products.get(number).getRating() %></h1>
						<%} %>
						
						
						<form action="UserHomePageServlet" method="GET">
							<input type="hidden" name="prodIndex" value="<%= number %>" />
							<button type="submit" name="purchase" class="prod-purchase">VIEW</button>
						</form>		
						
						
					</div>
				
				</div>
					
					
					
						
					<% }count++;
					}	}
				%>
				
				
<!-- EXAMPLE PRODUCTS END -->
			
			</div>
			
		
		</div>
<!-- Product Section END -->
		
<!-- Business BIO Start -->
		<div id="bioDiv">
			
			<div class="headDiv">
			
				<h1 class="head">RECOMMENDED BUSINESSES</h1>
			
			</div>
			
			<div class="bodyDiv">
			
<!-- EXAMPLE BUSINESSES START -->
				<%conn = null;
				ps = null;
				rs = null;
				ArrayList <Business> businesses = new ArrayList <Business>();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
					ps = conn.prepareStatement("SELECT * FROM Business");
					rs = ps.executeQuery();
					while (rs.next()) {				
						Business business = new Business(rs.getString("username"));
						businesses.add(business);
					}
				}
				finally {conn.close();
				ps.close();}
				
				session.setAttribute("businesses", businesses);
				count = 0;
				indices = new ArrayList <Integer>();
				if (businesses.size() == 0){%>
					<div class="productBody">
				
					<h1>No Recommended Businesses Available </h1>
				
				</div>
				<% }
				else{
					while (count < businesses.size()){
				
					int number = (int) (Math.random() * businesses.size()-1);
					if (indices.contains(number)){
						count++;
						continue;
					}
					else{
					indices.add(number);
					%>
					
					<div class="productBody">
				
					<img class="prodLogo" src="<%= businesses.get(number).getImagePath() %>" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="busiName">"<%=businesses.get(number).getName() %>"</h1>
						
						<form action="UserHomePageServlet" method="GET">
							<input type="hidden" name="busiIndex" value="<%= number %>" />
							<button type="submit" name="business" class="busiView">VIEW PAGE</button>
						</form>		
						
						
					</div>
				
					</div>
					
					
					
						
					<% }count++;
					}	
				}
				%>
				
				
				
				
<!-- EXAMPLE BUSINESSES END -->
			
			</div>
				
			
		</div>
<!-- Business BIO End -->
	
	
	</div>


<!-- End of Body Div -->

<!-- Start of Footer Div -->
	<div id="footer">
		<div id="footer-divider-left"></div>
		<div id="footer-divider-right">
			<img src="images/vendorSClogowithbackground.png" alt="footerLogo">
		</div>
	</div>
<!-- End of Footer Div -->

	
</body>
</html>