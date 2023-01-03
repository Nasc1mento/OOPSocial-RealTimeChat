package main.java.org.social.oop.persistence;

import java.sql.Connection;

public interface IConnectionDB {
	
	public Connection getConnection();
}
