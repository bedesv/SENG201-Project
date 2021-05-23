package gui;

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
	/** the damage multiplier, any damage received will be multiplied with this, the lower the better */
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
	/** the wage the player has to pay each crew for a day of a sail */
	private final int COSTPERCREW = 5;
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
		defenceMultiplier = damage;
		shipSpeed = speed;	
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
	

	public int getCurrentDamage() {
		return this.shipDamage;
	}
	
	public int getCrew() {
		return this.shipCrew;
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
	
	
/**
	 * Player wants to buy an item
	 * @param item The item that the player wants to purchase
	 * @param price The purchased price of the item
	 */
	public boolean buyItem(Item item, int price, StoreWindow storeWindow) {
		if (coins < price) {
			throw new InsufficientCoinsException();
		} else if (maxCapacity < currCapacity + item.getSize()) { 
			throw new InsufficientInventorySpaceException();
		} else {
			if (storeWindow.confirmPurchase(item, price)) {
				item = item.copy();
				item.buyItem(price);
				coins -= price;
				shipInventory.add(item);
				currCapacity += item.getSize();
				System.out.println(item.getName() + " purchased successfully\n");
				this.printCoins();
				return true;
			}
			return false;
		}
	}
	
	/**
	 * Player wants to buy a weapon and upgrade their ship
	 * @param weapon The weapon that the player wants to purchase
	 * @param price The purchased price of the weapon
	 */
	public boolean buyWeapon(Weapon weapon, int price, StoreWindow storeWindow) {
		if (coins < price) {
			throw new InsufficientCoinsException();
		} else if (maxCapacity < currCapacity + weapon.getSize()) { 
			throw new InsufficientInventorySpaceException();
		} else {
			
			if (storeWindow.confirmPurchase(weapon, price)) {
				weapon = weapon.copy();
				weapon.buyItem(price);
				coins -= price;
				currCapacity += weapon.getSize();
				shipWeapons.add(weapon);
				// upgrade ship
				attackMultiplier += weapon.getMultChanged();
				System.out.println(weapon.getName() + " purchased successfully\n");
				this.printCoins();
				return true;
			} 
			return false;
		}
	}
	
    /**
	 * Player wants to sell weapons
	 * @param weapon The weapon that the player wants to sell
	 * @param price The sold price of the weapon
	 */
	public boolean sellWeapon(Weapon weapon, int price, StoreWindow storeWindow) {
		
		if (storeWindow.confirmSale(weapon, price)) {
			weapon = this.getWeaponFromInventory(weapon);
			weapon.sellItem(this.location, price);
			soldWeapons.add(weapon);
			coins += price;
			shipWeapons.remove(weapon);
			currCapacity -= weapon.getSize();
			attackMultiplier -= weapon.getMultChanged();
			System.out.println(weapon.getName() + " sold successfully\n");
			this.printCoins();
			return true;
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
	/**
	 * Player wants to sell items
	 * @param item The item that the player wants to sell
	 * @param price The sold price of the item
	 */
	public boolean sellItem(Item item, int price, StoreWindow storeWindow) {
		
		if (storeWindow.confirmSale(item, price)) {
			item = this.getItemFromInventory(item);
			item.sellItem(this.location, price);
			soldItems.add(item);
			coins += price;
			shipInventory.remove(item);
			currCapacity -= item.getSize();
			System.out.println(item.getName() + " sold successfully\n");
			this.printCoins();
			return true;
		}
		return false;

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
	
	public int getCostToSail(int days) {
		return days * this.COSTPERCREW * this.shipCrew;
	}
	
//getter
	/**
	 * Get the ship's damage multiplier, 
	 * any damage received will be multiplied with this, the lower the better
	 * @return ship's damage multiplier
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
	 * Player takes a route to travel to an island with probability of random events
	 * @param route The chosen route to take
	 * @param destination The island the player wants to travel to
	 * @return
	 */
	public int useRoute(Route route, Island destination, SelectRouteWindow selectRouteWindow, Player player) {
		int daysTaken = route.getDaysToTravel(this);
		int wagesCost = daysTaken * this.COSTPERCREW * this.shipCrew;
		
		if (this.getCoins() < wagesCost) {
			throw new InsufficientCoinsException();
		} else if (!player.unlimitedDays() && (this.daysPlayed + daysTaken > player.getMaxDays())) {
			throw new InsufficientDaysException();
		} else {
			this.coins -= wagesCost;
			int setSailSuccess = 0;
			
			int event;
			int pirates = 1;
			int weather = 2;
			int sailors = 3;

			if ((int) (Math.random() * 100) <= route.getMultiplier()) {
				event = (int) (Math.random() * 3) + 1;
				if (event == pirates) {
					setSailSuccess = encounterPirates.pirateBattle(this, selectRouteWindow);
				} else if (event == weather) {
					setSailSuccess = unfortunateWeather.storm(this, selectRouteWindow);
				} else if (event == sailors) {
					rescueSailors.findSailors(this, selectRouteWindow);
				}
			}
			if (setSailSuccess == 0) {
				this.setLocation(destination);
			}
			return setSailSuccess;
		}
	}
	
	public void increaseAttackMult() {
		if (this.attackMultiplier + 1 <= 30) {
			this.attackMultiplier += 1;
		}
	}
	
	public void increaseDefenceMult() {
		if(this.defenceMultiplier + 1 <= 30) {
			this.defenceMultiplier += 1;
		}
	}
	
	public void increaseInventoryCapacity() {
		this.maxCapacity += 10;
	}
	

	
	//getter
	/**
	 * Get the days that the player has passed in the game
	 * @return
	 */
	public int getDays() {
		return this.daysPlayed;
	}
	
	
}
