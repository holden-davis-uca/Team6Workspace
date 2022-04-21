//Chris Stinson - Team 6
package ClientCommunication;

import java.io.*;
import java.util.ArrayList;
import ServerCommunication.User;

public class LobbyData implements Serializable {
	private String player;
	private double highscore;

	public LobbyData(String username, double highscore) {
		setPlayer(username);
		setHighscore(highscore);
	}

	public double getHighscore() {
		return highscore;
	}

	public void setHighscore(double highscore) {
		this.highscore = highscore;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}
}
