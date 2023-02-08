package main.java.org.social.oop.session;

public class UserChat {
	
	private UserChat() {
		
	}
	
	public static String name;
	public static int id;
	
	public static void setUserChat(int id, String name) {
		UserChat.id = id;
		UserChat.name = name;
	}
	
	
	public static void unsetUserChat() {
		UserChat.id = -1;
		UserChat.name = null;
	}
}
