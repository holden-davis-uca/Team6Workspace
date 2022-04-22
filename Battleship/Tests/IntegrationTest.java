//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*
 * IntegrationTest.java
 * 
 * Provides JUnit Integration Testing for the entire project
 */

package Tests;

import java.io.*;				//Needed for exceptions
import org.junit.*;				//Needed for before/after
import ClientCommunication.*;	//Needed for client
import ServerCommunication.*;	//Needed for server
import ClientGUI.*;				//Needed for interface

public class IntegrationTest {
	private GameServer server;
	private GameClient client;
	private Database db;
	

	@Before
	public void setUp() throws IOException {
		server = new GameServer();
		db = new Database();
		server.setDatabase(db);
		server.listen();
		client = new GameClient("localhost");
	}
	@Test
	public void mainTest()
	{
		System.out.println("\nPlaceholder\n");
	}
	@After
	public void tearDown() throws IOException
	{
		db.finish();
		client.closeConnection();
		server.close();
	}

}
