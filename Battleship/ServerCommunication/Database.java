//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*Database.java
 * 
 * Provides functionality for Battleship game server to interact with a database
 * Uses a MySql MariaDB instance setup and running via XAMPP on localhost at port 3306
 * Assumes the existence of a user with the name "student" and password "hello" as well as a database "student_space"
 * Necessary login credentials (username + password) and the url used for connection need to be contained within db.properties in the same directory
 * W/L values are stored along with user credentials in the database; W/L ratio is calculated serverside (here) to save on number of required database interactions
 * Input is sanitized prior to insertion to prevent SQLI
 */

package ServerCommunication;

import java.io.*; //Needed for FIS
import java.sql.*; //Needed for JDBC
import java.util.*; //Needed for Properties, ArrayList etc

public class Database {
	/*
	 * Fields: 
	 * 
	 * con is the connection to the database using JDBC
	 * username and password are the credentials eventually retrieved from db.properties that con uses to establish a connection
	 * url is the path used by JDBC to connect to the mysql instance
	 * aeskey is the encryption key used when encrypting and decrypting the password with aes_encrypt()
	 * * Needs to be constant over multiple setups and shutdowns of the server, so it is hard coded and not random
	 * fis is the fileinputstream object used to read db.properties
	 */
	private Connection con;
	private String username;
	private String password;
	private String url;
	private String aeskey;
	private FileInputStream fis;
	
	/*
	 *Methods:
	 *
	 *Database() - Default constructor; only needs to be called on instantiation of GameServer's private Database variable ex. 'Database db = new Database();'
	 *query() - Internal query method to be used by other methods; should not be called directly
	 *executeDML() - Internal dml execution method to be used by other methods; should not be called directly
	 *
	 *createAccount() - Method to create an account from given username and password - returns boolean if successful
	 *verifyAccount() - Method to verify if an account exists with the given username - returns boolean if one exists
	 *getAllUsers() - Method to retrieve all users and corresponding w/l ratios from the database, returned in an HashMap<String, String>
	 *getUserRatio() - Method to retrieve a user's w/l ratio given their username, returned in a String
	 *recordMatch() - Method to record a match given the usernames of the two players and a bool (true for first parameter name win, false for second)
	 *finish() - Method to safely close connection to database
	 *
	 *NOTE: All win/loss ratios are returned as strings, as their most common usage outside of the database is to be displayed on screen ex. in a JLabel
	 */
	
