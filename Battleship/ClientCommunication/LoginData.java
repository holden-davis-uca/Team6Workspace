//Holden Davis - Team #6
//CSCI 4490 - CRN 30660 - Spring 2022
/*LoginData.java
 * 
 * Provides the data (entered username and password) that is used to send the relevant information back and forth between LoginControl and LoginPanel
 * The "Model" component of the MVC set for Login
 */

package ClientCommunication;

import java.io.*;

public class LoginData implements Serializable {

	private String username;
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LoginData(String username, String password) {
		setUsername(username);
		setPassword(password);
	}

}
