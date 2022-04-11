//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*LoginControl.java
 * 
 * Provides the logic that facilitates interaction between LoginPanel and LoginData and validates user login input
 * The "Controller" component of the MVC set for Login
 */

package ClientCommunication;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;

import ClientGUI.*;

public class LoginControl implements ActionListener {

	private GameClient Client;
	private JPanel container;

	public LoginControl(JPanel container, GameClient Client) {
		this.container = container;
		this.Client = Client;
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if (command == "Submit") {
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "1");
		} else {
			LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
			LoginData data = new LoginData(loginPanel.getUsername(), loginPanel.getPassword());
			if (data.getUsername().equals("") || data.getPassword().equals("")) {
				displayError("You must enter a username and password.");
				return;
			}
//			try {
//				Client.sendToServer(data);
//			} catch (IOException ioe) {
//				displayError("Server connection failure!");
//				ioe.printStackTrace();
//			}
		}

	}

	public void loginSuccess() {
		LoginPanel loginPanel = (LoginPanel) container.getComponent(1);

		CardLayout cardLayout = (CardLayout) container.getLayout();
		cardLayout.show(container, "4");
	}

	public void displayError(String error) {
		LoginPanel loginPanel = (LoginPanel) container.getComponent(1);
		loginPanel.setError(error);
	}

}
