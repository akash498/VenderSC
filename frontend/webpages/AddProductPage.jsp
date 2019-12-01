<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
	<title>VendorSC</title>
	<link rel="stylesheet" type="text/css" href="AddProductPage.css">
	<!-- 	Icon Library	 -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">



</head>
<body>

<!-- Start of Header Div -->
	<div id="header">

			<img id="headerLogo" src="images/vendorSClogowithbackground.png" alt="vendorSC logo">
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

			<h1 id="addProd">NEW PRODUCT FORM</h1>

			<form action="AddProductPageServlet" method="POST" id="search-form" enctype="multipart/form-data">

				<div id="formDiv">
					<label id="productTitle">Product Name:</label><br>
					<input type="text" name="prodName" class="form-control" id="productText" placeholder="ADD A PRODUCT NAME:">
					<br><label id="productDescription">Description:</label><br>
					<input type="text" name="prodDesc" class="form-control" id="productDescribed" placeholder="ADD A PRODUCT DESCRIPTION">
					<br>
					<div id="imageUpload">
						<h1 id="imageLabel">ADD IMAGE:</h1>
						<br>
						<div class="upload-btn-wrapper">
							<button class="btn-upload">Upload a file</button>
							<input type="file" name="image" accept="image/*" id="fileBrowser">
						</div>
					</div>
					<div id="rateDiv">
						<h1 id="rateLabel">DISPLAY RATING:</h1>
						<br>
						<button onclick="updateRate(1)" type="button" id="yes">YES</button>
						<button onclick="updateRate(0)" type="button" id="no">NO</button>
						<input type="hidden" name="ratable" id="ratable" value="" />
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
			<img src="images/vendorSClogowithbackground.png" alt="footerLogo">
		</div>
	</div>
<!-- End of Footer Div -->
<!-- Javascript to change tect on file browser -->
<script>
	var button = document.querySelector(".btn-upload");
	var fileBrowser = document.querySelector("#fileBrowser");

	fileBrowser.onchange = function() {

		console.log(fileBrowser.value);

		if(fileBrowser.value == null || fileBrowser.value == ""){
			button.innerHTML = "Upload a file";
		}
		else {
			button.innerHTML = fileBrowser.value;
		}

	};

	function updateRate(x) {
		if(x==0){

			document.getElementById("yes").style.backgroundColor = "#C4C4C4";
			document.getElementById("yes").style.color = "#929292";

			document.getElementById("no").style.backgroundColor = "#929292";
			document.getElementById("no").style.color = "#C4C4C4";

			document.getElementById("ratable").value = "no";
		}
		else {
			document.getElementById("yes").style.backgroundColor = "#929292";
			document.getElementById("yes").style.color = "#C4C4C4";

			document.getElementById("no").style.backgroundColor = "#C4C4C4";
			document.getElementById("no").style.color = "#929292";

			document.getElementById("ratable").value = "yes";
		}
		console.log(document.getElementById("ratable").value);
	}
</script>

</body>
</html>
