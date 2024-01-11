package com.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Products.Order;

public class OrderDao {
	private Connection conn;
	private PreparedStatement ps;
	private String query;
	private ResultSet rs;

	public OrderDao(Connection conn) {
		this.conn = conn;
	}
	
	public boolean insertOrder(Order model) {
		boolean result = false;
		
		try {
			query="insert into orders (p_id, u_id, o_quantity, o_data) values(?,?,?,?) ";
			ps = conn.prepareStatement(query);
			ps.setInt(1, model.getId());
			ps.setInt(2, model.getUid());
			ps.setInt(3, model.getQuantity());
			ps.setString(4, model.getDate());
			int i =ps.executeUpdate();
			if(i==1) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return result;
	}
}
