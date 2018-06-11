  
 package adventure;
  
 /**
  
  * This Class extends the Command interface. This command is used to go to different rooms in
  
  * different directions. Directions are: east (e), west(w), north(n), south(s), up(u) and down(d).
  
  * it represents, and how to use it.
  
  * 
  
  * @author Jeevan Thapa
  
  * @version Nov 13, 2017
  
  */
  
 public class DirectionCommand
  
     extends Command
  
 {
 private final String direction;
 /**
  * Create a new DirectionCommand object.
  */
 public DirectionCommand()
 {
     direction = null;
 }
 /**
  * Create a new DirectionCommand object.
  * 
  * @param dir
  *            movement direction
  */
 public DirectionCommand(String dir)
 {
     this.direction = dir;
 }
 /**
  * {@inheritDoc}
  */
 @Override
 public String execute(Player playerArg)
 {
     String dir = direction;
     EnhancedPlayer player = (EnhancedPlayer)playerArg;
     String secondWord = this.getSecondWord();
     if (hasSecondWord())
     {
         dir = secondWord;
     }
     if (dir == null)
     {
         dir = getSecondWord();
     }
     Room nextRoom = playerArg.getCurrentRoom().getExit(dir);
     if (nextRoom == null)
     {
         return Message.noExitInDirectionMessage();
     }
     if (nextRoom.getShortDescription().equals("outside your apartment"))
     {
         if (!player.isPeanutButterEaten())
         {
             return Message.exitWithoutEatingPBMessage();
         }
         else if (!player.isBicyclelocked())
         {
             return Message.exitWithoutLockingBikeMessage();
         }
         else if (!player.isRubyTaken())
         {
             return Message.exitWithoutTakingRubyMessage();
         }
         playerArg.setCurrentRoom(nextRoom);
     }
     if (nextRoom.getShortDescription().equals("in the library"))
     {
         if (!player.isCoffeeDrank())
         {
             return "You don't want to go to the library without drinking coffee";
         }
         playerArg.setCurrentRoom(nextRoom);
     }
     if (nextRoom.getShortDescription()
         .equals("in the fitness center"))
     {
         if (!player.isSoccerTrainingBookTaken())
         {
             return "You don't want to go to fitness center without reading a  "
                 + "soccer-training-book.";
         }
         playerArg.setCurrentRoom(nextRoom);
     }
     if (nextRoom.getShortDescription()
         .equals(
             "in the soccer field. You have to drop the soccer-ball and shoot to win the game")
         && !player.isSoccerBallTaken())
     {
         return "You don't want to go to soccer field "
             + "without taking a soccer ball.";
     }
     playerArg.setCurrentRoom(nextRoom);
     return "";
  
     }