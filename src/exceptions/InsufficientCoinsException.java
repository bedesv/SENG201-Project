package exceptions;

/**
 * This class is used when the user runs out of coins to continue purchasing or sailing
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
 *
 */

@SuppressWarnings("serial")
public class InsufficientCoinsException extends IllegalStateException{
	
	public InsufficientCoinsException() {}
	
	public InsufficientCoinsException(String message) {
		super(message);
	}
}
