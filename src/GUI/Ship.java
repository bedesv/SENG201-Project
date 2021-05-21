package GUI;

import java.util.*;



/**
 * 
 * @author haianh
 *
 */

public class Ship {
	private String shipName;
	private int shipCrew;
	private int maxCapacity;
	private int currCapacity=0;
	private int shipDamage;
	private Island Location;
	private int coins=1000;
	private int attackMultiplier;
	private int damageMultiplier;
	private ArrayList<Item> shipInventory = new ArrayList<Item>();
	private ArrayList<Weapon> shipWeapons = new ArrayList<Weapon>();
	private ArrayList<Item> soldItems = new ArrayList<Item>();
	private ArrayList<Weapon> soldWeapons = new ArrayList<Weapon>();
	private int shipSpeed;
	private int costPerCrew = 50;
	private int daysPlayed = 0;
	
	private Pirates encounterPirates = new Pirates();
	private Weather unfortunateWeather = new Weather();
	private RescueSailors rescueSailors = new RescueSailors();
	
	/**
	 * 
	 * @param name 
	 * @param crew
	 * @param capacity
	 * @param attack
	 * @param damage
	 * @param speed
	 */
	public Ship(String name, int crew, int capacity, int attack, int damage, int speed) {
		shipCrew = crew;
		shipName = name;
		maxCapacity = capacity;
		attackMultiplier = attack;
		damageMultiplier = damage;
		shipSpeed = speed;	
	}
	
	public void repairShip(Scanner input) {
		if (coins < (shipDamage * 10)) {
			this.printCoins();
			System.out.println("Coins required for repairs: " + 10 * this.shipDamage + " coins.");
		} else {
			this.printCoins();
			System.out.println("Ship repairs will cost " + (shipDamage * 10) + " coins, do you want to proceed with repairs? y/n");
			char answer =  'p';
			answer = input.next().charAt(0);

			while (answer != 'y' && answer != 'n') {
					
				System.out.println("Please enter a valid answer (y/n).");
				answer = input.next().charAt(0);
			}
			if (answer == 'y') {
				coins -= shipDamage * 10;
				shipDamage = 0;
				System.out.println("Ship repaired successfully");
				this.printCoins();
			}
		}
	}
	
	public int getCoins() {
		return coins;
	}
	
	public int getSpeed() {
		return shipSpeed;
	}
	
	public void setLocation(Island location) {
		this.Location = location;
	}
	
	public Island getLocation() {
		return this.Location;
	}
	
	public void takeDamage(int damage) {
		this.shipDamage += damage;
	}
	
	public int getCurrCapacity() {
		return this.currCapacity;
	}
	
	public int getMaxCapacity() {
		return this.maxCapacity;
	}
	
	public void viewInventory() {
		System.out.println("Items in Inventory:\n");
		for (Item i : shipInventory) {
			System.out.println(String.format("%s\n", i));
		}
		System.out.println(String.format("Inventory is %.0f%% full (%d/%d slots full)", (double)(currCapacity*100/maxCapacity), currCapacity, maxCapacity));
	}
	
	public ArrayList<Item> getInventory() {
		return this.shipInventory;
	}
	
	public ArrayList<Weapon> getWeapons() {
		return this.shipWeapons;
	}
	
	public int inventoryTotal() {
		int sum = 0;
		for (Item i:this.shipInventory) {
			sum += i.getPrice();
		}
		return sum;
	}
	
