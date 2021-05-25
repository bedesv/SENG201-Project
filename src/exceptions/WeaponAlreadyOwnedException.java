package exceptions;

@SuppressWarnings("serial")
public class WeaponAlreadyOwnedException extends IllegalStateException{
	public WeaponAlreadyOwnedException() {}
	
	public WeaponAlreadyOwnedException(String message) {
		super(message);
	}
}
