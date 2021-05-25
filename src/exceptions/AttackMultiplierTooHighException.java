package exceptions;

/**
 * The exception is raised when the attack multiplier exceeds the maximum level possible in the game
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
@SuppressWarnings("serial")
public class AttackMultiplierTooHighException extends IllegalStateException {
	
	/**
	 * Constructor for AttackMultiplierTooHighException
	 * Empty
	 */
	public AttackMultiplierTooHighException() {}
	
	/**
	 * Constructor for AttackMultiplierTooHighException
	 * @param message The message showed on screen when the error occurs
	 */
	public AttackMultiplierTooHighException(String message) {
		super(message);
	}
}
