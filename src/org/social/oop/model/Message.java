package org.social.oop.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

public class Message {
	
	private int id;
	private int user1SenderId;
	private int user2SenderId;
	private int groupId;
	private String content;
	
	private Date date;
	
	
	
	
	
	
	public Message(int id, String content, int senderId, int receptorId, Date date) {
		super();
		this.id = id;
		this.content = content;
		this.user1SenderId = senderId;
		this.user2SenderId = receptorId;
		this.date = date;
	}
	
	public Message(int id, int senderId, String content, Date date,  int groupId) {
		super();
		this.id = id;
		this.user1SenderId = senderId;
		this.content = content;
		this.date = date;
		this.groupId = groupId;
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
	
	public Integer getSenderId() {
		return user1SenderId;
	}
	
	public void setSenderId(Integer senderId) {
		this.user1SenderId = senderId;
	}
	
	public int getReceptorId() {
		return user2SenderId;
	}
	
	public void setReceptorId(int receptorId) {
		this.user2SenderId = receptorId;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
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
