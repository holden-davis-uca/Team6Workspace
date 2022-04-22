package Tests;

import javax.swing.*;
import org.junit.*;
import ClientCommunication.*;

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
