<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>VendorSC</title>
	<link rel="stylesheet" type="text/css" href="UserHomePage.css">
	<!-- 	Icon Library	 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>

<!-- Start of Header Div -->
	<div id="header">
	
			<img id="headerLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
			<div id="header-divider"></div> 
			<div id="search-form">
			
				
					<div id="searchBar">
						<input type="text" name="" class="form-control" id="search-id" placeholder="SEARCH FOR PRODUCT OR BUSINESS">
						<button type="submit" id="submit-button"><i class="fa fa-search"></i>Search</button><br>
						<label class="radButton"><input type="radio" name="filter" value="business"> Business</label>
						<label class="radButton"><input type="radio" name="filter" value="product"> Product</label>
					</div>
				
			
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
			
				<h1 class="head">RECOMMENDED PRODUCTS</h1>
			
			</div>
			
			<div class="bodyDiv">
			
<!-- EXAMPLE PRODUCTS START -->
				<div class="productBody">
				
					<img class="prodLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="prodName">PRODUCT NAME: NAME</h1>
						<h1 class="prodCat">PRODUCT CATEGORY: CATEGORY</h1>
						<h1 class="prodCat">RATING: 4.5</h1>
						
						<form action="" method="GET">
							<button type="submit" class="prod-purchase">PURCHASE</button>
						</form>		
						
						
					</div>
				
				</div>
				
				<div class="productBody">
				
					<img class="prodLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="prodName">PRODUCT NAME: NAME</h1>
						<h1 class="prodCat">PRODUCT CATEGORY: CATEGORY</h1>
						<h1 class="prodCat">RATING: 4.5</h1>
						
						<form action="" method="GET">
							<button type="submit" class="prod-purchase">PURCHASE</button>
						</form>		
						
						
					</div>
				
				</div>
				
				<div class="productBody">
				
					<img class="prodLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="prodName">PRODUCT NAME: NAME</h1>
						<h1 class="prodCat">PRODUCT CATEGORY: CATEGORY</h1>
						<h1 class="prodCat">RATING: 4.5</h1>
						
						<form action="" method="GET">
							<button type="submit" class="prod-purchase">PURCHASE</button>
						</form>		
						
						
					</div>
				
				</div>
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
				<div class="productBody">
				
					<img class="prodLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="busiName">VENDORSC</h1>
						
						<form action="" method="GET">
							<button type="submit" class="busiView">VIEW PAGE</button>
						</form>		
						
						
					</div>
				
				</div>
				
				<div class="productBody">
				
					<img class="prodLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="busiName">VENDORSC</h1>
						
						<form action="" method="GET">
							<button type="submit" class="busiView">VIEW PAGE</button>
						</form>		
						
						
					</div>
				
				</div>
				
				<div class="productBody">
				
					<img class="prodLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
					<div class="prodInfo">
					
						<h1 class="busiName">VENDORSC</h1>
						
						<form action="" method="GET">
							<button type="submit" class="busiView">VIEW PAGE</button>
						</form>		
						
						
					</div>
				
				</div>
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
			<img src="../images/vendorSClogowithbackground.png" alt="footerLogo">
		</div>
	</div>
<!-- End of Footer Div -->

	
</body>
</html>