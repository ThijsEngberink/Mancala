package nl.sogyo.mancala;

public abstract class Box {
	protected int numberOfStones;
	protected Box boxRef;
	protected Player player;
	
	public int getNumberOfStones() {
		return numberOfStones;
	}
	
	public void setNumberOfStones(int numberOfStones) {
		this.numberOfStones = numberOfStones;
	}
	
	public Box getBoxRef() {
		return boxRef;
	}
	
	public Player getPlayer() {
		return player;
	}
	public abstract void move();
	abstract void move(int x);
	protected abstract void sendStonesToKalaha(int stonesToSend);
	protected abstract int findKalaha(int amountOfSteps);
	protected abstract Box getOpposingBox();
	protected abstract int getHit();
	protected abstract boolean findIfAllEmpty();
	
	public Box getXthNeighbour(int x) {
		if (x>0) {
			return boxRef.getXthNeighbour(--x);
		}
		else {
			return this;
		}
	}
}
