package Tests;

import org.junit.*;
import ServerCommunication.*;

public class UserTest {
	private User user;
	
	@Before
	public void setUp() {
		user = new User(null, null, null);
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
