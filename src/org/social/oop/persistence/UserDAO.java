package org.social.oop.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.social.oop.exception.EmailAlreadyRegisteredException;
import org.social.oop.exception.EmailFieldNotFilledException;
import org.social.oop.exception.EmailNotValidException;
import org.social.oop.exception.NameFieldNotFilledException;
import org.social.oop.exception.PasswordConfirmationNotMatchException;
import org.social.oop.exception.PasswordNotMatchException;
import org.social.oop.exception.PasswordFieldNotFilledException;
import org.social.oop.exception.PasswordInvalidException;
import org.social.oop.exception.PhoneFieldNotFilledException;
import org.social.oop.exception.UserAlreadyRegisteredException;
import org.social.oop.exception.UserNotRegisteredException;
import org.social.oop.hashing.PBKDF2Salt;
import org.social.oop.model.User;
import org.social.oop.session.UserSession;


public class UserDAO implements IUserPersistence{
	
	private IConnectionDB databaseMySQL;
	private static UserDAO instance;
	private Pattern patternEmail = Pattern.compile("^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
	private Pattern patternPassword = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$");
	
	private UserDAO() {
		this.databaseMySQL = new DatabaseMySQL();
	}
	public static UserDAO getInstance() {
		if (instance == null) 
			return new UserDAO();
		else 
			return instance;
	}
	@Override
	public void createUser(User user) throws NameFieldNotFilledException,EmailFieldNotFilledException, PhoneFieldNotFilledException,
	PasswordFieldNotFilledException, PasswordConfirmationNotMatchException, EmailNotValidException, PasswordInvalidException, 
	UserAlreadyRegisteredException, EmailAlreadyRegisteredException{
		
		String userSalt = PBKDF2Salt.getSalt();
		Matcher matcherEmail = patternEmail.matcher(user.getEmail());
		Matcher matcherPassword = patternPassword.matcher(user.getPassword());
		
		try {
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
					prepareStatement("SELECT USR_NAME,USR_EMAIL,USR_PHONE FROM OS_USERS");
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next() && resultSet.getString("USR_NAME").equals(user.getName()))
				throw new UserAlreadyRegisteredException("User already registered");
			else if (resultSet.getString("USR_EMAIL").equals(user.getEmail()))
				throw new EmailAlreadyRegisteredException("Email already registered");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (user.getName() == null || user.getName().equalsIgnoreCase("") || user.getName().equalsIgnoreCase("\n")) 
			throw new NameFieldNotFilledException("Name is required");
		else if (user.getEmail() == null || user.getEmail().equalsIgnoreCase("") || user.getEmail().equalsIgnoreCase("\n"))
			throw new EmailFieldNotFilledException("Email is required");
		else if (user.getPhone() == null || user.getPhone().equalsIgnoreCase("") || user.getPhone().equalsIgnoreCase("\n"))
			throw new PhoneFieldNotFilledException("Phone is required");
		else if (user.getPassword() == null || user.getPassword().equalsIgnoreCase("") || user.getPassword().equalsIgnoreCase("\n"))
			throw new PasswordFieldNotFilledException("Password is required");
		else if (! user.getConfirmPassword().equals(user.getPassword()))
			throw new PasswordConfirmationNotMatchException("Password and confirm password do not match");
		else if (! matcherEmail.matches())
			throw new EmailNotValidException("Email format invalid. Example valid: user@domain.com");
		else if (! matcherPassword.matches())
			throw new PasswordInvalidException("Invalid password");
		else {
			try {
				PreparedStatement preparedStatement = this.databaseMySQL.getConnection().prepareStatement("INSERT INTO OS_USERS VALUES (?, ?, ?, ?, ?, ?);");
				preparedStatement.setInt(1, user.getId());
				preparedStatement.setString(2, user.getName());
				preparedStatement.setString(3, user.getEmail());
				preparedStatement.setString(4, user.getPhone());
				preparedStatement.setString(5, PBKDF2Salt.hashing(user.getPassword(),userSalt));
				preparedStatement.setString(6,userSalt);
				preparedStatement.execute();
			}catch(SQLException exception){
				exception.printStackTrace();
			}
		}
	}
		
	@Override
	public void removeUser(User user) {
		
	}
	@Override
	public void updateUser(User user) throws NameFieldNotFilledException,EmailFieldNotFilledException, PhoneFieldNotFilledException,
	PasswordFieldNotFilledException, EmailNotValidException, PasswordInvalidException, UserAlreadyRegisteredException, 
	EmailAlreadyRegisteredException {
		String userSalt = PBKDF2Salt.getSalt();
		Matcher matcherEmail = patternEmail.matcher(user.getEmail());
		Matcher matcherPassword = patternPassword.matcher(user.getPassword());
		
		
		try {
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
					prepareStatement("SELECT USR_NAME,USR_EMAIL,USR_PHONE FROM OS_USERS WHERE USR_ID != ?");
			preparedStatement.setInt(1, UserSession.id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next() && resultSet.getString("USR_NAME").equals(user.getName()))
				throw new UserAlreadyRegisteredException("User already registered");
			else if (resultSet.getString("USR_EMAIL").equals(user.getEmail()))
				throw new EmailAlreadyRegisteredException("Email already registered");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		if (user.getName() == null || user.getName().equalsIgnoreCase("") || user.getName().equalsIgnoreCase("\n")) 
			throw new NameFieldNotFilledException("Name is required");
		else if (user.getEmail() == null || user.getEmail().equalsIgnoreCase("") || user.getEmail().equalsIgnoreCase("\n"))
			throw new EmailFieldNotFilledException("Email is required");
		else if (user.getPhone() == null || user.getPhone().equalsIgnoreCase("") || user.getPhone().equalsIgnoreCase("\n"))
			throw new PhoneFieldNotFilledException("Phone is required");
		else if (user.getPassword() == null || user.getPassword().equalsIgnoreCase("") || user.getPassword().equalsIgnoreCase("\n"))
			throw new PasswordFieldNotFilledException("Password is required");
		else if (! matcherEmail.matches())
			throw new EmailNotValidException("Email format invalid. Example valid: user@domain.com");
		else if (! matcherPassword.matches())
			throw new PasswordInvalidException("Invalid password");
		else {
			try {
				PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
						prepareStatement("UPDATE OS_USERS SET USR_NAME = ?, USR_EMAIL = ?, USR_PHONE = ?, USR_PASSWORD = ?, USR_SALT = ? WHERE USR_ID = ?;");
				preparedStatement.setString(1, user.getName());
				preparedStatement.setString(2, user.getEmail());
				preparedStatement.setString(3, user.getPhone());
				preparedStatement.setString(4, PBKDF2Salt.hashing(user.getPassword(),userSalt));
				preparedStatement.setString(5, userSalt);
				preparedStatement.setInt(6, UserSession.id);
				preparedStatement.execute();
				UserSession.update(user);
			}catch(SQLException exception) {
				exception.printStackTrace();
			}
		}
	}
	@Override
	public User locateUser(User user) {
		return user;
	}
	@Override
	public void authUser(User user) throws UserNotRegisteredException, EmailFieldNotFilledException, PasswordNotMatchException{
		try {

			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
					prepareStatement("SELECT * FROM OS_USERS WHERE USR_NAME = ? ;");
			preparedStatement.setString(1, user.getName());
			ResultSet resultset = preparedStatement.executeQuery();
			
			if (! resultset.next()) 
				throw new UserNotRegisteredException("User not registered");
			
			if (PBKDF2Salt.hashing(user.getPassword(), resultset.getString("USR_SALT")).equals(resultset.getString("USR_PASSWORD"))) {
				user.setId(resultset.getInt("USR_ID"));
				user.setName(resultset.getString("USR_NAME"));
				user.setEmail(resultset.getString("USR_EMAIL"));
				user.setPhone(resultset.getString("USR_PHONE"));
				user.setPassword(user.getPassword());
				UserSession.login(user);				
			}else
				throw new PasswordNotMatchException("Password do not match");
			
		}catch(SQLException exception) {
			exception.printStackTrace();
		}
	}
}
