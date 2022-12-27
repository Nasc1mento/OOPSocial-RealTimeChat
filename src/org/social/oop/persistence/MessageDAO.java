package org.social.oop.persistence;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

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
			preparedStatement.setTimestamp(5, message.getDate());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Message> listMessage(int user1Id, int user2Id) {
		// TODO Auto-generated method stub
		ArrayList<Message> messages = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
					prepareStatement("SELECT * FROM OS_MESSAGES WHERE MSG_USR_ID_SOURCE = ? AND MSG_USR_ID_DESTINY = ? OR MSG_USR_ID_SOURCE = ? AND MSG_USR_ID_DESTINY = ?");
				preparedStatement.setInt(1, user1Id);
				preparedStatement.setInt(2, user2Id);
				preparedStatement.setInt(3, user2Id);
				preparedStatement.setInt(4, user1Id);
							
				ResultSet resultSet = preparedStatement.executeQuery();
				
				while (resultSet.next()) {
					messages.add(new Message(resultSet.
							getInt("MSG_ID"),resultSet.getString("MSG_CONTENT"), resultSet.
							getInt("MSG_USR_ID_SOURCE"), resultSet.getInt("MSG_USR_ID_DESTINY"), resultSet.getTimestamp("MSG_DATE")));
				}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return messages;
	}
	
	
}
