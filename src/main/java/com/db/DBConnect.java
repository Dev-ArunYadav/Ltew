package com.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection conn = null;
	public static Connection getConn() {
		
			try {
				if(conn==null) {
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce_cart","root","01Aug2002");
					System.out.print("connected");
				}
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		
		return conn;	
	}

}
