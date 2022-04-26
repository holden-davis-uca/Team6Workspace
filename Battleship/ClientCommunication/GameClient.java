//Riley Williams - Team 6
package ClientCommunication;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.io.*;
import javax.swing.*;
import ClientGUI.*;
import ocsf.client.*;

public class GameClient extends AbstractClient {
	private LoginControl loginControl;
	private CreateControl createControl;
	private GameControl gameControl;
	private LobbyControl lobbyControl;
	private PlacingControl placingControl;
	private static JFrame jframe;

	//Sets LoginControl
	public void setLoginControl(LoginControl loginControl) {
		this.loginControl = loginControl;
	}
	
	//Sets CreateControl
	public void setCreateControl(CreateControl createControl) {
		this.createControl = createControl;
	}

	//Sets GameControl
	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}

	//Sets LobbyControl
	public void setLobbyControl(LobbyControl lobbyControl) {
		this.lobbyControl = lobbyControl;
	}
	
	//Sets PlacingControl
	public void setPlacingControl(PlacingControl placingControl) {
		this.placingControl = placingControl;
	}

	//Sets JFrame Object
	public void setJframe(JFrame frame) {
		this.jframe = frame;
	}

	//Get JFrame Object
	public JFrame getJframe() {
		return jframe;
	}

	//Constructor
	public GameClient(String host) {
		super(host, 8300);
	}

	//Handles messages from the server
	public void handleMessageFromServer(Object arg0) {
		String message = (String) arg0;

		//If login was successfull on the server, send to the server the online players
		if (message.equals("LoginSuccessful")) {
			loginControl.loginSuccess();
			try {
				sendToServer("MyName");
				sendToServer("OnlinePlayers");
			} catch (IOException e) {
				e.printStackTrace();
			}
		//If the login had an error, fail
		} else if (message.equals("LoginError"))
			loginControl.displayError("Login failed");
		//If create account successful, Update account list
		 else if (message.equals("CreateSuccessful")) {
			createControl.createAccountSuccess();
			try {
				sendToServer("AllPlayers");
			} catch (IOException e) {
				e.printStackTrace();
			}
		//If the Create account fails, display error
		} else if (message.equals("CreateError"))
			createControl.displayError("Account could not be created");
		//Handles the players online and list of players for the lobby
		else if (message.startsWith("All: ")) {
			String allPlayers = message.substring(5);
			lobbyControl.processAllPlayers(allPlayers);
		} else if (message.startsWith("MyName:")) {
			String playerName = message.substring(7);
			lobbyControl.updatePlayerName(playerName);
		} else if (message.startsWith("Online: ")) {
			String onlinePlayers = message.substring(8);
			lobbyControl.processOnlinePlayers(onlinePlayers);
		} else if (message.startsWith("Challenge:")) {
			String[] challengeInfo = message.split(":");
			if (challengeInfo[1].equals(lobbyControl.getUsername())) {
				lobbyControl.processChallenge(challengeInfo[1], challengeInfo[2], challengeInfo[3]);
			}
		} else if (message.startsWith("ChallengeResult:")) {
			String[] resultInfo = message.split(":");
			if (resultInfo[1].equals(lobbyControl.getUsername())) {
				lobbyControl.processChallengeResults(resultInfo[2]);
			}
		}
	}

	//runs the client
	public static void main(String[] args) {
		GameClient client = new GameClient(args[0]);
		jframe = new JFrame();

		//Opens the connection to the server
		try {
			client.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Sets up the jframe
		jframe.setTitle("Battleship");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);

		//Sets all the Controls
		StartControl sc = new StartControl(container, client);
		LoginControl lc = new LoginControl(container, client);
		CreateControl cc = new CreateControl(container, client);
		LobbyControl lbc = new LobbyControl(container, client);
		GameControl gc = new GameControl(container, client);
		PlacingControl pc = new PlacingControl(container, client);

		//Sets the controls on the client
		client.setLoginControl(lc);
		client.setCreateControl(cc);
		client.setLobbyControl(lbc);
		client.setGameControl(gc);
		client.setPlacingControl(pc);

		//Sets the view panels up
		JPanel view1 = new StartPanel(sc);
		JPanel view2 = new LoginPanel(lc);
		JPanel view3 = new CreatePanel(cc);
		JPanel view4 = new LobbyPanel(lbc);
		//JPanel view5 = new GamePanel(gc);
		JPanel view6 = new PlacingPanel(pc);

		//Add the views to the container
		container.add(view1, "1");
		container.add(view2, "2");
		container.add(view3, "3");
		container.add(view4, "4");
		// container.add(view5, "5");
		container.add(view6, "6");

		//Show the start screen
		cardLayout.show(container, "1");

		//Set up the Jframe
		jframe.setLayout(new GridBagLayout());
		jframe.add(container);

		jframe.setSize(550, 500);
		jframe.setVisible(true);
		try {
			client.sendToServer("AllPlayers");
		} catch (IOException e) {
			e.printStackTrace();
		}
		jframe.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				// lbc.Logout();
				try {
					client.sendToServer("Logout: " + lbc.getUsername());
					client.closeConnection();

				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
}
