package exceptions;

/**
 * This Exception class shows message when there is no more space for inventory
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */

@SuppressWarnings("serial")
public class InsufficientInventorySpaceException extends IllegalStateException {
	
	/**
	 * Constructor of the InsufficientInventorySpaceException
	 * Empty
	 */
	public InsufficientInventorySpaceException() {}
	
	/**
	 * Constructor of the InsufficientInventorySpaceException
	 * @param message The message showed on screen when the error occurs
	 */
	public InsufficientInventorySpaceException(String message) {
		super(message);
	}
}
