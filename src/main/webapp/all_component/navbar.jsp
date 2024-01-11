
<%@page import="com.User.UserDetails"%>
<nav
	class="navbar navbar-expand-lg navbar-light bg-custom  sticky-top fixed-top navbar-custom">
	<div class="container">
		<a class="navbar-brand" href="#"> <img
			src="image/AdminPageIcons/EatEasy.svg" class="logo"
			alt="EatEasy Logo" /></a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<!-- Collapsible wrapper -->
		<div class="collapse navbar-collapse " id="navbarSupportedContent">
			<%
		UserDetails user = (UserDetails) session.getAttribute("user-Name");
		if (user == null) {
		%>

			<ul
				class="navbar-nav navbar-collapse justify-content-center mb-2 mb-lg-0">
				<!-- Left links -->
				<li class="nav-item  active"><a class="nav-link"
					href="index.jsp">Home</a></li>

				<li class="nav-item active"><a class="nav-link "
					href="home.jsp">Feast</a></li>

				<li class="nav-item active"><a class="nav-link " href="#">AboutUs</a>
				</li>

			</ul>
			<!-- Right links -->
			<ul class="navbar-nav  me-auto">
				<li class="nav-item  active"><a href="login.jsp"
					class="nav-link  btn btn-outline-danger me-2 " type="submit">Login</a>
				</li>

				<li class="nav-item active"><a href="register.jsp"
					class="nav-link btn btn-outline-success" type="submit">Register</a>
				</li>
			</ul>
			<%
			} else {
			%>
			<!-- This Left links show after login -->
			<ul
				class="navbar-nav navbar-collapse justify-content-center mb-2 mb-lg-0">
				<li class="nav-item  active"><a class="nav-link"
					href="index.jsp">Home</a></li>


				<li class="nav-item active"><a class="nav-link "
					href="home.jsp">Feast</a></li>

				<li class="nav-item active"><a class="nav-link " href="#">AboutUs</a>
				</li>
			</ul>

			<ul class="navbar-nav  me-auto ">
				<li class="nav-item active mt-1"><a type="submit"
					class="nav-link " href="cart.jsp"> <i
						class="fa-solid fa-cart-shopping icon"> <span
							class="badge badge-danger px-1">${cart_list.size() }</span>
					</i>
				</a></li>

				<li class="nav-item dropdown px-1"><a
					class="nav-link dropdown-menu-end " href="#"
					id="navbarDarkDropdownMenuAvatar" data-bs-toggle="dropdown"
					aria-expanded="false"> <img
						src="https://mdbcdn.b-cdn.net/img/new/avatars/2.webp"
						class="rounded-circle px-2" height="25"
						alt="Black and White Portrait of a Man" loading="lazy" /><%=user.getName() %>
				</a>
					<ul class="dropdown-menu dropdown-menu-dark"
						aria-labelledby="navbarDarkDropdownMenuLink">

						<li><a class="dropdown-item" href="#!" data-toggle="modal"
							data-target="#add-Profile-Modal">Profile</a> <!-- Modal -->
							<div class="modal fade" id="add-Profile-Modal" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content custom-bg ">
										<div class="modal-header ">
											<h5 class="modal-title" id="exampleModalLabel">Profile</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body" id="exampleModalLabel">
											<div class="container text-center">
												<table class="table">
													<tbody>
														<tr>
															<th scope="row">Name :</th>
															<td>Abhi Yadav</td>
														</tr>
														<tr>
															<th scope="row">ID :</th>
															<td>05</td>
														</tr>
														<tr>
															<th scope="row">Email-Id :</th>
															<td>abhi@gmail.com</td>
														</tr>
													</tbody>
												</table>
											</div>
											<div class="modal-footer">
												<button class="btn btn-outline-success">Submit</button>
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Close</button>
											</div>
										</div>
									</div>
								</div>
							</div></li>

						<li><a class="dropdown-item" href="#">Orders</a></li>

						<li><hr class="dropdown-divider" /></li>

						<li><a href="LogoutServlet" class="dropdown-item"
							type="submit">Logout</a></li>
						<li></li>
					</ul></li>
			</ul>
			<%
		}
		%>
			<%--Search box 
      <form class="d-flex">
        <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      --%>
		</div>
	</div>
</nav>
<!--  End of navbar -->

<!--  Start of Profile Modal -->
<!-- Button trigger modal  
	<button type="button" class="btn btn-primary" data-toggle="modal"
		data-target="#add-Profile-Modal">Launch demo modal</button>
                             -->






<!--  End of Profile Modal -->

