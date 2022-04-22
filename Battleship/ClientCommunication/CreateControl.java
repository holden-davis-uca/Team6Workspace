//Chris Stinson - Team 6
package ClientCommunication;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import ClientGUI.*;

public class CreateControl implements ActionListener {
	// Private data fields for the container and chat client.
	private JPanel container;
	private GameClient client;

	// Constructor for the create account controller.
	public CreateControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}

	// Handle button clicks.
	public void actionPerformed(ActionEvent ae) {
		// Get the name of the button clicked.
		String command = ae.getActionCommand();

		// The Cancel button takes the user back to the initial panel.
		if (command.equals("Cancel")) {
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "1");
		}

		// The Submit button creates a new account.
		else if (command.equals("Submit")) {
			// Get the text the user entered in the three fields.
			CreatePanel createAccountPanel = (CreatePanel) container.getComponent(2);
			String username = createAccountPanel.getUsername();
			String password = createAccountPanel.getPassword();
			String passwordVerify = createAccountPanel.getPasswordVerify();

			// Check the validity of the information locally first.
			if (username.equals("") || password.equals("")) {
				displayError("You must enter a username and password.");
				return;
			} else if (!password.equals(passwordVerify)) {
				displayError("The two passwords did not match.");
				return;
			}
			if (username.length() <= 3) {
				displayError("The username must be at least 4 characters.");
				return;
			} else if (username.length() > 30) {
				displayError("The username must be less than 30 characters");
				return;
			} else if (!username.matches("[a-zA-Z0-9]*")) {
				displayError("The username must be alphanumeric.");
				return;
			}
			if (password.length() < 10) {
				displayError("The password must be at least 10 characters.");
				return;
			} else if (password.length() > 20) {
				displayError("The password must be less than 20 characters");
				return;
			} else if (!password.matches("[a-zA-Z0-9]*")) {
				displayError("The password must be alphanumeric.");
				return;
			}

			// Submit the new account information to the server.
			CreateData data = new CreateData(username, password);
			try {
				client.sendToServer(data);
			} catch (IOException e) {
				displayError("Error connecting to the server.");
			}
		}
	}

	// After an account is created, set the User object and display the contacts
	// screen.
	public void createAccountSuccess() {
		CreatePanel createPanel = (CreatePanel) container.getComponent(2);
		CardLayout cardLayout = (CardLayout) container.getLayout();
		cardLayout.show(container, "2");
	}

	// Method that displays a message in the error label.
	public void displayError(String error) {
		CreatePanel createAccountPanel = (CreatePanel) container.getComponent(2);
		createAccountPanel.setError(error);
	}
}
