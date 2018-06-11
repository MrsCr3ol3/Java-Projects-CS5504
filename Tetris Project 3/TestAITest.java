package edu.vt.cs5044;
  
 import org.junit.Before;
 
 import org.junit.Test;
 
 import edu.vt.cs5044.tetris.AI;
  
 import edu.vt.cs5044.tetris.Board;
 
 import edu.vt.cs5044.tetris.Placement;
  
 import edu.vt.cs5044.tetris.Rotation;
  
 import edu.vt.cs5044.tetris.Shape;
  
 import static org.junit.Assert.*;
 
  
  
 // CHECKSTYLE:OFF
  
 /**
  
  * Program implements Artificial Intelligence Interface. THe purpose of this project is to learn
  
  * about interface. This program will be tested in JUnit and the tetris window also open to play and
  
  * test the program. It verifies all the methods in TetrisAI are working correctly.
  
  * 
  
  * @author Jeevan Thapa
  
  * @version Oct 8, 2017
 
  
  */
  
 @SuppressWarnings("javadoc")
  
 public class TetrisAITest
  
 {
 private AI    brain;                                    // use the interface type here
 private Board emptyBoard;
 private Board firstTestBoard;
 private Board secondTestBoard;
 private Board testPlaceIShape;
 private Board testPlaceTShape;
 private Board testPlaceOShape;
 private Board testPlaceZShape;
 private Board testPlaceShape;
 @Before
 public void setup()
 {
     brain = new TetrisAI(); // instantiate your implementation
     emptyBoard = new Board();// empty Board
     firstTestBoard =
         new Board(
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "  #       ",
             "  #       ",
             "  #       ",
             "  #       ",
             "  #       ",
             "  #       ",
             " ##   #   ",
             "# #   #   ",
             "# ### #   ",
             "# ##  #   ",
             "##########");
			 
     secondTestBoard =
         new Board(
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "  #       ",
             "  #    ## ",
             "  #    ## ",
             "  #    ## ",
             "  #   ####",
             "  ##  ####",
             " ###  ####",
             "# ##  ####",
             "# ### ####",
             "# ##  ####",
             "## #######");
			 
     testPlaceIShape =
         new Board(
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "##### ####",
             "# ### ####",
             "# ### ####",
             "##### ####");
			 
     testPlaceTShape =
         new Board(
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "#      ###",
             "#       ##",
             "# ##   ###",
             "##### ####");
			 
     testPlaceOShape =
         new Board(
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "  #       ",
             "  #       ",
             "  #       ",
             "  #       ",
             "  #       ",
             "  #       ",
             " ##   #   ",
             "# #   #   ",
             "# ##  #   ",
             "# ##  #   ",
             "##########");
			 
     testPlaceZShape =
         new Board(
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "      #   ",
             "      #   ",
             "      ##  ",
             "      ####",
             "##########");
			 
     testPlaceShape =
         new Board(
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "          ",
             "      #   ",
             "      #   ",
             "      ##  ",
             "   #######",
             "  ########");
 }
 /*
  * Test Total block Count of Empty Board
  */
 @Test
 public void testEmptyBoardTBC()
 {
     assertEquals(0, brain.getTotalBlockCount(emptyBoard)); // assert the tbc
 }
 /*
  * Test Total block Count of First Test Board
  */
  
 @Test
 public void testFirstTestBoardTBC()
 {
     assertEquals(31, brain.getTotalBlockCount(firstTestBoard)); // assert tbc
 }
 /*
  * Test maximum Block height of the first test board
  */
  
 @Test
 public void testFirstTestBoardMaxHeight()
 {
     assertEquals(11, brain.getMaximumBlockHeight(firstTestBoard)); // assert MBH
 }
 /*
  * Test maximum Column Height Variability which is the sum of absolute value difference of
  * adjacent columns
  */
  
 @Test
 public void testFirstTestColHeightVar()
 {
     assertEquals(25, brain.getColumnHeightVariability(firstTestBoard));// assert CHV
 }
 /*
  * Test Total Gap count of first test board. Gap is defined as the number of spaces when there
  * is a block above the spaces
  */
  
 @Test
 public void testFirstTestBoardTotalGapCount()
 {
     assertEquals(4, brain.getTotalGapCount(firstTestBoard));// assertTGC
 }
 /*
  * Test Total Gap count of second test board. Gap is defined as the number of spaces when there
  * is a block above the spaces
  */
  
 @Test
 public void testSecondTestBoardTotalGapCount()
 {
     assertEquals(5, brain.getTotalGapCount(secondTestBoard)); // assertTGC
 }
 /*
  * Test Total block Count of Second Test Board
  */
  
 @Test
 public void testSecondTestBoardTotalBlockCount()
 {
     assertEquals(59, brain.getTotalBlockCount(secondTestBoard)); // assert TBC
 }
 /*
  * Test maximum Column Height Variability which is the sum of absolute value difference of
  * adjacent columns
  */
  
 @Test
 public void testSecondTestBoardTotalColHeightVarCount()
 {
     assertEquals(29, brain.getColumnHeightVariability(secondTestBoard)); // assert CHV
 }
 /*
  * Test maximum Block height of the second test board
  */
  
 @Test
 public void testSecondTestBoardMaxHeightCount()
 {
     assertEquals(11, brain.getMaximumBlockHeight(secondTestBoard)); // assert MBH
 }
 
 /*
  * Test maximum Block height of the first test board (MBH)
  */
 @Test
 public void testPlaceBestIShapePositionMaxBlockHeightCount()
 {
     assertEquals(4, brain.getMaximumBlockHeight(testPlaceIShape));// assert MBH
 }
 /*
  * Test Total block Count of I Shape Position
  */
  
 @Test
 public void testPlaceBestIShapePositionTotalBlockCount()
 {
     assertEquals(34, brain.getTotalBlockCount(testPlaceIShape)); // assert TBC
 }
 
 /*
  * Test Column height Variability of I Shape Position
  */
  
 @Test
 public void testPlaceBestIShapePositionColHeightVarCount()
 {
     assertEquals(8, brain.getColumnHeightVariability(testPlaceIShape));// assert CHV
 }
 
 /*
  * Test Total Gap Count of I Shape Position
  */
  
 @Test
 public void testPlaceBestIShapePositionTGCCount()
 {
     assertEquals(2, brain.getTotalGapCount(testPlaceIShape));// assert TGC
 }
 
 /*
  * Test Best position for I shape in a board
  */
  
 @Test
 public void testPlaceBestIShapePosition()
 {
     Placement bestPlace = brain.findBestPlacement(testPlaceIShape, Shape.I); // action
     assertEquals(new Placement(Rotation.NONE, 5), bestPlace); // assert the placement
     assertEquals(5, bestPlace.getColumn()); // placement details
     assertEquals(Rotation.NONE, bestPlace.getRotation()); // rotation check
 }
 
 /*
  * Test Best position for T shape in a board
  */
  
 @Test
 public void testPlaceBestTShapePosition()
 {
     Placement bestPlace = brain.findBestPlacement(testPlaceIShape, Shape.T); // action
     assertEquals(new Placement(Rotation.CCW_180, 4), bestPlace); // assert the placement
 }
 
 /*
  * Test Maximium Block Height for T shape in a board
  */
  
 @Test
 public void testPlaceBestTShapePositionMaxBlockHeightCount()
 {
     assertEquals(4, brain.getMaximumBlockHeight(testPlaceTShape)); // assert MBH
 }
 
 /*
  * Test Total Block Count for T shape in a board
  */
  
 @Test
 public void testPlaceBestTShapePositionTotalBlockCount()
 {
     assertEquals(22, brain.getTotalBlockCount(testPlaceTShape)); // assert TBC
 }
 
 /*
  * Test Total Column height Var for T shape in a board
  */
  
 @Test
 public void testPlaceBestTShapePositionColHeightVarCount()
 {
     assertEquals(10, brain.getColumnHeightVariability(testPlaceTShape)); // assert CHV
 }
 
 /*
  * Test Total gap count for T shape in a board
  */
  
 @Test
 public void testPlaceBestTShapePositionTGCCount()
 {
     assertEquals(1, brain.getTotalGapCount(testPlaceTShape)); // assert TGC
 }
 
 /*
  * Test Best position for O shape in a board
  */
  
 @Test
 public void testPlaceBestOShapePosition()
 {
     Placement bestPlace = brain.findBestPlacement(testPlaceOShape, Shape.O); // action
     assertEquals(new Placement(Rotation.NONE, 4), bestPlace); // assert the placement
 }
 
 /*
  * Test Maximum block height for O shape board
  */
  
 @Test
 public void testPlaceBestOShapePositionMaxBlockHeightCount()
 {
     assertEquals(11, brain.getMaximumBlockHeight(testPlaceOShape));// assert MBH
 }
 
 /*
  * Test total block count for O shape board
  */
  
 @Test
 public void testPlaceBestOShapePositionTotalBlockCount()
 {
     assertEquals(30, brain.getTotalBlockCount(testPlaceOShape)); // assert TBC
 }
 
 /*
  * Test Maximum Column Height Variability for O shape board
  */
  
 @Test
 public void testPlaceBestOShapePositionColHeightVarCount()
 {
     assertEquals(25, brain.getColumnHeightVariability(testPlaceOShape)); // assert CHV
 }
 
 /*
  * Test Maximum Total gap count for O shape board
  */
  
 @Test
 public void testPlaceBestOShapePositionTGCCount()
 {
     assertEquals(3, brain.getTotalGapCount(testPlaceOShape));// assert TGC
 }
 
 /*
  * Test best position for Z shape in a board
  */
  
 @Test
 public void testPlaceBestZShapePosition()
 {
     Placement bestPlace = brain.findBestPlacement(testPlaceZShape, Shape.Z); // action
     assertEquals(new Placement(Rotation.NONE, 7), bestPlace); // assert the placement
 }
 
 /*
  * Test maximum block height for Z shape in a board
  */
  
 @Test
 public void testPlaceBestZShapePositionMaxBlockHeightCount()
 {
     assertEquals(5, brain.getMaximumBlockHeight(testPlaceZShape)); // assert MBH
 }
 
 /*
  * Test total block count for Z shape in a board
  */
  
 @Test
 public void testPlaceBestZShapePositionTotalBlockCount()
 {
     assertEquals(18, brain.getTotalBlockCount(testPlaceZShape)); // assert TBC
 }
 
 /*
  * Test column height var for Z shape in a board
  */
  
 @Test
 public void testPlaceBestZShapePositionColHeightVarCount()
 {
     assertEquals(7, brain.getColumnHeightVariability(testPlaceZShape)); // assert CHV
 }
 
 /*
  * Test total Gap count for Z shape in a board
  */
 @Test
 public void testPlaceBestZShapePositionTGCCount()
 {
     assertEquals(0, brain.getTotalGapCount(testPlaceZShape)); // assert TGC
 }
 
 /*
  * Test best position for the S shape in a board
  */
  
 @Test
 public void testPlaceBestShapePosition()
 {
     Placement bestPlace = brain.findBestPlacement(testPlaceShape, Shape.S); // action
     assertEquals(new Placement(Rotation.NONE, 0), bestPlace); // assert the placement
 }
 
 /*
  * Test maximum block height for S shape board
  */
  
 @Test
 public void testPlaceBestShapePositionMaxBlockHeightCount()
 {
     assertEquals(5, brain.getMaximumBlockHeight(testPlaceShape)); // assert MBH
 }
 
 /*
  * Test total block count for S shape board
  */
  
 @Test
 public void testPlaceBestShapePositionTotalBlockCount()
 {
     assertEquals(19, brain.getTotalBlockCount(testPlaceShape)); // assert TBC
 }
 
 /*
  * Test Column Height Variability for S shape board
  */
  
 @Test
 public void testPlaceBestShapePositionColHeightVarCount()
 {
     assertEquals(8, brain.getColumnHeightVariability(testPlaceShape)); // assert CHV
 }
 
 /*
  * Test total gap count for S shape board
  */
 @Test
 public void testPlaceBestShapePositionTGCCount()
 {
     assertEquals(0, brain.getTotalGapCount(testPlaceShape)); // assert TGC
 }
  
 }