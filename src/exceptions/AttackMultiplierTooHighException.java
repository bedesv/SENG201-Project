package exceptions;

@SuppressWarnings("serial")
public class AttackMultiplierTooHighException extends IllegalStateException {

	public AttackMultiplierTooHighException() {}
	
	public AttackMultiplierTooHighException(String message) {
		super(message);
	}
}
