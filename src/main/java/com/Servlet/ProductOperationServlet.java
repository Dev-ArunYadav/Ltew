
package com.Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.Dao.CategoryDao;
import com.Dao.ProductDao;
//import com.Dao.ProductDao;
import com.Products.Category;
import com.Products.Product;
import com.db.DBConnect;

//We use Multipart for Storing image ,audio,video  etc.
@MultipartConfig
@WebServlet("/ProductOperationServlet")
public class ProductOperationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {

			/*
			 * Servlet Doing Two Work Together 2; { add Category of Food Court add Product
			 * of Food Court }
			 */

			String op = request.getParameter("operation");
//    ---------------------------------------------------- add category to Database with the help of servlet-------------------------------------------
// 				add Category of Food Court
//      		trim() is trim blank space or width space
			if (op.trim().equals("addCategory")) {
				System.out.println("add Category is method call....");
				// Fetching Food Court Data
				String title = request.getParameter("categ-Title");
				String Description = request.getParameter("categ-Descrip");
				
				// Creating Category object to Store data

				Category c = new Category();
				c.setTitle(title);
				c.setDescription(Description);
			
				CategoryDao dao = new CategoryDao(DBConnect.getConn());
				boolean f = dao.saveCategory(c);

				HttpSession session = request.getSession();

				if (f) {

					session.setAttribute("Added-SuccessFully", "Food Court Category Added SuccessFully!");
					response.sendRedirect("admin.jsp");

					return;
				} else {
					session.setAttribute("not-Added", "Something Went Wrong with data !");
					response.sendRedirect("admin.jsp");

				}
			}
// -------------------------------------------------------  End of Category Adding  -------------------------------------------------------------------------------

//  ---------------------------------------------------- add category to Database with the help of servlet-------------------------------------------	
// 			add Product of Food Court
			else if (op.trim().equals("addProduct")) {
				System.out.println("add product method call....");
				String name = request.getParameter("add-ProdName");
				String description = request.getParameter("add-ProdDescription");
				int price = Integer.parseInt(request.getParameter("add-ProdPrice"));
				int discount = Integer.parseInt(request.getParameter("add-ProdDiscount"));
				int quantity = Integer.parseInt(request.getParameter("add-ProdQuantity"));
				Part part = request.getPart("add-ProdImage");
				int catId = Integer.parseInt(request.getParameter("catId"));

				Product p = new Product();
				p.setName(name);
				p.setDescription(description);
				p.setPrice(price);
				p.setDiscount(discount);
				p.setQuantity(quantity);
				p.setImage(part.getSubmittedFileName());
				p.setCatId(catId);

// Product saving method SuccessFully
// 				Save Product Picture to database
				ProductDao dao = new ProductDao(DBConnect.getConn());
				boolean f = dao.saveProduct(p);
				
// 				find out the path to Upload Product
// 				File.separator ---- is like file path slash ( image/uploadImages/arun.jpg)
				String path = request.getRealPath("image") + File.separator + "uploadImages" + File.separator + part.getSubmittedFileName() ;
				System.out.println(path);
				try {
//	 			uploading image
				FileOutputStream fos = new FileOutputStream(path);
				  InputStream is = part.getInputStream();
//				reading data
				 byte[] data = new byte[is.available()];
				 	is.read(data);
//			 	writing the data
				fos.write(data);
				fos.close();
				}
				catch (Exception e) {
					e.printStackTrace();
				}
				out.println("Product save SuccessFully" );
				HttpSession session = request.getSession();
				
				if (f) {  
					session.setAttribute("Added-SuccessFully", "In Food Court Product Added SuccessFully!");
					response.sendRedirect("admin.jsp");
					return; 
				} else { 
					session.setAttribute("not-Added", "Something Went Wrong with data !"); 
					response.sendRedirect("admin.jsp");
				  } 
			}
// ------------------------------------------------------- End of Category Adding-------------------------------------------------------------------------------

		}
	}
}















//  Copy of code





