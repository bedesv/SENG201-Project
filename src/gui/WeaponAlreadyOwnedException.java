package gui;

@SuppressWarnings("serial")
public class WeaponAlreadyOwnedException extends IllegalStateException{
	public WeaponAlreadyOwnedException() {}
	
	public WeaponAlreadyOwnedException(String message) {
		super(message);
	}
}
