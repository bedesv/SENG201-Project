package commandLineApplication;

@SuppressWarnings("serial")
public class ItemNotOwnedException extends IllegalStateException{
	public ItemNotOwnedException() {}
	
	public ItemNotOwnedException(String message) {
		super(message);
	}

}

