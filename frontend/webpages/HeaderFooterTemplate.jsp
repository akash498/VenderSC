<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
		<meta charset="UTF-8">
		<title>VendorSC</title>
		<link rel="stylesheet" type="text/css" href="../css/HeaderFooterTemplateCSS.css">
		<!-- 	Icon Library	 -->
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
<!-- Start Template of Header Div -->
	<div id="header">
	
			<img id="headerLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
			<div id="header-divider"></div> 
			<div id="search-form">
			
				<form action="" method="GET" id="search-form">
				
					<div id="searchBar">
						<input type="text" name="" class="form-control" id="search-id" placeholder="SEARCH FOR PRODUCT OR BUSINESS">
						<button type="submit" id="submit-button"><i class="fa fa-search"></i>Search</button><br>
						<label class="radButton"><input type="radio" name="filter" value="business"> Business</label>
						<label class="radButton"><input type="radio" name="filter" value="product"> Product</label>
					</div>
				
				</form> 
			
			</div>
			
			
			<form action="" method="GET" id="search-form">
				
				
				<div id="logout">	
					
					<img id="signoutLogo" src="../images/ProfileIIcon.png" alt="vendorSC logo">
					<button type="submit" id="logoutButton">Logout</button><br>
						
				</div>
				
			</form> 
			
			
	</div>
<!-- End Template of Header Div -->

<!-- Start Template of Footer Div -->
		<div id="footer">
			<div id="footer-divider">
				<img src="../images/vendorSClogowithbackground.png" alt="footerLogo">
			</div>
		</div>
<!-- End Template of Header Div -->
</body>
</html>