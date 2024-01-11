<%@page import="java.util.*"%>
<%@page import="com.Products.*"%>
<%@page import="com.db.DBConnect"%>
<%@page import="com.Dao.*"%>
<%@page import="com.User.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");
if (cart_list != null) {
	request.setAttribute("cart_list", cart_list);

}
%>

<!DOCTYPE html>
<html>
<head>
<style type="text/css">
@import
	url('https://fonts.googleapis.com/css2?family=Noto+Sans:wght@700&family=Poppins:wght@400;500;600&display=swap')
	;

* {
	margin: 0;
	padding: 0;
	box-sizing: border-box;
	font-family: "Poppins", sans-serif;
}
/* =============== Home Section CSS Code Starts from Here =============== */
#home {
	padding: 25px;
	display: flex;
	align-items: center;
	justify-content: space-around;
	background-color: rgb(235, 232, 229);
}

.home-left .col-red {
	margin-bottom: 10px;
}

.home-left .col-red p {
	padding: 4px;
	display: inline;
	font-weight: bold;
	border-radius: 9px;
	background: #edcbc1;
	color: rgb(245, 49, 23);
}

.home-left {
	display: flex;
	flex-direction: column;
	justify-content: center;
}

.home-left p {
	margin-bottom: 10px;
}

.home-left h1 {
	font-size: 40px;
	text-align: left;
	margin-bottom: 10px;
}

.home-right {
	height: 300px;
	width: 300px;
	cursor: pointer;
	transition: all .5s ease-in;
	border-top-right-radius: 130px;
	border-bottom-left-radius: 130px;
	background-color: rgb(245, 49, 23);
	box-shadow: 0px 0px 12px 0px rgb(47, 53, 79);
}

.home-right:hover {
	transform: translateY(-12px);
}

.home-right img {
	position: relative;
	bottom: 16px;
	left: 67px;
	z-index: 1;
	width: 158px;
}

.bg-red-btn {
	padding: 8px;
	width: 124px;
	color: white;
	cursor: pointer;
	margin-top: 10px;
	font-weight: bold;
	border-radius: 15rem;
	background: rgb(245, 49, 23);
	border: 1px solid rgb(245, 49, 23);
}

.bg-red-btn:hover {
	padding: 8px;
	margin-top: 10px;
	background: transparent;
	color: rgb(245, 49, 23);
	border: 1px solid rgb(245, 49, 23);
}

/* =============== Food COurts CSS Code Starts from Here =============== */
.main-container {
	background: #edcbc1;
	border-radius: 15px;
	margin: 1rem;
	padding: 20px;
	box-shadow: 10px 10px 15px rgba(0, 0, 0, 0.4);
}

h2 {
	text-align: center;
}

hr {
	width: 100%;
	margin: 10px auto;
}

.members {
	display: flex;
	justify-content: center;
	flex-wrap: wrap;
}

.team-member {
	margin: 8px;
	transition: all .3s ease;
	cursor: pointer;
}

.team-member:hover {
	transform: scale(1.1);
}

img {
	width: 80xp;
	height: 80px;
	border-radius: 50%;
	margin: 10px;
}

h4, p {
	text-align: center;
	font-size: 14px;
	margin: 10px;
}
</style>


<link rel="stylesheet" href="css/style.css">
<meta charset="ISO-8859-1">
<title>Home</title>
<%-- CSS/FontAwesome/Bootstrap --%>
<%@include file="all_component/allcss.jsp"%>
</head>
<body>
	<%-- Navbar Design section 1 --%>
	<%@include file="all_component/navbar.jsp"%>

	<!-- ================== Home Section Code Starts from Here ================== -->
	<section id="home">
		<div class="home-left">
			<div class="col-red">
				<p>More Then Faster</p>
			</div>
			<h1>
				Be The Fastest <br> In Making <br> Your Food
			</h1>
			<p>
				Our Motive to develop this EatEasy is<br> that we can Save the
				time of Users.
			</p>
			<button class="bg-red-btn">Contact Here</button>
		</div>
		<div class="home-right">
			<img src="image/AdminPageIcons/EatEasy.svg" alt="">
		</div>
	</section>
	<!-- ================== Home Section Code Ends Here ================== -->

	<div class="main-container">
		<h2>Most Popular Court</h2>
		<hr>
		<div class="members">
			<%
		UserDao udao = new UserDao(DBConnect.getConn());
		List<UserDetails> ulist=udao.getAllUserDetails(); 
		
		for(UserDetails ud: ulist){
			if(ud.getUtype().equals("admin")){
		%>
			<div class="team-member">
				<a href="home.jsp"><img
					src="image/AdminPageIcons/<%= ud.getImg() %>"></a>
				<h4><%= ud.getName() %></h4>

			</div>
			<%}} %>
		</div>
	</div>
	<!-- Our Team Page design using HTML CSS by  -->


	<div class="container-fluid back-img">
		<div class="row mt-3 mx-2 ">
			<!-- Show  Categories -->
			<%
				String c = request.getParameter("category");

				ProductDao dao = new ProductDao(DBConnect.getConn());
				CategoryDao cdao = new CategoryDao(DBConnect.getConn());
				ArrayList<Category> clist = cdao.getAllCategories();
				
				List<Product> list = null;
				if (c == null) {
					list = dao.getAllProducts();
				}

				else if (c.trim().equals("all")) {
					list = dao.getAllProducts();
				} else {
					int cid = Integer.parseInt(c.trim());
					list = dao.getAllProductsById(cid);
				}

				%>
			<div class="col-md-3">
				<div class="list-group">
					<a href="index.jsp?category=all"
						class="list-group-item list-group-item-action active"> All
						Categories </a>

					<%
						for (Category cat : clist) {
						%>
					<a href="index.jsp?category=<%=cat.getCategoryId()%>"
						class="list-group-item list-group-item-action "> <%=cat.getTitle()%>
					</a>
					<%
						}
						%>

				</div>
			</div>

			<!-- Show  Products -->

			<div class="col-md-9">
				<div class="row mt-4">
					<div class="col-md-12">
						<div class="card-columns">
							<%
								for (Product p : list) {
								%>
							<div class="card w-100 ">
								<div class="container text-center">
									<img src="image/uploadImages/<%=p.getImage()%>"
										style="max-height: 170px; max-width: 100%; width: auto;"
										class="card-img-top" alt="...">
								</div>
								<div class="card-body">
									<h5 class="card-title"><%=p.getName()%></h5>
									<p class="carrd-text">
										<%=p.getDescription()%>
									</p>
									<h6 class="price">
										&#8377;
										<%=p.getPriceAfterApplyingDiscount()%>/- <span
											class="text-secondary"><strike>&#8377;<%=p.getPrice()%></strike>/-
											<%=p.getDiscount()%>% off</span>
									</h6>


									<a href="AddToCartServlet?id=<%=p.getId()%>"
										class="btn  btn-dark">Add to Cart</a>
								</div>
							</div>
							<%
									}
									if (list.size() == 0) {
									out.println("No item in this Category >");
									}
									%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


	<%-- Footer Design section 1  --%>
	<%@include file="all_component/footer.jsp"%>

</body>
</html>