package GUI;

/**
 * This Exception class shows message player wants to sell/ use
 * an item that he does not own
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
 *
 */

@SuppressWarnings("serial")
public class ItemNotOwnedException extends IllegalStateException{
	public ItemNotOwnedException() {}
	
	public ItemNotOwnedException(String message) {
		super(message);
	}

}

