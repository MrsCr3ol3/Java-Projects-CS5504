package adventure;
  
 import java.util.ArrayList;
 import java.util.List;
  
 /**
  
  * This class is inherited from Room class. This class describes the room type and its properties.
  
  * 
  
  * @author Jeevan Thapa
  
  * @version Nov 7, 2017
  
  */
  

 public class EnhancedRoom
  
     extends Room
  
 {
 private List<Item> contents = new ArrayList<>();
 /**
  * Create a new EnhancedRoom object.
  * 
  * @param description
  *            room description
  */
 public EnhancedRoom(String description)
 {
     super(description);
 }
 
 /**
  * add the item to the room.
  * 
  * @param item
  *            The item in inventory
  */
 public void addItem(Item item)
 {
     contents.add(item);
 }
 
 /**
  * remove the item from the room.
  * 
  * @param item
  *            The item in inventory
  */
 public void removeItem(Item item)
 {
     contents.remove(item);
 }
 
 /**
  * get the item from the room.
  * 
  * @param name
  *            The name of the inventory
  * @return The Item matches the item name
  */
 public Item getItem(String name)
 {
     for (Item item : contents)
     {
         if (item.getName().equals(name))
         {
             return item;
         }
     }
     return null;
 }
 
 /**
  * checks to see if the room has the item.
  * 
  * @param name
  *            The name of the item
  * @return boolean Item value of true or false
  */
 public boolean hasItem(String name)
 {
     for (Item item : contents)
     {
         if (item.getName().equals(name))
         {
             return true;
         }
     }
     return false;
 }
 
 /**
  * checks to see if the room has the item.
  * 
  * @return array Item lists
  */
 private String[] getStringArray()
 {
     String[] array = new String[contents.size()];
     int index = 0;
     for (Item item : contents)
     {
         array[index] = "the " + item.getName();
         index++;
     }
     return array;
 }
 
 /**
  * gives the comma-separated list of items.
  * 
  * @return String Item comma separated lists
  */
 private String getListOfItems()
 {
     if (contents.size() == 0)
     {
         return "";
     }
     return "<p>" + "You see " + Message.commaSeparatedList(getStringArray()) + "." + "</p>";
 }
 
 @Override
 public String getLongDescription()
 {
     String superDesc = super.getLongDescription();
     return superDesc + getListOfItems();
 }
  
 }