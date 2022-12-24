package org.social.oop.model;

import java.util.Objects;

public class User {
	
	private int id;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String confirmPassword;
	
	
	
	
	
	public User(Integer id, String name, String email, String phone, String password, String confirmPassword) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.confirmPassword = confirmPassword;
	}

	public User(String name, String email, String phone, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
	}

	public User(String name, String password) {
		super();
		this.name = name;
		this.password = password;
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




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}


	

	public String getConfirmPassword() {
		return confirmPassword;
	}




	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(this.id, other.id);
	}




	@Override
	public String toString() {
		return "User [id=" + this.id + ", name=" + this.name + ", email=" + this.email + ", password=" + this.password + ", telefone="
				+ this.phone + "]";
	}
	
}
