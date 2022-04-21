package ClientCommunication;
import static org.junit.Assert.*;

import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

import ClientGUI.GamePanel;

public class GameControl {
	private GamePanel container;
	private GameClient client;
 
	
	public GameControl(JPanel container, GameClient client) {
		this.container = (GamePanel) container;
		this.client = client;
		
	}
}
