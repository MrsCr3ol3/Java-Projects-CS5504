package minivan;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * This is a JUnit test class for the Minivan class
 * 
 * It checks that the attempt to open the door by various methods opens the door
 * in a newly constructed minivan object and the log meassage is the one that we
 * expect
 * 
 * @author your name (your-pid)
 * @version 2016.02.26
 */

public class MinivanTest {

	// ~ Fields ................................................................

	// Holds a minivan object to be used in your individual tests
	private Minivan minivan;

	// ~ Constructor ...........................................................

	/**
	 * Creates a new MinivanTest test object.
	 */
	public MinivanTest() {
		// The constructor is usually empty in unit tests, since it runs
		// once for the whole class, not once for each test method.
		// Per-test initialization should be placed in setUp() instead.
	}

	// ~ Methods ...............................................................

	/**
	 * Sets up the test fixture. Called before every test case method. Here, we just
	 * create a minivan using the default constructor, so a freshly created minivan
	 * is available for use in each test.
	 */
	@Before
	public void setUp() {
		minivan = new Minivan();
	}

	/**
	 * Check that the outside handle opens the door in a newly constructed minivan
	 * object and that the log message is the one we expect.
	 */
	@Test
	public void testOuterHandleWithDefaultMinivan() {
		minivan.pullOutsideHandle();
		assertTrue(minivan.isOpen());
		assertEquals(Message.DOOR_NOW_OPEN, minivan.getLastMessage());
		toString();
	}

	/**
	 * Check that the inside handle opens the door in a newly constructed minivan
	 * object and that the log message is the one we expect.
	 */
	@Test
	public void testInsideHandleWithDefaultMinivan() {
		minivan.pullInsideHandle();
		assertTrue(minivan.isOpen());
		assertEquals(Message.DOOR_NOW_OPEN, minivan.getLastMessage());
	}

	/**
	 * Check that by pushing the dashboard button opens the door in a newly
	 * constructed minivan object and that the log message is the one we expect.
	 */
	@Test
	public void testPushOpenButtonWithDefaultMinivan() {
		minivan.pushOpenButton();
		assertTrue(minivan.isOpen());
		assertEquals(Message.DOOR_NOW_OPEN, minivan.getLastMessage());
	}

}
