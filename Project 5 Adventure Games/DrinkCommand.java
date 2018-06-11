 package adventure;
  
 /**
  
  * This Class inherits from Command class. This class is used to drink drinkable objects. This class
  
  * is used by executing the execute method on item.
  
  * 
  
  * @author Jeevan Thapa
  
  * @version Nov 19, 2017
  
  */
  
 public class DrinkCommand
  
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
          return "The drink command requires an drinkable object to drink.";
      }
      Item item = player.getItem(secondWord);
      if (player.hasItem(secondWord))
      {
          if (item.isDrinkable())
          {
              player.setCoffeeDrank(true);
              player.removeItem(item);
              return "You drank coffee, now you can go south to Library.";
          }
          return secondWord + " is not drinkable";
      }
      if (room.hasItem(secondWord))
      {
          return "You need to take the " + secondWord
              + " in order to drink it.";
      }
      return Message.cantSeeMessage(secondWord);
  }
  
 }