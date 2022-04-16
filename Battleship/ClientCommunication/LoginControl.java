//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*LoginControl.java
 * 
 * Provides the logic that facilitates interaction between LoginPanel and LoginData and validates user login input
 * The "Controller" component of the MVC set for Login
 */

package ClientCommunication;

import java.awt.*; //Needed for CardLayout
import java.awt.event.*; //Needed for ActionEvent
import java.io.*; //Needed for exceptions
import java.nio.CharBuffer;
import java.util.Arrays;
import java.util.regex.Pattern;

import javax.swing.*; //Needed for containers

import ClientGUI.*;

public class LoginControl implements ActionListener {
	/*
	 * Fields: 
	 * 
	 * Client - the GameClient.java instance that eventually passes logindata from logincontrol to gameserver
	 * container - the parent jpanel containing all jpanels for the client GUI
	 */
	private GameClient Client;
	private JPanel container;
	/*
	 *Methods:
	 *
	 *LoginControl() - constructor, takes the client and container and sets them accordingly
	 *actionPerformed() - handles user input in the form of selecting the login button or cancel button
	 *loginSuccess() - is called whenever server responds green from login attempt; simply pushes to lobby panel
	 *displayError() - is called whenever a user inputs erroneous data for username or password
	 */
	
	/*
	 * Contructor
	 * Intializes an instance of LoginControl from given input
	 * 
	 * Takes:
	 * 	JPanel representing top level container
	 * 	GameClient representing user's client instance
	 * Returns:
	 * Throws:
	 */
	public LoginControl(JPanel container, GameClient Client) {
		this.container = container;
		this.Client = Client;
	}
	/*
	 * actionPerformed
	 * Handles all user input
	 * 
	 * Takes:
	 * 	ActionEvent representing any user input (selecting either button)
	 * Returns:
	 * Throws:
	 */
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if (command.equals("Back")) {
			//User selected Back option, go back to start screen and clear everything
			LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
			loginPanel.clearAll();
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "1");
		} else {
			//User selected Login option, retrieve input from panel and perform minimal initial checks before sending to server 
			LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
			LoginData data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());
			//Credentials cannot be empty
			if (data.getUsername().isEmpty() || data.getPassword().isEmpty())
				displayError("You must enter a username and password.");
			//Username cannot be <= 3 or not alphanumeric
			else if (data.getUsername().length() <= 3)
				displayError("Invalid username! (Less than 3 characters!)");
			else if (!data.getUsername().matches("[a-zA-Z0-9]*"))
				displayError("Invalid username! (Not alphanumeric!)");
			//Password cannot be < 10 or not alphanumeric
			else if (data.getPassword().length() < 10)
				displayError("Invalid password! (Less than 10 characters!)");
			
			
			//TODO: Send LoginData to server when GameServer.java and GameClient.java are ready
			
			
			
//			try {
//				Client.sendToServer(data);
//			} catch (IOException ioe) {
//				displayError("Server connection failure!");
//				ioe.printStackTrace();
//			}
			
			
			
			
			
			
			
			
			
			
		}

	}
	/*
	 * loginSuccess()
	 * Is called when server greenlights login, makes necessary graphical changes
	 * 
	 * Takes:
	 * Returns:
	 * Throws:
	 */
	public void loginSuccess() {
		LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
		loginPanel.clearAll();
		CardLayout cardLayout = (CardLayout) container.getLayout();
		cardLayout.show(container, "4");
	}
	/*
	 * displayError()
	 * Is called when an error needs to be displayed on screen; shows error and clears input fields
	 * 
	 * Takes:
	 * 	A string representing the error caused by user
	 * Returns:
	 * Throws:
	 */
	public void displayError(String error) {
		LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
		loginPanel.setError(error);
		loginPanel.setUsername("");
		loginPanel.setPassword("");
	}
}
