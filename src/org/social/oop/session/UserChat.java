package org.social.oop.session;

public abstract class UserChat {
	
	public static String name;
	public static int id;
	
	public static void setUserChat(int id, String name) {
		UserChat.id = id;
		UserChat.name = name;
		
	}
	
	
	public static void unsetUserChat() {
		UserChat.name = null;
	}
}
