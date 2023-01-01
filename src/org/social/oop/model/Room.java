package org.social.oop.model;

import java.util.Objects;

public class Room {
	
	private int id;
	private int adminId;
	private String title;
	
	
	
	
	public Room(int adminId, String title) {
		
		this.adminId = adminId;
		this.title = title;
	}
	
	public Room(int id, int adminId, String title) {
		this.id = id;
		this.adminId = adminId;
		this.title = title;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
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
		Room other = (Room) obj;
		return id == other.id;
	}
	
	@Override
	public String toString() {
		return "Room [id=" + id + ", title=" + title + "]";
	}
}
