package org.social.oop.persistence;

import java.util.ArrayList;

import org.social.oop.exception.EmailAlreadyRegisteredException;
import org.social.oop.exception.EmailFieldNotFilledException;
import org.social.oop.exception.EmailNotValidException;
import org.social.oop.exception.NameFieldNotFilledException;
import org.social.oop.exception.PasswordConfirmationNotMatchException;
import org.social.oop.exception.PasswordNotMatchException;
import org.social.oop.exception.PasswordFieldNotFilledException;
import org.social.oop.exception.PasswordInvalidException;
import org.social.oop.exception.PhoneFieldNotFilledException;
import org.social.oop.exception.PhoneNotValidException;
import org.social.oop.exception.UserAlreadyRegisteredException;
import org.social.oop.exception.UserNotRegisteredException;
import org.social.oop.model.User;

public interface IUserPersistence {
	
		public void createUser(User user) throws  NameFieldNotFilledException,EmailFieldNotFilledException, PhoneFieldNotFilledException,
		PasswordFieldNotFilledException, PasswordConfirmationNotMatchException, EmailNotValidException, PasswordInvalidException, 
		UserAlreadyRegisteredException, EmailAlreadyRegisteredException, PhoneNotValidException;

		
		public void removeUser();
		
		public void updateUser(User user) throws NameFieldNotFilledException, EmailFieldNotFilledException, PhoneFieldNotFilledException,
		PasswordFieldNotFilledException, EmailNotValidException, PasswordInvalidException, UserAlreadyRegisteredException, 
		EmailAlreadyRegisteredException;
		
		public void authUser(User user) throws UserNotRegisteredException, EmailFieldNotFilledException, PasswordNotMatchException;
		
		public ArrayList<String> listUser();
}
