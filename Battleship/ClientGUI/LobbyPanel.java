//Chris Stinson - Team 6
package ClientGUI;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.*;
import ClientCommunication.LobbyControl;
import ServerCommunication.User;

public class LobbyPanel extends JPanel{
	private String selectedPlayer;
	private JList<String> playerList;
	DefaultListModel<String> list;
	private String playerUsername;
	private double highscore = 0000;
	private JLabel errorLabel;
	private ArrayList<String> allPlayers = new ArrayList<String>();
	private ArrayList<String> allPlayersScore = new ArrayList<String>();
	private JLabel userHighScore;
	
	public LobbyPanel(LobbyControl lc) {
		// Create a list of example players.
		list = new DefaultListModel<String>();
//		list.addElement("Person One");
//		list.addElement("<html><b>Person Two</b></html>");
//		list.addElement("Person Three");
//		list.addElement("Person Four");
//		list.addElement("<html><b>Person Five</b></html>");
//		list.addElement("Person Six");
//		list.addElement("<html><b>Person Seven</b></html>");
//		list.addElement("<html><b>Person Eight</b></html>");
//		list.addElement("Person Nine");
		
		//Create list of players
		for (int i = 0; i < allPlayers.size();i++) {
			list.addElement(allPlayers.get(i));
		}

		// Use BorderLayout to lay out the components in this panel.
		this.setLayout(new BorderLayout());

		// Create the main lobby label in the north.
		JLabel label = new JLabel("Main Lobby", JLabel.CENTER);
		this.add(label, BorderLayout.NORTH);

		// create other player info on the Left
		JLabel userInfoLabel = new JLabel("Your Win/Loss Ratio!", JLabel.CENTER);
		userInfoLabel.setForeground(Color.BLUE);
		userHighScore = new JLabel(Double.toString(highscore), JLabel.CENTER);
		JPanel userInfoBuffer = new JPanel(new GridLayout(0,1));
		userInfoBuffer.add(userInfoLabel);
		userInfoBuffer.add(userHighScore);
		JPanel userInfoContainer = new JPanel();
		userInfoContainer.add(userInfoBuffer);
		this.add(userInfoContainer);

		// Create the playerList on the right.
		playerList = new JList<String>(list);
		playerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		playerList.setLayoutOrientation(JList.VERTICAL);
		playerList.setVisibleRowCount(-1);
		playerList.setPreferredSize(new Dimension(300, 200));
		playerList.setFont(playerList.getFont().deriveFont(Font.PLAIN));
		JPanel contactListBuffer = new JPanel();
		contactListBuffer.add(playerList);
		this.add(contactListBuffer, BorderLayout.EAST);


		// Create the buttons in the south and error label
		JPanel buttonsPanel = new JPanel(new BorderLayout());
		JPanel contactButtons = new JPanel();
		JPanel errorLabelPanel = new JPanel();
		errorLabel = new JLabel("Select a player to challenge!");
		errorLabelPanel.add(errorLabel);
		buttonsPanel.add(errorLabelPanel, BorderLayout.NORTH);
		JButton challengeButton = new JButton("Challenge");
		JButton viewHighscore = new JButton("View Score");
		contactButtons.add(challengeButton);
		contactButtons.add(viewHighscore);
		buttonsPanel.add(contactButtons, BorderLayout.CENTER);
		JButton logoutButton = new JButton("Log Out");
		JPanel logoutButtonBuffer = new JPanel();
		logoutButtonBuffer.add(logoutButton);
		buttonsPanel.add(logoutButtonBuffer, BorderLayout.SOUTH);
		this.add(buttonsPanel, BorderLayout.SOUTH);

		challengeButton.addActionListener(lc);
		logoutButton.addActionListener(lc);
		viewHighscore.addActionListener(lc);
		playerList.addListSelectionListener((javax.swing.event.ListSelectionListener) new ListSelectionListener() {

			public void valueChanged(ListSelectionEvent arg0) {
				if (!arg0.getValueIsAdjusting()) {
					setSelectedPlayer(playerList.getSelectedValue());
				}
			}
		});

		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	public void setError(String error) {
		errorLabel.setText(error);
	}
	
	public String getSelectedPlayer() {
		return selectedPlayer;
	}

	public void setSelectedPlayer(String selectedPlayer) {
		this.selectedPlayer = selectedPlayer;
	}

	public ArrayList<String> getAllPlayers() {
		return allPlayers;
	}

	public void setAllPlayers(ArrayList<String> allOnline) {
		this.allPlayers = allOnline;
	}
	
	public void addAllPlayers(String name) {
		allPlayers.add(name);
		updatePlayerPanel(name);
	}

	public ArrayList<String> getAllPlayersScore() {
		return allPlayersScore;
	}

	public void setAllPlayersScore(ArrayList<String> allOnlineScore) {
		this.allPlayersScore = allOnlineScore;
	}
	
	public void addAllPlayersScore(String score) {
		allPlayersScore.add(score);
	}
	
	public void updatePlayerPanel(String name) {
		list.addElement(name);
	}

	public String getPlayerUsername() {
		return playerUsername;
	}

	public void setPlayerUsername(String playerUsername) {
		this.playerUsername = playerUsername;
	}
	
	public void setHighscore(double highscore) {
		this.highscore = highscore;
	}
	
	public double getHighscore() {
		return highscore;
	}

	public void updatePlayerInfo(String playerName) {
		// TODO Auto-generated method stub
		setPlayerUsername(playerName);
		playerName = playerName.strip();
		for (int i = 0; i < allPlayers.size(); i++) {
			if (allPlayers.get(i).equals(playerName)) {
				list.remove(i);
				setHighscore(Double.parseDouble(allPlayersScore.get(i)));
				userHighScore.setText(Double.toString(highscore));
			}
		}
	}
	
	public int getUserHighScore() {
		return Integer.parseInt(userHighScore.getText());
	}

	public void updateAllOnline(String onlinePlayers) {
		// TODO Auto-generated method stub
		String[] allOnline = onlinePlayers.split(",");
		for (int i = 0; i<allOnline.length;i++) {
			if (list.contains(allOnline[i])) {
				System.out.println(list.get(list.indexOf(allOnline[i])));
				list.remove(list.indexOf(allOnline[i]));
				list.addElement("<html><b>" + allOnline[i] + "</b></html>");
			}
		}
	}
}
