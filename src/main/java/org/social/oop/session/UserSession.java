package main.java.org.social.oop.session;

import main.java.org.social.oop.model.User;

public abstract class UserSession {
	
	
	public static int id;
	public static String name;
	public static String email;
	public static String phone;
	public static String password;
	public static boolean isLogged;
	
	public static void logout() {
		id = -1;
		name = null;
		email = null;
		phone = null;
		password = null;
		isLogged = false;
	}
	
	public static void login(User user) {
		id = user.getId();
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
		password = user.getPassword();
		isLogged = true;
	}
	
	
	public static void update(User user) {
		name = user.getName();
		email = user.getEmail();
		phone = user.getPhone();
		password = user.getPassword();		
	}
	
	
}
