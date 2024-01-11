package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.OrderDao;
import com.Products.Order;
import com.User.UserDetails;
import com.db.DBConnect;


@WebServlet("/OrderNowServlet")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			
			
			out.print("Order Servlet is call.....");
			UserDetails user1 = (UserDetails) request.getSession().getAttribute("user-Name");
			if(user1 != null) {
				
				String pId = request.getParameter("id");
				int pQuantity = Integer.parseInt(request.getParameter("quantity"));
				if(pQuantity <= 0) {
					pQuantity = 1;
				}
					Order oModel = new Order();
					oModel.setId(Integer.parseInt(pId));
					oModel.setUid(user1.getId());
					oModel.setQuantity(pQuantity);
					
					OrderDao oDao  = new OrderDao(DBConnect.getConn());
					boolean result = oDao.insertOrder(oModel);
					
					if(result) {
						response.sendRedirect("orders.jsp");
					}else {
						out.print("Order Failed : "+result);
					}
				
			}else {
				response.sendRedirect("login.jsp");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
