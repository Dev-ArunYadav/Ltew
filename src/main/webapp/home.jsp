
<%@page import="java.util.*"%>
<%@page import="com.Products.*"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.Dao.* "%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
ProductDao pd = new ProductDao(DBConnect.getConn());
List<Product> products = pd.getAllProducts();
//List<Product> products = pd.getAllProducts();

ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<style type="text/css">
* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
}

#services {
	width: 100%;
}

.heading {
	font-size: 2rem;
	margin: 1rem auto;
	background-color: #edcbc1;
	text-align: center;
	font-family: system-ui;
}

#services p {
	text-align: center;
	margin-bottom: 1rem;
	font-family: sans-serif;
}

.services-container {
	width: 80%;
	margin: 0 auto;
	display: flex;
	flex-wrap: wrap;
	align-content: flex-start;
	justify-content: space-around;
}

.service-item {
	width: 20rem;
	margin: 1rem;
	padding: 10px;
	display: flex;
	flex-shrink: 1;
	align-items: center;
	flex-direction: column;
	justify-content: center;
	transition: all 0.1s linear;
	border-radius: 10px;
	cursor: pointer;
	box-shadow: 3px 3px 10px 0px rgb(0, 0, 0, 0.1);
}

.service-item:hover {
	transform: scale(1.01);
	box-shadow: 5px 5px 15px 0px rgb(0, 0, 0, 0.2);
}

.service-item ul li {
	width: 50px;
	height: 50px;
	color: white;
	list-style: none;
	font-size: 1.2rem;
	display: flex;
	border-radius: 50%;
	align-items: center;
	justify-content: center;
	background-color: #e65000;
}

.service-heading {
	margin: 1rem 0;
	text-align: center;
	color: #000000b7;
	font-family: system-ui;
}

article p {
	font-size: 14px;
	color: #000000b7;
}

.service-item:hover p, .service-item:hover .service-heading {
	color: #000000;
}
</style>
<title>Home</title>
<%-- CSS/FontAwesome/Bootstrap --%>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%-- Navbar Design section 1 --%>
	<%@include file="all_component/navbar.jsp"%>

	<%--
	//Connection conn = DBConnect.getConn();
	out.print(DBConnect.getConn());
	--%>
	<section id="home">
		<div class="container">
			<div class="card-header my-4">All Categories</div>
			<div class="row">
				<%
				if (!products.isEmpty()) {
					for (Product p : products) {
				%>
				<div class="col-md-3 my-3">
					<div class="card w-100" style="width: 18rem;">
						<img src="image/uploadImages/<%=p.getImage()%>"
							style="max-height: 170px; max-width: 100%; width: auto;"
							class="card-img-top" alt="...">
						<div class="card-body">
							<h5 class="card-title"><%=p.getName()%></h5>
							<h6 class="price">
								Price: &#8377;<%=p.getPrice()%>
							</h6>
							<h6 class="category">
								Category:
								<%=p.getDescription()%></h6>
							<div class="mt-3 d-flex justify-content-between">
								<a href="AddToCartServlet?id=<%=p.getId()%>"
									class="btn  btn-dark">Add to Cart</a> <a href="#"
									class="btn  btn-primary">Buy Now</a>
							</div>
						</div>
					</div>
				</div>
				<%
				}
				}
				%>
			</div>
		</div>
	</section>

	<%-- Footer Design section 1  --%>
	<%@include file="all_component/footer.jsp"%>

</body>
</html>