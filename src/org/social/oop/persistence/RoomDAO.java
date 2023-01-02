package org.social.oop.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.social.oop.model.Room;
import org.social.oop.session.RoomChatSession;

public class RoomDAO implements IRoomPersistence{
	
	
	
	private IConnectionDB databaseMySQL;
	private static RoomDAO instance;
	
	
	private RoomDAO() {
		this.databaseMySQL = new DatabaseMySQL();
	}
	
	public static RoomDAO getInstance() {
		if (instance == null) 
			return new RoomDAO();
		else 
			return instance;
	}
	
	@Override
	public void createRoom(Room room) {
		// TODO Auto-generated method stub
		try {
			PreparedStatement prepareStatement = this.databaseMySQL.getConnection().
					prepareStatement("INSERT INTO OS_ROOMS VALUES (?, ?, ?);");
			prepareStatement.setInt(1, room.getId() );
			prepareStatement.setString(2, room.getTitle());
			prepareStatement.setInt(3, room.getAdminId());
			prepareStatement.execute();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRoom() {
		// TODO Auto-generated method stub
		try {
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
					prepareStatement("DELETE OS_ROOMS, OS_ROOM_MESSAGES FROM OS_ROOMS INNER JOIN "
							+ "OS_ROOM_MESSAGES WHERE OS_ROOMS.ROS_ID = OS_ROOM_MESSAGES.ROM_ROS_ID "
							+ "AND OS_ROOMS.ROS_ID = ?");
			preparedStatement.setInt(1, RoomChatSession.id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}	
	
	
	
	@Override
	public List<String> listRoomsTitle() {
		// TODO Auto-generated method stub
		List<String> rooms = new ArrayList<String>();
		
		try {
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
					prepareStatement("SELECT * FROM OS_ROOMS;");
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				String title = resultSet.getString("ROS_TITLE");
				rooms.add(title);
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return rooms;
	
	}

	@Override
	public ArrayList<Room> listRooms() {
		// TODO Auto-generated method stub
		ArrayList<Room> rooms = new ArrayList<Room>();
		
		try {
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
					prepareStatement("SELECT * FROM OS_ROOMS;");
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int id = resultSet.getInt("ROS_ID");
				int adminId = resultSet.getInt("ROS_ADMIN_ID");
				String title = resultSet.getString("ROS_TITLE");
				
				Room room = new Room(id, adminId, title);
				rooms.add(room);
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		return rooms;
	}
	
}
