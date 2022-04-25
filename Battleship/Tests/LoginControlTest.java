//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*
 * LoginControlTest.java
 * 
 * Provides JUnit 5 unit tests for the LoginControl.java file, particularly those that take parameters
 */

package Tests;

import java.awt.*;				//Needed for cardlayout
import java.awt.event.*;		//Needed for actionevent
import javax.swing.*;			//Needed for Jpanel
import org.junit.*; 			//Needed for tests
import ClientCommunication.*;	//Needed for client
import ClientGUI.*;				//Needed for loginpanel

public class LoginControlTest {

	private GameClient Client;
	private LoginControl lc;
	private JPanel container;
	
	@Before
	public void setUp()
	{
		JPanel view1 = new LoginPanel(lc);
		CardLayout cardLayout = new CardLayout();
		container = new JPanel(cardLayout);
		lc = new LoginControl(container, Client);
		container.add(view1,"1");
		container.add(new LoginPanel(lc), "2");
		cardLayout.show(container, "1");
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
		lc.actionPerformed(new ActionEvent(this, 0, "Login"));
	}

}
