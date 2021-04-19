package main;

import java.util.ArrayList;

public class GameEnvironment {
	private static ArrayList<Item> foodItems = new ArrayList<Item>();
	
	private static Store VelvetKnife = new Store("Velvet Knife", 10);
	private static Store EducatedMonkey = new Store("Educated Monkey", 15);
	private static Store ViciousKettle = new Store("Vicious Kettle", 20);
	private static Store JollyNut = new Store("Jolly Nut", 17);
	private static Store IronBear = new Store("Iron Bear", 13);
	
	
	public static void initItems() {
		foodItems.add(new Item("Banana", "A yummy fruit", "Food", 1, 5));
		foodItems.add(new Item("Apple", "A round fruit", "Food", 1, 2));
		foodItems.add(new Item("Orange", "An orange fruit", "Food", 1, 3));
		foodItems.add(new Item("Pear", "A weird looking fruit", "Food", 1, 7));
	}
	
	public static void initStores() {
		
		
		for (Item i:foodItems) {
			JollyNut.addItem(i);
		}
		
		
	}
	
	
	public void startGame() {
		// to do: call functions to set up islands, routes ...
		
		boolean gameCont = true;
		
		while (gameCont) {
			// options to play...
			
			// if pirates
				// gameCont = pirateBattle (func in Pirates)
		}
	}
	
	public void finishGame() {
		
	}

	
	
	public static void main(String[] args) {
		
		Item Banana = new Item("Banana", "A yummy fruit", "Food", 1, 10);
		Item Apple = new Item("Banana", "A round fruit", "Food", 4, 2);
		Ship Ship = new Ship("Ship", 4, 5);
		
		initItems();
		initStores();
		JollyNut.viewItemsBought();
		Ship.buyItem(Apple, 50);
		Ship.viewShipProperties();
		Ship.sellItem(Apple, 40);
		Ship.viewShipProperties();
		
		
		
	}
}
