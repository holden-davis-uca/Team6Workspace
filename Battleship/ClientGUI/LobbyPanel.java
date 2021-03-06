//Chris Stinson - Team 6
package ClientGUI;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;
import ClientCommunication.*;

public class LobbyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
		// Create list of players
		list = new DefaultListModel<String>();
		for (int i = 0; i < allPlayers.size(); i++) {
			list.addElement(allPlayers.get(i));
		}

		// Use BorderLayout to lay out the components in this panel.
		this.setLayout(new BorderLayout());

		// Create the main lobby label in the north.
		JLabel label = new JLabel("Main Lobby", SwingConstants.CENTER);
		this.add(label, BorderLayout.NORTH);

		// create other player info on the Left
		JLabel userInfoLabel = new JLabel("Your Win/Loss Ratio!", SwingConstants.CENTER);
		userInfoLabel.setForeground(Color.BLUE);
		userHighScore = new JLabel(Double.toString(highscore), SwingConstants.CENTER);
		JPanel userInfoBuffer = new JPanel(new GridLayout(0, 1));
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
		//playerList.setPreferredSize(new Dimension(200, 200));
		playerList.setFont(playerList.getFont().deriveFont(Font.PLAIN));
		JScrollPane scrollPane = new JScrollPane(playerList);
		scrollPane.setPreferredSize(new Dimension(200, 200));
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		JPanel contactListBuffer = new JPanel();
		contactListBuffer.add(scrollPane);
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

		// updates selectedPlayer based off of which player is selected in the panel
		playerList.addListSelectionListener(new ListSelectionListener() {
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

	// adds player name to list of all players, returns true if name was added
	public boolean addAllPlayers(String name) {
		boolean result = false;
		if (!list.contains(name) && !list.contains("<html><b>" + name + "</b></html>")) {
			allPlayers.add(name);
			updatePlayerPanel(name);
			result = true;
		}
		return result;
	}

	public ArrayList<String> getAllPlayersScore() {
		return allPlayersScore;
	}

	public void setAllPlayersScore(ArrayList<String> allOnlineScore) {
		this.allPlayersScore = allOnlineScore;
	}

	// adds list of all players
	public void addAllPlayersScore(String score) {
		allPlayersScore.add(score);
	}

	// adds a name to lobby list
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

	// fills in player info in panel
	public void updatePlayerInfo(String playerName) {
		setPlayerUsername(playerName);
		playerName = playerName.strip();
		for (int i = 0; i < allPlayers.size(); i++) {
			if (allPlayers.get(i).equals(playerName)) {
				list.remove(i);
				String myHighscore = allPlayersScore.get(i);
				if (allPlayersScore.get(i).equals("NaN")) {
					myHighscore = allPlayersScore.get(i);
					myHighscore = "0.0";
				} else if (allPlayersScore.get(i).equals("Infinity")) {
					myHighscore = allPlayersScore.get(i);
					myHighscore = ">1.0";
				}
				setHighscore(Double.parseDouble(myHighscore));
				userHighScore.setText(Double.toString(highscore));
			}
		}
	}

	public int getUserHighScore() {
		return Integer.parseInt(userHighScore.getText());
	}

	// updates the list of players bolding the players online and returning offline
	// players to normal
	public void updateAllOnline(String onlinePlayers) {
		String[] allOnline = onlinePlayers.split(",");
		ArrayList<String> notOnline = new ArrayList<String>();
		ArrayList<String> allOnline1 = new ArrayList<String>();

		for (int i = 0; i < allOnline.length; i++) {
			allOnline1.add(allOnline[i]);
		}

		for (int i = 0; i < allPlayers.size(); i++) {
			if (!allOnline1.contains(allPlayers.get(i))) {
				notOnline.add(allPlayers.get(i));
			}
		}

		for (int i = 0; i < allOnline.length; i++) {
			if (list.contains(allOnline[i])) {
				System.out.println(list.get(list.indexOf(allOnline[i])));
				list.remove(list.indexOf(allOnline[i]));
				list.addElement("<html><b>" + allOnline[i] + "</b></html>");
			}
		}

		for (int i = 0; i < notOnline.size(); i++) {
			if (list.contains("<html><b>" + notOnline.get(i) + "</b></html>")) {
				list.remove(list.indexOf("<html><b>" + notOnline.get(i) + "</b></html>"));
				list.addElement(notOnline.get(i));
			}
		}
	}
}
