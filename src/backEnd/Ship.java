package backEnd;

import java.util.*;



/**
 * Ship is the vehicle to travel from an island to the other
 * <br>There are 4 ships for player to choose from
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */

public class Ship {
	/** the name of the ship */
	private String shipName;
	/** the number of the crew on the ship */
	private int shipCrew;
	/** the maximum capacity of the ship */
	private int maxCapacity;
	/** the current filled up capacity of the ship */
	private int currCapacity=0;
	/** the amount (%) of damage the ship has received */
	private int shipDamage;
	/** the island where the ship is located on */
	private Island location;
	/** the coins that the player owns, default at 1000 */
	private int coins=1000;
	/** the attack multiplier of the ship, the higher the more likely player will win a battle */
	private int attackMultiplier;
	/** the defence multiplier, any damage received will be divided by this, the lower the better */
	private int defenceMultiplier;
	/** the list of items in the inventory on the ship */
	private ArrayList<Item> shipInventory = new ArrayList<Item>();
	/** the list of weapons the ship has */
	private ArrayList<Weapon> shipWeapons = new ArrayList<Weapon>();
	/** the list of items that the player has sold */
	private ArrayList<Item> soldItems = new ArrayList<Item>();
	/** the list of weapons that the player has sold */
	private ArrayList<Weapon> soldWeapons = new ArrayList<Weapon>();
	/** the speed of the ship */
	private int shipSpeed;
	/** wages the player has to pay each crew member for a day of a sail */
	private final int COSTPERCREW = 5;
	/** The string for the location of the image of the ship */
	private String imgString;
	
/**
	 * Constructor of a ship
	 * @param name The name of the ship
	 * @param crew The number of crew on the ship
	 * @param capacity The maximum capacity that the ship can hold
	 * @param attack The attack multiplier of the ship
	 * @param damage The damage multiplier of the ship
	 * @param speed The speed of the ship
	 */
	public Ship(String name, int crew, int capacity, int attack, int damage, int speed, String imgString) {
		this.shipCrew = crew;
		this.shipName = name;
		this.maxCapacity = capacity;
		this.attackMultiplier = attack;
		this.defenceMultiplier = damage;
		this.shipSpeed = speed;	
		this.imgString = imgString;
	}
	
	/**
	 * Player will need to repair the ship when it is damaged
	 * @param input What the player types in the system
	 */
	public void repairShip() {
		coins -= shipDamage;
		shipDamage = 0;
	}
	
	//getter
	/**
	 * Get the cost for repairing the ship
	 * @return
	 */
	public int getRepairCost() {
		return shipDamage;
	}
	
	//getter
	/**
	 * Get the image location string
	 * @return
	 */
	public String getImgString() {
		return this.imgString;
	}
	
	//getter
	/**
	 * Get the amount of coins the player currently owns
	 * @return coins
	 */
	public int getCoins() {
		return coins;
	}
	
	//getter
	/**
	 * Get the speed of the ship
	 * @return ship's speed
	 */
	public int getSpeed() {
		return shipSpeed;
	}
	
	//setter
	/**
	 * Set the location of the ship
	 * @param location The island that we want to set as the home island of the ship
	 */
	public void setLocation(Island location) {
		this.location = location;
	}
	
	//getter
	/**
	 * Get the location where the ship is based
	 * @return island
	 */
	public Island getLocation() {
		return this.location;
	}
	
	/**
	 * Add the damage to the ship
	 * @param damage The extra damage received to the ship
	 */
	public void takeDamage(int damage) {
		this.shipDamage += damage;
	}
	
	//getter
	/**
	 * Get the current damage of the ship
	 * @return ship's damage
	 */
	public int getCurrentDamage() {
		return this.shipDamage;
	}
	
	//getter
	/**
	 * Get the number of crews on the ship
	 * @return ship's number of crew
	 */
	public int getCrew() {
		return this.shipCrew;
	}
	
	public boolean hasRum() {
		for (Item item:shipInventory) {
			if (item.getName() == "Rum") {
				return true;
			}
		}
		return false;
	}
	
	public void removeRum() {
		Item item = new Item();
		for (int i=0;i<shipInventory.size();i++) {
			item = shipInventory.get(i);
			if (item.getName() == "Rum") {
				shipInventory.remove(i);
				i--;
			}
		}
	}
	//getter
	/**
	 * Get the list of items bought by the player
	 * @return item list
	 */
	public ArrayList<Item> getItemsBought() {
		return shipInventory;
	}
	
	//getter
	/**
	 * Get the list of items sold by the player
	 * @return item list
	 */
	public ArrayList<Item> getItemsSold() {
		return soldItems;
	}
	
	//getter
	/**
	 * Get the list of weapons bought by the player
	 * @return weapon list
	 */
	public ArrayList<Weapon> getWeaponsBought() {
		return shipWeapons;
	}
	
	//getter
	/**
	 * Get the list of weapon sold by the player
	 * @return weapon list
	 */
	public ArrayList<Weapon> getWeaponsSold() {
		return soldWeapons;
	}
	
