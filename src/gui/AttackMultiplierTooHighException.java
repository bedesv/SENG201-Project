package gui;

@SuppressWarnings("serial")
public class AttackMultiplierTooHighException extends IllegalStateException {

	public AttackMultiplierTooHighException() {}
	
	public AttackMultiplierTooHighException(String message) {
		super(message);
	}
}
