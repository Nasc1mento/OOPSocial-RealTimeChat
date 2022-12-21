package org.social.oop.persistence;

import org.social.oop.model.User;

public interface IUserPersistence {
	
		public void createUser(User user);
		
		public User locateUser(User user);
		
		public void removeUser(User user);
		
		public void updateUser(User user);
		
		public boolean authUser(User user);
}