	//getter
	/**
	 * Get the current filled capacity of the ship
	 * @return ship's current used capacity
	 */
	public int getCurrCapacity() {
		return this.currCapacity;
	}
	
	//getter
	/**
	 * Get the maximum capacity the ship can hold
	 * @return ship's maximum capacity
	 */
	public int getMaxCapacity() {
		return this.maxCapacity;
	}

	//getter
	/**
	 * Get the inventory as a list of items on the ship
	 * @return ship's inventory
	 */
	public ArrayList<Item> getInventory() {
		return this.shipInventory;
	}
	
	//getter
	/**
	 * Get the list of weapons owned by the ship/ the player
	 * @return weapon list
	 */
	public ArrayList<Weapon> getWeapons() {
		return this.shipWeapons;
	}
	
	/**
	 * Calculate how much the inventory worths
	 * @return the sum of coins
	 */
	public int inventoryValue() {
		int sum = 0;
		for (Item i:this.shipInventory) {
			sum += i.getPrice();
		}
		for (Weapon w:this.shipWeapons) {
			sum += w.getPrice();
		}
		return sum;
	}
	
	/**
	 * Check if the item exists in the inventory
	 * @param i item in the inventory (item list)
	 * @return true (if the item is in the inventory) or false (if it is not)
	 */
	public boolean inventoryContains(Item i) {
		for (Item j: this.shipInventory) {
			if (j.equals(i)) {
				return true;
			}
		}
		return false;
	}
	
	//getter
	/**
	 * Get a single weapon from the inventory
	 * @param weapon The wanted weapon
	 * @return weapon
	 */
	public Weapon getWeaponFromInventory(Weapon weapon) {
		for (Weapon shipWeapon:shipWeapons) {
			if (weapon.equals(shipWeapon)) {
				weapon = shipWeapon;
			}
		}
		return weapon;
	}
	
	//getter
	/**
	 * Get a single item from the inventory
	 * @param item The wanted item
	 * @return item
	 */
	public Item getItemFromInventory(Item item) {
		for (Item shipItem:shipInventory) {
			if (item.equals(shipItem)) {
				item = shipItem;
			}
		}
		return item;
	}
	
	//getter
	/**
	 * Get the wage that player has to pay the crew before sailing
	 * @param days The length of the sail in days
	 * @return wage cost
	 */
	public int getCostToSail(int days) {
		return days * this.COSTPERCREW * this.shipCrew;
	}
	
	//getter
	/**
	 * Get the ship's defence multiplier, 
	 * any damage received will be multiplied with this, the lower the better
	 * @return ship's defence multiplier
	 */
	public int getDefenceMultiplier() {
		return defenceMultiplier;
	}
	
	//getter
	/**
	 * Get the ship's attack multiplier,
	 * the higher the more likely player will win a battle
	 * @return ship's attack multiplier
	 */
	public int getAttackMultiplier() {
		return attackMultiplier;
	}
	
	//getter
	/**
	 * Get the name of the ship
	 * @return ship's name
	 */
	public String getName() {
		return shipName;
	}
	
	 /**
	 * Player receives coins
	 * @param coins The amount of coins that need to be added
	 */
	public void addCoins(int coins) {
		this.coins += coins;
	}
	
	 /**
	 * Player loses coins
	 * @param coins The amount of coins that need to be removed
	 */
	public void removeCoins(int coins) {
		this.coins -= coins;
	}
	
	public void buyItem(Item item, int price) {
		coins -= price;
		shipInventory.add(item);
		currCapacity += item.getSize();
	}
	
	public void sellItem(Item item, int price) {
		coins += price;
		shipInventory.remove(item);
		soldItems.add(item);
		currCapacity -= item.getSize();
	}
	
	public void buyWeapon(Weapon weapon, int price) {
		coins -= price;
		shipWeapons.add(weapon);
		currCapacity += weapon.getSize();
		attackMultiplier += weapon.getMultChanged();
	}
	
	public void sellWeapon(Weapon weapon, int price) {
		soldWeapons.add(weapon);
		coins += price;
		shipWeapons.remove(weapon);
		currCapacity -= weapon.getSize();
		attackMultiplier -= weapon.getMultChanged();
	}
	
	 /**
	 * Remove all items from the ship inventory
	 */
	public void clearInventory() {
		this.shipInventory.clear();
		this.currCapacity = 0;
	}
	
	/**
	 * Increase the attack multiplier
	 */
	public void increaseAttackMult() {
		if (this.attackMultiplier + 1 <= 30) {
			this.attackMultiplier += 1;
		}
	}
	
	/**
	 * Increase the defence multiplier
	 */
	public void increaseDefenceMult() {
		if(this.defenceMultiplier + 1 <= 30) {
			this.defenceMultiplier += 1;
		}
	}
	
	/**
	 * Increase the inventory capacity on the ship
	 */
	public void increaseInventoryCapacity() {
		this.maxCapacity += 10;
	}
}
