package main.java.org.social.oop.persistence;

import java.util.List;

import main.java.org.social.oop.model.Message;

public interface IMessagePersistence {
		
	public void createMessage(Message message);
	
	public List<Message> getAllMessage();
	
	

}
