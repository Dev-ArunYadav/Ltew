<%@page import="java.util.ArrayList"%>
<%@page import="com.Dao.ProductDao"%>
<%@page import="com.Products.Category"%>
<%@page import="java.util.List"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.Dao.CategoryDao"%>
<%@page import="com.User.UserDetails"%>

<!-- --------- Here We Authenticate the normal user who have trying to Access the Admin Page -->
<%
UserDetails user1 = (UserDetails) session.getAttribute("user-Name");
if (user1 == null) {
	session.setAttribute("reg-failed", "You have not Login!! Login First");
	response.sendRedirect("login.jsp");
	return;
} else {
	if (user1.getUtype().equals("normal")) {
		session.setAttribute("reg-failed", "You are not admin!! This page is only accessable by Admin only.");
		response.sendRedirect("login.jsp");
		return;
	}
}
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
.admin .card {
	border: 2px solid #00dbc4;
}

.admin .card:hover {
	background: #00dbc4;
	cursor: pointer;
}
</style>
<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Admin panel</title>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container text-center admin">
		<!-- ---------------------------------- jabhi User Register karega usse Ek Pop up milega   -->

		<%
		String AddCatMsg = (String) session.getAttribute("Added-SuccessFully");
		if (AddCatMsg != null) {
		%>
		<div class="alert alert-success alert-dismissible fade show"
			role="alert">
			<strong><%=AddCatMsg%></strong>
			<button type="button" class="close" data-dismiss="alert"
				aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
		</div>
		<%
		session.removeAttribute("reg-Success");
		}
		%>
		<!-- jabhi User ka Register failed hoga usse Ek Pop up milega   -->

		<%
		String failed = (String) session.getAttribute("not-Added");
		if (failed != null) {
		%>
		<div class="alert alert-danger" role="alert">
			<%=failed%>
		</div>
		<%
		session.removeAttribute("not-Added");
		}
		%>


		<div class="row mt-4 ">

			<!---------------------- First cols -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<div class="container rounded-circle">
							<h1>
								<i class="fa-solid fa-user-plus "></i>
							</h1>
						</div>
						<h3>7</h3>
						<h1>Users</h1>
					</div>
				</div>
			</div>

			<!------------------------- Second cols -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<div class="container rounded-circle">
							<h1>
								<i class="fa-solid fa-list  "></i>
							</h1>
						</div>
						<h3>6</h3>
						<h1>Categories</h1>
					</div>
				</div>
			</div>

			<!--------------------------------- Third cols -->
			<div class="col-md-4">
				<div class="card">
					<div class="card-body">
						<div class="container rounded-circle">
							<h1>
								<i class="fa-solid fa-list"></i>
							</h1>
						</div>
						<h3>24</h3>
						<h1>Products</h1>
					</div>
				</div>
			</div>
		</div>
		<!--------------------------------------------------------- Second Rows ------------------------------------------------------------------->
		<div class="row mt-4 ">

			<!------------------------------------------------- First cols -->
			<div class="col-md-6">
				<div class="card" data-toggle="modal"
					data-target="#add-Category-Modal">
					<div class="card-body">
						<div class="container">
							<h1>
								<i class="fa-sharp fa-solid fa-plus"></i>
							</h1>
						</div>
						<p>Click here to add new categories</p>
						<h1>Add Categories</h1>
					</div>
				</div>
			</div>

			<!------------------------------------------------ Second cols -->
			<div class="col-md-6">
				<div class="card" data-toggle="modal"
					data-target="#add-Product-Modal">
					<div class="card-body">
						<div class="container rounded-circle">
							<h1>
								<i class="fa-solid fa-square-plus  "></i>
							</h1>
						</div>
						<p>Click here to add new Products</p>
						<h1>Add Products</h1>
					</div>
				</div>
			</div>
		</div>
	</div>


	<!-------------------------------- Add category Modal ----- ----------------Submit to Servlet------------------------------------------------------------->

	<!-- Button trigger modal 
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#exampleModal">Launch demo modal</button>
                                                                    -->
	<!-- Modal -->
	<div class="modal fade" id="add-Category-Modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content custom-bg ">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add Food Court
						category</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!----------------------------Servlet Form---------------------------------------  -->

					<form action="ProductOperationServlet" method="post">

						<input type="hidden" name="operation" value="addCategory">

						<div class="form-group">
							<input type="text" class="form-control" name="categ-Title"
								placeholder="Enter Food Court Title " required />

						</div>
						<div class="form-group">
							<textarea class="form-control" name="categ-Descrip"
								placeholder="Enter Your Court Description" required /></textarea>
						</div>
						<div class="container  text-center">
							<button class="btn btn-outline-success">Add Courts</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	<!-- End add category Modal -->

	<!-- *************************************************************************************************  -->

	<!---------------------------------Add Product Modal-------------Submit to servlet------------------------------------------------------------------- -->

	<!-- Button trigger modal 
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#add-Product-Modal">Launch demo modal</button>
                                                                    -->
	<!-- Modal -->
	<div class="modal fade" id="add-Product-Modal" tabindex="-1"
		role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog modal-lg" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add Products</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<!------------------------------------------Creating Form For Add Products video 17 Servlet form --------->

					<form action="ProductOperationServlet" method="post"
						id="add-Prod-form" enctype="multipart/form-data">

						<input type="hidden" name="operation" value="addProduct">


						<!-- Product Title -->
						<div class="form-group">
							<input type="text" class="form-control" name="add-ProdName"
								placeholder="Enter Food Title name">
						</div>
						<!-- Product Description -->

						<div class="form-group">

							<textarea class="form-control" name="add-ProdDescription"
								placeholder="Enter Your Court Description"></textarea>
						</div>
						<!-- Product Price -->
						<div class="form-group">
							<input type="number" class="form-control" name="add-ProdPrice"
								placeholder="Enter Product Price">
						</div>
						<!-- Product Discount -->
						<div class="form-group">
							<input type="number" class="form-control" name="add-ProdDiscount"
								placeholder="Enter Product Discount">
						</div>
						<!-- Product Quantity -->
						<div class="form-group">
							<input type="number" class="form-control" name="add-ProdQuantity"
								placeholder="Enter Product Quantity">
						</div>

						<!-- Product Category -->
						<!-------------------------------------  this method is created only for fetching Dynamic value ---------------------------------------->
						<%
					CategoryDao Cdao = new CategoryDao(DBConnect.getConn());
					ArrayList<Category> list = Cdao.getAllCategories();
					%>
						<div class="form-group">
							<select name="catId" class="form-control" id="">
								<option selected disabled>---Select Category---</option>
								<%
						 	for(Category c : list){
						%>
								<option value="<%=c.getCategoryId() %>"><%= c.getTitle() %></option>
								<% 
						}
						%>
							</select>
						</div>

						<!-- Product Image -->
						<div class="form-group">
							<label for="Prod-image">Select Product Image</label><br> <input
								type="file" id="Prod-image" name="add-ProdImage">
						</div>
						<!-- Submit Product -->
						<div class="container  text-center">
							<button class="btn btn-outline-success">Add Product</button>
							<button type="button" class="btn btn-secondary"
								data-dismiss="modal">Close</button>
						</div>
					</form>
				</div>

			</div>
		</div>
	</div>

	<!-- End add Products Modal -->
</body>
</html>












