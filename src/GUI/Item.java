package GUI;

/**
 * Items that are available to buy or sell by the player from/to a store when visiting the island
 * <br> Items includes food and weapons
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class Item{
	/** the name of the item */
	private String itemName;
	/** the description of the item */
	private String itemDescription;
	/** the type of the item: Food or Weapon */
	private String itemType;
	/** how much capacity the item takes */
	private int itemSize;
	/** the original price of the item */
	private int itemPrice;
	/** the price that the player has to pay to buy the item */
	private int itemPurchasedPrice;
	/** the price that the player receive when selling the item */
	private int itemSoldPrice;
	/** the isalnd on which the stire selling the item is based */
	private Island islandSoldOn;
	
	
	/**
	 * Constructor for an item
	 * @param name The name of the item
	 * @param description The description of the item
	 * @param type The type of the item, either Food or Weapon
	 * @param size the capacity the item takes
	 * @param price the original price of the item
	 */
	public Item(String name, String description, String type, int size, int price) {
		itemName = name;
		itemDescription = description;
		itemType = type;
		itemSize = size;
		itemPrice = price;
		
	}
	
	//getter
	/**
	 * Get the item's name
	 * @return item's name
	 */
	public String getName() {
		return itemName;
	}
	
	/**
	 * Create a new item
	 * @return new item
	 */
	public Item copy() {
		return new Item(this.getName(), this.getDescription(), this.getType(), this.getSize(), this.getPrice());
	}
	
	//getter
	/**
	 * Get the original price of the item
	 * @return item's price
	 */
	public int getPrice() {
		return itemPrice;
	}
	
	//getter
	/**
	 * Get the type of the item: Food or Weapon
	 * @return item's type
	 */
	public String getType() {
		return itemType;
	}
	
	//getter
	/**
	 * Get the size of the item (how much capacity it takes)
	 * @return item's size
	 */
	public int getSize() {
		return itemSize;
	}
	
	//getter
	/**
	 * Get the description of the item
	 * @return item's description
	 */
	public String getDescription() {
		return itemDescription;
	}
	
	/**
	 * Format a string of an Item object
	 * @return formated strind describing the item when the item object is called
	 */
	public String toString() {
		return String.format("\tItem: %s\n\tDescription: %s\n\tType: %s\n\tSize: %d\n\tPrice: %d", itemName, itemDescription, itemType, itemSize, itemPrice);
	}
	
	/**
	 * Player wants to increase coins or get rid of an item by selling it to 
	 * a store that will buy it
	 * @param island The island where the store is based
	 * @param price The price which the item was sold for by the player
	 */
	public void sellItem(Island island, int price) {
		this.islandSoldOn = island;
		this.itemSoldPrice = price;
	}
	
	//getter
	/**
	 * Get the price that a player has to pay to buy an item
	 * @return item's purchased price
	 */
	public int getPurchasedPrice() {
		return this.itemPurchasedPrice;
	}
	
	//getter
	/**
	 * Get the price that a player will sell an item to a store, 
	 * which is smaller than the purchased price
	 * @return item's sold price
	 */
	public int getSoldPrice() {
		return this.itemSoldPrice;
	}
	
	/**
	 * Player wants to buy an item from a store
	 * @param price The price that the item costs the player to buy the item
	 */
	public void buyItem(int price) {
		this.itemPurchasedPrice = price;
	}
	
	//getter
	/**
	 * Get the island where the item is sold from
	 * @return island
	 */
	public Island getIslandSoldOn() {
		return this.islandSoldOn;
	}
	
	/**
	 * Identify if the 2 items are identical or not
	 * @param item The other item that needs to be compared with
	 * @return true (if they are identical) or false (if they are different)
	 * 
	 */
	public boolean equals(Item item) {
		return item.getName().equals(this.getName());
	}
	
	
	
}
