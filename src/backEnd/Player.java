package backEnd;

import java.util.ArrayList;

import exceptions.AttackMultiplierTooHighException;
import exceptions.InsufficientCoinsException;
import exceptions.InsufficientDaysException;
import exceptions.InsufficientInventorySpaceException;
import exceptions.WeaponAlreadyOwnedException;

/**
 * A player is the captain of the game
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class Player { 
	/** The ship the the player selected */
	private Ship selectedShip;
	/** The name of the player */
	private String name;
	/** The maximum days the players are allowed to continue playing */
	private int maxDays;
	/** The days that have passed */
	private int daysPlayed=0;
	/** Instead of choosing a fixed number of days, player can play indefinitely */
	private boolean unlimitedDays;
	/** event of encountering pirates */
	private Pirates encounterPirates = new Pirates();
	/** event of a storm occurring on sail */
	private Weather unfortunateWeather = new Weather();
	/** event of rescuing another sailor */
	private RescueSailors rescueSailors = new RescueSailors();
	
	/**
	 * Constructor of a player
	 * @param ship The ship the player chose
	 * @param startingLocation The island the ship is currently based
	 * @param name The name of the player
	 * @param days The maximum of days that the player chose to play
	 */
	public Player(Ship ship, Island startingLocation, String name, int days) {
		this.selectedShip = ship;
		this.selectedShip.setLocation(startingLocation);
		this.name = name;
		
		if (days > 0) {
			this.maxDays = days;
			unlimitedDays = false;
		} else {
			unlimitedDays = true;
		}
	}
	
	//getter
	/**
	 * Get the coins on the ship
	 * @return coins
	 */
	public int getCoins() {
		return selectedShip.getCoins();
	}
	
	/**
	 * Repairs the ship after the it has been damaged
	 */
	public void repairShip() {
		selectedShip.repairShip();
	}
	
	//getter
	/**
	 * Get a string showing how much capacity has been used compared to the maximum capacity
	 * @return current capacity
	 */
	public String getShipCapacity() {
		return selectedShip.getCurrCapacity() + "/" + selectedShip.getMaxCapacity();
	}
	
	/**
	 * Check if the player can afford to buy and store the item
	 * @param item The item that the player wants to buy
	 * @param price the price of the item
	 * @return true (if yes) or throws the respective error otherwise
	 */
	public boolean checkItemPurchase(Item item, int price) {
		if (selectedShip.getCoins() < price) {
			throw new InsufficientCoinsException();
		} else if (selectedShip.getMaxCapacity() < selectedShip.getCurrCapacity() + item.getSize()) { 
			throw new InsufficientInventorySpaceException();
		} else {
			return true;
		}
	}
	
	/**
	 * Check if the player can afford to buy and store the weapon
	 * @param weapon The weapon that the player wants to buy
	 * @param price the price of the weapon
	 * @return true (if yes) or throws the respective error otherwise
	 */
	public boolean checkWeaponPurchase(Weapon weapon, int price) {
		boolean weaponAlreadyOwned = false;
		checkWeaponOwned:
			for (Weapon w: selectedShip.getWeapons()) {
				if (weapon.getName() == w.getName()) {
					weaponAlreadyOwned = true;
					break checkWeaponOwned;
				}
			}
		if (selectedShip.getCoins() < price) {
			throw new InsufficientCoinsException();
		} else if (selectedShip.getMaxCapacity() < selectedShip.getCurrCapacity() + weapon.getSize()) { 
			throw new InsufficientInventorySpaceException();
		} else if (selectedShip.getAttackMultiplier() + weapon.getMultChanged() > 30) {
			throw new AttackMultiplierTooHighException();
		} else if (weaponAlreadyOwned) {
			throw new WeaponAlreadyOwnedException();
		} else {
			return true;
		}
		
	}
	
	/**
	 * Player wants to buy an item
	 * @param item The item that the player wants to purchase
	 * @param price The purchased price of the item
	 */
	public void buyItem(Item item, int price) {
		item = item.copy();
		item.buyItem(price);
		selectedShip.buyItem(item, price);
	}
	
	/**
	 * Player wants to buy a weapon and upgrade their ship
	 * @param weapon The weapon that the player wants to purchase
	 * @param price The purchased price of the weapon
	 */
	public void buyWeapon(Weapon weapon, int price) {
		weapon = weapon.copy();
		weapon.buyItem(price);
		selectedShip.buyWeapon(weapon, price);		
	}
	
	/**
	 * Player wants to sell items
	 * @param item The item that the player wants to sell
	 * @param price The sold price of the item
	 */
	public void sellItem(Item item, int price) {
		item = selectedShip.getItemFromInventory(item);
		item.sellItem(selectedShip.getLocation(), price);
		selectedShip.sellItem(item, price);
	}
	
    /**
	 * Player wants to sell weapons
	 * @param weapon The weapon that the player wants to sell
	 * @param price The sold price of the weapon
	 */
	public void sellWeapon(Weapon weapon, int price) {
		weapon = selectedShip.getWeaponFromInventory(weapon);
		weapon.sellItem(selectedShip.getLocation(), price);
		selectedShip.sellWeapon(weapon, price);
	}
	
	/**
	 * Check if the play mode is unlimited days
	 * @return true or false
	 */
	public boolean unlimitedDays() {
		return this.unlimitedDays;
	}
	
	//getter
	/**
	 * Get the value of the inventory
	 * @return inventory's value
	 */
	public int getInventoryValue() {
		return selectedShip.inventoryValue();
	}
	
	//getter
	/**
	 * Get the island that the ship is located at
	 * @return island
	 */
	public Island getCurrLocation() {
		return selectedShip.getLocation();
	}
	
	/**
	 * Check if the player can afford to travel along a route
	 * @param route The route that the player has chosen
	 * @return true (if the player can use the route) or throws the respective error if not
	 */
	public boolean checkRoute(Route route) {
		int daysTaken = route.getDaysToTravel(selectedShip);
		int wagesCost = selectedShip.getCostToSail(daysTaken);
		
		if (this.getCoins() < wagesCost) {
			throw new InsufficientCoinsException();
		} else if (!this.unlimitedDays() && (this.daysPlayed + daysTaken > this.maxDays)) {
			throw new InsufficientDaysException();
		} else {
			return true;
		}
	}
	
	 /**
	 * Player takes a route to travel to an island with probability of random events
	 * @param route The chosen route to take
	 * @param destination The island the player wants to travel to
	 * @return The information about the event that occurred, if any
	 */
	public EventInfo setSail(Route route, Island destination) {
		int daysTaken = route.getDaysToTravel(selectedShip);
		int wagesCost = selectedShip.getCostToSail(daysTaken);
		
		// Deduct crew wages
		selectedShip.removeCoins(wagesCost);
		EventInfo eventInfo = new EventInfo(0, 0, new ArrayList<String>());
		
		int event;
		int pirates = 1;
		int weather = 2;
		int sailors = 3;
		
		// Generate a random number to see if an event occurs
		if ((int) (Math.random() * 100) <= route.getMultiplier()) {
			event = (int) (Math.random() * 3) + 1;
			if (event == pirates) {
				eventInfo = encounterPirates.pirateBattle(selectedShip);
			} else if (event == weather) {
				eventInfo = unfortunateWeather.storm(selectedShip);
			} else if (event == sailors) {
				eventInfo = rescueSailors.findSailors(selectedShip);
			}
		}
		// If the player survives the voyage
		if (eventInfo.getSailSuccess() == 0) {
			selectedShip.setLocation(destination);
			this.daysPlayed += daysTaken;
		}
		return eventInfo;
	}
	
	//getter
	/**
	 * Get maximum days to play
	 * @return days
	 */
	public int getMaxDays() {
		return this.maxDays;
	}
	
	//getter
	/**
	 * Get how many days having passed
	 * @return days
	 */
	public int getCurrDay() {
		return this.daysPlayed;
	}
	
	//getter
	/**
	 * Get the attack multiplier of the ship
	 * @return attack multiplier
	 */
	public int getAttackMultiplier() {
		return selectedShip.getAttackMultiplier();
	}
	
	//getter
	/**
	 * Get the name of the player
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	//getter
	/**
	 * Get the damage of the ship
	 * @return damage
	 */
	public int getShipDamage() {
		return selectedShip.getCurrentDamage();
	}
	
	//getter
	/**
	 * Get the repair cost for the ship
	 * @return repair cost
	 */
	public int getShipRepairCost() {
		return selectedShip.getRepairCost();
	}
	
	//getter
	/**
	 * Get the ship is being used
	 * @return ship
	 */
	public Ship getSelectedShip() {
		return this.selectedShip;
	}
	
	//getter
	/**
	 * Get the capacity has been used up in the ship
	 * @return current used capacity
	 */
	public int getCurrShipCapacity() {
		return selectedShip.getCurrCapacity();
	}
	
	//getter
	/**
	 * Get the maximum capacity on the ship
	 * @return maximum capacity
	 */
	public int getMaxShipCapacity() {
		return selectedShip.getMaxCapacity();
	}
	
	
 
} 
