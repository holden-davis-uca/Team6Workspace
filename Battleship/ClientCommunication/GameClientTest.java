package ClientCommunication;

import static org.junit.Assert.*;

import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

public class GameClientTest {
	private GameClient client;
	private Object result;
	private JPanel container;
	private LoginControl loginControl;
	private CreateControl createControl;
	private GameControl gameControl;
	private LobbyControl lobbyControl;
	private PlacingControl placingControl;

	@Before
	public void setUp() {
		client = new GameClient();
		container = new JPanel();
		loginControl = new LoginControl(container, client);
	}
	
	@Test
	public void testSetLoginControl() {
		client.setLoginControl(loginControl);
	}
	
	@Test
	public void testSetCreateControl() {
		client.setCreateControl(createControl);
	}
	
	@Test
	public void testSetGameControl() {
		client.setGameControl(gameControl);
	}
	
	@Test
	public void testSetLobbyControl() {
		client.setLobbyControl(lobbyControl);
	}
	
	@Test
	public void testSetPlacingControl() {
		client.setPlacingControl(placingControl);
	}
	
	@Test
	public void testHandleMessageFromServer() {
		result = "LoginSuccessful";
		JPanel v1 = new JPanel();
		JPanel v2 = new JPanel();
		
		container.add(v1);
		container.add(v2);
		client.setLoginControl(loginControl);
		
		client.handleMessageFromServer(result);
	}
	
	@Test
	public void testMain() {
		
	}

}
