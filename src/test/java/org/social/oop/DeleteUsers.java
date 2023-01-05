package test.java.org.social.oop;

//import org.junit.Before;
//import org.junit.Test;

import main.java.org.social.oop.persistence.UserDAO;
import main.java.org.social.oop.session.UserSession;

public class DeleteUsers {
	
	String name1;
	String name2;
	String name3;
		
//	@Before
	public void setUp() throws Exception {
		name1 = "user1";
		name2 = "user2";
		name3 = "user3";
	}

//	@Test
	public void test() {
		
		UserSession.name = name1;
		UserDAO.getInstance().removeUser();
		UserSession.name = name2;
		UserDAO.getInstance().removeUser();
		UserSession.name = name3;
		UserDAO.getInstance().removeUser();
		
	}

}
