<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ page import = "backend.Product"%>
<%@ page import = "backend.Review"%>
<%@ page import = "backend.User"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>VendorSC</title>
	<link rel="stylesheet" type="text/css" href="css/ProductPage.css">
	<!-- 	Icon Library	 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>

<!-- Start of Header Div -->
	<div id="header">
	
			<img id="headerLogo" src="images/vendorSClogowithbackground.png" alt="vendorSC logo">
			<div id="header-divider"></div> 
			<div id="search-form">
			
				<form action = "ProductPageServlet" method="GET">
				
					<div id="searchBar">
						<input type="text" name="userSearch" class="form-control" id="search-id" placeholder="SEARCH FOR PRODUCT OR BUSINESS">
						<button type="submit" id="submit-button"><i class="fa fa-search"></i>Search</button><br>
						<label class="radButton"><input type="radio" name="filter" value="business"> Business</label>
						<label class="radButton"><input type="radio" name="filter" value="product"> Product</label>
					</div>
					<input type="hidden" name="prodIndex" value="<%= request.getParameter("prodIndex") %>" />
					
				</form>
			
			</div>
			
			
				
				<div id="logout">	
					
					<img id="signoutLogo" src="images/ProfileIIcon.png" alt="vendorSC logo">
					<form action = "ProductPageServlet" method="GET">
						<button type="submit" id="logoutButton" name="logout">Logout</button><br>
					</form>	
				</div>
				
	</div>
<!-- End of Header Div -->
	
	<%
	
		Product p = ((ArrayList<Product>)(session.getAttribute("products"))).get(Integer.parseInt(request.getParameter("prodIndex")));
	
		ArrayList<Review> reviews = p.getReviews();
		
		double rating = 0.0;
		for(int i=0; i<reviews.size(); i++){
			rating += reviews.get(i).getRating();
		}
		rating = rating/reviews.size();
	%>
	
	<div id="containerDiv">
	
		<div id="imageDiv">
			<img src="images/vendorSClogo.png" alt="logo" id = "logo">
		</div>
		
		<div id="productDiv">
		
			<h1 class="info">NAME: <%= p.getName() %></h1><br>
			<h1 class="info">DESCRIPTION: <%= p.getDescription() %></p></h1>
			
			<% if(p.getRating()<0){ %>
				<h1 class="info">RATING: NOT YET RATED!</h1>
			<%
			} 
			else{
			%>
				<h1 class="info">RATING: <%= rating %></h1>
			<%
			} 
			%>
			<% if(session.getAttribute("user")!=null) { %>
				<form action="ProductPageServlet" method="GET">
					<input type="hidden" name="prodIndex" value="<%= request.getParameter("prodIndex") %>" />
					<button type="submit" name="purchase" id="purchase">PURCHASE</button>
				</form>
			<%} %>
		
		</div>
	
	</div>
	<div id="reviewDiv">
		
		<% 
	    	if (p.getReviews().size() == 0){
	    %>
	    	<h1 id="revs">REVIEWS: NO REVIEWS YET!</h1><br>
		
		<%
			} else { 
				
		%>
			<h1 id="revs">REVIEWS: </h1><br>
		<%
				int count = p.getReviews().size()-1;
				
				while (count >= 0){
		
		%>
			<div class="reviewContainer">
				<div class="image">
					<img src="<%= reviews.get(count).getUserImage()  %>>" alt="logo" class="profilePic">
				</div>
				<div class="reviewInfo">
				
					<h1 class="username">USERNAME: <%= reviews.get(count).getUsername() %></h1>
					<p class="statement">STATEMENT: <%= reviews.get(count).getReviewText() %></p>
					<h1 class="username">RATING: <%= reviews.get(count).getRating() %></h1>
				
				</div>
			
			</div>
			<% count--; } %>
			
		<%} %>
		
		<% 
			if(session.getAttribute("user")!=null ) { 
			
		%>
			<div class="reviewContainer">
		
				<form action="ProductPageServlet" method="GET" id="edit-bio">
			
					
					<h1 id="reviewHeader">RATE (1-5)</h1><br>
					<label class="button"><input type="radio" name="rating" value="1"> 1</label>
					<label class="button"><input type="radio" name="rating" value="2"> 2</label>
					<label class="button"><input type="radio" name="rating" value="3"> 3</label>
					<label class="button"><input type="radio" name="rating" value="4"> 4</label>
					<label class="button"><input type="radio" name="rating" value="5"> 5</label><br>
					<h1 id="reviewHeader">ADD A STATEMENT</h1><br>
					<textarea name="reviewText" id="userInput">ENTER TEXT HERE</textarea><br>
					<button type="submit" name="submitReview" value="submitReview" id="reviewButton">SUBMIT</button>
					<input type="hidden" name="prodIndex" value="<%= request.getParameter("prodIndex") %>" />
				
				
				</form>	
		
			</div>
		<%} %>
	
	</div>




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