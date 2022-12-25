package org.social.oop.session;

public abstract class UserChat {
	
	public static String name;
	
	public static void setUserChat(String name) {
		UserChat.name = name;
	}
	
	
	public static void unsetUserChat() {
		UserChat.name = null;
	}
}
