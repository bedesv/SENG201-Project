package GUI;

public class Weapon extends Item {
	private int multChanged;
	
	public Weapon(String name, String description, String type, int size, int price, int multChanged) {
		super(name, description, type, size, price);
		this.multChanged = multChanged;
	}
	
	public int getMultChanged() {
		return this.multChanged;
	}
	
	public Weapon copy() {
		return new Weapon(this.getName(), this.getDescription(), this.getType(), this.getSize(), this.getPrice(), this.getMultChanged());
	}

}
