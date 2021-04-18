package main;

public class Ship {
	private String shipName;
	private int shipCrew;
	private int maxCapacity;
	private int currCapacity=0;
	private int shipDamage;
	private location Island;
	private int coins=1000;
	
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
			System.out.println("Ship repaired successfully");
		}
	}
	
	public void
}
