package edu.vt.cs5044;

import edu.vt.cs5044.tetris.Shape;

import edu.vt.cs5044.tetris.AI;

import edu.vt.cs5044.tetris.Board;

import edu.vt.cs5044.tetris.Placement;

import edu.vt.cs5044.tetris.Rotation;

/**
 * 
 * Program implements Artificial Intelligence Interface. The purpose of this
 * project is to learn about interface. This program will be tested in JUnit and
 * the tetris window also open to play and test the program. It calculates
 * weight cost measure by adding the sum of weight multiplication total gaps
 * count, total block count, column height variability count, and maximum block
 * height count. It calculates the lowest cost among the column with different
 * shapes and place the shape in lowest cost column. purpose, what abstraction
 * it represents, and how to use it.
 * 
 * @author Jeevan Thapa
 * 
 * 
 * @version Oct 8, 2017
 * 
 */

public class TetrisAI

		implements AI

{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Placement findBestPlacement(Board currentBoard, Shape shape) {
		int bestCost = Integer.MAX_VALUE;
		Placement bestPlacement = null;
		for (Rotation rotShape : shape.getRotationSet()) {
			for (int col = 0; col <= Board.WIDTH - shape.getWidth(rotShape); col++) {
				Placement trialPlacement = new Placement(rotShape, col);
				Board resultBoard = currentBoard.getResultBoard(shape, trialPlacement);
				int totalCost = getTotalWeightedCost(resultBoard);
				if (totalCost < bestCost) {
					bestCost = totalCost;
					bestPlacement = trialPlacement;
				}
			}
		}
		return bestPlacement;
	}

	/**
	 * {@inheritDoc}
	 * 
	 */
	@Override
	public int getColumnHeightVariability(Board board) {
		int columnHeightVar = 0;
		for (int col = 0; col < Board.WIDTH - 1; col++) {
			int colHeightDiff = Math.abs(getHeightAtColumn(board, col) - getHeightAtColumn(board, col + 1));
			columnHeightVar = columnHeightVar + colHeightDiff;
		}
		return columnHeightVar;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getMaximumBlockHeight(Board board) {
		int tempHeight = Integer.MIN_VALUE;
		for (int col = 0; col < Board.WIDTH; col++) {
			int colHeight = getHeightAtColumn(board, col);
			if (colHeight > tempHeight) {
				tempHeight = colHeight;
			}
		}
		return tempHeight;
	}

	/**
	 * It gives the tallest height of a block at certain row and column
	 * 
	 * @param board
	 *            this is the board that's passed
	 * @param col
	 *            this is the column in a board
	 * @return the tallestPiece
	 */
	public int getHeightAtColumn(Board board, int col) {
		int tallestPiece = 0;
		for (int row = 0; row < Board.HEIGHT; row++) {
			if (board.isBlockAt(col, row)) {
				tallestPiece = row + 1;
			}
		}
		return tallestPiece;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getTotalBlockCount(Board board) {
		int totalNumofBlocks = 0;
		for (int col = 0; col < Board.WIDTH; col++) {
			for (int row = 0; row < Board.HEIGHT; row++) {
				if (board.isBlockAt(col, row)) {
					totalNumofBlocks++;
				}
			}
		}
		return totalNumofBlocks;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public int getTotalGapCount(Board board) {
		int count = 0;
		for (int col = 0; col < Board.WIDTH; col++) {
			boolean hasBlock = false;
			for (int row = Board.HEIGHT - 1; row >= 0; row--) {
				if (board.isBlockAt(col, row)) {
					hasBlock = true;
				} else if (hasBlock) {
					count++;
				}
			}
		}
		return count;
	}

	/**
	 * Cost value will give us a idea about a move. The lower the cost value the
	 * better the move is.
	 * 
	 * @param board
	 *            this is the board that's passed
	 * @return the overallCost
	 */
	public int getTotalWeightedCost(Board board) {
		int totalBlock = 0 * getTotalBlockCount(board);
		int colHeightVar = 5 * getColumnHeightVariability(board);
		int maxBlockHeight = 10 * getMaximumBlockHeight(board);
		int totalGap = 15 * getTotalGapCount(board);
		int overallCost = totalBlock + colHeightVar + maxBlockHeight + totalGap;
		return overallCost;
	}

}