//Riley Williams - Team 6
package ClientCommunication;

import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.io.IOException;
import javax.swing.*;
import ClientGUI.*;
import ocsf.client.AbstractClient;

public class GameClient extends AbstractClient {
	private LoginControl loginControl;
	private CreateControl createControl;
	private GameControl gameControl;
	private LobbyControl lobbyControl;
	private PlacingControl placingControl;
	private static JFrame jframe;
	
	public void setLoginControl(LoginControl loginControl) {
		this.loginControl = loginControl;
	}
	
	public void setCreateControl(CreateControl createControl) {
		this.createControl = createControl;
	}
	
	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}
	
	public void setLobbyControl(LobbyControl lobbyControl) {
		this.lobbyControl = lobbyControl;
	}
	
	public void setPlacingControl(PlacingControl placingControl) {
		this.placingControl = placingControl;
	}
	
	public void setJframe(JFrame frame) {
		this.jframe = frame;
	}
	
	public JFrame getJframe() {
		return jframe;
	}
	
	public GameClient() {
		super("localhost", 8300);
	}
	
	public void handleMessageFromServer(Object arg0) {
		String message = (String)arg0;
		
		if (message.equals("LoginSuccessful")) {
			loginControl.loginSuccess();
			try {
				//sendToServer("OnlinePlayers");	
				sendToServer("MyName");
				sendToServer("OnlinePlayers");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		else if (message.equals("LoginError"))
			loginControl.displayError("Login failed");
		else if (message.equals("CreateSuccessful")) 
			createControl.createAccountSuccess();
		else if (message.equals("CreateError")) 
			createControl.displayError("Account could not be created");
		else if (message.startsWith("All: ")) {
			String allPlayers = message.substring(5);
			lobbyControl.processAllPlayers(allPlayers);				
			}
		else if (message.startsWith("MyName:")) {
			String playerName = message.substring(7);
			lobbyControl.updatePlayerName(playerName);
		} else if (message.startsWith("Online: ")) {
			String onlinePlayers = message.substring(8);
			lobbyControl.processOnlinePlayers(onlinePlayers);
		}
		//TODO add the other handles
	}
	
	public void connectEstablished() {
		
	}
	
	public void connectionException() {
		
	}
	
	public static void main(String[] args) {
		GameClient client = new GameClient();
		jframe = new JFrame();
		
		try {
			client.openConnection();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jframe.setTitle("Battleship");
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		CardLayout cardLayout = new CardLayout();
		JPanel container = new JPanel(cardLayout);
		
		StartControl sc = new StartControl(container, client); 
		LoginControl lc = new LoginControl(container, client);
		CreateControl cc = new CreateControl(container, client);
		LobbyControl lbc = new LobbyControl(container, client); //TODO Doesnt take both inputs
		//GameControl gc = new GameControl(container, client); //TODO Not made yet
		PlacingControl pc = new PlacingControl(container, client); //TODO doesnt take both inputs
		
		client.setLoginControl(lc);
		client.setCreateControl(cc);
		client.setLobbyControl(lbc); //TODO
		//client.setGameControl(gc); TODO
		client.setPlacingControl(pc); //TODO
		
		JPanel view1 = new StartPanel(sc);
		JPanel view2 = new LoginPanel(lc);
		JPanel view3 = new CreatePanel(cc);
		JPanel view4 = new LobbyPanel(lbc); //TODO
		//JPanel view5 = new GamePanel(gc); TODO
		JPanel view6 = new PlacingPanel(pc); //TODO
		
		container.add(view1, "1");
		container.add(view2, "2");
		container.add(view3, "3");
		container.add(view4, "4");//TODO
		//container.add(view5, "5");//TODO
		container.add(view6, "6");//TODO
		
		cardLayout.show(container, "1");
		
		jframe.setLayout(new GridBagLayout());
		jframe.add(container);
		
		jframe.setSize(550, 350);
		jframe.setVisible(true);	
		try {
			client.sendToServer("AllPlayers");				
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
