package org.social.oop.persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import org.social.oop.exception.EmailFieldNotFilledException;
import org.social.oop.exception.EmailAndOrLoginNotMatchException;
import org.social.oop.exception.NameFieldNotFilledException;
import org.social.oop.exception.PasswordConfirmationDoesNotMatchException;
import org.social.oop.exception.PasswordFieldNotFilledException;
import org.social.oop.exception.PhoneFieldNotFilledException;
import org.social.oop.hashing.PBKDF2Salt;
import org.social.oop.model.User;


public class UserDAO implements IUserPersistence{
	
	private IConnectionDB databaseMySQL;
	private static UserDAO instance;
	
	
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
	public void createUser(User user) throws NameFieldNotFilledException,EmailFieldNotFilledException, PhoneFieldNotFilledException,PasswordFieldNotFilledException, PasswordConfirmationDoesNotMatchException {
		
		String salt = PBKDF2Salt.getSalt();
		
		if (user.getName() == null || user.getName().equalsIgnoreCase("") || user.getName().equalsIgnoreCase("\n")) 
			throw new NameFieldNotFilledException("Name is required");
		else if (user.getEmail() == null || user.getEmail().equalsIgnoreCase("") || user.getEmail().equalsIgnoreCase("\n"))
			throw new EmailFieldNotFilledException("Email is required");
		else if (user.getPhone() == null || user.getPhone().equalsIgnoreCase("") || user.getPhone().equalsIgnoreCase("\n"))
			throw new PhoneFieldNotFilledException("Phhone is required");
		else if (user.getPassword() == null || user.getPassword().equalsIgnoreCase("") || user.getPassword().equalsIgnoreCase("\n"))
			throw new PasswordFieldNotFilledException("Password is required");
		else if (! user.getConfirmPassword().equals(user.getPassword()))
			throw new PasswordConfirmationDoesNotMatchException("Password and confirm password do not match");
		else {
			try {
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().prepareStatement("INSERT INTO OS_USERS VALUES (?, ?, ?, ?, ?, ?);");
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, new PBKDF2Salt().hash(user.getPassword(),salt));
			preparedStatement.setString(6,salt);
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
	public void updateUser(User user) {
		
	}
	@Override
	public User locateUser(User user) {
		return user;
	}
	@Override
	public boolean authUser(User user) throws EmailAndOrLoginNotMatchException, EmailFieldNotFilledException{
		try {
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
					prepareStatement("SELECT * FROM OS_USERS WHERE USR_EMAIL = ? AND USR_PASSWORD = ?;");
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, new PBKDF2Salt().hash(user.getPassword(),getUserSalt(user)));
			ResultSet resultset = preparedStatement.executeQuery();
			if (! resultset.next()) throw new EmailAndOrLoginNotMatchException("Email or Password do not match:(");
		}catch(SQLException exception) {
			exception.printStackTrace();
		}
		return true;
	}
	
	public String getUserSalt(User user) throws EmailFieldNotFilledException{
		if (user.getEmail() == null || user.getEmail().equalsIgnoreCase("") || user.getEmail().equalsIgnoreCase("\n"))
			throw new EmailFieldNotFilledException("Email field not filled");
		else {
			try {
				PreparedStatement preparedStatement = this.databaseMySQL.getConnection().
						prepareStatement("SELECT USR_SALT FROM OS_USERS WHERE USR_EMAIL = ?;");
				preparedStatement.setString(1, user.getEmail());
				ResultSet resultSet = preparedStatement.executeQuery();
				if (resultSet.next()) return resultSet.getString(1);
			}catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
	
}
