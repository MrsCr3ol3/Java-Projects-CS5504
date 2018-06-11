package adventure;

/**
 * 
 * This class is used to drop objects from the hand or inventory. Once dropped
 * the objects will be removed from the inventory. The main purpose of this
 * class is to add item in rooms from inventory.
 * 
 * @author Jeevan Thapa
 * 
 * @version Nov 13, 2017
 * 
 */
public class DropCommand

		extends Command

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
			return "The drop command requires an object in your inventory to " + "drop.";
		}
		Item item = player.getItem(secondWord);
		if (player.hasItem(secondWord)) {

			if (!player.hasItem("soccer-ball")) {
				player.setSoccerBallTaken(false);
			}
			player.removeItem(item);
			room.addItem(item);
			player.setSoccerBallDropped(true);
			return Message.dropSuccessMessage(secondWord);
		}
		return Message.dropDontHaveMessage(secondWord);
	}

}