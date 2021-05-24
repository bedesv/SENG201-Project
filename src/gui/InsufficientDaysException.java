package gui;

@SuppressWarnings("serial")
public class InsufficientDaysException extends IllegalStateException{
	
	public InsufficientDaysException() {}
	
	public InsufficientDaysException(String message) {
		super(message);
	}

}