	/*
	 * Default constructor
	 * Retrieves and stores credentials from db.properties and establishes a connection to the database
	 * 
	 * Takes:
	 * Returns:
	 * Throws:
	 * 	FileNotFound if db.properties isn't found in local directory
	 * 	IOException if db.properties isn't formatted properly
	 * 	SQLException if the connection cannot be successfully created
	 */
	public Database()
	{
		try {
			fis = new FileInputStream("./ServerCommunication/db.properties");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties props = new Properties();
		try {
			props.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		username = props.getProperty("user");
		password = props.getProperty("password");
		url = props.getProperty("url");
		aeskey = props.getProperty("aeskey");
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Executes queries on the database
	 * Used to retrieve information from database such as verifying logins, retrieving w/l ratio
	 * 
	 * Takes:
	 * 	A String representing the query statement to be executed; ie. "select * from table users;"
	 * Returns:
	 * 	ResultSet - null if query unsuccessful, results of query otherwise
	 * Throws:
	 * 	SQLException if query is unsuccessful
	 */
	public ResultSet query(String query)
	{
		try {
			
			Statement stmt = con.createStatement();
			ResultSet results = stmt.executeQuery(query);
			return results;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * Executes dml statements on database
	 * Used whenever changes are made: new account creation or updating w/l ratio
	 * 
	 * Takes:
	 * 	A String representing the dml statement to be executed; ie. "insert into table values('this,'that');"
	 * Returns:
	 * 	boolean - true if statement is successfully executed, false otherwise
	 * Throws:
	 * 	SQLException if statement is not successfully executed
	 */
	public boolean executeDML(String dml)
	{
		Statement stmt;
		try {
			stmt = con.createStatement();
			stmt.execute(dml);
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}	
	}
	/*
	 * Attempts to create an user account in the database
	 * Used whenever the user selects to create an account after filling in adequate credentials on the related screen
	 * 
	 * Takes:
	 * 	2 Strings representing the username and password entered by the user
	 * Returns:
	 * 	boolean - true if account is successfully created, false otherwise (account by the name already exists)
	 * Throws:
	 * 
	 */
	public boolean createAccount(String username, String password)
	{
		if (executeDML("insert into users values('"+username+"',aes_encrypt('"+password+"', '"+aeskey+"'),0,0);"))
			return true;
		else return false;
	}
	/*
	 * Verifies whether a user account already exists in the database using a given username, and whether the given password matches that of said user account
	 * Used whenever the user attempts to login after filling in adequate credentials on the related screen
	 * 
	 * Takes:
	 * 	2 Strings representing the username and password entered by the user
	 * Returns:
	 * 	boolean - true if account exists and credentials match, false otherwise (incorrect credentials or account does not exist)
	 * Throws:
	 * 
	 */
	public boolean verifyAccount(String username, String password)
	{
		ResultSet results = query("select * from users where username='"+username+"' and password=aes_encrypt('"+password+"', '"+aeskey+"');");
		try {
			if (results == null || (!results.next()))
				return false;
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	/*
	 * Returns a list of all users and their win/loss ratios
	 * Used to list users and w/l ratios in the lobby screen
	 * 
	 * Takes:
	 * Returns:
	 * 	An HashMap<String> representing the list of users stored in the database and their respective w/l ratios
	 * Throws:
	 * 
	 */
	public HashMap<String, String> getAllUsers()
	{
		HashMap<String, String> newresults = new HashMap<String, String>();
		ResultSet results = query("select username from users");
		try {
			while (results.next())
			{
				newresults.put(results.getString(1), getUserRatio(results.getString(1)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return newresults;
	}
	/*
	 * Retrieves the win/loss ratio of a given user
	 * To be called whenever the W/L ratio needs to be displayed on screen
	 * 
	 * Takes:
	 * 	1 String representing the username
	 * Returns:
	 * 	1 String representing the win/loss ratio of that user
	 * Throws:
	 * 
	 */
	public String getUserRatio(String username)
	{
		ResultSet results = query("select wins, losses from users where username='"+username+"';");
		try {
			results.next();
			return String.valueOf(Double.parseDouble(results.getString(1)) / Double.parseDouble(results.getString(2)));
		} catch (NumberFormatException | SQLException e) {
			e.printStackTrace();
			return "";
		}
	}
	/*
	 * Records the results of a completed match
	 * To be called whenever a match is completed
	 * 
	 * Takes:
	 * 	2 Strings representing the usernames of each player
	 *  boolean - true if the first player name one, false if the second player name won
	 * Returns:
	 * Throws:
	 * 
	 */
	public void recordMatch(String user1, String user2, boolean user1win)
	{
		if (user1win)
		{
			executeDML("update users set wins = wins + 1 where username='"+user1+"';");
			executeDML("update users set losses = losses + 1 where username='"+user2+"';");
		}
		else
		{
			executeDML("update users set wins = wins + 1 where username='"+user2+"';");
			executeDML("update users set losses = losses + 1 where username='"+user1+"';");
		}
	}
	/*
	 * Safely closes connection to database server
	 * To be called before turning off server program
	 * 
	 * Takes:
	 * Returns:
	 * 	boolean - true if successfully closed connection, false otherwise
	 * Throws:
	 *	SQLException if connection is unable to be closed (if connection not initially established)
	 */
	public boolean finish()
	{
		try {
			con.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
