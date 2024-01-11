
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<%-- CSS/FontAwesome/Bootstrap --%>
<%@include file="all_component/allcss.jsp"%>
<style type="text/css">
.title {
	font-size: var(--fs-600);
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
				<div class="card mt-3 ">
					<div class="card-header  text-center logo__cover">
						<img src="image/AdminPageIcons/EatEasy.svg" class="logo "
							alt="EatEasy Logo" />

					</div>
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
						<h1 class="title ">Login</h1>
						<form action="LoginServlet" method="post">
							<div class="form-group">
								<label for="exampleInputEmail1">Email address</label> <input
									type="email" class="form-control" id="exampleInputEmail1"
									aria-describedby="emailHelp" placeholder="Enter email"
									name="login-email">
							</div>
							<div class="form-group">
								<label for="exampleInputPassword1">Password</label> <input
									type="password" class="form-control" id="exampleInputPassword1"
									placeholder="Password" name="login-password">
							</div>

							<button type="submit" class="btn submit badge-pill btn-block">Login</button>
							<a class="fog" href="forgotPass.jsp"> Forgotten Password?</a>
							<hr>
							<p class="askregister">
								Dont't have an account? <a href="register.jsp"> Register</a>
							</p>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
