package adventure;

/**
 * This class extends the Command class. This class gives the list of inventory
 * items on the player's inventory. Follow it with additional details about its
 * purpose, what abstraction it represents, and how to use it.
 * 
 * @author Jeevan Thapa
 * @version Nov 13, 2017
 */

public class InventoryCommand extends Command {
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String execute(Player playerArg) {
		EnhancedPlayer player = (EnhancedPlayer) playerArg;
		return player.getInventory();
	}

}