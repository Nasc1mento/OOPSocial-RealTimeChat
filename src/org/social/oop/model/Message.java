package org.social.oop.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Message {
	
	private int id;
	private String content;
	private int user1SenderId;
	private int user2SenderId;
	private Timestamp date;
	
	
	
	
	
	public Message(int id, String content, int senderId, int receptorId, Timestamp date) {
		super();
		this.id = id;
		this.content = content;
		this.user1SenderId = senderId;
		this.user2SenderId = receptorId;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getSenderId() {
		return user1SenderId;
	}
	
	public void setSenderId(int senderId) {
		this.user1SenderId = senderId;
	}
	
	public int getReceptorId() {
		return user2SenderId;
	}
	
	public void setReceptorId(int receptorId) {
		this.user2SenderId = receptorId;
	}
	
	public Timestamp getDate() {
		return date;
	}
	
	public void setDate(Timestamp date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", senderId=" + user1SenderId + ", receptorId=" + user2SenderId
				+ ", date=" + date + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(date);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Message other = (Message) obj;
		return Objects.equals(date, other.date);
	}
	
	
	
}
