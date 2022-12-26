package org.social.oop.persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.social.oop.model.Message;

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
	public void createMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
					prepareStatement("INSERT INTO OS_MESSAGES VALUES (?, ?, ?, ?, ?);");
			preparedStatement.setInt(1, message.getId());
			preparedStatement.setString(2, message.getContent());
			preparedStatement.setInt(3, message.getSenderId());
			preparedStatement.setInt(4, message.getReceptorId());
			preparedStatement.setDate(5, new Date(0));
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
