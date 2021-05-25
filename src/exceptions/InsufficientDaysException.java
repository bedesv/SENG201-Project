package exceptions;

/**
 * The exception is raised when there are not enough days to continue sailing
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
 *
 */
@SuppressWarnings("serial")
public class InsufficientDaysException extends IllegalStateException{
	
	/**
	 * Constructor of the InsufficientDaysException
	 * Empty
	 */
	public InsufficientDaysException() {}
	
	/**
	 * Constructor of the InsufficientDaysException
	 * @param message The message showed on screen when the error occurs
	 */
	public InsufficientDaysException(String message) {
		super(message);
	}

}
