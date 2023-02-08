package main.java.org.social.oop.session;

public class RoomChatSession {
	
	
	public static int id;
	public static int adminId;
	public static String title;
	
	private RoomChatSession() {
		
	}
	
	public static void setRoomChat(int id, int adminId, String title) {
		RoomChatSession.id = id;
		RoomChatSession.title = title;
		RoomChatSession.adminId = adminId;
	}
	
	
	public static void unsetRoomChat() {
		RoomChatSession.id = -1;
		RoomChatSession.adminId = -1;
		RoomChatSession.title = null;
	}
}