	public boolean inventoryContains(Item i) {
		
		for (Item j: this.shipInventory) {
			if (j.equals(i)) {
				return true;
			}
		}
		return false;
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
			attackMultiplier += weapon.getMultChanged();
			System.out.println(weapon.getName() + " purchased successfully\n");
			this.printCoins();
		}
	}
	
	public void sellWeapon(Weapon weapon, int price) {
		weapon = this.removeWeapon(weapon);
		weapon.sellItem(Location, price);
		soldWeapons.add(weapon);
		coins += price;
		attackMultiplier -= weapon.getMultChanged();
		System.out.println(weapon.getName() + " sold successfully\n");
		this.printCoins();
	}
	
	public Weapon removeWeapon(Weapon weapon) {
		Weapon j = weapon;
		for (Weapon i:shipWeapons) {
			if (weapon.equals(i)) {
				
				j = i;
				currCapacity -= i.getSize();
			}
		}
		shipWeapons.remove(j);
		return j;
	}
	
	public Item removeItem(Item item) {
		Item j = item;
		for (Item i:shipInventory) {
			if (item.equals(i)) {
				
				j = i;
				currCapacity -= i.getSize();
			}
		}
		shipInventory.remove(j);
		return j;
	}
	
	public void sellItem(Item item, int price) {
		item = this.removeItem(item);
		item.sellItem(Location, price);
		soldItems.add(item);
		coins += price;
		System.out.println(item.getName() + " sold successfully\n");
		this.printCoins();

	}
	
	public void viewPurchasedItems() {
		System.out.println("Items currently in inventory:");
		for (Item i: this.shipInventory) {
			System.out.println("\tItem: " + i.getName());
			System.out.println("\tPurchased for: " + i.getPurchasedPrice() + " coins");
			System.out.println();
		}
		System.out.println();
		
		System.out.println("Items that have been sold:");
		for (Item j: this.soldItems) {
			System.out.println("\tItem: " + j.getName());
			System.out.println("\tPurchased for: " + j.getPurchasedPrice() + " coins");
			System.out.println("\tSold for: " + j.getSoldPrice() + " coins");
			System.out.println("\tSold at: The " + j.getIslandSoldOn().getStore().getStoreName() + " on " + j.getIslandSoldOn().getName());
			System.out.println();
		}
		System.out.println();
	}
	
	public Item getItem(Item i) {
		for (Item j: shipInventory) {
			if (i.equals(j)) {
				return j;
			}
		}
		return i;
	}
	
	public int getDamageMultiplier() {
		return damageMultiplier;
	}
	
	public int getAttackMultiplier() {
		return attackMultiplier;
	}
	
	public String getName() {
		return shipName;
	}
	
	public void addCoins(int coin) {
		this.coins += coin;
	}
	
	public void printCoins() {
		System.out.println("Current coin balance: " + this.coins + " coins.");
	}
	
	public void clearInventory() {
		this.shipInventory.clear();
	}
	
	public boolean travel(Scanner input, ArrayList<Island> islands) {
		ArrayList<Island> destinations = new ArrayList<Island>();
		for (Island i:islands) {
			if (i != this.Location) {
				destinations.add(i);
			}
		}
		int index;
		int selectedIsland = 0;
		int selectedRoute = 0;
		char answer = 'p';
		boolean gameCont = true;
		
		index = 1;
		System.out.println("Select an island to travel to:");
		for (Island i:destinations) {
			System.out.println(index++ + ": " + i.getName());
		}
		System.out.println(index + ": " + "Cancel");
		
		selectIsland:
			while (selectedIsland != 5) {
				
				
				
				selectedIsland = input.nextInt();
				
				while (selectedIsland < 1 || selectedIsland > index) {
					System.out.println("Error: Invalid selection.");
					selectedIsland = input.nextInt();
				}	
				if (selectedIsland == 5) {
					break selectIsland;
				}
				
				
				System.out.println("Are you sure you want to travel to " + destinations.get(selectedIsland-1).getName() + "? y/n");
				
				
				answer = input.next().charAt(0);
				while (answer != 'y' && answer != 'n') {
				
					System.out.println("Please enter a valid answer (y/n).");
					answer = input.next().charAt(0);
				}
				if (answer == 'n') {
					index = 1;
					System.out.println("Select an island to travel to:");
					for (Island i:destinations) {
						System.out.println(index++ + ": " + i.getName());
					}
					System.out.println(index + ": " + "Cancel");
				} else {
					ArrayList<Route> possibleRoutes = this.Location.getRoutes(destinations.get(selectedIsland-1));
					index = 1;
					
					System.out.println("Select a route to take:");
					for (Route r: possibleRoutes) {
						r.getDescriptionNumbered(this.Location.getName(), index++);
					}
					System.out.println(index + " Cancel");
					
					selectedRoute = 0;
					answer = 'p';
					selectRoute:
						while (selectedRoute != 3) {
							selectedRoute = input.nextInt();
							while (selectedRoute < 1 || selectedRoute > index) {
								System.out.println("Error: Invalid selection.");
								selectedRoute = input.nextInt();
							}	
							if (selectedRoute == 3) {
								index = 1;
								System.out.println("Select an island to travel to:");
								for (Island i:destinations) {
									System.out.println(index++ + ": " + i.getName());
								}
								System.out.println(index + ": " + "Cancel");
								break selectRoute;
							}
							this.printCoins();
							System.out.println("Travelling along " + possibleRoutes.get(selectedRoute-1).getName() + " will take " + possibleRoutes.get(selectedRoute-1).getDays(this) + " days and your crews wages will cost " + possibleRoutes.get(selectedRoute-1).getDays(this) * this.costPerCrew * this.shipCrew + " coins.");
							System.out.println("Are you sure you want to travel via " + possibleRoutes.get(selectedRoute-1).getName() + "? y/n");
							
							
							answer = input.next().charAt(0);
							while (answer != 'y' && answer != 'n') {
							
								System.out.println("Please enter a valid answer (y/n).");
								answer = input.next().charAt(0);
							}
							if (answer == 'y' && possibleRoutes.get(selectedRoute-1).getDays(this) * this.costPerCrew * this.shipCrew <= this.coins) {
								gameCont = this.useRoute(possibleRoutes.get(selectedRoute-1), destinations.get(selectedIsland-1));
								break selectIsland;
								
							} else {
								if (possibleRoutes.get(selectedRoute-1).getDays(this) * this.costPerCrew * this.shipCrew > this.coins) {
									System.out.println("You don't have enough coins to take this route. Select a different one or sell some items to get more coins.\n");
								}
								index = 1;
								System.out.println("Select a route to take:");
								for (Route r: possibleRoutes) {
									r.getDescriptionNumbered(this.Location.getName(), index++);
								}
								System.out.println(index + " Cancel");
								
							}
						}
				}
			}
		return gameCont;
		
	}
	
	public boolean useRoute(Route route, Island destination) {
		Island oldLocation = this.Location;
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
			this.Location = destination;
		}
		return gameCont;
		
	}
	
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
	
	public int getDays() {
		return this.daysPlayed;
	}
	
	public static void main(String[] args) {
		
	}
	
}