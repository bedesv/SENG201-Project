package main;

public class Item{
	private String itemName;
	private String itemDescription;
	private String itemType;
	private int itemSize;
	private int itemPrice;
	
	
	
	public Item(String name, String description, String type, int size, int price) {
		itemName = name;
		itemDescription = description;
		itemType = type;
		itemSize = size;
		itemPrice = price;
		
	}
	
	public String getName() {
		return itemName;
	}
	
	public int getPrice() {
		return itemPrice;
	}
	
	public String getType() {
		return itemType;
	}
	
	public int getSize() {
		return itemSize;
	}
	
	public String getDescription() {
		return itemDescription;
	}
	
	public String toString() {
		return String.format("Item: %s\nDescription: %s\nType: %s\nSize: %d\nPrice: %d", itemName, itemDescription, itemType, itemSize, itemPrice);
	}
	
	public static void main(String[] args) {
		Item Banana = new Item("Banana", "A yummy fruit", "Food", 1, 5);
		System.out.println(Banana.getName());
		System.out.println(Banana.getDescription());
		System.out.println(Banana.getSize());
		System.out.println(Banana.getPrice());
		System.out.println(Banana.getType());
		System.out.println(Banana);
	}
	
}
