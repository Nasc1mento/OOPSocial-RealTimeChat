package org.social.oop.session;

import org.social.oop.model.User;

public class UserSession {
	
	
	
	public static String nome;
	public static String email;
	public static boolean isLogged;
	
	
	public UserSession() {
		
	}
	
	public static void logout() {
		nome = null;
		email = null;
		isLogged = false;	
	}
	
	public static void login(User user) {
		
		nome = user.getName();
		email = user.getEmail();
		isLogged = true;
	}
	
	
	
	
	
}
