package exceptions;

/**
 * This class is used when the user runs out of coins to continue purchasing or sailing
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
 *
 */

@SuppressWarnings("serial")
public class InsufficientCoinsException extends IllegalStateException{
	
	/**
	 * Constructor for InsufficientCoinsException
	 * Empty
	 */
	public InsufficientCoinsException() {}
	
	/**
	 * Constructor for InsufficientCoinsException
	 * @param message The message showed on screen when the error occurs
	 */
	public InsufficientCoinsException(String message) {
		super(message);
	}
}
