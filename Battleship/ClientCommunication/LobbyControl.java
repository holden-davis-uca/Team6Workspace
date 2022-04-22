//Chris Stinson - Team 6
package ClientCommunication;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import ClientGUI.*;

public class LobbyControl implements ActionListener {
	private JPanel container;
	private GameClient client;
	private String username;

	public LobbyControl(JPanel container, GameClient client) {
		this.container = container;
		this.client = client;
		username = "";
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
					LobbyData data = new LobbyData(panel.getSelectedPlayer(), panel.getHighscore());
					try {
						client.sendToServer(data);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else if (command.equals("View Score")) {
			// ToDO retrieve selected player info from server and display their score
			if (panel.getSelectedPlayer() == null) {
				panel.setError("You must select a player first!");
			} else {
				ArrayList<String> allPlayers = panel.getAllPlayers();
				ArrayList<String> allPlayersScores = panel.getAllPlayersScore();
				String selectedPlayerScore = "";
				for (int i = 0; i < allPlayers.size(); i++) {
					if (panel.getSelectedPlayer().strip().equals(allPlayers.get(i).strip())) {
						selectedPlayerScore = allPlayersScores.get(i);
					}
				}
				int dialogButton = JOptionPane.INFORMATION_MESSAGE;
				JOptionPane.showMessageDialog(panel.getParent(),
						panel.getSelectedPlayer() + " score is: " + selectedPlayerScore);
			}
		}
	}

	public void displayError(String error) {
		LobbyPanel panel = (LobbyPanel) container.getComponent(2);
		panel.setError(error);
	}

	public void addListUsers(String name, String score) {
		LobbyPanel panel = (LobbyPanel) container.getComponent(3);
		panel.addAllPlayers(name);
		panel.addAllPlayersScore(score);
	}

	public void Logout() {
		// TODO log client out from server
		try {
			client.sendToServer("Logout: " + getUsername());
			client.closeConnection();

		} catch (IOException e) {
			e.printStackTrace();
		}
		JFrame frame = client.getJframe();
		frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
	}

	public void processAllPlayers(String allPlayers) {
		String[] player = allPlayers.split(",");

		for (int i = 0; i < player.length; i++) {
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
		LobbyPanel panel = (LobbyPanel) container.getComponent(3);
		panel.updatePlayerInfo(playerName);
		setUsername(playerName);
	}

	public void challengeAccepted() {
		CardLayout cardLayout = (CardLayout) container.getLayout();		
		cardLayout.show(container, "6");
	}

	public void processOnlinePlayers(String onlinePlayers) {
		LobbyPanel panel = (LobbyPanel) container.getComponent(3);
		panel.updateAllOnline(onlinePlayers);

	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}
