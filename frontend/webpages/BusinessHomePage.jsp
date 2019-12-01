<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.ArrayList"%>
<%@ page import = "backend_classes.Business"%>
<%@ page import = "backend_classes.Product"%>
<%@ page import = "backend_classes.Business"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>VendorSC</title>
	<link rel="stylesheet" type="text/css" href="BusinessHomePage.css">
	<!-- 	Icon Library	 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>

<%Business business = (Business)session.getAttribute("business"); %>
<!-- Start of Header Div -->
	<div id="header">
	
			<img id="headerLogo" src="images/vendorSClogowithbackground.png" alt="vendorSC logo">
			<div id="header-divider"></div> 
				
			<div id="searchBar">
			
				<h1 id="busiTitle"> <%=business.getName() %></h1>
			
			</div>
				
			<div id="logout">
			
				<img id="signoutLogo" src="images/ProfileIIcon.png" alt="vendorSC logo">
				<form action="BusinessHomePageServlet" method="GET">
				<button type="submit" name="logout" value="logout" id="logoutButton">Logout</button><br>
				</form>
			
			</div>
				
			
	</div>
<!-- End of Header Div -->


<!-- Start of Body Div -->

	<div id="innerDiv">
	

<!-- Product Section Start -->
		<div id="prodDiv">
		
		
			<div class="headDiv">
			
				<h1 class="head">YOUR PRODUCTS</h1>
			
			</div>
			
			<div class="bodyDiv">
			
<!-- EXAMPLE PRODUCTS START -->
			
			<% ArrayList<Product> products = business.getProducts();
			
			
			
			
			
			for (int i = 0; i < products.size(); i++ ) {%>
				
				
				<div class="productBody">
				
					<img class="prodLogo" src="<%=products.get(i).getImagePath() %>" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="prodName"><%=products.get(i).getName() %></h1>
						<h1 class="prodCat">PRODUCT CATEGORY:<%=products.get(i).getName() %></h1>
						<form action="BusinessHomePageServlet" method="GET">
							<button type="submit" name="editProduct" value="<%=i%>" class="edit-prod-button">EDIT</button>
						</form>	
						<form action="BusinessHomePageServlet" method="GET">
							<button type="submit" name="removeProduct" value="<%=i%>" class="remove">REMOVE</button>
						</form>		
						
						
					</div>
				
				</div>
				
				
				
			
			
			<%} %>
			
			
			
			
			
			<!--  
				<div class="productBody">
				
					<img class="prodLogo" src="images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="prodName">PRODUCT NAME: NAME</h1>
						<h1 class="prodCat">PRODUCT CATEGORY: CATEGORY</h1>
						<form action="BusinessHomePageServlet" method="GET">
							<button type="submit" name="editProduct" value="0" class="edit-prod-button">EDIT</button>
						</form>	
						<form action="BusinessHomePageServlet" method="GET">
							<button type="submit" name="removeProduct" value="0" class="remove">REMOVE</button>
						</form>		
						
						
					</div>
				
				</div>
				
				<div class="productBody">
				
					<img class="prodLogo" src="images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="prodName">PRODUCT NAME: NAME</h1>
						<h1 class="prodCat">PRODUCT CATEGORY: CATEGORY</h1>
						<form action="BusinessHomePageServlet" method="GET">
							<button type="submit" name="editProduct" value="1" class="edit-prod-button">EDIT</button>
						</form>	
						<form action="BusinessHomePageServlet" method="GET">
							<button type="submit" name="removeProduct" value="1" class="remove">REMOVE</button>
						</form>		
						
						
					</div>
				
				</div>
				
				<div class="productBody">
				
					<img class="prodLogo" src="images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="prodName">PRODUCT NAME: NAME</h1>
						<h1 class="prodCat">PRODUCT CATEGORY: CATEGORY</h1>
						<form action="BusinessHomePageServlet" method="GET">
							<button type="submit" name="editProduct" value="2" class="edit-prod-button">EDIT</button>
						</form>	
						<form action="BusinessHomePageServlet" method="GET">
							<button type="submit" name="removeProduct" value="2" class="remove">REMOVE</button>
						</form>		
						
						
					</div>
				
				</div>-->
<!-- EXAMPLE PRODUCTS END -->
			
			</div>
			
			<form action="BusinessHomePageServlet" method="GET" id="email-notifs">
				<button type="submit" name="addProduct" value="addProduct" id="add-product-button">ADD PRODUCT</button><br>
			</form>	
			
		
		</div>
<!-- Product Section END -->
		
<!-- Business BIO Start -->
		<div id="bioDiv">
			
			<div class="headDiv">
			
				<h1 class="head">BIO</h1>
			
			</div>
			
			<div class="bodyDivB">
			
				<h1 id="bioHead">BUSINESS DESCRIPTION:</h1><br>
				
				<form action="BusinessHomePageServlet" method="GET" id="edit-bio">
			
			
					<textarea name="bioText" id="bio"><%=business.getDescription() %>
					</textarea><br>
					<button type="submit" name="editBio" value="editBio" id="edit-bio-button">EDIT</button>
				
				
				</form>	
				
			
			</div>
					
			
			
			
			<form action="BusinessHomePageServlet" method="GET" id="email-notifs">
				<button type="submit" name="email" value="email" id="email-button">EMAIL NOTIFICATIONS</button>
			</form>		
				
			
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

<script>














</script>
</html>