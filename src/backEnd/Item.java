package backEnd;

/**
 * Items that are available to buy or sell by the player from/to a store when visiting the island
 * <br> Items includes food and weapons
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class Item{
	/** The name of the item */
	private String itemName;
	/** The description of the item */
	private String itemDescription;
	/** The type of the item */
	private String itemType;
	/** The inventory space the item takes up */
	private int itemSize;
	/** The price of the item */
	private int itemPrice;
	/** The price that the player paid to buy the item */
	private int itemPurchasedPrice;
	/** The price that the player received when they sold the item */
	private int itemSoldPrice;
	/** The island on which the player sold the item */
	private Island islandSoldOn;
	
	/**
	 * Constructor for an item
	 * Constructs an empty item
	 */
	public Item() {
	}
	
	
	/**
	 * Constructor for an item
	 * @param name The name of the item
	 * @param description The description of the item
	 * @param type The type of the item, Food, Weapon, Jewellery or Special
	 * @param size The inventory space the item takes up
	 * @param price The price of the item
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
	 * @return The item's name
	 */
	public String getName() {
		return itemName;
	}
	
	/**
	 * Create a new copy of the item
	 * @return A copy of the item
	 */
	public Item copy() {
		return new Item(this.getName(), this.getDescription(), this.getType(), this.getSize(), this.getPrice());
	}
	
	//getter
	/**
	 * Get the original price of the item
	 * @return The item's price
	 */
	public int getPrice() {
		return itemPrice;
	}
	
	//getter
	/**
	 * Get the type of the item
	 * @return The item's type
	 */
	public String getType() {
		return itemType;
	}
	
	//getter
	/**
	 * Get the size of the item (how much inventory space it takes up)
	 * @return The item's size
	 */
	public int getSize() {
		return itemSize;
	}
	
	//getter
	/**
	 * Get the description of the item
	 * @return The item's description
	 */
	public String getDescription() {
		return itemDescription;
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
	 * Get the price that the player paid for the item
	 * @return item's purchased price
	 */
	public int getPurchasedPrice() {
		return this.itemPurchasedPrice;
	}
	
	//getter
	/**
	 * Get the price that the player sold the item for
	 * @return item's sold price
	 */
	public int getSoldPrice() {
		return this.itemSoldPrice;
	}
	
	/**
	 * Saves the price the player paid for the item
	 * @param price The price that the player paid for the item
	 */
	public void buyItem(int price) {
		this.itemPurchasedPrice = price;
	}
	
	//getter
	/**
	 * Get the island the item was sold on
	 * @return island
	 */
	public Island getIslandSoldOn() {
		return this.islandSoldOn;
	}
	
	/**
	 * Identify if the 2 items are equal or not
	 * @param item The other item that needs to be compared with
	 * @return true (if they are equal) or false (if they are different)
	 * 
	 */
	public boolean equals(Item item) {
		return item.getName().equals(this.getName());
	}
	
	
	
}
