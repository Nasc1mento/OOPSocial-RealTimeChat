package main.java.org.social.oop.persistence;

import java.util.ArrayList;
import java.util.List;

import main.java.org.social.oop.exception.EmailAlreadyRegisteredException;
import main.java.org.social.oop.exception.EmailFieldNotFilledException;
import main.java.org.social.oop.exception.EmailNotValidException;
import main.java.org.social.oop.exception.NameFieldNotFilledException;
import main.java.org.social.oop.exception.PasswordConfirmationNotMatchException;
import main.java.org.social.oop.exception.PasswordFieldNotFilledException;
import main.java.org.social.oop.exception.PasswordInvalidException;
import main.java.org.social.oop.exception.PasswordNotMatchException;
import main.java.org.social.oop.exception.PhoneFieldNotFilledException;
import main.java.org.social.oop.exception.PhoneNotValidException;
import main.java.org.social.oop.exception.UserAlreadyRegisteredException;
import main.java.org.social.oop.exception.UserNotRegisteredException;
import main.java.org.social.oop.model.User;

public interface IUserPersistence {
	
		public void createUser(User user) throws  NameFieldNotFilledException,EmailFieldNotFilledException, PhoneFieldNotFilledException,
		PasswordFieldNotFilledException, PasswordConfirmationNotMatchException, EmailNotValidException, PasswordInvalidException, 
		UserAlreadyRegisteredException, EmailAlreadyRegisteredException, PhoneNotValidException;

		
		public void removeUserById();
		
		public void updateUser(User user) throws NameFieldNotFilledException, EmailFieldNotFilledException, PhoneFieldNotFilledException,
		PasswordFieldNotFilledException, EmailNotValidException, PasswordInvalidException, UserAlreadyRegisteredException, 
		EmailAlreadyRegisteredException, PhoneNotValidException;
		
		public void authUser(User user) throws UserNotRegisteredException, EmailFieldNotFilledException, PasswordNotMatchException;
		
		public ArrayList<User> listUsers();
		
		
		public List<String> listUsersName();
		
		
		
		
}
