<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

<!-- Start of Header Div -->
	<div id="header">
	
			<img id="headerLogo" src="vendorSClogowithbackground.png" alt="vendorSC logo">
			<div id="header-divider"></div> 
				
			<div id="searchBar">
			
				<h1 id="busiTitle">BUSINESS TITLE</h1>
			
			</div>
				
			<div id="logout">
			
				<img id="signoutLogo" src="../images/ProfileIIcon.png" alt="vendorSC logo">
				<form action = "GuestHomePage.jsp">
				<button type="submit" id="logoutButton">Logout</button><br>
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
				<div class="productBody">
				
					<img class="prodLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="prodName">PRODUCT NAME: NAME</h1>
						<h1 class="prodCat">PRODUCT CATEGORY: CATEGORY</h1>
						<form action="" method="GET">
							<button type="submit" class="edit-prod-button">EDIT</button>
						</form>	
						<form action="" method="GET">
							<button type="submit" class="remove">REMOVE</button>
						</form>		
						
						
					</div>
				
				</div>
				
				<div class="productBody">
				
					<img class="prodLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="prodName">PRODUCT NAME: NAME</h1>
						<h1 class="prodCat">PRODUCT CATEGORY: CATEGORY</h1>
						<form action="" method="GET">
							<button type="submit" class="edit-prod-button">EDIT</button>
						</form>	
						<form action="" method="GET">
							<button type="submit" class="remove">REMOVE</button>
						</form>		
						
						
					</div>
				
				</div>
				
				<div class="productBody">
				
					<img class="prodLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="prodName">PRODUCT NAME: NAME</h1>
						<h1 class="prodCat">PRODUCT CATEGORY: CATEGORY</h1>
						<form action="" method="GET">
							<button type="submit" class="edit-prod-button">EDIT</button>
						</form>	
						<form action="" method="GET">
							<button type="submit" class="remove">REMOVE</button>
						</form>		
						
						
					</div>
				
				</div>
<!-- EXAMPLE PRODUCTS END -->
			
			</div>
			
			<form action="" method="GET" id="email-notifs">
				<button type="submit" id="add-product-button">ADD PRODUCT</button><br>
			</form>	
			
		
		</div>
<!-- Product Section END -->
		
<!-- Business BIO Start -->
		<div id="bioDiv">
			
			<div class="headDiv">
			
				<h1 class="head">YOUR BIO</h1>
			
			</div>
			
			<div class="bodyDiv">
			
				<h1 id="bioHead">BUSINESS DESCRIPTION:</h1><br>
				<p id="bio">THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.THIS IS A BUNCH OF RANDOM TEXT THAT HAS NO MEANING. I DO NOT KNOW WHAT TO TYPE, I AM JUST WINGING THIS.</p>
			
			</div>
					
			<form action="" method="GET" id="edit-bio">
				<button type="submit" id="edit-bio-button">EDIT</button>
			</form>	
			<form action="" method="GET" id="email-notifs">
				<button type="submit" id="email-button">EMAIL NOTIFICATIONS</button>
			</form>		
				
			
		</div>
<!-- Business BIO End -->
	
	
	</div>


<!-- End of Body Div -->

<!-- Start of Footer Div -->
	<div id="footer">
		<div id="footer-divider-left"></div>
		<div id="footer-divider-right">
			<img src="../images/vendorSClogowithbackground.png" alt="footerLogo">
		</div>
	</div>
<!-- End of Footer Div -->

	
</body>
</html>