
package com.User;

public class UserDetails {
	private int id;
	private String name;
	private String email;
	private String password;
	private String utype;
	private String img;
	
	public UserDetails() {
		super();
	}
	
	public UserDetails(int id, String name, String email, String password, String utype,String img) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.utype = utype;
		this.img = img;
	}
	public UserDetails(String name, String email, String password, String utype,String img) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.utype = utype;
		this.img = img;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUtype() {
		return utype;
	}

	public void setUtype(String utype) {
		this.utype = utype;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "UserDetails [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", utype="
				+ utype + "]";
	}
}
