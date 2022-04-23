//Chris Stinson - Team 6
package ClientCommunication;

import java.io.*;

public class LobbyData implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String player;
	private double highscore;
	private String toChallengeUsername;

	public LobbyData(String username, double highscore, String toChallengeUsername) {
		setPlayer(username);
		setHighscore(highscore);
		setToChallengeUsername(toChallengeUsername);
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

	public String getToChallengeUsername() {
		return toChallengeUsername;
	}

	public void setToChallengeUsername(String toChallengeUsername) {
		this.toChallengeUsername = toChallengeUsername;
	}
}
