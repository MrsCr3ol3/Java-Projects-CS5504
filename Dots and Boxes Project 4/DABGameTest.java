  
 package edu.vt.cs5044;
  
 import static org.junit.Assert.*;
  
 import java.util.Map;
  
 import org.junit.Before;
  
 import org.junit.Test;
  
 /**
  
  * This class will test the Dots and Boxes engine. It will test the methods used to manage a
  
  * two-player game of Dots And Boxes. The game is played on a matrix pattern of dots, with each dot
  
  * representing one vertex of a grid of neighboring, non-overlapping boxes. Each turn involves the
  
  * current player drawing a single line to connect any two unconnected adjacent dots, either
  
  * horizontally or vertically. Except on the outer-most grid boundaries, each line is shared between
  
  * two neighboring boxes. Players alternate the game; however if a Player completes a box then the
  
  * player who owns a box will get another turn immediately. If no box is completed then the turn
  
  * goes to the another player. The player who owns most boxes will get higher score and wins the
  
  * game.
  
  * 
  
  * @author Jeevan Thapa
  
  * @version Oct 21, 2017
  
  */
  
 @SuppressWarnings("javadoc")
  
 public class DABGameTest 
 {
 private DotsAndBoxes dab;
 /**
  * Setting a new Dots and Boxes game.
  * 
  * @throws java.lang.Exception
  */
 @Before
 public void setUp()
     throws Exception
 {
     dab = new DABGame();// new game
 }
 
 /*
  * Test the size of the box grid to be at least 2*2. It throws an exception if it fails
  */
 @Test
 public void testGetSizeTryCatch()
 {
     try
     {
         dab.getSize();
         fail("getSize() did not throw expected Exception");
     }
     catch (GameException ge)
     {
         assertEquals(null, ge.getMessage());
     }
 }
 
 /*
  * Test the size of the box grid to be at least 5*5 after initialization.
  */
 @Test
 public void testSizeAfterInit()
 {
     dab.init(5);// action
     assertEquals(5, dab.getSize());
 }
 
 /*
  * Test the invalid size and capture the expected game exception.
  */
 @Test(expected = GameException.class)
 public void testInvalidSize()
 {
     dab.init(1);// action
 }
 
 /*
  * Initialize the board and draw edge at the null direction and capture the exception.
  */
 @Test(expected = GameException.class)
 public void testDrawEdgeDirectionNull()
 {
     dab.init(2);// action
     assertNull(dab.drawEdge(new Coordinate(0, 0), null));// assert null
 }
 
 /*
  * Test weather the box has an edge or not at a given direction.
  */
 @Test
 public void testBoxHasEdgeOrNotAtGivenDirection()
 {
     dab.init(2);// action
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.EAST)); //setup
     assertFalse(dab.drawEdge(new Coordinate(0, 0), Direction.EAST)); //action
 }
 
 /*
  * Test the first edge in the board.
  */
 @Test
 public void testDrawFirstEdge()
 {
     dab.init(3);// action
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.EAST));
     assertFalse(dab.drawEdge(new Coordinate(0, 0), Direction.EAST));// edge already drawn
     assertEquals(1, dab.getDrawnEdgesAt(new Coordinate(0, 0)).size());
     assertTrue(dab.getDrawnEdgesAt(new Coordinate(0, 0)).contains(Direction.EAST));
     assertEquals(1, dab.getDrawnEdgesAt(new Coordinate(1, 0)).size());// size
     assertTrue(dab.getDrawnEdgesAt(new Coordinate(1, 0)).contains(Direction.WEST));
     assertTrue(
         dab.getDrawnEdgesAt(new Coordinate(0, 0).getNeighbor(Direction.EAST))
             .contains(Direction.WEST));
 }
 
 /*
  * Test the first edge and draw the same edge again at the same coordinate.
  */
 @Test
 public void testDrawFirstEdgeAgain()
 {
     dab.init(2);// action
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.EAST));// setup
     assertFalse(dab.drawEdge(new Coordinate(0, 0), Direction.EAST));// action
     assertEquals(1, dab.getDrawnEdgesAt(new Coordinate(0, 0)).size());// action
     assertTrue(dab.getDrawnEdgesAt(new Coordinate(0, 0)).contains(Direction.EAST));
     assertEquals(1, dab.getDrawnEdgesAt(new Coordinate(1, 0)).size());// action
     assertTrue(dab.getDrawnEdgesAt(new Coordinate(1, 0)).contains(Direction.WEST));
 }
 
 /*
  * Test the first edge and draw the same edge again at the same coordinate but from the
  * neighbor. The neighbor of East of (0, 0) coordinate must be West of coordinate (1, 0)
  */
 @Test
 public void testDrawFirstEdgeAgainFromNeighbor()
 {
     dab.init(2);// action
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.EAST));// setup
     assertFalse(dab.drawEdge(new Coordinate(1, 0), Direction.WEST));// action
     assertEquals(1, dab.getDrawnEdgesAt(new Coordinate(0, 0)).size());// action
     assertTrue(dab.getDrawnEdgesAt(new Coordinate(0, 0)).contains(Direction.EAST));
     assertEquals(1, dab.getDrawnEdgesAt(new Coordinate(1, 0)).size());// action
     assertTrue(dab.getDrawnEdgesAt(new Coordinate(1, 0)).contains(Direction.WEST));
 }
 
 /*
  * Test the first completed box, this time it is completed from the neighbor box.
  */
 @Test
 public void testCompletedFirstBoxFromNeighbor()
 {
     dab.init(2);// action
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.WEST));// p1
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.SOUTH));// p2
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.NORTH));// p1
     assertEquals(Player.TWO, dab.getCurrentPlayer());// p2
     assertTrue(dab.drawEdge(new Coordinate(1, 0), Direction.WEST));// p2
     assertEquals(4, dab.getDrawnEdgesAt(new Coordinate(0, 0)).size());// size 4
     assertEquals(Player.TWO, dab.getOwnerAt(new Coordinate(0, 0)));// action
 }
 
 /*
  * Test the first completed box, this time it is completed from the neighbor box, and score is
  * noted.
  */
 @Test
 public void testCompletedFirstBoxFromNeighborGetScore()
 {
     dab.init(2);// action
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.WEST));// p1
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.SOUTH));// p2
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.NORTH));// p1
     assertEquals(Player.TWO, dab.getCurrentPlayer());// p2
     assertTrue(dab.drawEdge(new Coordinate(1, 0), Direction.WEST));// p2
     assertEquals(4, dab.getDrawnEdgesAt(new Coordinate(0, 0)).size());// size 4
     assertEquals(Player.TWO, dab.getOwnerAt(new Coordinate(0, 0)));// action
     assertEquals(Player.TWO, dab.getCurrentPlayer());
     Map<Player, Integer> scoreMap = dab.getScores();
     assertEquals(0, (int)scoreMap.get(Player.ONE));
     assertEquals(1, (int)scoreMap.get(Player.TWO));
 }
 
 /*
  * Test the owner of the box at the particular box.
  */
 @Test
 public void testGetOwnerAtParticularBox()
 {
     dab.init(3);// action
     assertEquals(Player.ONE, dab.getCurrentPlayer());
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.EAST));// p1
     assertEquals(Player.TWO, dab.getCurrentPlayer());
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.WEST));// p2
     assertEquals(Player.ONE, dab.getCurrentPlayer());
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.NORTH));// p1
     assertEquals(Player.TWO, dab.getCurrentPlayer());
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.SOUTH));// p2
     assertEquals(4, dab.getDrawnEdgesAt(new Coordinate(0, 0)).size());
     assertEquals(Player.TWO, dab.getOwnerAt(new Coordinate(0, 0)));
     assertEquals(Player.TWO, dab.getCurrentPlayer());
 }
 
 /*
  * Test the full game engine at 2 by 2 grid size in total of four boxes. Observed the score and
  * noticed the winner.
  */
 @Test
 public void testScoreAtTwoByTwoGrid()
 {
     dab.init(2);// action
     assertEquals(Player.ONE, dab.getCurrentPlayer());
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.EAST));// p1
     assertEquals(Player.TWO, dab.getCurrentPlayer());
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.WEST));// p2
     assertEquals(Player.ONE, dab.getCurrentPlayer());
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.NORTH));// p1
     assertEquals(Player.TWO, dab.getCurrentPlayer());
     assertTrue(dab.drawEdge(new Coordinate(0, 0), Direction.SOUTH));// p2
     assertEquals(4, dab.getDrawnEdgesAt(new Coordinate(0, 0)).size());// 4
     assertEquals(Player.TWO, dab.getOwnerAt(new Coordinate(0, 0)));// p2 owns it
     assertEquals(Player.TWO, dab.getCurrentPlayer());// p2
     assertTrue(dab.drawEdge(new Coordinate(1, 0), Direction.EAST));// p2
     assertEquals(Player.ONE, dab.getCurrentPlayer());
     assertFalse(dab.drawEdge(new Coordinate(1, 0), Direction.WEST));// already drawn by neighbor
     assertEquals(Player.ONE, dab.getCurrentPlayer());
     assertTrue(dab.drawEdge(new Coordinate(1, 0), Direction.NORTH));// p1
     assertEquals(Player.TWO, dab.getCurrentPlayer());
     assertTrue(dab.drawEdge(new Coordinate(1, 0), Direction.SOUTH));// p2
     assertEquals(4, dab.getDrawnEdgesAt(new Coordinate(1, 0)).size());
     assertEquals(Player.TWO, dab.getOwnerAt(new Coordinate(1, 0)));// p2 owns it
     assertEquals(Player.TWO, dab.getCurrentPlayer());
     assertTrue(dab.drawEdge(new Coordinate(0, 1), Direction.EAST));// p2
     assertEquals(Player.ONE, dab.getCurrentPlayer());// p1
     assertTrue(dab.drawEdge(new Coordinate(0, 1), Direction.SOUTH));// p1
     assertEquals(Player.TWO, dab.getCurrentPlayer());// p2
     assertTrue(dab.drawEdge(new Coordinate(0, 1), Direction.WEST));// p2
     assertEquals(Player.TWO, dab.getOwnerAt(new Coordinate(0, 1)));// p2 owns it
     assertEquals(Player.TWO, dab.getCurrentPlayer());// p2
     assertTrue(dab.drawEdge(new Coordinate(1, 1), Direction.SOUTH));// p2
     assertEquals(Player.ONE, dab.getCurrentPlayer());// p1
     assertTrue(dab.drawEdge(new Coordinate(1, 1), Direction.EAST));// p1
     assertEquals(Player.ONE, dab.getOwnerAt(new Coordinate(1, 1)));// p1 owns it
     Map<Player, Integer> scoreMap = dab.getScores();// action
     assertEquals(1, (int)scoreMap.get(Player.ONE));// score p1 = 1
     assertEquals(3, (int)scoreMap.get(Player.TWO));// score p2 = 3
     assertNull(dab.getCurrentPlayer());// game over current player is null
 }
  
 }