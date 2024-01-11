package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
//import java.util.List;

import com.Products.Category;

public class CategoryDao {
	private Connection conn;
	private PreparedStatement ps;
	private String query;
	private ResultSet rs;

	public CategoryDao(Connection conn) {
		this.conn = conn;
	}
// Save all Category to database using servlet class ProductOperationServlet 
// iska servlet banega kyuki data servlet me jayega.

	public boolean saveCategory(Category cat ) {
		boolean f = false;
		 try {
			 query = "insert into category(title,description) values(?,?)";
			 ps = conn.prepareStatement(query);
			 ps.setString(1, cat.getTitle());
			 ps.setString(2, cat.getDescription());
			 //ps.executeUpdate();
			 int i =ps.executeUpdate();
				if(i==1) {
					f = true;
				}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return f;
	}

//    this method is fetch all values from Category 
// --------------------------- this method used in add-Product from as dynamic value-----------------------------------------
		public ArrayList<Category> getAllCategories(){
			ArrayList<Category> list = new ArrayList<>();
			try {
				query = "select * from category";
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				while(rs.next()) {
// put as it is data which you have mention in table Column.
					int id = rs.getInt("categoryId");
					String title = rs.getString("title");
					String description = rs.getString("description");
					int userid = rs.getInt("usersId");
//  in category constructor pass all data in parameter 
					Category c = new Category(id,title,description,userid);
//		store all users data in arrayList of Category	
					list.add(c);
				}	
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
// ------------------------------------ this method is used add-Product-Modal which is mention in ProductOperationServlet  -----------------------------
		}
	
		
// Save Category ID using Foreign key to database
// ye mothod jo hai woh sirf Single Category dega
	public Category getCategoryById(int cid) {
		Category cat = new Category();
		
		try {
		    query="select * from category where categoryId=?";
			ps = conn.prepareStatement(query);
			ps.setInt(1, cid);
			rs=ps.executeQuery();
			
			if(rs.next()) {
// put as it is data which you have mention in table Column.
				cat.setCategoryId(rs.getInt("categoryId"));
				
			}
			} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return cat;
		
	}
	
}
