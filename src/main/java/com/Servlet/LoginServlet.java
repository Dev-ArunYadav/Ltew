/*package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.UserDao;
import com.User.UserDetails;
import com.db.DBConnect;



@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			//out.print("this is login page!");
			String email=request.getParameter("login-email");
			String password=request.getParameter("login-password");
// Login Servlet Checking Email or Password is getting or not. using below code
			
			
			UserDao udao = new UserDao(DBConnect.getConn());
			UserDetails user = udao.userLogin(email, password);
			//out.print(email+password);
			if(user != null) {
				out.print(email);
			}else {
				out.print("Login failed");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}



}


*/



package com.Servlet;
 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.User.UserDetails;
import com.db.DBConnect;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("login-email");
		String password=request.getParameter("login-password");
		
		UserDetails us= new UserDetails();
		us.setEmail(email);
		us.setPassword(password);
		us.setUtype("admin");
		us.setImg("null");
		UserDao dao = new UserDao(DBConnect.getConn());
		//in the place of UserDetails we replace boolean
		UserDetails user=dao.loginUser(us);
		
		HttpSession session=request.getSession();
		if(user != null){
			session.setAttribute("user-Name",user);//isko hum changes karenge 
			          //   navbar me 
			//admin panel
			if(user.getUtype().equals("admin")) {
				
				response.sendRedirect("admin.jsp");
			// normal user panel
			}else if(user.getUtype().equals("normal")){
				response.sendRedirect("home.jsp");
			}
		}
		else {
			session.setAttribute("reg-failed","Invalid UserName PassWord!");
			response.sendRedirect("login.jsp");
			
			//login 
			//session.setAttribute("current-user", user);
	// completed login session in playlist 3 	
		}
	}

}

/*
 package com.Servlet;
 

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.User.UserDetails;
import com.db.DBConnect;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("uemail");
		String password=request.getParameter("upassword");
		
		UserDetails us= new UserDetails();
		us.setEmial(email);
		us.setPassword(password);
		
		UserDao dao = new UserDao(DBConnect.getConn());
		boolean f=dao.loginUser(us);
		
		if(f){
			response.sendRedirect("home.jsp");
		}
		else {
			HttpSession session=request.getSession();
			session.setAttribute("reg-failed","Invalid UserName PassWord!");
			response.sendRedirect("login.jsp");
		}
	}

}
*/