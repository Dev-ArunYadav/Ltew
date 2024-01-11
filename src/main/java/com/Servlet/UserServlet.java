
package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.UserDao;
import com.User.UserDetails;
import com.db.DBConnect;

@WebServlet("/UserServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public UserServlet() {
        super();
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("Register-name");
		String email=request.getParameter("Register-email");
		String password=request.getParameter("Register-password");
	    
	// Creating user object to Store data
		UserDetails us= new UserDetails();
		us.setName(name);
		us.setEmail(email);
		us.setPassword(password);
	 	us.setUtype("normal");
	 	us.setImg("null");
		UserDao dao = new UserDao(DBConnect.getConn());
		
		boolean f =dao.addUser(us);
		HttpSession session =request.getSession();
		if(f) {
			// HttpSession session =request.getSession();
		 //HttpSession Dusre Page pe Redirect krta hai Jab bhi User Register 
			                     //  Karega SuccessFully 
			session.setAttribute("reg-Success","Registration SuccessFully!");
			response.sendRedirect("register.jsp");
		}
		else {
			session.setAttribute("reg-failed","Something Went Wrong !");
			response.sendRedirect("register.jsp");
		}
	
	}

}
