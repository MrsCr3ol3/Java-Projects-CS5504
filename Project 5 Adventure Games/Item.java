 package adventure;
 /**
  
  * Item class define the properties of item. This class is used to set and get the item properties.  
  * 
  * @author Jeevan Thapa
  * @version Nov 7, 2017
  */
  
 public class Item
  
 {
	private final String name;
	private final String description;
	private int          weight;
	private boolean      lockable;
	private boolean      edible;
	private boolean      locked;
	private boolean      drinkable;
	private boolean      readable;
 /**
  * Get the current value of readable.
  * 
  * @return The value of readable for this object.
  */
 public boolean isReadable()
 {
     return readable;
 }
 
 /**
  * Set the value of readable for this object.
  * 
  * @param readable
  *            The new value for readable.
  */
 public void setReadable(boolean readable)
 {
     this.readable = readable;
 }
 
 /**
  * Get the current value of drinkable.
  * 
  * @return The value of drinkable for this object.
  */
 public boolean isDrinkable()
 {
     return drinkable;
 }
 
 /**
  * Set the value of drinkable for this object.
  * 
  * @param drinkable
  *            The new value for drinkable.
  */
 public void setDrinkable(boolean drinkable)
 {
     this.drinkable = drinkable;
 }
 
 /**
  * Create a new GameObject object.
  * 
  * @param name
  *            item name
  * @param description
  *            item description
  */
 public Item(String name, String description)
 {
     this.name = name;
     this.description = description;
 }
 
 /**
  * Get the current value of weight.
  * 
  * @return The value of weight for this object.
  */
 public int getWeight()
 {
     return weight;
 }
 
 /**
  * Set the value of weight for this object.
  * 
  * @param weight
  *            The new value for weight.
  */
 public void setWeight(int weight)
 {
     this.weight = weight;
 }
 
 /**
  * Get the current value of lockable.
  * 
  * @return The value of lockable for this object.
  */
 public boolean isLockable()
 {
     return lockable;
 }
 
 /**
  * Set the value of lockable for this object.
  * 
  * @param lockable
  *            The new value for lockable.
  */
 public void setLockable(boolean lockable)
 {
     this.lockable = lockable;
 }
 
 /**
  * Get the current value of edible.
  * 
  * @return The value of edible for this object.
  */
 public boolean isEdible()
 {
     return edible;
 }
 
 /**
  * Set the value of edible for this object.
  * 
  * @param edible
  *            The new value for edible.
  */
 public void setEdible(boolean edible)
 {
     this.edible = edible;
 }
 
 /**
  * Get the current value of name.
  * 
  * @return The value of name for this object.
  */
 public String getName()
 {
     return name;
 }
 
 /**
  * Get the current value of description.
  * 
  * @return The value of description for this object.
  */
 public String getDescription()
 {
     return description;
 }
 
 /**
  * Get the current value of locked.
  * 
  * @return The value of locked for this object.
  */
 public boolean isLocked()
 {
     return locked;
 }
 
 /**
  * Set the value of locked for this object.
  * 
  * @param locked
  *            The new value for locked.
  */
 public void setLocked(boolean locked)
 {
     this.locked = locked;
 }
  
 }