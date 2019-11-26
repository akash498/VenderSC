<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
		<meta charset="UTF-8">
		<title>VendorSC</title>
		<link rel="stylesheet" type="text/css" href="../css/HeaderFooterTemplateCSS.css">
		<link rel="stylesheet" type="text/css" href="../css/SearchResults.css">
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
<div class ="searchResultsDiv">
	<div class='searchResultsHeader'>SEARCH RESULTS FOR ''</div>
<%
	for (int i = 0; i < 10; i++) {
%>
	<div class='product'>
		<div class='productImage'>
			<a href=''>
				<img src='https://encrypted-tbn1.gstatic.com/shopping?q=tbn:ANd9GcTWpGYhGdmN_cihqVfLH4hC9-3g1iLV1bZs9RgEKAIHeunXqd3DBiNwF3BAbiGg5B6ltbYvjaiNFnk&usqp=CAc' onclick='details()'/>
			</a>
		</div>
		<div class='productInfo'>
			<div class='productName'>Product name</div>
			<div class='businessName'>Business name</div>
			<div class='rating'>Rating: </div>
			<% // add java for if (logged in) %>
			<button class="purchase">PURCHASE</button>
			<% %>
		</div> 
	</div>
	<hr>
<%
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