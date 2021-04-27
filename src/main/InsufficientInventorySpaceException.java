package main;

@SuppressWarnings("serial")
public class InsufficientInventorySpaceException extends IllegalStateException {
	
	public InsufficientInventorySpaceException() {}
	
	public InsufficientInventorySpaceException(String message) {
		super(message);
	}
}
