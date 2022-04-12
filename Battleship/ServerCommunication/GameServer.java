package ServerCommunication;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import ClientCommunication.CreateData;
import ClientCommunication.LoginData;
import ClientCommunication.Ships;
import ocsf.server.*;

public class GameServer extends AbstractServer {
	private Database db;
	private ResultSetMetaData rmd;
	private Ships player1Ships;
	private Ships player2Ships;
	private int player1Hits;
	private int player2Hits;
	private int player1Miss;
	private int player2Miss;
	
	public GameServer() {
		super(8300);
		this.setTimeout(500);
	}
	
	public void setDatabase(Database db) {
		this.db = db;
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
		}
		
		//TODO add the other handles
	}
	
	public void checkIfHit() {
		
	}
	
	public void checkIfSunk() {
		
	}
	
	public void validateSelection() {
		
	}
	
	public void playerBoardDataUpdate() {
		
	}
	
	//TODO add server main
}
