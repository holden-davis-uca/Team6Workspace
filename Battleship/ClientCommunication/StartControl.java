package ClientCommunication;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import ClientGUI.CreatePanel;
import ClientGUI.LoginPanel;
import ClientGUI.StartPanel;

public class StartControl implements ActionListener {
	private GameClient client;
	private JPanel container;
	
	public StartControl(GameClient client, JPanel container) {
		this.container = container;
		this.client = client;
	}
	
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		
		if (command.equals("Login")) {
			//LoginPanel loginPanel = (LoginPanel)container.getComponent(1);
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "2");
		} else if (command.equals("Create")) {
			//CreatePanel createPanel = (CreatePanel)container.getComponent(2);
			CardLayout cardLayout = (CardLayout)container.getLayout();
			cardLayout.show(container, "3");
		}
	}
}
