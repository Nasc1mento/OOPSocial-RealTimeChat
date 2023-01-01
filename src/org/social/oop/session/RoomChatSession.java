package org.social.oop.session;

public abstract class RoomChatSession {
	
	public static int id;
	public static int adminId;
	public static String title;
	
	
	
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
