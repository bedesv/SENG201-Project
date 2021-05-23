package GUI;

import java.util.*;



/**
 * Ship is the vehicle to travel from an island to the other
 * <br>There are 4 ships for player to choose from
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
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
	/** the attack multiplier of the ship, the higher the mroe likely player will win a battle */
	private int attackMultiplier;
	/** the damage multiplier, any damage received will be multiplied with this, the lower the better */
	private int damageMultiplier;
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
	/** the wage the player has to pay each crew for a day of a sail */
	private int costPerCrew = 50;
	/** how many days the player has been playing for */
	private int daysPlayed = 0;
	/** event of encountering pirates */
	private Pirates encounterPirates = new Pirates();
	/** event of a storm occurring on sail */
	private Weather unfortunateWeather = new Weather();
	/** event of rescuing another sailor */
	private RescueSailors rescueSailors = new RescueSailors();
	
/**
	 * Constructor of a ship
	 * @param name The name of the ship
	 * @param crew The number of crew on the ship
	 * @param capacity The maximum capacity that the ship can hold
	 * @param attack The attack multiplier of the ship
	 * @param damage The damage multiplier of the ship
	 * @param speed The speed of the ship
	 */
	public Ship(String name, int crew, int capacity, int attack, int damage, int speed) {
		shipCrew = crew;
		shipName = name;
		maxCapacity = capacity;
		attackMultiplier = attack;
		damageMultiplier = damage;
		shipSpeed = speed;	
	}
	
	/**
	 * Player will need to repair the ship when it is damaged
	 * @param input What the player types in the system
	 */
	public void repairShip() {
		coins -= shipDamage * 10;
		shipDamage = 0;
			
	}
	
	public int getRepairCost() {
		return shipDamage * 10;
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
	 * Set the location o fthe ship
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
	
	public ArrayList<Item> getItemsBought() {
		return shipInventory;
	}
	
	public ArrayList<Item> getItemsSold() {
		return soldItems;
	}
	
	public ArrayList<Weapon> getWeaponsBought() {
		return shipWeapons;
	}
	
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
	public int inventoryTotal() {
		int sum = 0;
		for (Item i:this.shipInventory) {
			sum += i.getPrice();
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
	
	
/**
	 * Player wants to buy an item
	 * @param item The item that the player wants to purchase
	 * @param price The purchased price of the item
	 */
	public void buyItem(Item item, int price) {
		if (coins < price) {
			System.out.println("Not enough coins to buy " + item.getName() + ", sell some items to get more.");
		} else if (maxCapacity < currCapacity + item.getSize()) { 
			System.out.println("Not enough inventory space to buy" + item.getName() + ", sell some items to free some up.");
		} else {
			item = item.copy();
			item.buyItem(price);
			coins -= price;
			shipInventory.add(item);
			currCapacity += item.getSize();
			System.out.println(item.getName() + " purchased successfully\n");
			this.printCoins();
		}
	}
	
	/**
	 * Player wants to buy a weapon and upgrade their ship
	 * @param weapon The weapon that the player wants to purchase
	 * @param price The purchased price of the weapon
	 */
	public void buyWeapon(Weapon weapon, int price) {
		if (coins < price) {
			System.out.println("Not enough coins to buy " + weapon.getName() + ", sell some items to get more.");
		} else if (maxCapacity < currCapacity + weapon.getSize()) { 
			System.out.println("Not enough inventory space to buy" + weapon.getName() + ", sell some items to free some up.");
		} else {
			weapon = weapon.copy();
			weapon.buyItem(price);
			coins -= price;
			currCapacity += weapon.getSize();
			shipWeapons.add(weapon);
			// upgrade ship
			attackMultiplier += weapon.getMultChanged();
			System.out.println(weapon.getName() + " purchased successfully\n");
			this.printCoins();
		}
	}
	
    /**
	 * Player wants to sell weapons
	 * @param weapon The weapon that the player wants to sell
	 * @param price The sold price of the weapon
	 */
	public void sellWeapon(Weapon weapon, int price) {
		weapon = this.getWeaponFromInventory(weapon);
		weapon.sellItem(this.location, price);
		soldWeapons.add(weapon);
		coins += price;
		shipWeapons.remove(weapon);
		currCapacity -= weapon.getSize();
		attackMultiplier -= weapon.getMultChanged();
		System.out.println(weapon.getName() + " sold successfully\n");
		this.printCoins();
	}
	
	public Weapon getWeaponFromInventory(Weapon weapon) {
		
		for (Weapon shipWeapon:shipWeapons) {
			if (weapon.equals(shipWeapon)) {
				weapon = shipWeapon;
			}
		}
		return weapon;
	}
	
	public Item getItemFromInventory(Item item) {
		for (Item shipItem:shipInventory) {
			if (item.equals(shipItem)) {
				
				item = shipItem;
			}
		}
		return item;
	}
	/**
	 * Player wants to sell items
	 * @param item The item that the player wants to sell
	 * @param price The sold price of the item
	 */
	public void sellItem(Item item, int price) {
		item = this.getItemFromInventory(item);
		item.sellItem(this.location, price);
		soldItems.add(item);
		coins += price;
		shipInventory.remove(item);
		currCapacity -= item.getSize();
		System.out.println(item.getName() + " sold successfully\n");
		this.printCoins();

	}
    
	//getter
	/**
	 * Get an item on the ship
	 * @param i The item that needs to get
	 * @return wanted item
	 */
	public Item getItem(Item i) {
		for (Item j: shipInventory) {
			if (i.equals(j)) {
				return j;
			}
		}
		return i;
	}
	
//getter
	/**
	 * Get the ship's damage multiplier, 
	 * any damage received will be multiplied with this, the lower the better
	 * @return ship's damage multiplier
	 */
	public int getDamageMultiplier() {
		return damageMultiplier;
	}
	
	//getter
	/**
	 * Get the ship's attack multiplier,
	 * the higher the mroe likely player will win a battle
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
	 * @param coin The amount that needs to be added
	 */
	public void addCoins(int coin) {
		this.coins += coin;
	}
	
	 /**
	 * Show how many coins the player have 
	 */
	public void printCoins() {
		System.out.println("Current coin balance: " + this.coins + " coins.");
	}
	
	 /**
	 * Remove all the inventory from the ship
	 */
	public void clearInventory() {
		this.shipInventory.clear();
	}
	
	 /**
	 * Player takes a route to travel to an isalnd with probability of random events
	 * @param route The chosen route to take
	 * @param destination The island the player wants to travel to
	 * @return
	 */
	public boolean useRoute(Route route, Island destination) {
		// identidy the island that the player is currently at
		Island oldLocation = this.location;
		int daysTaken = route.getDays(this);
		int wagesCost = daysTaken * this.costPerCrew * this.shipCrew;
		int event;
		int pirates = 1;
		int weather = 2;
		int sailors = 3;
		this.coins -= wagesCost;
		boolean gameCont = true;
		if ((int) (Math.random() * 100) <= route.getMultiplier()) {
			event = (int) (Math.random() * 3) + 1;
			if (event == pirates) {
				gameCont = encounterPirates.pirateBattle(this);
			} else if (event == weather) {
				gameCont = unfortunateWeather.storm(this);
			} else if (event == sailors) {
				rescueSailors.findSailors(this);
			}
		}
		
		if (gameCont) {
			System.out.println("Successfully traveled from " + oldLocation.getName() + " to " + destination.getName() + ".\n");
			this.daysPlayed += daysTaken;
			this.location = destination;
		}
		return gameCont;
		
	}
	
	//getter
	/**
	 * Get the current damage of the ship
	 * @return ship's damage
	 */
	public int getCurrentDamage() {
		return this.shipDamage;
	}
	
	public void shipInfo() {
		System.out.println(shipName + " Properties:");
		System.out.println();
		System.out.println("Damage Multiplier: " + damageMultiplier);
		System.out.println("All damage received is multiplied by this before being applied (lower is better).");
		System.out.println();
		System.out.println("Attack Multiplier: " + attackMultiplier);
		System.out.println("All damage given is multiplied by this before being applied (higher is better).");
		System.out.println();
		System.out.println("Crew Size: " + shipCrew);
		System.out.println();
		System.out.println("Max Inventory Capacity: " + maxCapacity);
		System.out.println();
		System.out.println();
	}
	
	//getter
	/**
	 * Get the days that the player has passed in the game
	 * @return
	 */
	public int getDays() {
		return this.daysPlayed;
	}
	
	public static void main(String[] args) {
		
	}
	
}
