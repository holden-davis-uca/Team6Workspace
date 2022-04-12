//Chris Stinson - Team 6
package ClientGUI;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import ClientCommunication.LobbyControl;

public class LobbyPanel extends JPanel{
	private String selectedPlayer;
	private int highscore = 0000;
	private JLabel errorLabel;
	
	public LobbyPanel(LobbyControl lc) {
		// Create a list of example players.
		DefaultListModel<String> list = new DefaultListModel<String>();
		list.addElement("Person One");
		list.addElement("<html><b>Person Two</b></html>");
		list.addElement("Person Three");
		list.addElement("Person Four");
		list.addElement("<html><b>Person Five</b></html>");
		list.addElement("Person Six");
		list.addElement("<html><b>Person Seven</b></html>");
		list.addElement("<html><b>Person Eight</b></html>");
		list.addElement("Person Nine");

		// Use BorderLayout to lay out the components in this panel.
		this.setLayout(new BorderLayout());

		// Create the main lobby label in the north.
		JLabel label = new JLabel("Main Lobby", JLabel.CENTER);
		this.add(label, BorderLayout.NORTH);

		// create other player info on the Left
		JLabel userInfoLabel = new JLabel("Your High Score!", JLabel.CENTER);
		userInfoLabel.setForeground(Color.BLUE);
		JLabel userHighScore = new JLabel(Integer.toString(highscore), JLabel.CENTER);
		JPanel userInfoBuffer = new JPanel(new GridLayout(0,1));
		userInfoBuffer.add(userInfoLabel);
		userInfoBuffer.add(userHighScore);
		JPanel userInfoContainer = new JPanel();
		userInfoContainer.add(userInfoBuffer);
		this.add(userInfoContainer);

		// Create the playerList on the right.
		JList<String> playerList = new JList<String>(list);
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
}
