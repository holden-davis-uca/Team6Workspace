package Tests;

import static org.junit.Assert.*;
import javax.swing.JPanel;
import org.junit.Before;
import org.junit.Test;

import ClientCommunication.GameClient;
import ClientCommunication.StartControl;

public class StartControlTest {
	private StartControl sc;
	private JPanel container;
	private GameClient client;
	
	@Before
	public void setUp() {
		sc = new StartControl(container, client);
	}
	
	@Test
	public void testActionPerformed() {
		sc.actionPerformed(null);
	}

}
