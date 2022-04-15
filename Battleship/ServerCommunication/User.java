package ServerCommunication;

import java.io.Serializable;

public class User implements Serializable {
	private String username;
	private String password;
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public User(String username, String password) {
		setUsername(username);
		setPassword(password);
	}
	
	public User() {
		
	}
}
