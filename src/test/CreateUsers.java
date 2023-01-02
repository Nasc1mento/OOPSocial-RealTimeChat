package test;

import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import org.social.oop.exception.EmailAlreadyRegisteredException;
import org.social.oop.exception.EmailFieldNotFilledException;
import org.social.oop.exception.EmailNotValidException;
import org.social.oop.exception.NameFieldNotFilledException;
import org.social.oop.exception.PasswordConfirmationNotMatchException;
import org.social.oop.exception.PasswordFieldNotFilledException;
import org.social.oop.exception.PasswordInvalidException;
import org.social.oop.exception.PhoneFieldNotFilledException;
import org.social.oop.exception.PhoneNotValidException;
import org.social.oop.exception.UserAlreadyRegisteredException;
import org.social.oop.model.User;
import org.social.oop.persistence.UserDAO;

public class CreateUsers {
	
	User user1;
	User user2;
	User user3;
	
	String name1;
	String name2;
	String name3;
	
	String email1;
	String email2;
	String email3;
	
	
	String phone1;
	String phone2;
	String phone3;
	
	String password1;
	String password2;
	String password3;
	
	Timestamp date1;
	Timestamp date2;
	Timestamp date3;
	
	
	
	@Before
	public void setUp() throws Exception {
		name1 = "user1";
		name2 = "user2";
		name3 = "user3";
		
		email1 = "user1@email.com";
		email2 = "user2@email.com";
		email3 = "user3@email.com";
		
		phone1 = "(99) 99999-9999";
		phone2 = "(88) 88888-8888";
		phone3 = "(77) 77777-7777";
		
		password1 = "User@2022";
		password2 = "User@2022";
		password3 = "User@2022";
		
		date1 = Timestamp.valueOf(java.time.LocalDateTime.now());
		date2 = Timestamp.valueOf(java.time.LocalDateTime.now());
		date3 = Timestamp.valueOf(java.time.LocalDateTime.now());
		
		user1 = new User(0,name1,email1,phone1,password1,password1,date1);
		user2 = new User(0,name2,email2,phone2,password2,password2,date2);
		user3 = new User(0,name3,email3,phone3,password3,password3,date3);
	}

	@Test
	public void test() throws NameFieldNotFilledException, EmailFieldNotFilledException, PhoneFieldNotFilledException, PasswordFieldNotFilledException, PasswordConfirmationNotMatchException, EmailNotValidException, PasswordInvalidException, UserAlreadyRegisteredException, EmailAlreadyRegisteredException, PhoneNotValidException {
		
		UserDAO.getInstance().createUser(user1);
		UserDAO.getInstance().createUser(user2);
		UserDAO.getInstance().createUser(user3);
	}

}
