
package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.Products.*;

public class ProductDao {
	private Connection conn;
	private PreparedStatement ps; 
	private String query;
	private ResultSet rs;

	public ProductDao(Connection conn) {
		this.conn = conn;
	}
	
	// Save all Category to database using servlet class ProductOperationServlet 
// iska servlet banega kyuki data servlet me jayega.
	
	public boolean saveProduct(Product prod) {
		boolean f = false;
		 try {
			 query = "insert into ecommerce_cart.product(name,description,price,discount,quantity,image,catId) values(?,?,?,?,?,?,?)";
			 ps = conn.prepareStatement(query);
			 ps.setString(1, prod.getName());
			 ps.setString(2, prod.getDescription());
			 ps.setInt(3, prod.getPrice());
			 ps.setInt(4, prod.getDiscount());
			 ps.setInt(5, prod.getQuantity());
			 ps.setString(6, prod.getImage());
			 ps.setInt(7, prod.getCatId());
			 int i =ps.executeUpdate();
				if(i==1) {
					f = true;
				}
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.print("not inserted in Product table : "+f);
		}
		
		return f;
	}
	

	public List<Product> getAllProducts() {
		List<Product> products = new ArrayList<Product>();
			try {
				query = "select * from Product";
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Product row = new Product();
					row.setId(rs.getInt("id"));
					row.setName(rs.getString("name"));
					row.setDescription(rs.getString("description"));
					row.setPrice(rs.getInt("price"));
					row.setDiscount(rs.getInt("discount"));
					row.setQuantity(rs.getInt("quantity"));
					row.setImage(rs.getString("image"));
					row.setCatId(rs.getInt("catId"));
					row.setUserId(rs.getInt("userId"));
					products.add(row);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return products;
	}
// get all products of given category	
	public List<Product> getAllProductsById(int cid) {
		List<Product> products = new ArrayList<Product>();
			try {
				query = "select * from Product where catId=?";
				ps = conn.prepareStatement(query);
				ps.setInt(1, cid);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					Product row = new Product();
					row.setId(rs.getInt("id"));
					row.setName(rs.getString("name"));
					row.setDescription(rs.getString("description"));
					row.setPrice(rs.getInt("price"));
					row.setImage(rs.getString("image"));
					row.setDiscount(rs.getInt("discount"));
					row.setQuantity(rs.getInt("quantity"));
					row.setCatId(rs.getInt("catId"));
					row.setUserId(rs.getInt("userId"));
					products.add(row);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return products;
	}
	

	public List<Cart> getCartProducts(ArrayList<Cart> cartList){
		List<Cart> products = new ArrayList<Cart>();
		
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query = "select * from product where id=?";
					ps = this.conn.prepareStatement(query);
					ps.setInt(1, item.getId());
					rs = ps.executeQuery();
					while(rs.next()) {
						Cart row = new Cart();
						row.setId(rs.getInt("id"));
						row.setName(rs.getString("name"));
						row.setDescription(rs.getString("description"));
						row.setImage(rs.getString("image"));
						row.setDiscount(rs.getInt("discount"));
						row.setPrice(rs.getInt("price")*item.getQuantity());
						row.setQuantity(item.getQuantity());
						row.setCatId(rs.getInt("catId"));
						row.setUserId(rs.getInt("userId"));
						
						products.add(row);
						
					}
				}
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return products;
	}

	public int getTotalCartPrice(ArrayList<Cart> cartList) {
		int sum = 0;
		
		try {
			if (cartList.size()>0) {
				for(Cart item:cartList) {
					query = "select price from product where id=?";
					ps = this.conn.prepareStatement(query);
					ps.setInt(1, item.getId());
					rs = ps.executeQuery();
					
					while(rs.next()) {
						sum += rs.getInt("price")*item.getQuantity();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return sum ;
	}	
}
