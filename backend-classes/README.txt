Please update this file when you do work on the backend.

NOTE: When making a servlet, INCLUDE "Servlet" in the end of the class name.

Product.java: Status - Incomplete
	Need to update SQL string for insert when database is up and running
	
Business.java: Status - Unknown
	I added a boolean for email logic.
	TODO- add emailOn column to database to store whether businesses have email notifications on or off

EditProductPageServlet.java: Status - Incomplete

	Business class needs to be implemented so the data is stored in the business.

	We need to have the image that was uploaded saved in a folder located in WebContent called "images".

EditProductPage.jsp: Status - Incomplete
	
	Business Product information needs to load as place holders
	
	All buttons and input fields behave as expected.

AddProductPageServlet.java: Status - Incomplete

	Business class needs to be implemented so the data is stored in the business.

	We need to have the image that was uploaded saved in a folder located in WebContent called "images".

AddProductPage.jsp: Status - Complete

	All buttons and input fields behave as expected.

BusinessHomePageServlet.java: Status - Incomplete

	This is the servlet that all buttons in BusinessHomePage.jsp should redirect to. Depending on the URL parameters, the servlet should
	respond appropriately.

	Email Button: Status - Incomplete

		Someone who knows how the business class is being passed needs to implement the pseudo code provided. The thread code is
		correct.

	Edit Bio: Status - Incomplete

		The business's bio needs to be changed to the new bio. The servlet file has more details on this.

	Edit Product: Status - Incomplete

		This button needs to be modified so it interacts with the business that is currently logged in. More details are in the servlet.

	Remove Product: Status - Incomplete

		This button needs to be modified so it interacts with the business that is currently logged in. More details are in the servlet.

	Add Product: Status - Incomplete

		This button needs to be modified so it interacts with the business that is currently logged in. More details are in the servlet.

BusinessHomePage.jsp: Status - Incomplete

	NOTE (11/29/12019): the frontend aspect of this file was updated so please copy over the updated jsp AND css files associated.

	NOTE #2: The buttons are complete from the jsp side. The servlet aspect of each button is not complete. See the servlet for more
	details.

	Loading Business Info: Status - Incomplete

		The business information needs to be parsed and generate the information needed by this page.

	Edit Bio Button: Status - Complete 

		This button works as it should.

	Email Button: Status - Complete

		This button works as it should.

	Edit Product: Status - Complete

		This button works as it should.

	Remove Product: Status - Complete

		This button works as it should.

	Add Product: Status - Complete

		This button works as it should.

Email_Thread: Status - Complete!

	This class has been fully implemented. Please look at the Email_Thread.java file for how to get it working in your project.


