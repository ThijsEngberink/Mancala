package nl.sogyo.mancala;

public class Kalaha extends Box {

	Kalaha(int amountOfBoxesStillToMake, Hole hole1, Player player) {
		this.player = player;
		if (amountOfBoxesStillToMake > 1) {
			boxRef = new Hole(--amountOfBoxesStillToMake, hole1, player.getOpponent());
		}
		else {
			boxRef = hole1; 
		}
	}
	
	Kalaha() {
		
	}
	
	
	public void move() {
		
	}
	
	void move(int amountOfIncomingStones) {
		if (player.isCurrentPlayer()) {
			numberOfStones++;
			if (amountOfIncomingStones > 1) {
				boxRef.move(--amountOfIncomingStones);
			}
		}
		else {
			boxRef.move(amountOfIncomingStones);
		}
	}
	
	protected void sendStonesToKalaha(int stonesToSend) {
		numberOfStones += stonesToSend;
	}

	protected int findKalaha(int amountOfSteps) {
		return amountOfSteps;
	}

	protected Box getOpposingBox() {
		return getXthNeighbour(7);
	}

	@Override
	protected int getHit() {
		// TODO Auto-generated method stub
		return 0;
	}


	protected boolean findIfAllEmpty() {
		return true;
	}

}
