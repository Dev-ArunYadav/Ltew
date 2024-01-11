<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>
<%-- CSS/FontAwesome/Bootstrap --%>
<%@include file="all_component/allcss.jsp"%>
<style type="text/css">
<
style type ="text /css ">.title {
	font-size: var(--fs-500);
	font-family: var(--ff-body);
	font-weight: var(--fw-semi-bold);
	padding: 1rem;
}

.logo__cover {
	background-color: var(--clr-neutral-750);
	border-radius: 1rem 1rem 0 0;
	padding: 0.5rem 2rem;
}

.logo__cover img {
	margin: auto;
	width: 40%;
}

.submit {
	margin-block: 0.75rem;
	background-color: var(--clr-neutral-750);
	border: none;
	line-height: 2.5;
	border-radius: 0.25rem;
	color: var(--clr-neutral-100);
	transition: 0.3s ease;
}

.submit:hover {
	background-color: var(--clr-neutral-700);
	transform: translateY(-4px);
	box-shadow: 0 10px 10px var(--clr-neutral-725);
}

.askregister {
	font-size: var(--fs-300);
	padding-block: 0.5rem;
	align-self: flex-start;
}

.askregister a {
	color: var(--clr-neutral-750);
	text-decoration: underline;
}
</style>
</head>
<body>
	<%-- Navbar Design section 1 --%>
	<%@include file="all_component/navbar.jsp"%>
	<div class="container-fluid div-color">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="card mt-3">
					<div class="card-header  text-center logo__cover">
						<img src="image/AdminPageIcons/EatEasy.svg" class="logo "
							alt="EatEasy Logo" />

					</div>
					<!-- jabhi User Register karega usse Ek Pop up milega   -->

					<%
					String regMsg = (String) session.getAttribute("reg-Success");
					if (regMsg != null) {
					%>
					<div class="alert alert-success alert-dismissible fade show"
						role="alert">
						<strong><%= regMsg %></strong>
						<button type="button" class="close" data-dismiss="alert"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
						<a href="login.jsp">For Login Click here!</a>
					</div>
					<%
					session.removeAttribute("reg-Success");
					}
					%>
					<!-- jabhi User ka Register failed hoga usse Ek Pop up milega   -->

					<%
					String regfail = (String) session.getAttribute("reg-failed");
					if (regfail != null) {
					%>
					<div class="alert alert-danger" role="alert">
						<%=regfail%>
					</div>
					<%
					session.removeAttribute("reg-failed");
					}
					%>

					<div class="card-body">
						<h2 class="title">Register</h2>
						<form action="UserServlet" method="post">
							<div class="form-group">
								<div class="form-group">
									<label> Enter Full Name</label> <input type="text"
										class="form-control" id="exampleInputPassword1"
										placeholder="Full Name" name="Register-name">
								</div>
								<label>Email address</label> <input type="email"
									class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									name="Register-email">
							</div>
							<div class="form-group">
								<label>Password</label> <input type="password"
									class="form-control" id="exampleInputPassword1"
									placeholder="Enter Password" name="Register-password">
							</div>
							<%-- Form checkBox
							<div class="form-check">
								<input type="checkbox" class="form-check-input"
									id="exampleCheck1"> <label class="form-check-label"
									for="exampleCheck1">Check me out</label>
							</div> 
							----  --%>
							<button type="submit" class="btn  submit badge-pill btn-block">Register</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>