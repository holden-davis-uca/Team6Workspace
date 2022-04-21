//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*
 * LoginPanelTest.java
 * 
 * Provides JUnit 5 unit tests for the LoginPanelTest
 */

package Tests;

import static org.junit.Assert.*; //Needed for not null and equals assertions
import javax.swing.*; //Needed for JPanel/JLabel casts
import org.junit.*; //Needed for tests
import ClientCommunication.*; //Needed for dummy logincontrol for loginpanel constructor
import ClientGUI.LoginPanel;

public class LoginPanelTest {
	
	LoginPanel lp;
	LoginControl lc;

	@Before
	public void setUp()
	{
		lc = new LoginControl(null, null);
		lp = new LoginPanel(lc);
	}
	@Test
	public void testsetUsername()
	{
		lp.setUsername("test");
		assertEquals(lp.getUsername(), "test");
	}
	@Test
	public void testgetUsername()
	{
		lp.setUsername("test");
		assertNotNull(lp.getUsername());
	}
	@Test
	public void testsetPassword()
	{
		lp.setPassword("test");
		assertNotNull(lp.getPassword());
	}
	@Test
	public void testgetPassword()
	{
		lp.setPassword("test");
		assertNotNull(lp.getPassword());
	}
	@Test
	public void testsetError()
	{
		lp.setError("test");
		JLabel temp = (JLabel) ((JPanel) ((JPanel) lp.getComponent(0)).getComponent(0)).getComponent(0);
		assertEquals(temp.getText(), "test");
	}
	@Test
	public void testclearAll()
	{
		assertEquals(lp.getUsername(), "");
		assertNotNull(lp.getPassword());
	}

}
