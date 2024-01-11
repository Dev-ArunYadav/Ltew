/*package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;
// Dao   -   User access Object
public class UserDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private String query;
	private ResultSet rs;
	

	public UserDao(Connection conn) {
		this.conn = conn;
	}
	public UserDetails userLogin(String email, String password) {
		UserDetails user= null;
		try {
			query="select * From users where email=? and password=?";
			ps = this.conn.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				user = new UserDetails();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return null;
	}



	
}
*/



package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.Products.Category;
import com.Products.Product;
import com.User.UserDetails;

public class UserDao {
	
	private Connection conn;
	private PreparedStatement ps;
	private String query;
	private ResultSet rs;
	

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addUser(UserDetails us) {
		boolean f = false;
		try {
			query="insert into users(name,email,password,utype,img) values(?,?,?,?,?)";
			ps = conn.prepareStatement(query);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmail());
			ps.setString(3, us.getPassword());
			ps.setString(4, us.getUtype());
			ps.setString(5, us.getImg());
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return f;
	}
	
	
	public UserDetails loginUser(UserDetails us) {
		UserDetails user = null;
		try {
			String query="select * From users where email=? and password=?";
			ps = conn.prepareStatement(query);
			ps.setString(1, us.getEmail());
			ps.setString(2, us.getPassword());
			 //Abb Right hai
			rs=ps.executeQuery();
			
			if(rs.next()) {
				user=new UserDetails();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUtype(rs.getString("utype"));
				user.setImg(rs.getString("img"));
			}
			
		} catch (Exception e) {
		     e.printStackTrace();	
		}
		return user;
	}
	
	
	public List<UserDetails> getAllUserDetails() {
		List<UserDetails> admin_details = new ArrayList<UserDetails>();
			try {
				query = "select * from users";
				ps = conn.prepareStatement(query);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					
					UserDetails row =new UserDetails();
					row.setId(rs.getInt("id"));
					row.setName(rs.getString("name"));
					row.setEmail(rs.getString("email"));
					row.setPassword(rs.getString("password"));
					row.setUtype(rs.getString("utype"));
					row.setImg(rs.getString("img"));
					
					 admin_details.add(row);
				}
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		return  admin_details ;
	}
	
	
	public UserDetails getAdminDetailsOnly(String adminType) {
		UserDetails adDet = new UserDetails();
		
		try {
		    query="select * from users where utype=admin";
			ps = conn.prepareStatement(query);
			ps.setString(1, adminType);
			rs=ps.executeQuery();
			
			if(rs.next()) {
// put as it is data which you have mention in table Column.
				adDet.setUtype(rs.getString("utype"));
				
			}
			} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return adDet;
		
	}
}

























/*package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.User.UserDetails;

public class UserDao {
	
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public boolean addUser(UserDetails us) {
		boolean f = false;
		try {
			String query="insert into user(name,email,password) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, us.getName());
			ps.setString(2, us.getEmial());
			ps.setString(3, us.getPassword());
			int i=ps.executeUpdate();
			
			if(i==1) {
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return f;
	}
	public boolean loginUser(UserDetails us) {
		boolean f=false;
		try {
			String query="select * From user where email=? and password=?";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, us.getEmial());
			ps.setString(2, us.getPassword());
			 //Abb Right hai
			ResultSet rs=ps.executeQuery();
			
			if(rs.next()) {
				f=true;
			}
			
		} catch (Exception e) {
		     e.printStackTrace();	
		}
		return f;
	}
}
*/
