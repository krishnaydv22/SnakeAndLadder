package Models;

public class Player {
	


	private int currentPosition;
private String playerName;
	public Player(String playerName, int currentPosition) {
		super();
		this.playerName = playerName;
		this.currentPosition = currentPosition;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	
	
	
	
	

}
