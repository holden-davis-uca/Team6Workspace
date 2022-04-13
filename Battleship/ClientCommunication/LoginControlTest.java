//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*
 * LoginControlTest.java
 * 
 * Provides JUnit 5 unit tests for the LoginControl.java file, particularly those that take parameters
 */

package ClientCommunication;

import javax.swing.*;
import org.junit.*; //Needed for tests

public class LoginControlTest {

	private GameClient Client;
	private LoginControl lc;
	private JPanel container;
	
	@Before
	public void setUp()
	{
		lc = new LoginControl(container, Client);
	}
	@Test
	public void testloginSuccess() 
	{
		lc.loginSuccess();
	}
	@Test
	public void testdisplayError()
	{
		lc.displayError("test");
	}
	@Test 
	public void testactionPerformed()
	{
		lc.actionPerformed(null);
	}

}
