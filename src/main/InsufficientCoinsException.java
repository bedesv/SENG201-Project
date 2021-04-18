package main;

@SuppressWarnings("serial")
public class InsufficientCoinsException extends IllegalStateException{
	
	public InsufficientCoinsException() {}
	
	public InsufficientCoinsException(String message) {
		super(message);
	}
}
