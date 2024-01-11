package com.Products;

public class Order extends Product {
	private int orderId;
	private int uid;
	private int Quantity;
	private String date;
	
	public Order() {
		super();
	}
	
	public Order(int orderId, int uid, int quantity, String date) {
		super();
		this.orderId = orderId;
		this.uid = uid;
		Quantity = quantity;
		this.date = date;
	}
	
	public Order(int uid, int quantity, String date) {
		super();
		this.uid = uid;
		Quantity = quantity;
		this.date = date;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}	
}
