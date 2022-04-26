package ServerCommunication;

import java.io.Serializable;

public class User implements Serializable {
	private String username;
	private String password;
	private String winRatio;

	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setWinRatio(String winRatio) {
		this.winRatio = winRatio;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getWinRatio() {
		return winRatio;
	}
	
	//Constructor
	public User(String username, String password, String winRatio) {
		setUsername(username);
		setPassword(password);
		setWinRatio(winRatio);
	}
}
