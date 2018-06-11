package edu.vt.cs5044;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * This class implements the DotsAndBoxes Interface. It defines the methods
 * needed to manage a two-player game of Dots And Boxes. The game is played on a
 * matrix pattern of dots, with each dot representing one vertex of a grid of
 * neighboring, non-overlapping boxes. Each turn involves the current player
 * drawing a single line to connect any two unconnected adjacent dots, either
 * horizontally or vertically. Except on the outer-most grid boundaries, each
 * line is shared between two neighboring boxes. Players alternate the game;
 * however if a Player completes a box then the player who owns a box will get
 * another turn immediately. If no box is completed then the turn goes to the
 * another player. The player who owns most boxes will get higher score and wins
 * the game.
 * 
 * @author Jeevan Thapa
 * @version Oct 21, 2017
 */

public class DABGame implements DotsAndBoxes {
	private Map<Coordinate, Box> boxGrid;
	private Player currentPlayer;
	private int gridSize;

	/**
	 * Initially there are no current players and no box grid. The size of the grid
	 * is a random negative number to test the size is at least 2 by 2.
	 */
	public DABGame() {
		boxGrid = null;
		gridSize = -1;
		currentPlayer = null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void init(int size) {
		if (size < 2) {
			throw new GameException();
		}
		gridSize = size;
		currentPlayer = Player.ONE;
		boxGrid = new HashMap<>();
		for (int x = 0; x < gridSize; x++) {
			for (int y = 0; y < gridSize; y++) {
				Coordinate xy = new Coordinate(x, y);
				Box bx = new Box();
				boxGrid.put(xy, bx);
			}
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean drawEdge(Coordinate xyAxis, Direction dir) {
		checkInit();
		if (dir == null) {
			throw new GameException();
		}
		Box box = findBox(xyAxis);
		boolean boxCompleted = false;
		boolean neighborCompleted = false;
		if (box.hasEdge(dir)) {
			return false;
		}
		box.addEdge(dir, currentPlayer);
		if (box.getOwner() != null) {
			boxCompleted = true;
		}
		try {
			Box neighbor = findBox(xyAxis.getNeighbor(dir));
			neighbor.addEdge(dir.getOpposite(), currentPlayer);
			if (neighbor.getOwner() != null) {
				neighborCompleted = true;
			}
		} catch (GameException ge) {
			// do nothing; we just needed to skip this section if there's no neighbor
		}
		if (!boxCompleted && !neighborCompleted) {
			currentPlayer = currentPlayer.getOpponent();
		}
		return true;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Player getCurrentPlayer() {
		checkInit();
		Map<Player, Integer> scoreSheetMap = getScores();
		int sum = 0;
		for (int score : scoreSheetMap.values()) {
			sum += score;
		}
		if (sum == boxGrid.size()) {
			currentPlayer = null;
		}
		return currentPlayer;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<Direction> getDrawnEdgesAt(Coordinate coord) {
		checkInit();
		findBox(coord);
		Box box = findBox(coord);
		return box.getDrawnEdges();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Player getOwnerAt(Coordinate coord) {
		checkInit();
		Box box = findBox(coord);
		return box.getOwner();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<Player, Integer> getScores() {
		checkInit();
		int scoreP1 = 0;
		int scoreP2 = 0;
		for (Box boxValue : boxGrid.values()) {
			if (boxValue.getOwner() == Player.ONE) {
				scoreP1++;
			} else if (boxValue.getOwner() == Player.TWO) {
				scoreP2++;
			}
		}
		Map<Player, Integer> scoreMap = new HashMap<>();
		scoreMap.put(Player.ONE, scoreP1);
		scoreMap.put(Player.TWO, scoreP2);
		return scoreMap;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getSize() {
		checkInit();
		return gridSize;
	}

	/**
	 * This method throws a game exception - if the grid was never initialized.
	 */
	private void checkInit() {
		if (gridSize < 0) {
			throw new GameException();
		}
	}

	/**
	 * It will find the box at the specified coordinate. It will throw a game
	 * excetion if there is no box at the specified coordinate
	 * 
	 * @param coord
	 *            this is the coordinate that's passed
	 * @return the box at the specified coordinate
	 */
	private Box findBox(Coordinate coord) {
		Box box = boxGrid.get(coord); // fetch; will be null if no such Coordinate in grid
		if (box == null) {
			throw new GameException();
		}
		return box;
	}
}