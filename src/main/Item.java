package main;

public class Item{
	private String itemName;
	private String itemDescription;
	private String itemType;
	private int itemSize;
	private int itemPrice;
	private int itemPurchasedPrice;
	private int itemSoldPrice;
	private Island islandSoldOn;
	
	
	
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
	
	public Item copy() {
		return new Item(this.getName(), this.getDescription(), this.getType(), this.getSize(), this.getPrice());
	}
	
	public int getPrice() {
		return itemPrice;
	}
	
	public void updatePrice(int price) {
		this.itemPrice = price;
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
		return String.format("\tItem: %s\n\tDescription: %s\n\tType: %s\n\tSize: %d\n\tPrice: %d", itemName, itemDescription, itemType, itemSize, itemPrice);
	}
	
	public void sellItem(Island island, int price) {
		this.islandSoldOn = island;
		this.itemSoldPrice = price;
	}
	
	public int getPurchasedPrice() {
		return this.itemPurchasedPrice;
	}
	
	public int getSoldPrice() {
		return this.itemSoldPrice;
	}
	
	public void buyItem(int price) {
		this.itemPurchasedPrice = price;
	}
	
	public Island getIslandSoldOn() {
		return this.islandSoldOn;
	}
	
	public boolean equals(Item item) {
		return item.getName().equals(this.getName());
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
