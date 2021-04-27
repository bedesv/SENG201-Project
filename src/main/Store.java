package main;

import java.util.ArrayList;

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
	
	public void addItem(Item item) {
		itemsBought.add(new Item(item.getName(), item.getDescription(), item.getType(), item.getSize(), (item.getPrice() * boughtMultiplier)));
		itemsSold.add(new Item(item.getName(), item.getDescription(), item.getType(), item.getSize(), (item.getPrice() * soldMultiplier)));
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public static void main(String[] args) {
		Store Random = new Store("Random", 5);
		Item Banana = new Item("Banana", "A yummy fruit", "Food", 1, 5);
		Item Apple = new Item("Apple", "A round fruit", "Food", 1, 2);
		Item Orange = new Item("Orange", "An orange fruit", "Food", 1, 3);
		Item Pear = new Item("Pear", "A weird looking fruit", "Food", 1, 7);
		Random.itemsBought.add(Banana);
		Random.itemsBought.add(Orange);
		Random.itemsBought.add(Apple);
		Random.itemsBought.add(Pear);
		
		Random.viewItemsBought();
		
	}
}
