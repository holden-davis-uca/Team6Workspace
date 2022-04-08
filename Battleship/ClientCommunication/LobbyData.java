package ClientCommunication;

import java.io.*;

public class LobbyData implements Serializable {
	private String player;
	private int highscore;

	public LobbyData(String username, int highscore) {
		setPlayer(username);
		setHighscore(highscore);
	}

	public int getHighscore() {
		return highscore;
	}

	public void setHighscore(int highscore) {
		this.highscore = highscore;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

}
