<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"%>
<%@ page import = "backend.Business"%>
<%@ page import = "backend.Product"%>
<%@ page import = "backend.User"%>

<!DOCTYPE html>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="css/BusinessPage.css">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<link rel="stylesheet" href = "Business.css">
	<link href="https://fonts.googleapis.com/css?family:Merriweather&display=swap" rel="stylesheet">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>

<body>


	<div id="header">
	
			<img id="headerLogo" src="images/vendorSClogowithbackground.png" alt="vendorSC logo">
			<div id="header-divider"></div> 
			<div id="search-form">
			
				<form action = "Search" method="GET">
				
					<div id="searchBar">
						<input type="text" name="userSearch" class="form-control" id="search-id" placeholder="SEARCH FOR PRODUCT OR BUSINESS">
						<button type="submit" id="submit-button"><i class="fa fa-search"></i>Search</button><br>
						<label class="radButton"><input type="radio" name="filter" value="business"> Business</label>
						<label class="radButton"><input type="radio" name="filter" value="product"> Product</label>
					</div>
					<input type="hidden" name="busiIndex" value="<%= request.getParameter("busiIndex") %>" />
					
				</form>
			
			</div>
			
			
			<form action="" method="GET" id="search-form">
				
				<div id="logout">	
					
					<img id="signoutLogo" src="images/ProfileIIcon.png" alt="vendorSC logo">
					<button type="submit" id="logoutButton">Logout</button><br>
						
				</div>
				
			</form> 
			
			
	</div>

	<div class="container-fluid">
  	
  		<%
  			ArrayList<Business> businesses = (ArrayList<Business>)session.getAttribute("businesses");
  			Business b = (businesses).get(Integer.parseInt(request.getParameter("busiIndex")));
  		
  		%>
  
		<div class = "row d-flex justify-content-center">
	
			<div class = "col-md-3">
				<img src="images/vendorSClogo.png" alt="logo" id = "logo" style="max-width:40%; ">
			</div>
		
			<div class = "col-md-6">
  				<h1 style = "color:black;font-family:varsity;">NAME: <%= b.getName() %></h1>
  				<h4 style="color:black;font-family:varsity;">DESCRIPTION: <%= b.getDescription() %>.</h4>
  			</div>

		</div>
  
		<br><br>
  
		<!-- Products -->
		<div class = "row d-flex justify-content-center"> 
			<div class = "col-md-3">
				<h2 style = "color:black; font-family:varsity;">PRODUCTS</h2></div>
			</div>
	    
	    
	    	<br>	
    		<%
    			ArrayList<Product> products = b.getProducts();
    			for(int i=0; i<products.size(); i++){
    		%>
    		<!-- Loop through and display all products -->
    	    <div class = "row d-flex justify-content-center" style="border-bottom: 2px solid black; font-family:varsity;">

    			<div class = "col-md-3 ">
  					<img src="<%= products.get(i).getImagePath() %>" alt="logo" id = "logo" style="max-width:40%;">
  				</div>
  
  				<div class = "col-md-6">
  					<h4 style = "color:black;font-family:varsity;">NAME: <%= products.get(i).getName() %></h4>
  					<h4 style="color:black; font-family:varsity;">DESCRIPTION: <%= products.get(i).getDescription() %></h4>
  					<%
  						if(products.get(i).getRating()<0){
  					%>
  						<h4 style="color:black; font-family:varsity;">RATING: NOT RATED YET!</h4>
  					<%
  						} else {
  					%>
  						<h4 style="color:black; font-family:varsity;">RATING: <%= products.get(i).getRating() %></h4>
  					<%
  						}
  					%>
  					<a class="btn btn-outline-danger my-2 my-sm-0" href="BusinessServlet?busiIndex=<%= request.getParameter("busiIndex") %>&prodNum=<%= products.get(i).getProductId() %>" style="	
  					border: 2px solid; color: #FFCC00;background-color:#990000; font-family: varsity;">VIEW</a>
					<br><br>
  				</div>
			
			</div>
		
			<br><br>
			
			<% } %>
    	
    
    </div>
    
    <!-- Start Template of Footer Div -->
	<div id="footer">
		<div id="footer-divider">
			<img src="images/vendorSClogowithbackground.png" alt="footerLogo">
		</div>
	</div>
	<!-- End Template of Header Div -->
  

</body>
</html>










