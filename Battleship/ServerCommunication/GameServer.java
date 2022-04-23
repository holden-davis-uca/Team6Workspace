//Riley Williams - Team 6
package ServerCommunication;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
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
	private ArrayList<User> onlinePlayers = new ArrayList<User>();
	
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
				User user = new User(data.getUsername(), data.getPassword(), db.getUserRatio(data.getUsername()));
				System.out.println("Client " + arg1.getId() + " successfully logged in as " + data.getUsername() + "\n");
				result = "LoginSuccessful";
				onlinePlayers.add(user);
			} else {
				result = "LoginError";
				System.out.println("Client " + arg1.getId() + " failed to login\n");
			}
			
			try {
				arg1.sendToClient(result);
				arg1.sendToClient("MyName:" + data.getUsername());
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
				User user = new User(data.getUsername(), data.getPassword(), db.getUserRatio(data.getUsername()));
				result = "CreateSuccessful";
				System.out.println("Client " + arg1.getId() + " created a new account called " + data.getUsername() + "\n");
				onlinePlayers.add(user);
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
			String challenge = "Challenge:";
			
			challenge += data.getToChallengeUsername() + ":";
			challenge += data.getPlayer() + ":";
			challenge += data.getHighscore();
						
			sendToAllClients(challenge);
			
		} else if (arg0 instanceof PlacingData) {
			PlacingData data = (PlacingData)arg0;
			Object result;
			
			
		} else if (arg0 instanceof GameData) {
			
		} else if (arg0.equals("AllPlayers")) {
			String response = "All: ";
			response += db.getAllUsers();
			sendToAllClients(response);
		} else if (arg0.equals("OnlinePlayers")) {
			String response = "Online: ";
			for (int i = 0; i < onlinePlayers.size(); i++) {
				response += onlinePlayers.get(i).getUsername();
				if (i + 1 < onlinePlayers.size()) {
					response += ",";
				}
			}
			
			sendToAllClients(response);
		} else if (arg0.toString().startsWith("Logout: ")) {
			String username = arg0.toString().substring(8);
			for (int i = 0; i < onlinePlayers.size(); i++) {
				if (onlinePlayers.get(i).getUsername().equals(username)) {
					onlinePlayers.remove(i);
				}
			}
			String response = "Online: ";
			for (int i = 0; i < onlinePlayers.size(); i++) {
				response += onlinePlayers.get(i).getUsername();
				if (i + 1 < onlinePlayers.size()) {
					response += ",";
				}
			}			
			
			sendToAllClients(response);
			
			try {
				arg1.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (arg0.toString().startsWith("ChallengeResult:")) {
			sendToAllClients(arg0.toString());
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
