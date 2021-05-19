package main;

import java.util.*;

public class Store {
	private String storeName;
	private ArrayList<Item> itemsBought = new ArrayList<Item>();
	private ArrayList<Item> itemsSold = new ArrayList<Item>();
	private int boughtMultiplier;
	private int soldMultiplier;
	
	public Store(String name, int multiplier) {
		storeName = name;
		boughtMultiplier = multiplier - 2;
		soldMultiplier = multiplier;
	}
	
	public void viewItemsBought() {
		System.out.println(String.format("Items bought at %s:\n", storeName));
		for (Item i : itemsBought) {
			System.out.println(String.format("%s\n", i));
		}
	}
	public void viewItemsSold() {
		System.out.println(String.format("Items sold at %s:\n", storeName));
		for (Item i : itemsSold) {
			System.out.println(String.format("%s\n", i));
		}
	}
	
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
	
	public boolean buysItem(Item i) {
		
		for (Item j: this.itemsBought) {
			if (j.equals(i)) {
				return true;
			}
		}
		return false;
	}
	
	public void addItem(Item item) {
		itemsBought.add(new Item(item.getName(), item.getDescription(), item.getType(), item.getSize(), (item.getPrice() * boughtMultiplier)));
		itemsSold.add(new Item(item.getName(), item.getDescription(), item.getType(), item.getSize(), (item.getPrice() * soldMultiplier)));
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public int getPurchasePrice(Item i) {
		for (Item j: this.itemsSold) {
			if (i.equals(j)) {
				return j.getPrice();
			}
		}
		return 0;
	}
	
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
			
			if (selectedActivity == 1) {
				System.out.println("Select an item to purchase from the following:");
				index = 1;
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
			} else if (selectedActivity == 2) {
				ArrayList<Item> itemsInCommon = new ArrayList<Item>();
				for (Item i:ship.getInventory()) {
					if (this.buysItem(i)) {
						itemsInCommon.add(new Item(i.getName(), i.getDescription(), i.getType(), i.getSize(), this.getPurchasePrice(i))); 
					}
				}
				if (itemsInCommon.size() > 0) {
					System.out.println("Select an item to sell from the following:");
					index = 1;
					selectedItem = 0;
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
					
				} else {
					System.out.println("Error: You don't have any items to sell.");
					System.out.println();
				}
			}
		}
		
		
	}
	
}
