package backEnd;

import java.util.ArrayList;

import gui.*;

/**
 * Where the game happens
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class Game {
	/** The list of normal items */
	private ArrayList<Item> items = new ArrayList<Item>(); 
	/** The list of weapons */
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	/** The list of ships */
	private ArrayList<Ship> ships = new ArrayList<Ship>(); 
	/** The list of island */
	private ArrayList<Island> islands = new ArrayList<Island>(); 
	/** The list of stores */
	private ArrayList<Store> stores = new ArrayList<Store>();
	/** The list of special items */
	private ArrayList<Item> specialItems = new ArrayList<Item>();
	/** The player who controls the game */
	private Player player;
	/** The screen that displays the store */
	private StoreWindow storeWindow;
	/** The screen that allows the player to initiate their game, only opens once at the start */
	private SetupWindow setupWindow;
	/** The screen that displays the main menu of actions for the player to choose from */
	private MainMenuWindow mainMenuWindow;
	/** The screen that displays the inventory of the ship */
	private InventoryWindow inventoryWindow;
	/** The screen that allows the player to sail from one island to the other */
	private SetSailWindow setSailWindow;
	/** The screen that displays the secret menu to adjust the ship's property for testing */
	private SecretMenuWindow secretMenuWindow;
	/** The screen that displays the ship's information */
	private ShipInformationWindow shipInformationWindow;
	/** The screen that displays the islands' information */
	private IslandInformationWindow islandInformationWindow;
	/** The name of the player */
	public static String name = "";
	/** The index number for home island */
	public static int home = -1;
	/**
	 * To create all and add all the possible ships to the array
	 */
	private void initShips() {
		// Create Ships
		Ship Delight = new Ship("Delight", 8, 100, 12, 8, 4, "/Images/Delight.jpg"); 
		Ship Defender = new Ship("Defender", 13, 130, 6, 18, 3, "/Images/Defender.jpg"); 
		Ship Mantis = new Ship("Mantis", 12, 110, 17, 5, 4, "/Images/Mantis.jpg"); 
		Ship Pioneer = new Ship("Pioneer", 12, 80, 10, 10, 5, "/Images/Pioneer.jpg");
		
		ships.add(Pioneer);
		ships.add(Defender);
		ships.add(Delight);
		ships.add(Mantis);
	}
	
	/**
	 * To get all the islands, routes and stores ready for the game
	 */
	private void initGame() {

		//create stores 
		Store VelvetKnife = new Store("Velvet Knife", 10); 
		Store EducatedMonkey = new Store("Educated Monkey", 15); 
		Store ViciousKettle = new Store("Vicious Kettle", 20); 
		Store JollyNut = new Store("Jolly Nut", 17); 
		Store IronBear = new Store("Iron Bear", 13); 
		
		//add store to the array
		stores.add(VelvetKnife);
		stores.add(IronBear);
		stores.add(EducatedMonkey);
		stores.add(JollyNut);
		stores.add(ViciousKettle);
		 
		 
		//create islands 
		Island RemoteRefuge = new Island("Remote Refuge", VelvetKnife); 
		Island RainingArchipelago = new Island("Raining Archipelago", EducatedMonkey); 
		Island BrightwichIsland = new Island("Brightwich Island", ViciousKettle); 
		Island CrosserPeninsula = new Island("Crosser Peninsula", JollyNut); 
		Island ArborlandIslet = new Island("Arborland Islet", IronBear); 
		
		//create routes 
		//Route(int distance, Island island1, Island island2, String description, int eventMultiplier) 
		
		Route AridTrail = new Route(25, RemoteRefuge, RainingArchipelago, "Arid Trail", 20); 
		Route DragonfireRoute = new Route(10, RemoteRefuge, RainingArchipelago, "Dragonfire Route", 60); 
		Route TrepidationPass = new Route(35, RemoteRefuge, BrightwichIsland, "Trepidation Pass", 30); 
		Route TheGlisteningDeep = new Route(20, RemoteRefuge, BrightwichIsland, "The Glistening Deep", 70); 
		Route TerrenrontoWaters = new Route(35, RemoteRefuge, CrosserPeninsula, "Terrenronto Waters", 50); 
		Route SalfilWaters = new Route(45, RemoteRefuge, CrosserPeninsula, "Salfil Waters", 20); 
		Route TheBurstingWaves = new Route(15, RemoteRefuge, ArborlandIslet, "The Bursting Waves", 40); 
		Route TheEmptyBay = new Route(20, RemoteRefuge, ArborlandIslet, "The Empty Bay", 10); 
		 
		Route ChillwaterSea = new Route(10, RainingArchipelago, BrightwichIsland, "Chillwater Sea", 30); 
		Route TheDarkestDepths = new Route(5, RainingArchipelago, BrightwichIsland, "The Darkest Depths", 80); 
		Route CartvonsBay = new Route(30, RainingArchipelago, CrosserPeninsula, "Cartvons Bay", 20); 
		Route TheTroubledOcean = new Route(25, RainingArchipelago, CrosserPeninsula, "The Troubled Ocean", 35); 
		Route TheNarrowGulf = new Route(25, RainingArchipelago, ArborlandIslet, "The Narrow Gulf", 20); 
		Route TheOceanOfWoodbourg = new Route(15, RainingArchipelago, ArborlandIslet, "The Ocean of Woodbourg", 40); 
		 
		Route TheSunnyDomain = new Route(35, BrightwichIsland, CrosserPeninsula, "The Sunny Domain", 40); 
		Route TheDarkOcean = new Route(30, BrightwichIsland, CrosserPeninsula, "The Dark Ocean", 50); 
		Route TheCoralOcean = new Route(30, BrightwichIsland, ArborlandIslet, "The Coral Ocean", 50); 
		Route TheHungryDepths = new Route(25, BrightwichIsland, ArborlandIslet, "The Hungry Depths", 65); 
		 
		Route TheWastingBay = new Route(50, CrosserPeninsula, ArborlandIslet, "The Wasting Bay", 40); 
		Route TheGraveSea = new Route(20, CrosserPeninsula, ArborlandIslet, "The Grave Sea", 100); 
		
		// Add Islands to array
		islands.add(ArborlandIslet);
		islands.add(CrosserPeninsula);
		islands.add(RainingArchipelago);
		islands.add(RemoteRefuge);
		islands.add(BrightwichIsland); 
		
		// add routes to islands' array list of routes
		
		//RemoteRefuge's routes
		RemoteRefuge.addRoute(AridTrail); 
		RemoteRefuge.addRoute(DragonfireRoute); 
		RemoteRefuge.addRoute(TrepidationPass); 
		RemoteRefuge.addRoute(TheGlisteningDeep); 
		RemoteRefuge.addRoute(TerrenrontoWaters); 
		RemoteRefuge.addRoute(SalfilWaters); 
		RemoteRefuge.addRoute(TheBurstingWaves); 
		RemoteRefuge.addRoute(TheEmptyBay); 
		 
		//RainingArchipelago 
		RainingArchipelago.addRoute(AridTrail); 
		RainingArchipelago.addRoute(DragonfireRoute); 
		RainingArchipelago.addRoute(ChillwaterSea); 
		RainingArchipelago.addRoute(TheDarkestDepths); 
		RainingArchipelago.addRoute(CartvonsBay); 
		RainingArchipelago.addRoute(TheTroubledOcean); 
		RainingArchipelago.addRoute(TheNarrowGulf); 
		RainingArchipelago.addRoute(TheOceanOfWoodbourg); 
		 
		//BrightwichIsland 
		BrightwichIsland.addRoute(TrepidationPass); 
		BrightwichIsland.addRoute(TheGlisteningDeep); 
		BrightwichIsland.addRoute(ChillwaterSea); 
		BrightwichIsland.addRoute(TheDarkestDepths); 
		BrightwichIsland.addRoute(TheSunnyDomain); 
		BrightwichIsland.addRoute(TheDarkOcean); 
		BrightwichIsland.addRoute(TheCoralOcean); 
		BrightwichIsland.addRoute(TheHungryDepths); 
		 
		//CrosserPeninsula 
		CrosserPeninsula.addRoute(TerrenrontoWaters); 
		CrosserPeninsula.addRoute(SalfilWaters); 
		CrosserPeninsula.addRoute(CartvonsBay); 
		CrosserPeninsula.addRoute(TheTroubledOcean); 
		CrosserPeninsula.addRoute(TheSunnyDomain); 
		CrosserPeninsula.addRoute(TheDarkOcean); 
		CrosserPeninsula.addRoute(TheWastingBay); 
		CrosserPeninsula.addRoute(TheGraveSea); 
		 
		//ArborlandIslet 
		ArborlandIslet.addRoute(TheBurstingWaves); 
		ArborlandIslet.addRoute(TheEmptyBay); 
		ArborlandIslet.addRoute(TheNarrowGulf); 
		ArborlandIslet.addRoute(TheOceanOfWoodbourg); 
		ArborlandIslet.addRoute(TheCoralOcean); 
		ArborlandIslet.addRoute(TheHungryDepths); 
		ArborlandIslet.addRoute(TheWastingBay); 
		ArborlandIslet.addRoute(TheGraveSea);
	}	
	

	/**
	 * To create items in game
	 */
	private void initItems() { 
		// create normal items
		items.add(new Item("Banana", "A yummy fruit", "Food", 1, 5)); 
		items.add(new Item("Apple", "A round fruit", "Food", 1, 2)); 
		items.add(new Item("Orange", "An orange fruit", "Food", 1, 3)); 
		items.add(new Item("Pear", "A weird looking fruit", "Food", 1, 7)); 
		items.add(new Item("Rum", "Delicous alcohol", "Drink", 5, 15));
		items.add(new Item("Ring", "Has an expensive looking diamond", "Jewellery", 1, 10));
		items.add(new Item("Necklace", "Made of gold", "Jewelery", 1, 12));
		items.add(new Item("Broach", "Owned by someones grandma","Jewelery", 1, 8));
		
		// create special items that are unique to the stores
		specialItems.add(new Item("Hay", "Could be eaten as a last resort?", "Special", 5, 10));
		specialItems.add(new Item("Tobacco", "Can be smoked or chewed", "Special", 2, 12));
		specialItems.add(new Item("Rice", "Good with curries", "Special", 4, 8));
		specialItems.add(new Item("Tea", "Mix with hot water for a tasy drink", "Special", 5, 10));
		specialItems.add(new Item("Spices", "Make your meals taste good", "Special", 4, 15));
		
		//create weapons unique to the stores
		weapons.add(new Weapon("Single Cannon", "Adds 5 to the ships attack multiplier", "Weapon", 7, 60, 5));
		weapons.add(new Weapon("Double Cannon", "Adds 9 to the ships attack multiplier", "Weapon", 16, 70, 9));
		weapons.add(new Weapon("Grappling Hook", "Adds 3 to the ships attack multiplier", "Weapon", 5, 35, 3));
		weapons.add(new Weapon("Prow Armour", "Adds 10 to the ships attack multiplier", "Weapon", 0, 85, 10));
		weapons.add(new Weapon("Triple Cannon", "Adds 15 to the ships attack multiplier", "Weapon", 35, 95, 15));

	} 
	
	/**
	 * To allocate items and weapons to the stores
	 */
	private void initStores() { 
		 
		for (Item i:items) { 
			for (Store s:stores) {
				s.addItemBought(i);
				s.addItemSold(i);
			}
		} 
		
		for (int i=0; i<stores.size(); i++) {
			stores.get(i).addWeaponSold(weapons.get(i));
			stores.get(i).addItemSold(specialItems.get(i));
			for (int j=0;j<weapons.size();j++) {
				if (j!=i) {
					stores.get(i).addWeaponBought(weapons.get(j));
					stores.get(i).addSpecialItemBought(specialItems.get(j));
				}
			}
		}	 	 
	}
	
	/**
	 * Initialize all of the frames in gui
	 */
	private void initWindows() {
		storeWindow = new StoreWindow();
		setSailWindow = new SetSailWindow();
		inventoryWindow = new InventoryWindow();
		mainMenuWindow = new MainMenuWindow();
		secretMenuWindow = new SecretMenuWindow();
		shipInformationWindow = new ShipInformationWindow();
		islandInformationWindow = new IslandInformationWindow();
	}
	
	//getter
	/**
	 * Get the player
	 * @return player
	 */
	public Player getPlayer() {
		return player;
	}
	
	//getter
	/**
	 * Get a list of all the ships
	 * @return ship list
	 */
	public ArrayList<Ship> getShips() {
		return this.ships;
	}
	
	//getter
	/**
	 * Get all of the islands
	 * @return island list
	 */
	public ArrayList<Island> getIslands() {
		return this.islands;
	}
	 
	//getter
	/**
	 * Get the list of all of the stores
	 * @return store list
	 */
	public ArrayList<Store> getStores() {
		return this.stores;
	}
	
	/**
	 * To create a new player
	 * @param ship The ship that the player chose
	 * @param island The start island that the player chose
	 * @param name The name of the player
	 * @param days The number of days the player chose to play
	 */
	public void createPlayer(Ship ship, Island island, String name, int days) {
		player = new Player(ship, island, name, days);
	}
	
	/**
	 * To exit the store screen and back to the main menu screen
	 */
	public void exitStore() {
		mainMenuWindow.open(this);
		storeWindow.close();
	}
	
	/**
	 * To open the store screen
	 */
	public void openStore() {
		storeWindow.open(this);
		mainMenuWindow.close();
	}
	
	/**
	 * To open the inventory screen 
	 */
	public void openInventory() {
		inventoryWindow.open(this);
		mainMenuWindow.close();
	}
	
	/**
	 * To exit the inventory screen and back to the main menu screen
	 */
	public void exitInventory() {
		mainMenuWindow.open(this);
		inventoryWindow.close();
	}
	
	/**
	 * To open the select destination frame
	 */
	public void openSelectDestination() {
		setSailWindow.open(this);
		mainMenuWindow.close();
	}
	
	/**
	 * To exit the set sail screen and back to the main menu screen
	 */
	public void exitSetSail() {
		mainMenuWindow.open(this);
		setSailWindow.close();
	}
	
	/**
	 * To open the secret menu screen
	 */
	public void openSecretMenu() {
		secretMenuWindow.open(this);
		mainMenuWindow.close();
	}
	
	/**
	 * To exit the secret menu screen and back to the main menu screen
	 */
	public void exitSecretMenu() {
		mainMenuWindow.open(this);
		secretMenuWindow.close();
	}
	
	/**
	 * To open the ship information screen
	 */
	public void openShipInformation() {
		shipInformationWindow.open(this);
		mainMenuWindow.close();
	}
	
	/**
	 * To exit the ship information screen and back to the main menu screen
	 */
	public void exitShipInformation() {
		mainMenuWindow.open(this);
		shipInformationWindow.close();
	}
	
	/**
	 * To open the island information screen
	 */
	public void openIslandInformation() {
		islandInformationWindow.open(this);
		mainMenuWindow.close();
	}
	
	/**
	 * To exit the island information screen and back to the main menu screen
	 */
	public void exitIslandInformation() {
		mainMenuWindow.open(this);
		islandInformationWindow.close();
	}
	
	/**
	 * To determine what is the reason for the game over
	 * @param deathType The reason for the game over
	 * @return the type of game over
	 */
	public String gameOver(int deathType) {
		int pirates = 1;
		int weather = 2;
		setSailWindow.close();
		if (deathType == pirates) {
			return "Game Over: Thanks for playing " + player.getName() + "! You lasted for " + player.getCurrDay() + " days before you were killed by pirates";
		} else if (deathType == weather) {
			return "Game Over: Thanks for playing " + player.getName() + "! You lasted for " + player.getCurrDay() + " days before your ship was destroyed in a storm";
		}
		return "";
	}

	/**
	 * To start the game
	 */
	public void startGame() {
		initWindows();
		mainMenuWindow.open(this);
		setupWindow.close();
	}
	
	/**
	 * To end the game
	 */
	public void endGame() {
		mainMenuWindow.close();
		System.exit(0);
	}
	
	/**
	 * To play the game
	 */
	public void playGame() {
		initShips();
		initGame();
		initItems();
		initStores();
		setupWindow = new SetupWindow();
		setupWindow.open(this);	
	}
	
	/**
	 * Initiate a game
	 * @param args
	 */
	public static void main(String[] args) {
		
		Game game = new Game();
		game.playGame();
	}

}
