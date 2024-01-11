<%@page import="java.text.DecimalFormat"%>
<%@page import="com.Servlet.*"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.Dao.*"%>
<%@page import="com.Products.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%
//   Decimal Format for 122.0000000 is take after value of .00 only
	/* DecimalFormat dcf = new DecimalFormat("#.##");
	request.setAttribute("dcf", dcf); */
	ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
	List<Cart> cartProduct = null;
	if(cart_list != null){
		ProductDao pDao = new ProductDao(DBConnect.getConn());
		cartProduct = pDao.getCartProducts(cart_list);
		int total = pDao.getTotalCartPrice(cart_list);
		request.setAttribute("cart-list", cart_list);
		request.setAttribute("total", total);
	}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
<%-- CSS/FontAwesome/Bootstrap --%>
<%@include file="all_component/allcss.jsp"%>
<style type="text/css">
th {
	border: 2px solid red;
	border-collapse: collapse;
	padding: 2%;
	border-left: 0px;
	border-right: 0px;
	padding-left: 0px;
}

table, tbody, td {
	border: 0px solid black;
	border-collapse: collapse;
	vertical-align: middle;
}

.btn-incre, .btn-decre {
	box-shadow: none;
	font-size: 20px;
	color: blue;
}
</style>
</head>
<body>
	<%-- Navbar Design section 1 --%>
	<%@include file="all_component/navbar.jsp"%>

	<div class="container">
		<div class="d-flex py-3">
			<h3>Total Price: &#8377; ${ (total>0)?total:0}</h3>
			<a class="mx-3 btn btn-primary" href="#">Check Out</a>
		</div>
		<table class="table table-loght" style="width: 80%" align="center">
			<thead>
				<tr>
					<th scope="col">Name</th>
					<th scope="col" width="12%">Category</th>
					<th scope="col" width="10%">Price</th>
					<th scope="col" width="35%">Quantity</th>
					<th scope="col">Order now</th>
					<th scope="col">Cancel</th>
				</tr>
			</thead>
			<tbody>
				<%
	 			if(cart_list != null){
	 				for(Cart c : cartProduct){
		 	%>
				<tr>
					<td><%= c.getName() %></td>
					<td><%= c.getDescription() %></td>
					<td><%= c.getPrice() %></td>

					<td>
						<form action="OrderNowServlet" method="post" class="form-inline">
							<input type="hidden" name="id" value="<%= c.getId() %>"
								class="form-input">
							<div class="form-group d-flex justify-content-between w-50">
								<a class="btn btn-sm btn-decre"
									href="QuantityInDecServlet?action=dec&id=<%= c.getId()%>"><i
									class="fas fa-minus-square"></i></a> <input type="text"
									name="quantity" value="<%= c.getQuantity() %>"
									class="form-control w-50" readonly> <a
									class="btn btn-sm btn-incre "
									href="QuantityInDecServlet?action=inc&id=<%= c.getId()%>"><i
									class="fas fa-plus-square"></i></a>
							</div>
						</form>
					</td>
					<td><button type="submit" class="btn btn-primary btn-sm ">Buy</button></td>
					<td><a class="btn btn-sm btn-danger"
						href="RemoveFromCartServlet?id=<%=  c.getId()%>">Remove</a></td>
				</tr>
				<% }
	 			}
	 		%>

			</tbody>
		</table>

	</div>
</body>
</html>

