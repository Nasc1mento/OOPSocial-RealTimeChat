package org.social.oop.persistence;

import java.util.ArrayList;
import java.util.List;

import org.social.oop.model.Room;

public interface IRoomPersistence {
	
	
	public void createRoom(Room room);
	
	public void deleteRoom();
	
	public ArrayList<Room> listRooms();
	
	public List<String> listRoomsTitle();
	
}
