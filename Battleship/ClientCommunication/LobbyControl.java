//Chris Stinson - Team 6
package ClientCommunication;

import java.awt.event.*;
import java.io.IOException;

import javax.swing.*;
import ClientGUI.LobbyPanel;

public class LobbyControl implements ActionListener {
	private JPanel container;
	private GameClient client;

	public LobbyControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;			
	}

	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();		
		LobbyPanel panel = (LobbyPanel) container.getComponent(3);
		
		if (command.equals("Log Out")) {
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

		} else if (command.equals("View Score")){
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
	
	public void addListUsers(String name, String score) {
		LobbyPanel panel = (LobbyPanel) container.getComponent(3);
		panel.addAllOnline(name);
		panel.addAllOnlineScore(score);
	}

	public void Logout() {
		// TODO log client out from server
		try {
			client.closeConnection();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void processOnline(String allPlayers) {
		String [] player = allPlayers.split(","); 
		
		for (int i = 0; i < player.length;i++) {
			if (player[i].startsWith("{")) {
				player[i] = player[i].substring(1);
			}
			if (player[i].endsWith("}")) {
				player[i] = player[i].substring(0, player[i].length() - 1);
			}
			player[i] = player[i].strip();
			String[] toSend = player[i].split("=");
			addListUsers(toSend[0], toSend[1]);
		}
	}

	public void updatePlayerName(String playerName) {
		// TODO Auto-generated method stub
		LobbyPanel panel = (LobbyPanel) container.getComponent(3);
		panel.updatePlayerInfo(playerName);
	}
}
