package exceptions;

/**
 * This exception class is raised when the weapon is already owned by the player
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
 *
 */
@SuppressWarnings("serial")
public class WeaponAlreadyOwnedException extends IllegalStateException{
	
	/**
	 * Constructor for the WeaponAlreadyOwnedException
	 * Empty
	 */
	public WeaponAlreadyOwnedException() {}
	
	/**
	 * Constructor for the WeaponAlreadyOwnedException
	 * @param message The message showed on screen when the error occurs
	 */
	public WeaponAlreadyOwnedException(String message) {
		super(message);
	}
}
