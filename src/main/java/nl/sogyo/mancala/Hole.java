package nl.sogyo.mancala;

public class Hole extends Box {
	
	Hole() {
		numberOfStones = 4;
		player = new Player(this);
		boxRef = new Hole(12, this, player);
		
	}
	Hole(int amountOfBoxesStillToMake, Hole hole1, Player player) {
		numberOfStones = 4;
		this.player = player;
		if (amountOfBoxesStillToMake > 1 && amountOfBoxesStillToMake != 8) {
			boxRef = new Hole(--amountOfBoxesStillToMake, hole1, player);
		}
		else {
			boxRef = new Kalaha(--amountOfBoxesStillToMake, hole1, player);
		}
	}
	
	public void move() {
		if (player == player.getCurentPlayer()) {
			int stonesToMove = numberOfStones;
			numberOfStones = 0;
			boxRef.move(stonesToMove);
		}
	}
	
	void move(int amountOfIncomingStones) {
		if (amountOfIncomingStones > 0) {
			numberOfStones++;
			if (amountOfIncomingStones > 1) {
				boxRef.move(--amountOfIncomingStones);
			}
			else {
				if (numberOfStones == 1 && player == player.getCurentPlayer()) {
					hit();
				}
				player.nextTurn();
			}
		}
	}
	
	private void hit() {
		numberOfStones = 0;
		int stonesToSend = getOpposingBox().getHit() + 1;
		sendStonesToKalaha(stonesToSend);
	}
	
	protected void sendStonesToKalaha(int stonesToSend) {
		boxRef.sendStonesToKalaha(stonesToSend);
	}
	
	public Box getOpposingBox() {
		int stepsToKalaha = findKalaha(0);
		int stepsToOpposingHole = 2*stepsToKalaha;
		return getXthNeighbour(stepsToOpposingHole);
	}
	
	protected int findKalaha(int amountOfSteps) {
		return boxRef.findKalaha(++amountOfSteps);
	}
	
	protected int getHit() {
		int stonesToSend = numberOfStones;
		numberOfStones = 0;
		return stonesToSend;
	}
	
	public boolean checkIfGameEnds() {
		boolean allEmptyPlayer1Side = findIfAllEmpty();
		boolean allEmptyPlayer2Side = getXthNeighbour(7).findIfAllEmpty();
		if (allEmptyPlayer1Side == true || allEmptyPlayer2Side == true) { 
			return true;
		}
		else {
			return false;
		}
	}

	protected boolean findIfAllEmpty() {
		if (numberOfStones == 0) {
			return boxRef.findIfAllEmpty();
		}
		else {
			return false;
		}
	}
}
