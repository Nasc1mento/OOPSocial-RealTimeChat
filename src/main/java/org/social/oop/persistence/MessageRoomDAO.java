package main.java.org.social.oop.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import main.java.org.social.oop.model.Message;
import main.java.org.social.oop.session.RoomChatSession;

public class MessageRoomDAO implements IMessagePersistence {

	
	
	private IConnectionDB databaseMySQL;
	private static MessageRoomDAO instance;
	
	
	private MessageRoomDAO() {
		this.databaseMySQL = new DatabaseMySQL();
	}
	
	public static MessageRoomDAO getInstance() {
		if (instance == null) 
			return new MessageRoomDAO();
		else 
			return instance;
	}
	
	
	
	@Override
	public void createMessage(Message message) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
					prepareStatement("INSERT INTO OS_ROOM_MESSAGES VALUES (?, ?, ?, ?, ?);");
			preparedStatement.setInt(1, message.getId());
			preparedStatement.setInt(2, message.getGroupId());
			preparedStatement.setInt(3, message.getSenderId());
			preparedStatement.setString(4, message.getContent());
			preparedStatement.setTimestamp(5, message.getDate());
			preparedStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public List<Message> getAllMessage() {
		// TODO Auto-generated method stub
		List<Message> messages = new ArrayList<>();
		
		try {
			
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
					prepareStatement("SELECT * FROM OS_ROOM_MESSAGES WHERE ROM_ROS_ID = ?");
			preparedStatement.setInt(1, RoomChatSession.id);			
			ResultSet resultSet = preparedStatement.executeQuery();
				
			while (resultSet.next()) {
					
				int id = resultSet.getInt("ROM_ID");
				int sender = resultSet.getInt("ROM_USR_ID");
				String content = resultSet.getString("ROM_CONTENT");
				Timestamp date = resultSet.getTimestamp("ROM_DATE");
				Message message = new Message(id, sender, content, date, RoomChatSession.id);
					
				messages.add(message);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return messages;
	}
}
