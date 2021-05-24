package gui;

import java.util.ArrayList;

public class Player { 

	private Ship selectedShip;
	private String name;
	private int maxDays;
	private int daysPlayed=0;
	private boolean unlimitedDays;
	
	/** event of encountering pirates */
	private Pirates encounterPirates = new Pirates();
	/** event of a storm occurring on sail */
	private Weather unfortunateWeather = new Weather();
	/** event of rescuing another sailor */
	private RescueSailors rescueSailors = new RescueSailors();
	
	 
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
	
	public int getCoins() {
		return selectedShip.getCoins();
	}
	
	public void repairShip() {
		selectedShip.repairShip();
	}
	
	public String getShipCapacity() {
		return selectedShip.getCurrCapacity() + "/" + selectedShip.getMaxCapacity();
	}
	
	/**
	 * Check if the player can afford to buy and store the item
	 * @param item The item that the player wants to buy
	 * @param price the price of the item
	 * @return true (if yes) or false (otherwise)
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
	 * @param item The weapon that the player wants to buy
	 * @param price the price of the weapon
	 * @return true (if yes) or false (otherwise)
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
	
	public boolean unlimitedDays() {
		return this.unlimitedDays;
	}
	
	public int getInventoryValue() {
		return selectedShip.inventoryValue();
	}
	
	public Island getCurrLocation() {
		return selectedShip.getLocation();
	}
	
	/**
	 * Check if the player can afford to travel a route
	 * @param route The route that the player chooses
	 * @param player The player
	 * @return true (if the player can use the route) or false (otherwise)
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
	 * @return
	 */
	public EventInfo setSail(Route route, Island destination) {
		int daysTaken = route.getDaysToTravel(selectedShip);
		int wagesCost = selectedShip.getCostToSail(daysTaken);
		
		selectedShip.removeCoins(wagesCost);
		EventInfo eventInfo = new EventInfo(0, 0, new ArrayList<String>());
		
		int event;
		int pirates = 1;
		int weather = 2;
		int sailors = 3;

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
		if (eventInfo.getSailSuccess() == 0) {
			selectedShip.setLocation(destination);
			this.daysPlayed += daysTaken;
		}
		return eventInfo;
	}
	
	public int getMaxDays() {
		return this.maxDays;
	}
	
	public int getCurrDay() {
		return this.daysPlayed;
	}
	
	public int getAttackMultiplier() {
		return selectedShip.getAttackMultiplier();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getShipDamage() {
		return selectedShip.getCurrentDamage();
	}
	
	public int getShipRepairCost() {
		return selectedShip.getRepairCost();
	}
	
	public Ship getSelectedShip() {
		return this.selectedShip;
	}
	
	public int getCurrShipCapacity() {
		return selectedShip.getCurrCapacity();
	}
	
	public int getMaxShipCapacity() {
		return selectedShip.getMaxCapacity();
	}
	
	
 
} 
