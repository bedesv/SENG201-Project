package backEnd;

import java.util.*;

/**
 * Store is a place to trade good for player
 * <br> There are 5 stores in total, each is situated in a unique island
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class Store {
	/** The name of the store */
	private String storeName;
	/** The list of items that the store will buy */
	private ArrayList<Item> itemsBought = new ArrayList<Item>();
	/** The list of items that the store will sell */
	private ArrayList<Item> itemsSold = new ArrayList<Item>();
	/** The list of weapons that the store will buy */
	private ArrayList<Weapon> weaponsBought = new ArrayList<Weapon>();
	/** The list of weapons that the store will sell */
	private ArrayList<Weapon> weaponsSold = new ArrayList<Weapon>();
	/** The price of the item or weapon when bought by the store will be multiplied with this */
	private int boughtMultiplier;
	/** The price of the item or weapon when sold by the store will be multiplied with this */
	private int soldMultiplier;
	
	
	/**
	 * Constructor of a store
	 * Constructs an empty store
	 */
	public Store() {
	}
	/**
	 * Constructor of a store
	 * @param name The name of the store
	 * @param multiplier The price of the item or weapon when sold by the store will be multiplied with this
	 */
	public Store(String name, int multiplier) {
		storeName = name;
		boughtMultiplier = multiplier - 2;
		soldMultiplier = multiplier;
	}
	
	/**
	 * Check if store can buy an item from the player
	 * @param i The item that the player wants to sell to the store
	 * @return true (if the item can be bought by the store) or false (otherwise)
	 */
	public boolean buysItem(Item i) {
		
		for (Item j: this.itemsBought) {
			if (j.equals(i)) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Check if store can buy a weapon from the player
	 * @param i The weapon that the player wants to sell to the store
	 * @return true (if the weapon can be bought by the store) or false (otherwise)
	 */
	public boolean buysWeapon(Weapon w) {
		for (Weapon x:this.weaponsBought) {
			if(x.equals(w)) {
				return true;
			}
		}
		return false;
	}
	
	//getter
	/**
	 * Get the list of items can be bought by the store
	 * @return item list
	 */
	public ArrayList<Item> getItemsBought() {
		return this.itemsBought;
	}
	
	//getter
	/**
	 * Get the list of items can be sold by the store
	 * @return item list
	 */
	public ArrayList<Item> getItemsSold() {
		return this.itemsSold;
	}
	
	//getter
	/**
	 * Get the list of weapons can be bought by the store
	 * @return weapon list
	 */
	public ArrayList<Weapon> getWeaponsBought() {
		return this.weaponsBought;
	}
	
	//getter
	/**
	 * Get the list of weapons can be sold by the store
	 * @return weapon list
	 */
	public ArrayList<Weapon> getWeaponsSold() {
		return this.weaponsSold;
	}
	
	/**
	 * Add an item to the store when it is bought by the store
	 * @param item The item that the store bought
	 */
	public void addItem(Item item) {
		itemsBought.add(new Item(item.getName(), item.getDescription(), item.getType(), item.getSize(), (item.getPrice() * boughtMultiplier)));
		itemsSold.add(new Item(item.getName(), item.getDescription(), item.getType(), item.getSize(), (item.getPrice() * soldMultiplier)));
	}
	
	/**
	 * Add an weapon to the store when it is bought by the store
	 * @param weapon The item that the store bought
	 */
	public void addWeapon(Weapon weapon) {
		weaponsBought.add(new Weapon(weapon.getName(), weapon.getDescription(), weapon.getType(), weapon.getSize(), (weapon.getPrice() * boughtMultiplier), weapon.getMultChanged()));
		weaponsSold.add(new Weapon(weapon.getName(), weapon.getDescription(), weapon.getType(), weapon.getSize(), (weapon.getPrice() * soldMultiplier), weapon.getMultChanged()));
	}
	
	//getter
	/**
	 * Get the store's name
	 * @return store's name
	 */
	public String getStoreName() {
		return storeName;
	}
	
	//getter
	/**
	 * Get the price that the player has to pay to buy the item
	 * @param i The item whose the purchase price is needed to know
	 * @return item's purchase price
	 */
	public int getPurchasePrice(Item i) {
		if (i.getType() == "Weapon") {
			for (Weapon j: this.weaponsSold) {
				if (i.equals(j)) {
					return j.getPrice();
				}
			}
		} else {
			for (Item j: this.itemsSold) {
				if (i.equals(j)) {
					return j.getPrice();
				}
			}
		}
		return 0;
	}
	
	//getter
	/**
	 * Get the price that the player receives when selling the item
	 * @param i The item whose the sale price is needed to know
	 * @return item's sale price
	 */
	public int getSalePrice(Item i) {
		if (i.getType() == "Weapon") {
			for (Weapon j: this.weaponsBought) {
				if (i.equals(j)) {
					return j.getPrice();
				}
			}
		} else {
			for (Item j: this.itemsBought) {
				if (i.equals(j)) {
					return j.getPrice();
				}
			}
		}
		return 0;
	}
	
	//getter
	/**
	 * Get a list of items that the player can sell
	 * @param playersShip The ship the player is using
	 * @return item list
	 */
	public ArrayList<Item> getItemsPlayerCanSell(Ship playersShip) {
		ArrayList<Item> itemsCanSell = new ArrayList<Item>();
		// Find all items the player owns and the store will buy
		for (Item item:playersShip.getInventory()) {
			outerLoop:
				if (this.buysItem(item)) {
					// Ensure each item is only added once
					for (Item storeItem:itemsCanSell) {
						if (storeItem.equals(item)) {
							break outerLoop;
						}
					}
					itemsCanSell.add(item);
				}
		}
		return itemsCanSell;
	}
	
	//getter
	/**
	 * Get a list of weapons that the player can sell
	 * @param playersShip The ship the player is using
	 * @return weapon list
	 */
	public ArrayList<Weapon> getWeaponsPlayerCanSell(Ship playersShip) {
		ArrayList<Weapon> weaponsCanSell = new ArrayList<Weapon>();
		// Find all weapons the player owns and the store will buy
		for (Weapon weapon:playersShip.getWeapons()) {
			outerLoop:
				if (this.buysWeapon(weapon)) {
					// Ensure each weapon is only added once
					for (Weapon storeWeapon:weaponsCanSell) {
						if (storeWeapon.equals(weapon)) {
							break outerLoop;
						}
					}
					weaponsCanSell.add(weapon);
				}
		}
		return weaponsCanSell;
	}
}
