package GUI;

import java.util.*;

/**
 * Store is a place to trade good for player
 * <br> There are 5 stores in total, each is situated in a unique island
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
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
	 * @param name The name of the store
	 * @param multiplier The price of the item or weapon when sold by the store will be multiplied with this
	 */
	public Store(String name, int multiplier) {
		storeName = name;
		boughtMultiplier = multiplier - 2;
		soldMultiplier = multiplier;
	}
	
	/**
	 * To see what items the store will buy
	 */
	public void viewItemsBought() {
		System.out.println(String.format("Items bought at %s:\n", storeName));
		for (Item i : itemsBought) {
			System.out.println(String.format("%s\n", i));
		}
	}
	
	/**
	 * To see what items the store will sell
	 */
	public void viewItemsSold() {
		System.out.println(String.format("Items sold at %s:\n", storeName));
		for (Item i : itemsSold) {
			System.out.println(String.format("%s\n", i));
		}
	}
	
	/**
	 * To string method that will show what the store sells or buys
	 * @return the message of the store's property
	 */
	public String toString() {
		String mess = "Items bought at " + storeName + ": \n";
		for (Item i : itemsBought) {
			mess += String.format("%s\n", i);
		}
		mess += String.format("Items sold at %s:\n", storeName);
		for (Item i : itemsSold) {
			mess += String.format("%s\n", i);
		}
		return mess;
		
	}
	
	/**
	 * Check if store can buy an item from the player
	 * @param i The item that th eplayer wants to sell to the store
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
	 * Check if store can buy an weapon from the player
	 * @param w The weapon that th eplayer wants to sell to the store
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
	 * Set all the items that can be bought by the store
	 * @return item list that the store can buy
	 */
	public ArrayList<Item> getItemsBought() {
		return this.itemsBought;
	}
	
	//getter
	/**
	 * Set all the items that can be sold by the store
	 * @return item list that the store can sell
	 */
	public ArrayList<Item> getItemsSold() {
		return this.itemsSold;
	}
	
	//getter
	/**
	 * Set all the weapons that can be bought by the store
	 * @return weapon list that the store can buy
	 */
	public ArrayList<Weapon> getWeaponsBought() {
		return this.weaponsBought;
	}
	
	//getter
	/**
	 * Set all the weapons that can be sold by the store
	 * @return weapon list that the store can sell
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
	 * Add a weapon to the store when it is bought by the store
	 * @param weapon The weapon that the store bought
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
	 * @param i
	 * @return
	 */
	public int getPurchasePrice(Item i) {
		for (Item j: this.itemsSold) {
			if (i.equals(j)) {
				return j.getPrice();
			}
		}
		return 0;
	}
	
	//getter
	/**
	 * Get the price that the store has to pay when the player sell to the store
	 * @param i The item/ weapon that is traded
	 * @return the price
	 */
	public int getSalePrice(Item i) {
		if (i.getType() == "Weapon") {
			for (Weapon j: this.weaponsBought) {
				if (i.equals(j)) {
					return j.getPrice();
				}
			}
			return 0;
		} else {
			for (Item j: this.itemsBought) {
				if (i.equals(j)) {
					return j.getPrice();
				}
			}
			return 0;
		}
	}
	
	
	/**
	 * The player wants to go to the store
	 * @param input What the player types in
	 * @param ship The ship that the player is using
	 */
	public void enterStore(Scanner input, Ship ship) {
		int selectedActivity = 0;
		int selectedItem;
		char answer = 'p';
		int index;
		while (selectedActivity != 3) {
			System.out.println("Welcome to The " + this.getStoreName());
			System.out.println("Select an option from the following:");
			System.out.println("1: View items to buy");
			System.out.println("2: View items to sell");
			System.out.println("3: Exit store");
			selectedActivity = input.nextInt();
			while (selectedActivity < 1 || selectedActivity > 3) {
				System.out.println("Error: Invalid selection.");
				selectedActivity = input.nextInt();
			}
			// player wants to buy an item
			if (selectedActivity == 1) {
				System.out.println("Select an item to purchase from the following:");
				index = 1;
				// list all the items that are sold in the store
				for (Item i: this.itemsSold) {
					System.out.println(String.format("%d %s\n", index++, i));
				}
				System.out.println(String.format("%d 	Cancel", index++));
				
				answer = 'p';
				selectedItem = 0;
				
				while (answer != 'y') {
					selectedItem = input.nextInt();
			
					while (selectedItem < 1 || selectedItem > index) {
						System.out.println("Error: Invalid selection.");
						selectedItem = input.nextInt();
					}	
					if (selectedItem == index - 1) {
						break;
					}
					ship.printCoins();
					System.out.println("Are you sure you want to buy a " + itemsSold.get(selectedItem-1).getName() + " for " + itemsSold.get(selectedItem-1).getPrice() + " coins? y/n");
					// asking for confirmation of player buying an item
					answer = input.next().charAt(0);
					while (answer != 'y' && answer != 'n') {
						System.out.println("Please enter a valid answer (y/n).");
						answer = input.next().charAt(0);
					}
					if (answer == 'n') {
						System.out.println("Select an item to buy from the following:");
						index = 1;
						for (Item i:itemsSold) {
							System.out.println(String.format("%d %s\n", index++, i));
						}
						System.out.println(String.format("%d	Cancel", index++));
					}
				}
				if (selectedItem != index - 1) {
					ship.buyItem(itemsSold.get(selectedItem-1), itemsSold.get(selectedItem-1).getPrice());
				}
			// player wants to sell to the store
			} else if (selectedActivity == 2) {
				// get a list of items that the player has
				ArrayList<Item> itemsInCommon = new ArrayList<Item>();
				for (Item i:ship.getInventory()) {
					if (this.buysItem(i)) {
						itemsInCommon.add(new Item(i.getName(), i.getDescription(), i.getType(), i.getSize(), this.getPurchasePrice(i))); 
					}
				}
				// if player has inventory to sell
				if (itemsInCommon.size() > 0) {
					System.out.println("Select an item to sell from the following:");
					index = 1;
					selectedItem = 0;
					// list all the sellable items by the player
					for (Item i:itemsInCommon) {
						System.out.println(String.format("%d %s\n", index++, i));
					}
					System.out.println(String.format("%d 	Cancel", index++));
					answer = 'p';
					while (answer != 'y') {
						selectedItem = input.nextInt();
						while (selectedItem < 1 || selectedItem > index) {
							System.out.println("Error: Invalid selection.");
							selectedItem = input.nextInt();
						}	
						if (selectedItem == index - 1) {
							break;
						}
						ship.printCoins();
						// ask for permission to sell an item
						System.out.println("Are you sure you want to sell a " + itemsInCommon.get(selectedItem-1).getName() + " for " + itemsInCommon.get(selectedItem-1).getPrice() + " coins? y/n");
						answer = input.next().charAt(0);
						while (answer != 'y' && answer != 'n') {
							System.out.println("Please enter a valid answer (y/n).");
							answer = input.next().charAt(0);
						}
						if (answer == 'n') {
							System.out.println("Select an item to sell from the following:");
							index = 1;
							for (Item i:itemsInCommon) {
								System.out.println(String.format("%d %s\n", index++, i));
						
							}
							System.out.println(String.format("%d	Cancel", index++));
						}
					}
					if (selectedItem != index - 1) {
						ship.sellItem(ship.getItem(itemsInCommon.get(selectedItem-1)), itemsInCommon.get(selectedItem-1).getPrice());
					}
				// if the player does not own any good	
				} else {
					System.out.println("Error: You don't have any items to sell.");
					System.out.println();
				}
			}
		}
	}
}
