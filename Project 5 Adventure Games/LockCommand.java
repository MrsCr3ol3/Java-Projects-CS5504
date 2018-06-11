 package adventure;
 2
  
 
 3
  
 /**
  
  * This Class extends the Command class. This class is used to lock any lockable objects in the
  
  * room. Player needs to take the item before they lock it. Player also needds to drop the item if
   
  * they are holding it. it represents, and how to use it.

  * 
 
  * @author Jeevan Thapa
  
  * @version Nov 13, 2017
  
  */
  
 public class LockCommand
 
  
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
          return "The lock command requires an object to lock";
      }
      if (player.isBicyclelocked())
      {
          return "The " + secondWord + " is already locked.";
      }
      if (player.hasItem(secondWord))
      {
          return Message.lockPutDownMessage(secondWord);
      }
      if (room.hasItem(secondWord))
      {
          Item itemroom = room.getItem(secondWord);
          if (itemroom.isLockable())
          {
              itemroom.setLocked(true);
              player.setBicyclelocked(true);
              return Message.lockSuccessMessage(secondWord);
          }
          return Message.lockNotPossibleMessage(secondWord);
      }
      return Message.cantSeeMessage(secondWord);
  }
  
 }