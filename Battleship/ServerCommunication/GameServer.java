//Riley Williams - Team 6
package ServerCommunication;

import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import ClientCommunication.*;
import ocsf.server.*;

public class GameServer extends AbstractServer {
	private Database db;
	private Ships player1Ships;
	private Ships player2Ships;
	private int player1Hits;
	private int player2Hits;
	private int player1Miss;
	private int player2Miss;
	private boolean running = false;
	
	public GameServer() {
		super(8300);
		this.setTimeout(500);
	}
	
	public void setDatabase(Database db) {
		this.db = db;
	}
	
	public boolean isRunning() {
		return running;
	}
	
	public void serverStarted() {
		running = true;
		System.out.println("Server Started\n");
	}
	
	public void serverStopped() {
		System.out.println("Server stopped accepting new clients\n");
	}
	
	public void serverClosed() {
		running = false;
		System.out.println("Server is closed\n");
	}
	
	public void clientConnected(ConnectionToClient client) {
		System.out.println("Client " + client.getId() + " connected\n");
	}
	
	public void listeningException(Throwable exception) {
		System.out.println("Listening exception: " + exception.getMessage() + "\n");
	}
	
	public void handleMessageFromClient(Object arg0, ConnectionToClient arg1) {
		if (arg0 instanceof LoginData) {
			LoginData data = (LoginData)arg0;
			boolean verify = false;
			Object result = null;
			
			verify = db.verifyAccount(data.getUsername(), data.getPassword());
			
			if (verify == true) {
				System.out.println("Client " + arg1.getId() + " successfully logged in as " + data.getUsername() + "\n");
				result = "LoginSuccessful";
			} else {
				result = "LoginError";
				System.out.println("Client " + arg1.getId() + " failed to login\n");
			}
			
			try {
				arg1.sendToClient(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (arg0 instanceof CreateData) {
			CreateData data = (CreateData)arg0;
			Object result;
			boolean created = false;
			
			created = db.createAccount(data.getUsername(), data.getPassword());
			
			if (created == true) {
				result = "CreateSuccessful";
				System.out.println("Client " + arg1.getId() + " created a new account called " + data.getUsername() + "\n");
			} else {
				result = "CreateError";
				System.out.println("Client " + arg1.getId() + " failed to create a new account\n");
			}
			
			try {
				arg1.sendToClient(result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (arg0 instanceof LobbyData) {
			LobbyData data = (LobbyData)arg0;
			Object result;
			
			try {
				System.out.println("Client " + arg1.getId() + " successfully logged out of " + data.getPlayer() + "\n");
				arg1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (arg0 instanceof PlacingData) {
			PlacingData data = (PlacingData)arg0;
			Object result;
			
			
		} else if (arg0 instanceof GameData) {
			
		}
		
		//TODO finish the other handles
	}
	
	public void checkIfHit() {
		
	}
	
	public void checkIfSunk() {
		
	}
	
	public void validateSelection() {
		
	}
	
	public void playerBoardDataUpdate() {
		
	}
	
	public static void main(String[] args) {
		//TODO Finish server main
		GameServer server = new GameServer();
		Database db = new Database();
		Scanner scanner = new Scanner(System.in);
		String input;
		
		server.setDatabase(db);
		
		try {
			server.listen();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		System.out.println("Type 'close' to close the server and end the program.");
		
		do {
			input = scanner.nextLine();
				
			if (input.equals("close"))
				break;
		} while (server.isRunning()); 
		scanner.close();
		
		try {
			if (input.equals("close"))
				db.finish();
				server.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
