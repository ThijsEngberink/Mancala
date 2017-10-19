package nl.sogyo.mancala;

import org.junit.Assert;
import org.junit.Test;

public class MancalaTest {

    @Test
    public void testIfOriginalHoleIsEmptyAfterMove()
    {
    	Hole hole = new Hole();
    	hole.move();
    	int result = hole.getNumberOfStones();
    	Assert.assertEquals(result, 0);
    }
    @Test
    public void testIfNextHoleHas5StonesAfterMove() {
    	Hole hole = new Hole();
    	hole.move();
    	int result = hole.getBoxRef().getNumberOfStones();
    	Assert.assertEquals(result, 5);
    }
    
    @Test
    public void testIf6thHoleHas4StonesAfterMove() {
    	Hole hole = new Hole();
    	hole.move();
    	int result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getNumberOfStones();
    	Assert.assertEquals(result, 4);
    }
    
    @Test
    public void testIf5thHoleHas5StonesAfterMove() {
    	Hole hole = new Hole();
    	hole.move();
    	int result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getNumberOfStones();
    	Assert.assertEquals(result, 5);
    }
    
    @Test
    public void testIf5thHoleHas4StonesAfterMoveIfItStartsWith3Stones() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(3);
    	hole.move();
    	int result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getNumberOfStones();
    	Assert.assertEquals(result, 4);
    }
    
    @Test
    public void testIf4thHoleHas5StonesAfterMoveIfItStartsWith3Stones() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(3);
    	hole.move();
    	int result = hole.getBoxRef().getBoxRef().getBoxRef().getNumberOfStones();
    	Assert.assertEquals(result, 5);
    }
    
    @Test
    public void testIf7thBoxIsKalaha() {
    	Hole hole = new Hole();
    	boolean result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getClass().equals((new Kalaha()).getClass());
    	Assert.assertTrue(result);
    }
    
    @Test
    public void testIf8thBoxIsHole() {
    	Hole hole = new Hole();
    	boolean result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getClass().equals((new Hole()).getClass());
    	Assert.assertTrue(result);
    }
    
    @Test
    public void testIf14thBoxIsKalaha() {
    	Hole hole = new Hole();
    	boolean result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getClass().equals((new Kalaha()).getClass());
    	Assert.assertTrue(result);
    }
    
    @Test
    public void testIf15thBoxIs1stBox() {
    	Hole hole = new Hole();
    	boolean result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef() == hole;
    	Assert.assertTrue(result);
    }
    
    @Test
    public void testIfKalahaHas0StonesAtStart() {
    	Hole hole = new Hole();
    	int result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getNumberOfStones();
    	Assert.assertEquals(result, 0);
    }
    
    @Test
    public void testIf1stHoleHasPlayer1() {
    	Hole hole = new Hole();
    	String result = hole.getPlayer().getName();
    	Assert.assertEquals(result,  "player 1");
    }
    
    @Test
    public void testIf1stKalahaHasPlayer1() {
    	Hole hole = new Hole();
    	String result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getPlayer().getName();
    	Assert.assertEquals(result,  "player 1");
    }
    
    @Test
    public void testIf8thBoxHasPlayer2() {
    	Hole hole = new Hole();
    	String result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getPlayer().getName();
    	Assert.assertEquals(result,  "player 2");
    }
    
    @Test
    public void testIf1stKalahaHas1StoneAfterMoveIfStartsWith6Stones() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(6);
    	hole.move();
    	int result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getNumberOfStones();
    	Assert.assertEquals(result, 1);
    }
    
    @Test
    public void testIf8thBoxHas5StonesAfterMoveIfStartsWith7Stones() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(7);
    	hole.move();
    	int result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getNumberOfStones();
    	Assert.assertEquals(result, 5);
    }
    
    @Test
    public void testIf2ndKalahaHas0StonesAfterMoveIfStartsWith13Stones() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(13);
    	hole.move();
    	int result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getNumberOfStones();
    	Assert.assertEquals(result, 0);
    }
    
    @Test
    public void testIfItsTheTurnOfPlayer2AfterMove() {
    	Hole hole = new Hole();
    	hole.move();
    	Player result = hole.getPlayer().getCurentPlayer();
    	Player expected = hole.getPlayer().getOpponent();
    	Assert.assertEquals(expected, result);
    }
    
    @Test
    public void testIfItsTheTurnOfPlayer2AfterMoveInPlayer2() {
    	Hole hole = new Hole();
    	hole.move();
    	Player result = hole.getPlayer().getOpponent().getCurentPlayer();
    	Player expected = hole.getPlayer().getOpponent();
    	Assert.assertEquals(expected, result);
    }
    
    @Test
    public void testIfItsTheTurnOfPlayer1AfterMoveEndsOnKalaha() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(6);
    	hole.move();
    	Player result = hole.getPlayer().getCurentPlayer();
    	Player expected = hole.getPlayer();
    	Assert.assertEquals(expected, result); 
    }
    
    @Test
    public void testIfItsTheTurnOfPlayer1AfterMoveEndsOnKalahaInPlayer2() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(6);
    	hole.move();
    	Player result = hole.getPlayer().getOpponent().getCurentPlayer();
    	Player expected = hole.getPlayer();
    	Assert.assertEquals(expected, result); 
    }
    
    @Test
    public void testIfHoleIsEmptyIfMoveEndsOnEmptyHole() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(1);
    	hole.getBoxRef().setNumberOfStones(0);
    	hole.move();
    	int result = hole.getBoxRef().getNumberOfStones();
    	Assert.assertEquals(0,  result);
    }
    
    @Test
    public void testIfKalahaHas5StonesAfterAHit() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(1);
    	hole.getBoxRef().setNumberOfStones(0);
    	hole.move();
    	int result = hole.getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getBoxRef().getNumberOfStones();
    	Assert.assertEquals(5, result);
    }
    
    @Test
    public void testIf6thNeighbourIsKalaha() {
    	Hole hole = new Hole();
    	Box result = hole.getXthNeighbour(6);
    	Box expected = new Kalaha();
    	Assert.assertEquals(expected.getClass(), result.getClass());
    }
    
    @Test
    public void testIfGetOpposingHoleGivesOpposingHole() {
    	Hole hole = new Hole();
    	Box result = hole.getOpposingBox();
    	Box expected = hole.getXthNeighbour(12);
    	Assert.assertEquals(expected, result);
    }
    
    @Test
    public void testIfOpposingHoleIsEmptyAfterHit() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(1);
    	hole.getBoxRef().setNumberOfStones(0);
    	hole.move();
    	int result = hole.getBoxRef().getOpposingBox().getNumberOfStones();
    	Assert.assertEquals(0, result);
    }
    
    @Test
    public void testIfHitWorksOn3rdHoleInKalaha() {
    	Hole hole = new Hole();
    	hole.getBoxRef().setNumberOfStones(1);
    	hole.getXthNeighbour(2).setNumberOfStones(0);
    	hole.getBoxRef().move();
    	int result = hole.getXthNeighbour(6).getNumberOfStones();
    	Assert.assertEquals(5, result);
    }
    
    @Test
    public void testIfHitWorksOn3rdHoleInOpposingHole() {
    	Hole hole = new Hole();
    	hole.getBoxRef().setNumberOfStones(1);
    	hole.getXthNeighbour(2).setNumberOfStones(0);
    	hole.getBoxRef().move();
    	int result = hole.getXthNeighbour(2).getOpposingBox().getNumberOfStones();
    	Assert.assertEquals(0, result);
    }
    
    @Test
    public void testIfNoHitOccursInOpposingHoles() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(7);
    	hole.getXthNeighbour(7).setNumberOfStones(0);
    	hole.move();
    	int result = hole.getXthNeighbour(5).getNumberOfStones();
    	Assert.assertEquals(5, result);
    }
    
    @Test
    public void testIfGameEndWorksCorrectlyOnPlayer1Side() {
    	Hole hole = new Hole();
    	for (int i = 0; i < 6; i++) {
    		hole.getXthNeighbour(i).setNumberOfStones(0);
    	}
    	boolean result = hole.checkIfGameEnds();
    	Assert.assertTrue(result);
    }
    
    @Test
    public void testIfGameDoesntEndNormaly() {
    	Hole hole = new Hole();
    	boolean result = hole.checkIfGameEnds();
    	Assert.assertFalse(result);
    }
    
    @Test
    public void testIfGameEndWorksCorrectlyOnPlayer2Side() {
    	Hole hole = new Hole();
    	for (int i = 7; i < 13; i++) {
    		hole.getXthNeighbour(i).setNumberOfStones(0);
    	}
    	boolean result = hole.checkIfGameEnds();
    	Assert.assertTrue(result);
    }
    
    @Test
    public void testScoreCalculationForGameEndOnPlayer1Side() {
    	Hole hole = new Hole();
    	for (int i = 0; i < 6; i++) {
    		hole.getXthNeighbour(i).setNumberOfStones(0);
    	}
    	hole.getXthNeighbour(6).setNumberOfStones(24);
    	int result = hole.getPlayer().getScoreOfPlayer1AfterGameEnds();
    	Assert.assertEquals(24, result);
    }
    
    @Test
    public void testScoreCalculationForGameEndOnPlayer2Side() {
    	Hole hole = new Hole();
    	for (int i = 7; i < 13; i++) {
    		hole.getXthNeighbour(i).setNumberOfStones(0);
    	}
    	hole.getXthNeighbour(13).setNumberOfStones(24);
    	int result = hole.getPlayer().getScoreOfPlayer1AfterGameEnds();
    	Assert.assertEquals(24, result);
    }
    
    @Test
    public void testIfMoveFailsIfUsedOnAHoleNotOfTheCurrentPlayer() {
    	Hole hole = new Hole();
    	hole.getXthNeighbour(7).move();
    	int result = hole.getXthNeighbour(7).getNumberOfStones();
    	Assert.assertEquals(4, result);
    }
    
    @Test
    public void testIfHoleContainsOneStoneAfterMoveWith14Stones() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(14);
    	hole.move();
    	int result = hole.getNumberOfStones();
    	Assert.assertEquals(1, result);
    }
    
    @Test
    public void testWinnerForGameEndOnPlayer1Side() {
    	Hole hole = new Hole();
    	for (int i = 0; i < 6; i++) {
    		hole.getXthNeighbour(i).setNumberOfStones(0);
    	}
    	hole.getXthNeighbour(6).setNumberOfStones(24);
    	String result = hole.getPlayer().getWinner();
    	Assert.assertEquals("draw", result);
    }
    
    @Test
    public void testIfMoveOnHoleWith0StonesDoesntAddAStoneToTheNextHole() {
    	Hole hole = new Hole();
    	hole.setNumberOfStones(0);
    	hole.move();
    	int result = hole.getBoxRef().getNumberOfStones();
    	Assert.assertEquals(4, result);
    }
}
