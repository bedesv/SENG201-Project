package main;

import java.util.ArrayList;
public class GameEnvironment {
	private ArrayList<Item> foodItems = new ArrayList<Item>();
	
	private Store VelvetKnife = new Store("Velvet Knife", 10);
	private Store EducatedMonkey = new Store("Educated Monkey", 15);
	private Store ViciousKettle = new Store("Vicious Kettle", 20);
	private Store JollyNut = new Store("Jolly Nut", 17);
	private Store IronBear = new Store("Iron Bear", 13);
	
	
	public void initItems() {
		foodItems.add(new Item("Banana", "A yummy fruit", "Food", 1, 5));
		foodItems.add(new Item("Apple", "A round fruit", "Food", 1, 2));
		foodItems.add(new Item("Orange", "An orange fruit", "Food", 1, 3));
		foodItems.add(new Item("Pear", "A weird looking fruit", "Food", 1, 7));
	}
	
	public void initStores() {
		
		
		for (Item i:foodItems) {
			VelvetKnife.addItem(i);
		}
		
		
	}
	
	public void main(String[] args) {
		
		initItems();
		initStores();
		VelvetKnife.viewItemsBought();
	}
}
