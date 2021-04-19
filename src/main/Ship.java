package main;

import java.util.ArrayList;

public class Ship {
	private String shipName;
	private int shipCrew;
	private int maxCapacity;
	private int currCapacity=0;
	private int shipDamage;
	private Island Location;
	private int coins=1000;
	private ArrayList<Item> shipInventory = new ArrayList<Item>();
	
	public Ship(String name, int crew, int capacity) {
		shipCrew = crew;
		shipName = name;
		maxCapacity = capacity;
	}
	
	public void repairShip() {
		if (coins < (shipDamage * 10)) {
			throw new InsufficientCoinsException("Not enough coins to repair ship, sell some items to get more.");
		} else {
			coins -= shipDamage * 10;
			shipDamage = 0;
			System.out.println("Ship repaired successfully");
		}
	}
	
	public void viewInventory() {
		System.out.println("Items in Inventory:\n");
		for (Item i : shipInventory) {
			System.out.println(String.format("%s\n", i));
		}
		System.out.println(String.format("Inventory is %.0f%% full (%d/%d slots full)", (double)(currCapacity*100/maxCapacity), currCapacity, maxCapacity));
	}
	
	public void viewShipProperties() {
		System.out.println(shipName + " Properties:\n");
		this.viewInventory();
		System.out.println();
		System.out.println("Damage: " + shipDamage);
		System.out.println("Crew: " + shipCrew);
		//System.out.println("Current Location: " + Location.getName());
		System.out.println("Coins: " + coins);
		System.out.println();
	}
	
	public void buyItem(Item item, int price) {
		if (coins < price) {
			throw new InsufficientCoinsException("Not enough coins to buy " + item.getName() + ", sell some items to get more.");
		} else {
			coins -= price;
			shipInventory.add(item);
			currCapacity += item.getSize();
			System.out.println(item.getName() + " purchased successfully\n");
		}
	}
	
	public boolean removeItem(Item item) {
		for (Item i:shipInventory) {
			if (item.equals(i)) {
				shipInventory.remove(i);
				currCapacity -= item.getSize();
				return true;
			}
		}
		return false;
	}
	
	public void sellItem(Item item, int price) {
		if (this.removeItem(item)) {
			coins += price;
			System.out.println(item.getName() + " sold successfully\n");
		} else {
			throw new ItemNotOwnedException(item.getName() + " not in inventory.");
		}
	}
	
	public static void main(String[] args) {
		Ship ship = new Ship("Ship", 4, 5);
		ship.currCapacity = 4;
		ship.viewShipProperties();
	}
	
}
