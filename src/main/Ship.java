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
		
	}
	
	public static void main(String[] args) {
		Ship ship = new Ship("ship", 4, 5);
		ship.currCapacity = 4;
		ship.viewShipProperties();
	}
	
}
