package org.social.oop.persistence;

import java.util.ArrayList;

import org.social.oop.model.Message;

public interface IMessageRoomPersistence {
	
	public void createMessage(Message message);
	
	public ArrayList<Message> getAllMessage(int roomId);
}
