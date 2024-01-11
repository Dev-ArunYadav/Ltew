package com.Products;

import java.util.ArrayList;
import java.util.List;

public class Category {
	private int categoryId;
	private String title;
	private String description;
	private int usersId; 
	
	private List<Product> products = new ArrayList<>();
	public Category() {
		super();
	}
	
	public Category(int categoryId, String title, String description, int usersId) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
		this.usersId = usersId;
	}
	
	public Category(String title, String description) {
		super();
		this.title = title;
		this.description = description;	
	}
	
	public Category(int categoryId, String title, String description,int usersId, List<Product> products) {
		super();
		this.categoryId = categoryId;
		this.title = title;
		this.description = description;
		this.usersId = usersId;
		this.products = products;
	}

	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public int getUsersId() {
		return usersId;
	}

	public void setUsersId(int usersId) {
		this.usersId = usersId;
	}

	@Override
	public String toString() {
		return "Category [categoryId=" + categoryId + ", title=" + title + ", description=" + description + "]";
	}
	
	
}
