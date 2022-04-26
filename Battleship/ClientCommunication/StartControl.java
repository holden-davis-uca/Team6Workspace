//Riley Williams - Team 6
package ClientCommunication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class StartControl implements ActionListener {
	private GameClient client;
	private JPanel container;

	//Constructor
	public StartControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();

		//If login button pressed, go to login panel
		if (command.equals("Login")) {
			// LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "2");
		//If the create button pressed, go to the create panel
		} else if (command.equals("Create")) {
			// CreatePanel createPanel = (CreatePanel)container.getComponent(2);
			CardLayout cardLayout = (CardLayout) container.getLayout();
			cardLayout.show(container, "3");
		}
	}
}
