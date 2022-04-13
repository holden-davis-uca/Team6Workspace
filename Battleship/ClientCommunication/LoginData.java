//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*LoginData.java
 * 
 * Provides the data (entered username and password) that is used to send the relevant information back and forth between LoginControl and LoginPanel
 * The "Model" component of the MVC set for Login
 */

package ClientCommunication;

import java.io.*; //Needed for Serializable implementation

public class LoginData implements Serializable {

	/*
	 * Fields: 
	 * 
	 * serialVersionUID - a static long for classes that implement Serializable according to eclipse specifications
	 * username and password - credentials for the user
	 */
	private static final long serialVersionUID = 1L;
	private String username;
	private String password;
	/*
	 *Methods:
	 *
	 *LoginData() - constructor, takes the username and password of the user and sets them accordingly
	 *getUsername() - getter for username
	 *setPassword() - setter for username
	 *getPassword() - getter for password
	 *setPassword() - setter for password
	 */
	
	/*
	 * Getter for username
	 * 
	 * Takes:
	 * Returns:
	 * 	A string representing the username
	 * Throws:
	 */
	public String getUsername() {
		return username;
	}
	/*
	 * Setter for username
	 * 
	 * Takes:
	 * 	A string representing the username to be set
	 * Returns:
	 * Throws:
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/*
	 * Getter for password
	 * 
	 * Takes:
	 * Returns:
	 * 	A string representing the password
	 * Throws:
	 */
	public String getPassword() {
		return password;
	}
	/*
	 * Setter for password
	 * 
	 * Takes:
	 * 	A string representing the password to be set
	 * Returns:
	 * Throws:
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * Contructor
	 * Intializes an instance of LoginData from given input
	 * 
	 * Takes:
	 * 	Two strings representing the username and password of the user
	 * Returns:
	 * Throws:
	 */
	public LoginData(String username, String password) {
		setUsername(username);
		setPassword(password);
	}

}
