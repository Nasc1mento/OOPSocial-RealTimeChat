package main.java.org.social.oop.persistence;

import java.util.List;

import main.java.org.social.oop.model.Room;

public interface IRoomPersistence {
	
	public void createRoom(Room room);
	
	public void deleteRoomById();
	
	public List<Room> getAllRooms();
	
	public List<String> getAllRoomTitle();
	
}
