package ClientCommunication;

import java.awt.event.*;
import javax.swing.*;
import ClientGUI.LobbyPanel;

public class LobbyControl implements ActionListener {
	private JPanel container;
	//private GameClient client;

	public LobbyControl(JPanel container/*, GameClient client*/) {
		this.container = container;
		//this.client = client
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		LobbyPanel panel = (LobbyPanel) container.getComponent(2);

		if (command == "Logout") {
			System.out.println("Logout Selected");
			// TODO add logout functionality
			Logout();
		} else if (command.equals("Challenge")) {
			if (panel.getSelectedPlayer() == null) {
				panel.setError("You must select a player first!");
			} else {
				System.out.println("Challenge Button Pressed");
				int dialogButton = JOptionPane.YES_NO_CANCEL_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Challenge " + panel.getSelectedPlayer() + "?",
						command, dialogButton);
				if (dialogResult == JOptionPane.YES_OPTION) {
					System.out.println("Challenge Selected");
					// TODO send request to selected player
				}
			}

		} else if (command == "View Score"){
			System.out.println("View Score");
			// ToDO retrieve selected player info from server and display their score
			if (panel.getSelectedPlayer() == null) {
				panel.setError("You must select a player first!");
			} else {
				int dialogButton = JOptionPane.INFORMATION_MESSAGE;
				JOptionPane.showMessageDialog(panel.getParent(), panel.getSelectedPlayer() + " score is: x");
				//TODO fix above line to get real player name from list and score from server
			}
		}
	}

	public void displayError(String error) {
		LobbyPanel panel = (LobbyPanel) container.getComponent(2);
		panel.setError(error);
	}

	public void Logout() {
		// TODO log client out from server
	}
}
