package gui;

/**
 * This Exception class shows message when there is no more space for inventory
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
 *
 */

@SuppressWarnings("serial")
public class InsufficientInventorySpaceException extends IllegalStateException {
	
	public InsufficientInventorySpaceException() {}
	
	public InsufficientInventorySpaceException(String message) {
		super(message);
	}
}
