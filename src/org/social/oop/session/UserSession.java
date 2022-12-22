package org.social.oop.session;

import org.social.oop.model.User;

public class UserSession {
	
	
	public static int id;
	public static String name;
	public static String email;
	public static String phone;
	public static boolean isLogged;
	
	
	public UserSession() {
		
	}
	
	public static void logout() {
		id = 0;
		name = null;
		email = null;
		phone = null;
		isLogged = false;
	}
	
	public static void login(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
		isLogged = true;
	}
	
	
	
	
	
}
