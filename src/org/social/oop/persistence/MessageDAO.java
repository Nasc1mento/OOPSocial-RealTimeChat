package org.social.oop.persistence;

public class MessageDAO implements IMessagePersistence{
	
	
	private IConnectionDB databaseMySQL;
	private static MessageDAO instance;
	
	
	private MessageDAO() {
		this.databaseMySQL = new DatabaseMySQL();
	}
	
	public static MessageDAO getInstance() {
		if (instance == null) 
			return new MessageDAO();
		else 
			return instance;
	}
	
	
	
	
	@Override
	public void createMessage() {
		// TODO Auto-generated method stub
		
	}

}
