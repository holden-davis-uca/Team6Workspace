package ServerCommunication;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class GameServerTest {
	private Database db;
	private GameServer server;
	
	@Before
	public void setUp() {
		db = new Database();
		server = new GameServer();
	}

	@Test
	public void testSetDatabase() {
		server.setDatabase(db);
	}

	@Test
	public void testIsRunning() {
		assertNotNull(server.isRunning());
	}
	
	@Test
	public void testServerStarted() {
		server.serverStarted();
	}
	
	@Test
	public void testServerStopped() {
		server.serverStopped();
	}
	
	@Test
	public void testServerClosed() {
		server.serverClosed();
	}

	@Test
	public void testClientConnected() {
		server.clientConnected(null);
	}
	
	@Test
	public void testHandleMessageFromClient() {
		
	}
}
