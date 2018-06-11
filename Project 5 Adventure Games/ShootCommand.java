package adventure;

/**
 * 
 * This class is inherited from the Command class. First the object needs to be
 * taken and then dropped in order to shoot.
 * 
 * @author Jeevan Thapa
 * 
 * @version Nov 19, 2017
 */

public class ShootCommand

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
			return "The shoot command requires object you have to shoot";
		}
		if (room.hasItem(secondWord)) {
			if (room.hasItem("soccer-ball") && player.isSoccerBallDropped()) {
				player.setSoccerBallKicked(true);
				if (player.isSoccerBallKicked()) {
					return "You shot the soccer ball into the net. " + "You score a goal, " + Message.youWinMessage();
				}
			}

		}
		return "You need to drop the soccer-ball to shoot.";
	}

}