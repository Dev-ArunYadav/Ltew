package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
//step4 is use LogoutServlet in navbar on Logout Section for Removing those Condition which 
// User Using after Login e.g:- His Name, Cart, Logout Button.
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		try (PrintWriter out = response.getWriter()){
//step1 here we are Checking User is login or not 
			if(session.getAttribute("user-Name") != null) {
		//step2 if user is login and then he click on logout button Session Will remove from login 
				session.removeAttribute("user-Name");
		//Step3 and redirect to index page
		
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			
		}
	}

}
