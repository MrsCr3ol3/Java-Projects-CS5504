package adventure;

import java.util.ArrayList;

import java.util.List;

/**
 * 
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Jeevan Thapa
 * 
 * @version Nov 8, 2017
 * 
 */

public class EnhancedPlayer

		extends Player

{
	private boolean bicyclelocked = false;
	private boolean peanutButterEaten = false;
	private boolean rubyTaken = false;
	private boolean coffeeDrank = false;
	private boolean soccerBallTaken = false;
	private boolean soccerTrainingBookTaken = false;
	private boolean soccerBallKicked = false;
	private boolean soccerBallDropped = false;
	private final int maxWeight = 10;
	private List<Item> contents = new ArrayList<>();

	/**
	 * Get the current value of soccerBallDropped.
	 * 
	 * @return The value of soccerBallDropped for this object.
	 */
	public boolean isSoccerBallDropped() {
		return soccerBallDropped;
	}

	/**
	 * Set the value of soccerBallDropped for this object.
	 * 
	 * @param soccerBallDropped
	 *            The new value for soccerBallDropped.
	 */
	public void setSoccerBallDropped(boolean soccerBallDropped) {
		this.soccerBallDropped = soccerBallDropped;
	}

	/**
	 * Get the current value of soccerBallKicked.
	 * 
	 * @return The value of soccerBallKicked for this object.
	 */
	public boolean isSoccerBallKicked() {
		return soccerBallKicked;
	}

	/**
	 * Set the value of soccerBallKicked for this object.
	 * 
	 * @param soccerBallKicked
	 *            The new value for soccerBallKicked.
	 */
	public void setSoccerBallKicked(boolean soccerBallKicked) {
		this.soccerBallKicked = soccerBallKicked;
	}

	/**
	 * Get the current value of maxWeight.
	 * 
	 * @return The value of maxWeight for this object.
	 */
	public int getMaxWeight() {
		return maxWeight;
	}

	/**
	 * Get the current value of legStretched.
	 * 
	 * @return The value of soccerTrainingBookTaken for this object.
	 */
	public boolean isSoccerTrainingBookTaken() {
		return soccerTrainingBookTaken;
	}

	/**
	 * Set the value of legStretched for this object.
	 * 
	 * @param soccerTrainingBookTaken
	 *            The new value for soccer training book.
	 */
	public void setSoccerTrainingBookTaken(boolean soccerTrainingBookTaken) {
		this.soccerTrainingBookTaken = soccerTrainingBookTaken;
	}

	/**
	 * Get the current value of soccerBallTaken.
	 * 
	 * @return The value of soccerBallTaken for this object.
	 */
	public boolean isSoccerBallTaken() {
		return soccerBallTaken;
	}

	/**
	 * Set the value of soccerBallTaken for this object.
	 * 
	 * @param soccerBallTaken
	 *            The new value for fitnessBookRead.
	 */
	public void setSoccerBallTaken(boolean soccerBallTaken) {
		this.soccerBallTaken = soccerBallTaken;
	}

	/**
	 * Get the current value of coffeeDrank.
	 * 
	 * @return The value of coffeeDrank for this object.
	 */
	public boolean isCoffeeDrank() {
		return coffeeDrank;
	}

	/**
	 * Set the value of coffeeDrank for this object.
	 * 
	 * @param coffeeDrank
	 *            The new value for coffeeDrank.
	 */
	public void setCoffeeDrank(boolean coffeeDrank) {
		this.coffeeDrank = coffeeDrank;
	}

	/**
	 * Get the current value of rubyTaken.
	 * 
	 * @return The value of rubyTaken for this object.
	 */
	public boolean isRubyTaken() {
		return rubyTaken;
	}

	/**
	 * Set the value of rubyTaken for this object.
	 * 
	 * @param rubyTaken
	 *            The new value for rubyTaken.
	 */
	public void setRubyTaken(boolean rubyTaken) {
		this.rubyTaken = rubyTaken;
	}

	/**
	 * Get the current value of peanutButterEaten.
	 * 
	 * @return The value of peanutButterEaten for this object.
	 */
	public boolean isPeanutButterEaten() {
		return peanutButterEaten;
	}

	/**
	 * Set the value of peanutButterEaten for this object.
	 * 
	 * @param peanutButterEaten
	 *            The new value for peanutButterEaten.
	 */
	public void setPeanutButterEaten(boolean peanutButterEaten) {
		this.peanutButterEaten = peanutButterEaten;
	}

	/**
	 * Get the current value of bikelocked.
	 * 
	 * @return The value of bikelocked for this object.
	 */
	public boolean isBicyclelocked() {
		return bicyclelocked;
	}

	/**
	 * Set the value of bikelocked for this object.
	 * 
	 * @param bikelocked
	 *            The new value for bikelocked.
	 */
	public void setBicyclelocked(boolean bikelocked) {
		this.bicyclelocked = bikelocked;
	}

	/**
	 * add the item in player's inventory.
	 * 
	 * @param item
	 *            The item in inventory
	 */
	public void addItem(Item item) {
		contents.add(item);
	}

	/**
	 * remove the item from player's inventory.
	 * 
	 * @param item
	 *            The item in inventory
	 */
	public void removeItem(Item item) {
		contents.remove(item);
	}

	/**
	 * get the item by matching name from player inventory.
	 * 
	 * @param name
	 *            The name in inventory
	 * @return item The item list in inventory
	 */
	public Item getItem(String name) {
		for (Item item : contents) {
			if (item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}

	/**
	 * find whether the object is in player's inventory.
	 * 
	 * @param name
	 *            The name in inventory
	 * @return boolean The item list in inventory
	 */

	public boolean hasItem(String name) {
		for (Item item : contents) {
			if (item.getName().equals(name)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * get the array list of the items in player inventory.
	 * 
	 * @return an Array of items The item list in inventory
	 */

	private String[] getStringArray() {
		String[] array = new String[contents.size()];
		int index = 0;
		for (Item item : contents) {
			array[index] = "the " + item.getName();
			index++;
		}
		return array;
	}

	/**
	 * Get weight of all items in inventory
	 *
	 * @return int total weight
	 */
	public int getInventoryWeight() {
		int totalWeight = 0;
		for (Item items : contents) {
			totalWeight += items.getWeight();
		}
		return totalWeight;
	}

	/**
	 * Get comma separated lists of all items in inventory
	 *
	 * @return String Commaseparated lists
	 */
	public String getInventory() {
		if (contents.size() == 0) {
			return Message.inventoryEmptyMessage();
		}
		return "<p>" + "You are holding " + Message.commaSeparatedList(getStringArray()) + "." + "</p>";
	}

}