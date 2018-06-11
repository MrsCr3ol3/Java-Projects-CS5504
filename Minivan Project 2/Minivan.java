package minivan;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a Minivan class.It has a sliding door. The door can be locked or
 * unlocked using a dashboard button. The door can be opened by either a
 * dashboard button, its inside handle, or its outside handle. However, the
 * inside handles do not work if the minivan's child lock switch is activated.
 * In order for the sliding door to open, the door must be unlocked and the gear
 * shift must be in park. Methods have been defined to open the door by these
 * methods . Test case methods have been written for deciding whether a sliding
 * door will open or not.
 * 
 * @author your name (your-pid)
 * @version 2016.02.26
 */
public class Minivan {

	// ~ Fields ................................................................

	private String openOrClosed;
	private String lockedOrUnlocked;
	private String childLock;
	private Gear gear;
	private List<String> log;

	// ~ Constructor ...........................................................

	/**
	 * Creates a new minivan object with the doors closed, gear shift in park,
	 * child lock switch off, and master unlock switch on (unlocked).
	 */
	public Minivan() {
		openOrClosed = "closed";
		lockedOrUnlocked = "unlocked";
		childLock = "off";
		gear = Gear.PARK;
		log = new ArrayList<>();
	}

	// ~Public Methods ........................................................

	/**
	 * This method is used to check if the door is open or not
	 * 
	 * @return boolean
	 */
	public boolean isOpen() {
		if (openOrClosed.equals("open"))
			return true;
		else
			return false;
	}

	/**
	 * This method is used to check if the door is locked or not
	 * 
	 * @return boolean
	 */
	public boolean isLocked() {
		if (lockedOrUnlocked.equals("locked"))
			return true;
		else
			return false;
	}

	/**
	 * This method is used to check if the child lock is switched off or not
	 * 
	 * @return boolean
	 */
	public boolean getChildLock() {
		if (childLock.equals("on"))
			return true;
		else
			return false;
	}

	/**
	 * This method is used to check if the gear shift is in park or not
	 * 
	 * @return boolean
	 */
	public boolean getGear() {
		if (gear.equals(Gear.PARK))
			return true;
		else
			return false;
	}

	/**
	 * This method is used to lock the door even if it is open
	 */
	public void pushLockButton() {
		lockedOrUnlocked = "locked";
	}

	/**
	 * This method is used to unlock the door
	 */
	public void pushUnlockButton() {
		lockedOrUnlocked = "unlocked";
	}

	/**
	 * This method is used to turns on the child safety lock (if value is true)
	 * or turns off the child safety lock (if value is false).
	 * 
	 * @param value
	 */
	public void setChildLock(boolean value) {
		if (value == true)
			this.childLock = "on";
		else if (value == false)
			this.childLock = "off";
	}

	/**
	 * This method is used to print the string representation of the minivan
	 * object newly created
	 */
	public String toString() {
		String stringRepresentation = "The van is in  " + gear + ".\nThe child lock is " + childLock + ".\nThe door is "
				+ openOrClosed + " and " + lockedOrUnlocked + ".";
		return stringRepresentation;
	}

	/**
	 * This method is used to close the door
	 */
	public void closeDoor() {
		openOrClosed = "closed";
	}

	/**
	 * This method is used to set the value of gear
	 */
	public void setGear(Gear gearArg) {
		gear = gearArg;
	}

	/**
	 * This method is used to print the list of messages in the log
	 */
	public void printLog() {
		for (String message : log) {
			System.out.println(message);
		}
	}

	/**
	 * This method is used to print the last message in the log
	 */
	public void printLastMessage() {
		String lastMessage = log.get(log.size() - 1);
		System.out.println(lastMessage);
	}

	/**
	 * This message is used to get the last message from the log
	 * 
	 * @return String
	 */
	public String getLastMessage() {
		return log.get(log.size() - 1);
	}

	/**
	 * This method is used to open the door by using the inside handle
	 */
	public void pullInsideHandle() {
		if (!getChildLock()) {
			if (!isLocked()) {
				if (getGear()) {
					if (!isOpen()) {
						openOrClosed = "open";
						log.add(Message.DOOR_NOW_OPEN);
					} else {
						log.add(Message.DOOR_ALREADY_OPEN);
					}
				}
			} else {
				log.add(Message.DOOR_LOCKED);
			}
		} else {
			log.add(Message.CHILD_LOCK_ON);
		}
	}

	/**
	 * This method is used to attempt to open the door by the outside handle
	 */
	public void pullOutsideHandle() {
		if (!isOpen()) {
			if (!isLocked()) {
				if (getGear()) {
					openOrClosed = "open";
					log.add(Message.DOOR_NOW_OPEN);
				}
			} else {
				log.add(Message.DOOR_LOCKED);
			}
		} else {
			log.add(Message.DOOR_ALREADY_OPEN);
		}
	}

	/**
	 * This method is used to attempt to open the door by pushing the dashboard
	 * button
	 */
	public void pushOpenButton() {
		if (!isOpen()) {
			if (!isLocked()) {
				if (getGear()) {
					openOrClosed = "open";
					log.add(Message.DOOR_NOW_OPEN);
				}
			} else {
				log.add(Message.DOOR_LOCKED);
			}
		} else {
			log.add(Message.DOOR_ALREADY_OPEN);
		}
	}
}
