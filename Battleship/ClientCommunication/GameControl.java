package ClientCommunication;

import javax.swing.*;
import ClientGUI.*;

public class GameControl {
	private GamePanel container;
	private GameClient client;

	public GameControl(JPanel container, GameClient client) {
		this.container = (GamePanel) container;
		this.client = client;

	}
}
