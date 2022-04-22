//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*LoginPanel.java
 * 
 * Provides the JPanel that is presented to the user when they select the "Login" option from StartPanel.java
 * The "View" component of the MVC set for Login
 * Simply provides two labeled fields for the user to enter their username and password
 */

package ClientGUI;

import java.awt.*;
import java.util.*;
import javax.swing.*;
import ClientCommunication.*;

public class LoginPanel extends JPanel {

	/*
	 * Fields: 
	 * 
	 * serialVersionUID - a static long for classes that implement Serializable according to eclipse specifications
	 * usernameField - a JTextField for the username entry 
	 * passwordField - a JPasswordField for the password entry
	 * errorLabel - a JLabel for displaying errors
	 * titleLabel - a JLabel for displaying a large title image
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel errorLabel;
	private JLabel titleLabel;
	/*
	 *Methods:
	 *
	 *LoginPanel() - constructor, takes the LoginControl that handles interaction and logic
	 *getUsername() - getter for username
	 *setPassword() - setter for username
	 *getPassword() - getter for password
	 *setPassword() - setter for password
	 *setError() - setter for the errorLabel contents
	 *clearAll() - clears both user entry fields as well as the errorLabel
	 */
	/*
	 * Getter for username
	 * 
	 * Takes:
	 * Returns:
	 * 	A string representing the username
	 * Throws:
	 */
	public String getUsername() {
		return usernameField.getText();
	}
	/*
	 * Setter for username
	 * 
	 * Takes:
	 * 	A string representing the username to be set
	 * Returns:
	 * Throws:
	 */
	public void setUsername(String username) {
		usernameField.setText(username);
	}
	/*
	 * Setter for password
	 * 
	 * Takes:
	 * 	A string representing the password to be set
	 * Returns:
	 * Throws:
	 */
	public void setPassword(String password) {
		passwordField.setText(password);
	}
	/*
	 * Getter for password
	 * 
	 * Takes:
	 * Returns:
	 * 	A string representing the password
	 * Throws:
	 */
	public String getPassword() {
		return new String(passwordField.getPassword());
	}
	/*
	 * setError()
	 * Is called when an error needs to be displayed on screen; shows error and clears input fields
	 * 
	 * Takes:
	 * 	A string representing the error caused by user
	 * Returns:
	 * Throws:
	 */
	public void setError(String error) {
		errorLabel.setText(error);
	}
	/*
	 * clearAll()
	 * Is called when all on screen fields need to be cleared (username, password, error)
	 * 
	 * Takes:
	 * Returns:
	 * Throws:
	 */
	public void clearAll()
	{
		passwordField.setText("");
		usernameField.setText("");
		errorLabel.setText("");
	}
	/*
	 * Contructor
	 * Initializes an instance of LoginPanel from the given input
	 * 
	 * Takes:
	 * 	LoginControl representing the controller for the Login module
	 * Returns:
	 * Throws:
	 */
	public LoginPanel(LoginControl lc)
	{
		
	    JPanel labelPanel = new JPanel(new GridLayout(3, 1, 0, 5));
	    errorLabel = new JLabel("", SwingConstants.CENTER);
	    errorLabel.setForeground(Color.RED);
	    errorLabel.setFont(new Font("", Font.BOLD, 12));
	    titleLabel = new JLabel("BattleShip - Login", SwingConstants.CENTER);
	    titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	    JLabel instructionLabel = new JLabel("Enter Username and Password:", SwingConstants.CENTER);
	    instructionLabel.setFont(new Font("", Font.ITALIC, 12));
	    labelPanel.add(errorLabel);
	    labelPanel.add(titleLabel);
	    labelPanel.add(instructionLabel);

	    JPanel loginPanel = new JPanel(new GridLayout(4, 1, 5, 5));
	    JLabel usernameLabel = new JLabel("Username:", SwingConstants.CENTER);
	    usernameField = new JTextField(10);
	    JLabel passwordLabel = new JLabel("Password:", SwingConstants.CENTER);
	    passwordField = new JPasswordField(10);
	    loginPanel.add(usernameLabel);
	    loginPanel.add(usernameField);
	    loginPanel.add(passwordLabel);
	    loginPanel.add(passwordField);
	    
	    JPanel buttonPanel = new JPanel();
	    JButton loginButton = new JButton("Login");
	    loginButton.addActionListener(lc);
	    JButton backButton = new JButton("Back");
	    backButton.addActionListener(lc);    
	    buttonPanel.add(loginButton);
	    buttonPanel.add(backButton);

	    JPanel grid = new JPanel(new GridLayout(3, 1, 0, 10));
	    grid.add(labelPanel);
	    grid.add(loginPanel);
	    grid.add(buttonPanel);
	    this.add(grid);

		
	}

}
