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
		JPanel grid = new JPanel(new GridLayout(3,2,0,10));
//		grid.add(*);
		this.add(grid);
		
	}

}
