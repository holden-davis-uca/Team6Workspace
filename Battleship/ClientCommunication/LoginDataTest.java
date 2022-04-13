//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*
 * LoginDataTest.java
 * 
 * Provides JUnit 5 unit tests for the LoginData.java file, particularly those that take parameters
 */

package ClientCommunication;

import org.junit.*; //Needed for tests

public class LoginDataTest {
	String[] users = {"username1", "username2", "username3"};
	String[] passwords = {"password1", "password2", "password3"};
	private LoginData data;
	
	@Before
	public void setUp()
	{
		data = new LoginData(users[0], passwords[0]);
	}
	@Test
	public void testgetUsername() {
		assert(data.getUsername().equals("username1"));
	}
	@Test
	public void testsetUsername() {
		data.setUsername("username3");
		assert(data.getUsername().equals(users[2]));
	}
	@Test
	public void testgetPassword() {
		assert(data.getPassword().equals("password1"));
	}
	@Test
	public void testsetPassword() {
		data.setPassword("password3");
		assert(data.getPassword().equals(passwords[2]));
	}

}
