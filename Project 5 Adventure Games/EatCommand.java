
package adventure;

/**
 * 
 * This Class is used to eat eatable objects in room. In order to eat the object
 * must be carried. Once eaten the objecs will be removed from inventory and
 * room. 
 * 
 * @author Jeevan Thapa
 * 
 * @version Nov 13, 2017
 * 
 */

public class EatCommand extends Command

{
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String execute(Player playerArg) {
		String secondWord = this.getSecondWord();
		EnhancedPlayer player = (EnhancedPlayer) playerArg;
		EnhancedRoom room = (EnhancedRoom) player.getCurrentRoom();
		if (!hasSecondWord()) {
			return "The eat command requires something to eat.";
		}
		Item item = player.getItem(secondWord);
		if (room.hasItem(secondWord)) {
			return Message.dontHaveMessage(secondWord);
		}
		if (player.hasItem(secondWord)) {
			if (item.isEdible()) {
				player.setPeanutButterEaten(true);
				player.removeItem(item);
				return Message.eatSuccessMessage(secondWord);
			}
			return Message.eatNotEdibleMessage(secondWord);
		}
		return Message.cantSeeMessage(secondWord);
	}

}