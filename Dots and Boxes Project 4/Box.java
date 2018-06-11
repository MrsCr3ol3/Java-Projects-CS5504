package edu.vt.cs5044;

import java.util.Collection;
import java.util.HashSet;

/**
 * 
 * 
 * This helper class is created to facilitate the calculation in DABGame class.
 * The Box Object will be used as a HashMap key value to represent the box at
 * the specified coordinate. Various helper methods are created in order to make
 * DABGame class efficient. These helper method will calculate the function in
 * order to manage readability and better code management. These methods are
 * called by the DABClass to subdivide the workload, and used the return value
 * to calculate as per its need.
 * 
 * @author Jeevan Thapa
 * 
 * @version Oct 22, 2017
 * 
 */

public class Box

{
	private Player owner;
	private Collection<Direction> drawnEdges;

	/**
	 * Initializes the owner of the boxes to null, and initializes the Collection
	 * variable to store all the edges drawn by the box.
	 */
	public Box() {
		owner = null;
		drawnEdges = new HashSet<>();
	}

	/**
	 * This boolean method will test if the box has already an edge already drawn.
	 * 
	 * @param dir
	 *            this is the direction that's passed
	 * @return true if the Box at the specific direction has edge already drawn else
	 *         false
	 */
	public Boolean hasEdge(Direction dir) {
		return drawnEdges.contains(dir);
	}

	/**
	 * This boolean method will test if the box has already an edge already drawn.
	 * 
	 * @param dir
	 *            this is the direction that's passed
	 * @param player
	 *            this is the player that draws the edge at the particular location
	 */
	public void addEdge(Direction dir, Player player) {
		drawnEdges.add(dir);
		if (drawnEdges.size() == 4) {
			owner = player;
		} else {
			owner = null;
		}
	}

	/**
	 * This method will return the HashSet of the edges drawn at the specific
	 * location
	 * 
	 * @return the collection of the edges that has been drawn
	 */
	public Collection<Direction> getDrawnEdges() {
		Collection<Direction> edgesToReturn = new HashSet<>(drawnEdges);
		return edgesToReturn;
	}

	/**
	 * This method will return the owner of the boxes at the specified location.
	 * 
	 * @return the player who owns the box
	 */
	public Player getOwner() {
		return owner;
	}

}