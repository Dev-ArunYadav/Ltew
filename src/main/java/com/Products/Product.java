

package com.Products;

public class Product {
	private int id;
	private String name;
	private String description;
	private int price;
	private int discount;
	private int quantity;
	private String image;
	private int catId;
	private int userId;
	public Product() {	
	}
	
	
	public Product(int id, String name, String description, int price, String image, int discount, int quantity, int catId,int userId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image = image;
		this.discount = discount;
		this.quantity = quantity;
		this.catId = catId;
		this.catId = userId;
	}

	public Product(String name, String description, int price, int discount, int quantity, String image,int catId,int userId) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.discount = discount;
		this.quantity = quantity;
		this.image = image;
		this.catId = catId;
		this.catId = userId;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCatId() {
		return catId;
	}
	public void setCatId(int catId) {
		this.catId = catId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", discount=" + discount + ", quantity=" + quantity + ", image=" + image
				+ "]";
	}

	public int getPriceAfterApplyingDiscount() {
		int d = (int) ((this.getDiscount()/100.0)* this.getPrice());
		return this.getPrice()-d;
	}
	

	
	
}
