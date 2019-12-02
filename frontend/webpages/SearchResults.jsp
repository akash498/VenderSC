<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ page import = "backend.Business"%>
<%@ page import = "backend.Product"%>
<%@ page import = "backend.Search"%>
<%@ page import = "java.sql.*" %>
<!DOCTYPE html>
<head>
		<meta charset="UTF-8">
		<title>VendorSC</title>
		<link rel="stylesheet" type="text/css" href="css/HeaderFooterTemplateCSS.css">
		<link rel="stylesheet" type="text/css" href="css/SearchResults.css">
		<!-- 	Icon Library	 -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>

<body>
<!-- Start Template of Header Div -->
	<div id="header">
			<img id="headerLogo" src="images/vendorSClogowithbackground.png" alt="vendorSC logo">
			<div id="header-divider"></div> 
			<div id="search-form">
				<form action="Search" method="GET" id="search-form">
					<div id="searchBar">
						<input type="text" name="userSearch" class="form-control" id="search-id" placeholder="SEARCH FOR PRODUCT OR BUSINESS">
						<button type="submit" id="submit-button"><i class="fa fa-search"></i>Search</button><br>
						<label class="radButton"><input type="radio" name="filter" value="business"> Business</label>
						<label class="radButton"><input type="radio" name="filter" value="product"> Product</label>
					</div>
				</form> 
			</div>
			<%if (session.getAttribute("user")!= null){%>
				
			
			<form action="GuestHomePage" method="GET" id="search-form">
				<div id="logout">	
					<img id="signoutLogo" src="images/ProfileIIcon.png" alt="vendorSC logo">
					<button type="submit" id="logoutButton">Logout</button><br>
				</div>		
			</form> 
			<%} %>
	</div>
<!-- End Template of Header Div -->
<div class ="searchResultsDiv">
	<div class='searchResultsHeader'>SEARCH RESULTS FOR <%=request.getParameter("userSearch") %></div>
<%
String searchType = (String)request.getParameter("searchType");
String userSearch = (String)request.getParameter("userSearch");
String businessName = "";
if (searchType.contentEquals("product")){
	
for (int i = 0; i < Search.productResults.size(); i++) {

				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				ArrayList <Product> products = new ArrayList <Product>();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					conn = DriverManager.getConnection("jdbc:mysql://google/vendorDB?cloudSqlInstance=vendorsc:us-central1:vendor&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false&user=vendor&password=0203");
					ps = conn.prepareStatement("SELECT * FROM Business WHERE businessID=?");
					ps.setInt(1,Search.productResults.get(i).getBusinessId());
					rs = ps.executeQuery();
					while (rs.next()) {				
						businessName = rs.getString("name");
					}
				}
				finally {conn.close();
				ps.close();}
				%>
	<div class='product'>
		<div class='productImage'>
			<a href=''>
				<img src='<%=Search.productResults.get(i).getImagePath() %>' onclick='details()'/>
			</a>
		</div>
		<div class='productInfo'>
			<div class='productName'><%=Search.productResults.get(i).getName() %></div>
			<div class='businessName'><%=businessName %></div>
			<div class='rating'>Rating: <%=Search.productResults.get(i).getRating() %></div>
			<% if (session.getAttribute("loggedIn")!=null){ %>
			<button class="purchase">PURCHASE</button><%} %>
			
		</div> 
	</div>
	<hr>
<%
	} 
}

else if (searchType.contentEquals("business")){
	for (int i = 0; i < Search.businessResults.size(); i++) {
		%>
			<div class='product'>
				<div class='productImage'>
					<a href=''>
						<img src="<%=Search.businessResults.get(i).getImagePath()%> href = ""/>
					</a>
				</div>
				<div class='productInfo'>
					<div class='productName'><%=Search.businessResults.get(i).getName() %></div>
					
					
				</div> 
			</div>
			<hr>
		<%
			}
}
%>
</div>
<!-- Start Template of Footer Div -->
	<div id="footer">
		<div id="footer-divider">
			<img src="../images/vendorSClogowithbackground.png" alt="footerLogo">
		</div>
	</div>
<!-- End Template of Header Div -->
</body>
</html>