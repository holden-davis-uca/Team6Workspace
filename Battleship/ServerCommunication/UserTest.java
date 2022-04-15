package ServerCommunication;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	private User user;
	
	@Before
	public void setUp() {
		user = new User();
	}

	@Test
	public void testSetUsername() {
		user.setUsername("Riley");
	}
	
	@Test
	public void testSetPassword() {
		user.setPassword("Williams");
	}
	
	@Test
	public void testGetUsername() {
		user.setUsername("Riley");

		assert(user.getUsername().equals("Riley"));
	}
	
	@Test
	public void testGetPassword() {
		user.setPassword("Williams");

		assert(user.getPassword().equals("Williams"));
	}

}
