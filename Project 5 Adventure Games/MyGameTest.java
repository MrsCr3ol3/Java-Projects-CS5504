package adventure;

import org.junit.Before;

import org.junit.Test;

import static org.junit.Assert.*;

// CHECKSTYLE:OFF

@SuppressWarnings("javadoc")

public class MyGameTest

{
	private String message;

	private String roomDesc;
	// private String longDesc;
	private Game game;

	public MyGameTest() {
	}

	@Before
	public void setUp() {
		game = new MyGame(); // new game
		game.createCommands(); // Command
		game.createRooms(); // Room
	}

	@Test
	public void testInit() {
		roomDesc = game.player().getCurrentRoom().getShortDescription();
		assertEquals(Message.livingRoomDescriptionMessage(), roomDesc);
	}

	@Test
	public void testExamineBicycle() {
		executeMoves("examine bicycle");
		assertEquals(Message.livingRoomDescriptionMessage(), roomDesc);
		assertEquals(Message.bicycleDescriptionMessage(), message);
	}

	@Test
	public void testExamineAlreadyLockedBicycle() {
		executeMoves("lock bicycle");
		assertEquals("You locked up the bicycle.", message);
		executeMoves("lock bicycle");
		assertEquals("The bicycle is already locked.", message);
	}

	@Test
	public void testDropItemNotOnInventory() {
		executeMoves("drop bicycle");
		assertEquals("You don't have the bicycle to drop.", message);
	}

	@Test
	public void testItemDrinkable() {
		executeMoves("drink ");
		assertEquals("The drink command requires an drinkable object to drink.", message);
	}

	@Test
	public void testMultipleItemsInInventory() {
		executeMoves("e", "take peanut-butter", "w", "take bicycle", "w", "take ruby");
		executeMoves("i");
		assertEquals("<p>You are holding the peanut-butter and the ruby.</p>", message);
	}

	@Test
	public void testNotReadableObjects() {
		executeMoves("w", "take ruby", "read ruby");
		assertEquals("ruby is not readable", message);
	}

	@Test
	public void testReadableObjectsWithoutTaking() {
		executeMoves("w", "read ruby");
		assertEquals("You need to take the ruby in order to read it.", message);
	}

	@Test
	public void testReadRoomDoesNotHaveItem() {
		executeMoves("u", "read ruby");
		assertEquals("You don't see any ruby.", message);
	}

	@Test
	public void testInventoryEmpty() {
		executeMoves("inventory");
		assertEquals(Message.inventoryEmptyMessage(), message);
	}

	@Test
	public void testNullItemDescription() {
		executeMoves("go down", "x noMeaning");
		assertEquals("You don't see anything special about the noMeaning.", message);
	}

	@Test
	public void testMessageClassDummy() {
		assertNotNull(new Message());
	}

	@Test
	public void testRubyFromInitalStageWithAllPossibleTestCases() {
		executeMoves("west", "lock ruby");// living room
		assertEquals(Message.lockNotPossibleMessage("ruby"), message);
		executeMoves("take ruby");
		assertEquals("in your bedroom", roomDesc);
		assertEquals(Message.takeSuccessMessage("ruby"), message);
		executeMoves("take ruby");
		assertEquals(Message.takeAlreadyHaveMessage("ruby"), message);
		executeMoves("take  ");
		assertEquals("The take command requires an object to take.", message);
		executeMoves("examine ruby");
		assertEquals(Message.rubyDescriptionMessage(), message);
		executeMoves("lock bicycle");
		assertEquals(Message.cantSeeMessage("bicycle"), message);
		executeMoves("take");

		assertEquals("The take command requires an object to take.", message);
		executeMoves("e", "take bicycle");
		assertEquals(Message.takeNotEnoughRoomMessage("bicycle"), message);
	}

	@Test
	public void testEatPeanutButterFromInitalStageWithAllPossibleTestCases() {
		executeMoves("e");
		assertEquals("in your kitchen", roomDesc);
		executeMoves("eat peanut-butter");
		assertEquals(Message.dontHaveMessage("peanut-butter"), message);
		executeMoves("examine");
		assertEquals("The examine command requires an object to examine.", message);
		executeMoves("examine  ");
		assertEquals("The examine command requires an object to examine.", message);
		executeMoves("examine ruby");
		assertEquals(Message.cantSeeMessage("ruby"), message);
		executeMoves("examine peanut-butter");
		assertEquals(Message.peanutButterDescriptionMessage(), message);
		executeMoves("take peanut-butter");
		assertEquals(Message.takeSuccessMessage("peanut-butter"), message);
		executeMoves("eat peanut-butter");
		assertEquals(Message.eatSuccessMessage("peanut-butter"), message);
		executeMoves("eat  ");
		assertEquals("The eat command requires something to eat.", message);
		executeMoves("eat");
		assertEquals("The eat command requires something to eat.", message);
		executeMoves("i");
		assertEquals(Message.inventoryEmptyMessage(), message);
	}

	@Test
	public void testEatExamineWithAllPossibleCases()

