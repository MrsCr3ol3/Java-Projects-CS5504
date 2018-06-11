package adventure;

/**
 * 
 * This MyGame class defines the new commands used to command on the object.This
 * class also creates and describe room objects in different direction.This
 * class sets the map or route for the player to follow during the game. This
 * class also define different objects in different rooms. This class not only
 * sets the properties of objects, but also add certain items to the room at
 * initial.
 * 
 * @author Jeevan Thapa
 * 
 * @version Nov 13, 2017
 * 
 */

public class MyGame

		extends Game

{
	/**
	 * Create a new MyGame object.
	 */
	public MyGame() {
		super(new EnhancedPlayer(), new Parser());
	}

	/**
	 * This method creates a game object.
	 * 
	 * @param args
	 *            String array
	 */
	public static void main(String[] args) {
		Game game = new MyGame();
		game.play();
	}

	@Override
	public void createCommands() {
		CommandWords commands = parser().commandWords();
		commands.addCommand("go", new DirectionCommand());
		commands.addCommand("help", new HelpCommand(commands));
		commands.addCommand("quit", new QuitCommand());
		commands.addCommand("q", new QuitCommand());
		commands.addCommand("examine", new ExamineCommand());
		commands.addCommand("x", new ExamineCommand());
		commands.addCommand("take", new TakeCommand());
		commands.addCommand("drop", new DropCommand());
		commands.addCommand("eat", new EatCommand());
		commands.addCommand("lock", new LockCommand());
		commands.addCommand("inventory", new InventoryCommand());
		commands.addCommand("i", new InventoryCommand());
		commands.addCommand("drink", new DrinkCommand());
		commands.addCommand("shoot", new ShootCommand());
		commands.addCommand("read", new ReadCommand());
		// direction
		commands.addCommand("north", new DirectionCommand("north"));
		commands.addCommand("n", new DirectionCommand("north"));
		commands.addCommand("south", new DirectionCommand("south"));
		commands.addCommand("s", new DirectionCommand("south"));
		commands.addCommand("west", new DirectionCommand("west"));
		commands.addCommand("w", new DirectionCommand("west"));
		commands.addCommand("east", new DirectionCommand("east"));
		commands.addCommand("e", new DirectionCommand("east"));
		commands.addCommand("up", new DirectionCommand("up"));
		commands.addCommand("u", new DirectionCommand("up"));
		commands.addCommand("down", new DirectionCommand("down"));
		commands.addCommand("d", new DirectionCommand("down"));
	}

	@Override
	public void createRooms() {
		// create the rooms
		EnhancedRoom livingRoom = new EnhancedRoom(Message.livingRoomDescriptionMessage());
		EnhancedRoom outsideApartment = new EnhancedRoom("outside your apartment");
		EnhancedRoom bedroom = new EnhancedRoom("in your bedroom");
		EnhancedRoom kitchenRoom = new EnhancedRoom("in your kitchen");
		EnhancedRoom fitnessCenter = new EnhancedRoom("in the fitness center");
		EnhancedRoom coffeeShop = new EnhancedRoom("in the coffee shop");
		EnhancedRoom library = new EnhancedRoom("in the library");
		EnhancedRoom basement = new EnhancedRoom("in the basement");
		EnhancedRoom porch = new EnhancedRoom("on the porch");
		EnhancedRoom soccerField = new EnhancedRoom(
				"in the soccer field. You have to drop the soccer-ball and shoot to win the game");
		// initialize room exits
		livingRoom.setExit("west", bedroom);
		bedroom.setExit("east", livingRoom);
		livingRoom.setExit("east", kitchenRoom);
		kitchenRoom.setExit("west", livingRoom);
		livingRoom.setExit("down", basement);
		basement.setExit("up", livingRoom);
		livingRoom.setExit("up", porch);
		porch.setExit("down", livingRoom);
		livingRoom.setExit("south", outsideApartment);
		outsideApartment.setExit("north", livingRoom);
		outsideApartment.setExit("east", coffeeShop);
		coffeeShop.setExit("west", outsideApartment);
		coffeeShop.setExit("south", library);
		library.setExit("north", coffeeShop);
		library.setExit("south", fitnessCenter);
		fitnessCenter.setExit("north", library);
		fitnessCenter.setExit("west", soccerField);
		soccerField.setExit("east", fitnessCenter);
		// initialize items
		Item bicycle = new Item("bicycle", Message.bicycleDescriptionMessage());
		Item ruby = new Item("ruby", Message.rubyDescriptionMessage());
		Item peanutbutter = new Item("peanut-butter", Message.peanutButterDescriptionMessage());
		Item coffee = new Item("coffee", "it wakes you up to train.");
		Item soccerTraningBook = new Item("soccer-training-book",
				"you need to read the soccer training book before you leave.");
		Item soccerBall = new Item("soccer-ball", "you need to drop the soccer ball "
				+ ", drop the soccer-training-book and shoot the soccer-ball" + "in order to win the game.");
		Item noMeaning = new Item("noMeaning", null);
		// Bicycle
		bicycle.setEdible(false);
		bicycle.setLockable(true);
		bicycle.setLocked(false);
		bicycle.setDrinkable(false);
		bicycle.setReadable(false);
		bicycle.setWeight(10);
		// Ruby
		ruby.setEdible(false);
		ruby.setLockable(false);
		ruby.setLocked(false);
		ruby.setDrinkable(false);
		ruby.setReadable(false);
		ruby.setWeight(1);
		// Peanutbutter
		peanutbutter.setEdible(true);
		peanutbutter.setLockable(false);
		peanutbutter.setLocked(false);
		peanutbutter.setDrinkable(false);
		peanutbutter.setReadable(false);
		peanutbutter.setWeight(2);
		// Coffee
		coffee.setEdible(false);
		coffee.setLockable(false);
		coffee.setLocked(false);
		coffee.setDrinkable(true);
		coffee.setReadable(false);
		coffee.setWeight(2);
		// Soccer Training Book
		soccerTraningBook.setEdible(false);
		soccerTraningBook.setLockable(false);
		soccerTraningBook.setLocked(false);
		soccerTraningBook.setDrinkable(false);
		soccerTraningBook.setReadable(true);
		soccerTraningBook.setWeight(2);
		// Soccer Ball
		soccerBall.setEdible(false);
		soccerBall.setLockable(false);
		soccerBall.setLocked(false);
		soccerBall.setDrinkable(false);
		soccerBall.setReadable(false);
		soccerBall.setWeight(2);
		livingRoom.addItem(bicycle);
		kitchenRoom.addItem(peanutbutter);
		bedroom.addItem(ruby);
		coffeeShop.addItem(coffee);
		library.addItem(soccerTraningBook);
		fitnessCenter.addItem(soccerBall);
		basement.addItem(noMeaning);
		// the player starts the game outside
		player().setCurrentRoom(livingRoom);

	}

	@Override
	public String welcomeMessage() {
		return "<p>Welcome to My Adventure Game!</p>" + "<p>Type 'help' if you need help.</p>"
				+ "<p>Hit [return] to continue...</p>";
	}

}