package adventure;
  
 /**
  
  *  This class extends the Command class. This class will be used to examine the objects. This 
  
  *  class gives the information about the objects.
  
  * 
  
  *  @author Jeevan Thapa
  
  *  @version Nov 7, 2017
  
  */
  
 public class ExamineCommand
  
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
      EnhancedRoom room = (EnhancedRoom)playerArg.getCurrentRoom();
      if (!this.hasSecondWord())
      {
          return "The examine command requires an object to examine.";
      }
      Item itemplayer =
          player.getItem(secondWord);
      if (room.hasItem(secondWord))
      {
          Item item = room.getItem(secondWord);
          if (item.isLocked())
          {
              return Message.objectIsLockedMessage(secondWord);
          }
          if (item.getDescription() == null)
          {
              return Message.examineDefaultMessage(secondWord);
          }
          return item.getDescription();
      }
      if (player.hasItem(secondWord))
      {
          return itemplayer.getDescription();
      }
      return Message.cantSeeMessage(secondWord);
  }
  
 }