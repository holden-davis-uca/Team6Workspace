//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*Database.java
 * Provides functionality for Battleship game server to interact with a database
 * Uses a MySql MariaDB instance setup and running via XAMPP on localhost at port 3306
 * Assumes the existence of a user with the name "student" and password "hello" as well as a database "student_space"
 * Necessary login credentials (username + password) and the url used for connection need to be contained within db.properties in the same directory
 */

package ServerCommunication;

import java.io.*; //Needed for FIS
import java.sql.*; //Needed for JDBC
import java.util.*; //Needed for Properties, ArrayList etc

public class Database {
	/*
	 * Fields: 
	 * con is the connection to the database using JDBC
	 * username and password are the credentials eventually retrieved from db.properties that con uses to establish a connection
	 * url is the path used by JDBC to connect to the mysql instance
	 * aeskey is the encryption key used when encrypting and decrypting the password with aes_encrypt()
	 * * Needs to be constant over multiple setups and shutdowns of the server, so it is hard coded and not random
	 * fis is used to read in the information stored in db.properties
	 */
	private Connection con;
	private String username;
	private String password;
	private String url;
	private String aeskey;
	private FileInputStream fis;
	
	/*
	 * Default constructor
	 * Retrieves and stores credentials from db.properties and establishes a connection to the database
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
			fis = new FileInputStream(".\\db.properties");
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
	 * Takes:
	 * 	A String representing the query statement to be executed; ie. "select * from table users;"
	 * Returns:
	 * 	ArrayList<String> - null if query unsuccessful, results of query otherwise
	 * Throws:
	 * 	SQLException if query is unsuccessful
	 */
	public ArrayList<String> query(String query)
	{
		try {
			
			Statement stmt = con.createStatement();
			ArrayList<String> queryresults = new ArrayList<String>();
			ResultSet results = stmt.executeQuery(query);
			if (results == null)
			{
				return null;
			}
			while (results.next())
			{
				queryresults.add(results.getString(1));
				queryresults.add(results.getString(2));
				queryresults.add(results.getString(3));
			}
			
			return queryresults;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	/*
	 * Executes dml statements on database
	 * Used whenever changes are made: new account creation or updating w/l ratio
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
//	public boolean createAccount(String username, String password)
//	{
//		
//	}
//	public boolean verifyAccount(String username, String password)
//	{
//		
//	}
//	public ArrayList<String> getAllUsers()
//	{
//		
//	}
//	public ArrayList<String> getUser(String username)
//	{
//		
//	}

}
