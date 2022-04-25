//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*
 * IntegrationTest.java
 * 
 * Provides JUnit Integration Testing for the "Login" module - LoginPanel, LoginData, LoginControl
 */

package Tests;

import static org.junit.Assert.assertEquals;	//Needed for equal assertions
import static org.junit.Assert.assertNotNull;	//Needed for non-null assertions
import java.awt.*;								//Needed for cardlayout
import java.awt.event.*;						//Needed for fake actionevent
import javax.swing.*;							//Needed for container jpanel
import org.junit.*;								//Needed for before/after
import ClientCommunication.*;					//Needed for client
import ClientGUI.*;								//Needed for interface

public class IntegrationTest {
	
	String[] users = {"username1", "username2", "username3"};
	String[] passwords = {"password1", "password2", "password3"};
	
	private LoginPanel lp;
	private LoginControl lc;
	private LoginData ld;
	private JPanel container;
	private GameClient client;

	@Before
	public void setUp(){
		JFrame jframe = new JFrame();
		lp = new LoginPanel(lc);
		CardLayout cardLayout = new CardLayout();
		container = new JPanel(cardLayout);
		lc = new LoginControl(container, client);
		container.add(lp,"1");
		container.add(new LoginPanel(lc), "2");
		ld = new LoginData(users[0], passwords[0]);
		cardLayout.show(container, "1");
		jframe.setLayout(new GridBagLayout());
		jframe.add(container);
		jframe.setSize(550, 500);
		jframe.setVisible(true);
	}
	@Test
	public void testSettersGetters()
	{
		lp.setPassword(passwords[0]);
		assertEquals(ld.getPassword(), "password1");
		lp.setUsername("test");
		assertEquals(lp.getUsername(), "test");
	}

	@Test
	public void testLoginControlloginSuccess()
	{
		lc.loginSuccess();
		assertEquals(lp.getUsername(), "");
	}
	@Test
	public void testErrors()
	{
		lp.setError("TEST ERROR");
		JLabel temp = (JLabel) ((JPanel) ((JPanel) lp.getComponent(0)).getComponent(0)).getComponent(0);
		assertEquals(temp.getText(), "TEST ERROR");
	}
	@Test
	public void testLoginControlactionPerformed()
	{
		lc.actionPerformed(new ActionEvent(this, 0, "Login"));
	}
	@Test
	public void testLoginPanelclearAll()
	{
		lc.displayError("HELP");
		assertEquals(lp.getUsername(), "");
		assertNotNull(lp.getPassword());
	}
	

}
