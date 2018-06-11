package adventure;

/**
 * 
 * This class extends the Command class. Taking items will add items to the
 * inventory. This call will remove items from the room.
 * 
 * @author Jeevan Thapa
 * 
 * @version Nov 8, 2017
 * 
 */

public class TakeCommand

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
			return "The take command requires an object to take.";
		}
		if (player.hasItem(secondWord)) {
			return Message.takeAlreadyHaveMessage(secondWord);
		}
		Item item = room.getItem(secondWord);
		if (room.hasItem(secondWord)) {
			if (item.isLocked()) {
				return Message.takeLockedMessage(secondWord);
			}
			if (item.getWeight() + player.getInventoryWeight() <= player.getMaxWeight()) {
				player.addItem(item);
				if (player.hasItem("ruby")) {
					player.setRubyTaken(true);
				}
				if (player.hasItem("soccer-ball")) {
					player.setSoccerBallTaken(true);
				}
				room.removeItem(item);
				return Message.takeSuccessMessage(secondWord);
			}
			return Message.takeNotEnoughRoomMessage(secondWord);
		}
		return Message.cantSeeMessage(secondWord);
	}

}