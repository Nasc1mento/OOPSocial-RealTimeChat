package org.social.oop.model;

import java.util.Date;
import java.util.Objects;

public class Message {
	
	private int id;
	private String content;
	private int senderId;
	private int receptorId;
	private Date date;
	
	
	
	
	
	public Message(int id, String content, int senderId, int receptorId, Date date) {
		super();
		this.id = id;
		this.content = content;
		this.senderId = senderId;
		this.receptorId = receptorId;
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
		return senderId;
	}
	
	public void setSenderId(int senderId) {
		this.senderId = senderId;
	}
	
	public int getReceptorId() {
		return receptorId;
	}
	
	public void setReceptorId(int receptorId) {
		this.receptorId = receptorId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Message [id=" + id + ", content=" + content + ", senderId=" + senderId + ", receptorId=" + receptorId
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
