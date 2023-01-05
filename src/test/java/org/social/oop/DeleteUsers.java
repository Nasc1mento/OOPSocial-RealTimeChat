package test.java.org.social.oop;

//import org.junit.Before;
//import org.junit.Test;

import main.java.org.social.oop.persistence.UserDAO;
import main.java.org.social.oop.session.UserSession;

public class DeleteUsers {
	
	int id1;
	int id2;
	int id3;
		
//	@Before
	public void setUp() throws Exception {
		id1 = 1;
		id2 = 2;
		id3 = 3;
	}

//	@Test
	public void test() {
		
		UserSession.id = id1;
		UserDAO.getInstance().removeUserById();
		UserSession.id = id2;
		UserDAO.getInstance().removeUserById();
		UserSession.id = id3;
		UserDAO.getInstance().removeUserById();
		
	}

}
