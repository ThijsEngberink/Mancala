package nl.sogyo.mancala;

public class Player {
	private String name;
	private Player opponent;
	private Player currentPlayer;
	private Box firstBox;
	
	Player(Box firstBox) {
		opponent = new Player(this, firstBox);
		name = "player 1";
		currentPlayer = this;
		this.firstBox = firstBox;
	}
	
	Player(Player opponent, Box firstBox) {
		this.opponent = opponent;
		name = "player 2";
		currentPlayer = opponent;
		this.firstBox = firstBox;
	}

	public String getName() {
		return name;
	}
	
	public Player getOpponent() {
		return opponent;
	}
	
	public Player getCurentPlayer() {
		return currentPlayer;
	}

	public boolean isCurrentPlayer() {
		if (this == currentPlayer) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void nextTurn() {
		currentPlayer = currentPlayer.getOpponent();
		opponent.switchCurrentPlayer();
	}
	
	private void switchCurrentPlayer() {
		currentPlayer = currentPlayer.getOpponent();
	}
	
	public int getScoreOfPlayer1AfterGameEnds() {
		int score = 0;
		if (firstBox.findIfAllEmpty() == true) {
			score = firstBox.getXthNeighbour(6).getNumberOfStones();	
		}
		else {
			score = 48-firstBox.getXthNeighbour(13).getNumberOfStones();
		}
		return score;
	}
	
	public int getScoreOfPlayer2AfterGameEnds() {
		int score = 48 - getScoreOfPlayer1AfterGameEnds();
		return score;
	}
	
	public String getWinner() {
		String winner = null;
		if (getScoreOfPlayer1AfterGameEnds() > 24) {
			winner = "player 1";
		}
		else if (getScoreOfPlayer1AfterGameEnds() < 24 ) {
			winner = "player 2";
		}
		else {
			winner = "draw";
		}
		return winner;
	}
}