	{
		executeMoves("examine bicycle");
		assertEquals("in your living room", roomDesc);
		assertEquals(Message.bicycleDescriptionMessage(), message);
		executeMoves("go south");
		assertEquals(Message.exitWithoutEatingPBMessage(), message);
		executeMoves("take bicycle");
		executeMoves("eat bicycle");
		assertEquals(Message.eatNotEdibleMessage("bicycle"), message);
		executeMoves("eat ruby");
		assertEquals(Message.cantSeeMessage("ruby"), message);
		executeMoves("drop bicycle", "e", "take peanut-butter", "eat peanut-butter", "w");
		executeMoves("go south");
		assertEquals(Message.exitWithoutLockingBikeMessage(), message);
		executeMoves("w", "take ruby", "i");
		executeMoves("drink ruby");
		assertEquals("ruby is not drinkable", message);
		executeMoves("drop ruby");
		assertEquals(Message.dropSuccessMessage("ruby"), message);
		executeMoves("lock");
		assertEquals("The lock command requires an object to lock", message);
		executeMoves("lock  ");
		assertEquals("The lock command requires an object to lock", message);
		executeMoves("lock bicycle");
		assertEquals(Message.cantSeeMessage("bicycle"), message);
		executeMoves("e");
		executeMoves("eat peanut-butter");
		assertEquals(Message.cantSeeMessage("peanut-butter"), message);
		executeMoves("take bicycle");
		assertEquals(Message.takeSuccessMessage("bicycle"), message);
		executeMoves("lock bicycle");
		assertEquals(Message.lockPutDownMessage("bicycle"), message);
		executeMoves("drop");
		assertEquals("The drop command requires an object in your inventory to drop.", message);
		executeMoves("drop bicycle");
		assertEquals(Message.dropSuccessMessage("bicycle"), message);
		executeMoves("lock bicycle");
		assertEquals(Message.lockSuccessMessage("bicycle"), message);
		executeMoves("take bicycle");
		assertEquals(Message.takeLockedMessage("bicycle"), message);
		executeMoves("examine bicycle");
		assertEquals(Message.objectIsLockedMessage("bicycle"), message);
		executeMoves("go south");
	}

	@Test
	public void testEmptyDescriptionWithAnExamine() {
		executeMoves();
		assertEquals("You don't see anything special about the ruby.", Message.examineDefaultMessage("ruby"));
		executeMoves("i");
		assertEquals(Message.inventoryEmptyMessage(), message);
		executeMoves("go", "n", "n");
		executeMoves("go south");
		executeMoves("examine coffee");
		executeMoves("take coffee");
		executeMoves("drink coffee");
		executeMoves("w", "go south");
	}

	@Test
	public void testInitialStageToTheFinalStageWithAllPossibleTestCases()

	{
		executeMoves("go", "n", "n");
		assertEquals(Message.noExitInDirectionMessage(), message);
		executeMoves("go south", "e", "take peanut-butter", "eat peanut-butter", "w", "go south");
		assertEquals(Message.exitWithoutLockingBikeMessage(), message);
		executeMoves("lock bicycle", "go south");
		assertEquals(Message.exitWithoutTakingRubyMessage(), message);
		executeMoves("w", "take ruby", "e", "go south");
		assertEquals("outside your apartment", roomDesc);
		executeMoves("e");
		assertEquals("in the coffee shop", roomDesc);
		executeMoves("go south");
		assertEquals("You don't want to go to the library without drinking coffee", message);
		executeMoves("examine coffee");
		assertEquals("it wakes you up to train.", message);
		executeMoves("drink coffee");
		assertEquals("You need to take the coffee in order to drink it.", message);
		executeMoves("take coffee");
		executeMoves("drink coffee");
		assertEquals("You drank coffee, now you can go south to Library.", message);
		executeMoves("w", "go east", "go south");
		assertEquals("in the library", roomDesc);
		executeMoves("go south");
		assertEquals("You don't want to go to fitness center without reading a  soccer-training-book.", message);
		executeMoves("take soccer-training-book");
		assertEquals("You take the soccer-training-book.", message);
		executeMoves("n", "s", "s");
		assertEquals("in the library", roomDesc);
		executeMoves("go west");
		assertEquals("There is no exit in that direction!", message);
		executeMoves("read");
		assertEquals("The read command requires a readable object to read.", message);
		executeMoves("read soccer-training-book");
		assertEquals("you read soccer training book, now you can go south to fitness center.", message);

		executeMoves("w", "e", "w");
		assertEquals("in the library", roomDesc);
		executeMoves("shoot soccer-ball");
		executeMoves("shoot ");
		assertEquals("The shoot command requires object you have to shoot", message);
		executeMoves("drop soccer-ball");
		assertEquals("You don't have the soccer-ball to drop.", message);
		executeMoves("go south");
		assertEquals("in the fitness center", roomDesc);
		executeMoves("go west");
		assertEquals("You don't want to go to soccer field without taking a soccer ball.", message);
		executeMoves("take soccer-ball");
		executeMoves("n", "take soccer-training-book");
		executeMoves("i");
		assertEquals("<p>You are holding the ruby, the soccer-training-book and the soccer-ball.</p>", message);
		executeMoves("s");
		executeMoves("take soccer-ball");
		assertEquals("You already have the soccer-ball.", message);
		executeMoves("shoot soccer-ball");
		assertEquals("You need to drop the soccer-ball to shoot.", message);
		executeMoves("drop soccer-ball");
		assertEquals("You dropped the soccer-ball.", message);
		executeMoves("shoot soccer-ball");
		assertEquals("You shot the soccer ball into the net. You score a goal, Congratulations. You won!", message);
	}

	@Test
	public void testMainDummy() {
		MyGame.main(new String[0]);
	}

	@Test
	public void testWelcomeMessage() {
		assertTrue(new MyGame().welcomeMessage().contains("Welcome"));
	}

	private void executeMoves(String... inputs) {
		for (String input : inputs) {
			Command command = game.parser().getCommand(input);
			message = command.execute(game.player());
		}
		roomDesc = game.player().getCurrentRoom().getShortDescription();
		game.player().getCurrentRoom().getLongDescription();
	}

}