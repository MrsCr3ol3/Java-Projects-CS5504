package adventure;
  
 /**
  
  * This class extends the Command Class. This class is used to read the readable items in the room.
  
  * First the objects needs to be taken in order to read.
  
  * 
  
  * @author Jeevan Thapa
  
  * @version Nov 20, 2017
  
  */
  
 public class ReadCommand
  
     extends Command
  
 {
  /**
   * {@inheritDoc}
   */
  @Override
  public String execute(Player playerArg)
  {
      String secondWord = this.getSecondWord();
      EnhancedPlayer player = (EnhancedPlayer)playerArg;
      EnhancedRoom room = (EnhancedRoom)player.getCurrentRoom();
      if (!hasSecondWord())
      {
          return "The read command requires a readable object to read.";
      }
      Item item = player.getItem(secondWord);
      if (player.hasItem(secondWord))
      {
          if (item.isReadable())
          {
              player.setSoccerTrainingBookTaken(true);
              return "you read soccer training book, now you can go south to fitness center.";
          }
          return secondWord + " is not readable";
      }
      if (room.hasItem(secondWord))
      {
          return "You need to take the " + secondWord
              + " in order to read it.";
      }
      return Message.cantSeeMessage(secondWord);
  }
  
 }