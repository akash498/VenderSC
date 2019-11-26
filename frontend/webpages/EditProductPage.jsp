<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>VendorSC</title>
	<link rel="stylesheet" type="text/css" href="../css/EditProductPage.css">
	<!-- 	Icon Library	 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">


</head>
<body>

<!-- Start of Header Div -->
	<div id="header">
	
			<img id="headerLogo" src="../images/vendorSClogowithbackground.png" alt="vendorSC logo">
			<div id="header-divider"></div> 
				
			<div id="searchBar">
			
				<h1 id="busiTitle">BUSINESS TITLE</h1>
			
			</div>
				
			<div id="logout"></div>
				
			
	</div>
<!-- End of Header Div -->


<!-- Start of Body Div -->

	<div id="innerDiv">
	
		<div id="headDiv">
		
			<h1 id="addProd">EDIT PRODUCT INFO</h1>
			
			<form action="" method="GET" id="search-form">
				
				<div id="formDiv">
					<label id="productTitle">Product Name:</label><br>
					<input type="text" name="" class="form-control" id="productText" placeholder="ADD A PRODUCT NAME:">
					<br><label id="productDescription">Description:</label><br>
					<input type="text" name="" class="form-control" id="productDescribed" placeholder="ADD A PRODUCT DESCRIPTION">
					<br>
					<div id="imageUpload">
						<h1 id="imageLabel">ADD IMAGE:</h1>
					</div>
					<div id="rateDiv">
						<h1 id="rateLabel">DISPLAY RATING:</h1>
						<br>
						<button type="button" id="yes">YES</button>
						<button type="button" id="no">NO</button>
					</div>
					<br>
					<button type="submit" id="submit">SUBMIT FORM FOR VERIFICATION</button><br>
				</div>
				
			</form> 
		
		</div>
	
	
	
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