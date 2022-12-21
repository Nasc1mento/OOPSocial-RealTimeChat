package org.social.oop.persistence;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
	public void createUser(User user) {
		try {
			PreparedStatement preparedStatement = this.databaseMySQL.getConnection().prepareStatement("INSERT INTO OS_USERS VALUES (?, ?, ?, ?, ?);");
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPhone());
			preparedStatement.setString(5, user.getPassword());
			preparedStatement.execute();
			
		}catch(SQLException exception){
			exception.printStackTrace();
		}
	}
	@Override
	public void removeUser(User user) {
		
	}
	@Override
	public void updateUser(User user) {
		
	}
	@Override
	public User searchUser(User user) {
		return user;
	}
	
}