/*
 * package com.Servlet;
 * 
 * import java.io.IOException; import java.io.PrintWriter;
 * 
 * import javax.servlet.ServletException; import
 * javax.servlet.annotation.MultipartConfig; import
 * javax.servlet.annotation.WebServlet; import javax.servlet.http.HttpServlet;
 * import javax.servlet.http.HttpServletRequest; import
 * javax.servlet.http.HttpServletResponse; import
 * javax.servlet.http.HttpSession; import javax.servlet.http.Part;
 * 
 * import com.Dao.CategoryDao; import com.Dao.ProductDao; //import
 * com.Dao.ProductDao; import com.Products.Category; import
 * com.Products.Product; import com.db.DBConnect;
 * 
 * //We use Multipart for Storing image ,audio,video etc.
 * 
 * @MultipartConfig
 * 
 * @WebServlet("/ProductOperationServlet") public class ProductOperationServlet
 * extends HttpServlet { private static final long serialVersionUID = 1L;
 * 
 * protected void doPost(HttpServletRequest request, HttpServletResponse
 * response) throws ServletException, IOException {
 * response.setContentType("text/html;charset=UTF-8"); try (PrintWriter out =
 * response.getWriter()) {
 * 
 * 
 * Servlet Doing Two Work Together 2; { add Category of Food Court add Product
 * of Food Court }
 * 
 * 
 * String op = request.getParameter("operation"); //
 * ---------------------------------------------------- add category to Database
 * with the help of servlet------------------------------------------- // add
 * Category of Food Court // trim() is trim blank space or width space if
 * (op.trim().equals("addCategory")) {
 * System.out.println("add Category is method call...."); // Fetching Food Court
 * Data String title = request.getParameter("categ-Title"); String Description =
 * request.getParameter("categ-Descrip");
 * 
 * // Creating Category object to Store data
 * 
 * Category c = new Category(); c.setTitle(title);
 * c.setDescription(Description);
 * 
 * CategoryDao dao = new CategoryDao(DBConnect.getConn()); boolean f =
 * dao.saveCategory(c);
 * 
 * HttpSession session = request.getSession();
 * 
 * if (f) {
 * 
 * session.setAttribute("Added-SuccessFully",
 * "Food Court Category Added SuccessFully!");
 * response.sendRedirect("admin.jsp");
 * 
 * return; } else { session.setAttribute("not-Added",
 * "Something Went Wrong with data !"); response.sendRedirect("admin.jsp");
 * 
 * } } // ------------------------------------------------------- End of
 * Category
 * Adding-----------------------------------------------------------------------
 * --------
 * 
 * // ---------------------------------------------------- add category to
 * Database with the help of servlet-------------------------------------------
 * // add Product of Food Court else if (op.trim().equals("addProduct")) {
 * System.out.println("add product method call...."); String name =
 * request.getParameter("add-ProdName"); String description =
 * request.getParameter("add-ProdDescription"); int price =
 * Integer.parseInt(request.getParameter("add-ProdPrice")); int discount =
 * Integer.parseInt(request.getParameter("add-ProdDiscount")); int quantity =
 * Integer.parseInt(request.getParameter("add-ProdQuantity")); Part part =
 * request.getPart("add-ProdImage"); int catId =
 * Integer.parseInt(request.getParameter("catId"));
 * 
 * Product p = new Product(); p.setName(name); p.setDescription(description);
 * p.setPrice(price); p.setDiscount(discount); p.setQuantity(quantity);
 * p.setImage(part.getSubmittedFileName()); p.setCatId(catId);
 * 
 * 
 * get category by id | video no.17 Add Product 11:28 --- 25:42 
 * CategoryDao cdao = new CategoryDao(DBConnect.getConn()); 
 * Category cate = cdao.getCategoryById(categor); 
 *  
 *  p.setCatId(cate);
 * 
 * 
 * // Product saving method SuccessFully ProductDao dao = new
 * ProductDao(DBConnect.getConn()); boolean f = dao.saveProduct(p);
 * out.println("Product save SuccessFully" + f); HttpSession session =
 * request.getSession();
 * 
 * if (f) {
 * 
 * session.setAttribute("Added-SuccessFully",
 * "In Food Court Product Added SuccessFully!");
 * response.sendRedirect("admin.jsp");
 * 
 * return; } else { session.setAttribute("not-Added",
 * "Something Went Wrong with data !"); response.sendRedirect("admin.jsp");
 * 
 * } } // ------------------------------------------------------- End of
 * Category //
 * Adding-----------------------------------------------------------------------
 * --------
 * 
 * } } }
 */