package org.social.oop.persistence;

import org.social.oop.model.User;

public interface IUserPersistence {
	
		public void createUser(User user);
		
		public User searchUser(User user);
		
		public void removeUser(User user);
		
		public void updateUser(User user);
}
