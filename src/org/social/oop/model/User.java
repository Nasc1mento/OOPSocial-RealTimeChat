package org.social.oop.model;

import java.util.Objects;

public class User {
	
	private String id;
	private String name;
	private String email;
	private String password;
	private String telefone;
	
	
	
	
	public User(String id, String name, String email, String password, String telefone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.telefone = telefone;
	}




	public User() {
		
	}




	public String getId() {
		return id;
	}




	public void setId(String id) {
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




	public String getTelefone() {
		return telefone;
	}




	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
		return Objects.equals(id, other.id);
	}




	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", telefone="
				+ telefone + "]";
	}
	
}
