package backEnd;

/**
 * This is a sub class of Item class, a type of item
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class Weapon extends Item {
	/** How much the weapon can aid the ship by changing/ increasing the multiplier of the ship */
	private int multChanged;
	
	/**
	 * Constructor of a weapon
	 * @param name The name of the item (weapon)
	 * @param description The description of the item (weapon)
	 * @param type The type of the item (weapon)
	 * @param size How much capacity the item (weapon) will take
	 * @param price The original price of the item (weapon)
	 * @param multChanged How much the weapon can aid the ship by changing/ increasing the multiplier of the ship
	 */
	public Weapon(String name, String description, String type, int size, int price, int multChanged) {
		super(name, description, type, size, price);
		this.multChanged = multChanged;
	}
	
	//getter
	/**
	 * Get the multipier change of the ship
	 * @return multChanged
	 */
	public int getMultChanged() {
		return this.multChanged;
	}
	
	/**
	 * Create a new weapon
	 * @return new weapon
	 */
	public Weapon copy() {
		return new Weapon(this.getName(), this.getDescription(), this.getType(), this.getSize(), this.getPrice(), this.getMultChanged());
	}
	
	/**
	 * Check if the 2 weapons are identical
	 * @param weapon The weapon we want to compare
	 * @return true or false
	 */
	public boolean equals(Weapon weapon) {
		return weapon.getName().equals(this.getName());
	}

}
