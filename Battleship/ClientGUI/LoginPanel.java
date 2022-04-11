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

	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel errorLabel;

	public String getUsername() {
		return usernameField.getText();
	}

	public String getPassword() {
		return Arrays.toString(passwordField.getPassword());
		
	}

	public void setError(String error) {
		errorLabel.setText(error);
	}
	
	public LoginPanel(LoginControl lc)
	{
//		LoginControl controller = new LoginControl(container, client);
//		client.setLoginControl(controller);
		
	    JPanel labelPanel = new JPanel(new GridLayout(2, 1, 5, 5));
	    errorLabel = new JLabel("", JLabel.CENTER);
	    errorLabel.setForeground(Color.RED);
	    JLabel instructionLabel = new JLabel("Enter username and password", JLabel.CENTER);
	    labelPanel.add(errorLabel);
	    labelPanel.add(instructionLabel);

	    JPanel loginPanel = new JPanel(new GridLayout(2, 2, 5, 5));
	    JLabel usernameLabel = new JLabel("Username:", JLabel.RIGHT);
	    usernameField = new JTextField(10);
	    JLabel passwordLabel = new JLabel("Password:", JLabel.RIGHT);
	    passwordField = new JPasswordField(10);
	    loginPanel.add(usernameLabel);
	    loginPanel.add(usernameField);
	    loginPanel.add(passwordLabel);
	    loginPanel.add(passwordField);
	    
	    JPanel buttonPanel = new JPanel();
	    JButton submitButton = new JButton("Submit");
	    submitButton.addActionListener(lc);
	    JButton cancelButton = new JButton("Cancel");
	    cancelButton.addActionListener(lc);    
	    buttonPanel.add(submitButton);
	    buttonPanel.add(cancelButton);

	    JPanel grid = new JPanel(new GridLayout(3, 1, 0, 10));
	    grid.add(labelPanel);
	    grid.add(loginPanel);
	    grid.add(buttonPanel);
	    this.add(grid);
		
	}

}
