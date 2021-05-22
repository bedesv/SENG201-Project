package gui;

import java.util.ArrayList;

public class Game {
	
	private ArrayList<Item> items = new ArrayList<Item>(); 
	private ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private ArrayList<Ship> ships = new ArrayList<Ship>(); 
	private ArrayList<Island> islands = new ArrayList<Island>(); 
	private ArrayList<Store> stores = new ArrayList<Store>();
	
	private Player player;
	
	private StoreWindow storeWindow;
	private SetupWindow setupWindow;
	private MainMenuWindow mainMenuWindow;
	private InventoryWindow inventoryWindow;
	private SelectDestinationWindow selectDestinationWindow;
	
	private void initShips() {
		// Create Ships
		
		Ship Delight = new Ship("Delight", 8, 100, 12, 8, 4); 
		Ship Defender = new Ship("Defender", 13, 130, 6, 18, 3); 
		Ship Mantis = new Ship("Mantis", 12, 110, 17, 5, 4); 
		Ship Pioneer = new Ship("Pioneer", 12, 80, 10, 10, 5);
		
		ships.add(Pioneer);
		ships.add(Defender);
		ships.add(Delight);
		ships.add(Mantis);
	}
	
	 
	private void initGame() {
		
		//create stores 
		Store VelvetKnife = new Store("Velvet Knife", 10); 
		Store EducatedMonkey = new Store("Educated Monkey", 15); 
		Store ViciousKettle = new Store("Vicious Kettle", 20); 
		Store JollyNut = new Store("Jolly Nut", 17); 
		Store IronBear = new Store("Iron Bear", 13); 
		
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
		Route AridTrail = new Route(10000, RemoteRefuge, RainingArchipelago, "Arid Trail", 20); 
		Route DragonfireRoute = new Route(4000, RemoteRefuge, RainingArchipelago, "Dragonfire Route", 60); 
		Route TrepidationPass = new Route(4600, RemoteRefuge, BrightwichIsland, "Trepidation Pass", 20); 
		Route TheGlisteningDeep = new Route(1100, RemoteRefuge, BrightwichIsland, "The Glistening Deep", 40); 
		Route TerrenrontoWaters = new Route(5200, RemoteRefuge, CrosserPeninsula, "Terrenronto Waters", 40); 
		Route SalfilWaters = new Route(18000, RemoteRefuge, CrosserPeninsula, "Salfil Waters", 10); 
		Route TheBurstingWaves = new Route(2500, RemoteRefuge, ArborlandIslet, "The Bursting Waves", 50); 
		Route TheEmptyBay = new Route(19500, RemoteRefuge, ArborlandIslet, "The Empty Bay", 10); 
		 
		Route ChillwaterSea = new Route(18200, RainingArchipelago, BrightwichIsland, "Chilwater Sea", 30); 
		Route TheDarkestDepths = new Route(5150, RainingArchipelago, BrightwichIsland, "The Darkest Depths", 40); 
		Route CartvonsBay = new Route(1230, RainingArchipelago, CrosserPeninsula, "Cartvons Bay", 50); 
		Route TheTroubledOcean = new Route(4130, RainingArchipelago, CrosserPeninsula, "The Troubled Ocean", 20); 
		Route TheNarrowGulf = new Route(15000, RainingArchipelago, ArborlandIslet, "The Narrow Gulf", 20); 
		Route TheOceanOfWoodbourg = new Route(10050, RainingArchipelago, ArborlandIslet, "The Ocean of Woodbourg", 30); 
		 
		Route TheSunnyDomain = new Route(17000, BrightwichIsland, CrosserPeninsula, "The Sunny Domain", 10); 
		Route TheDarkOcean = new Route(5300, BrightwichIsland, CrosserPeninsula, "The Dark Ocean", 50); 
		Route TheCoralOcean = new Route(17050, BrightwichIsland, ArborlandIslet, "The Coral Ocean", 10); 
		Route TheHungryDepths = new Route(3500, BrightwichIsland, ArborlandIslet, "The Hungry Depths", 70); 
		 
		Route TheWastingBay = new Route(20000, CrosserPeninsula, ArborlandIslet, "The Wasting Bay", 10); 
		Route TheGraveSea = new Route(4000, CrosserPeninsula, ArborlandIslet, "The Grave Sea", 100); 
		
		// Add Islands to array
		islands.add(ArborlandIslet);
		islands.add(CrosserPeninsula);
		islands.add(RainingArchipelago);
		islands.add(RemoteRefuge);
		islands.add(BrightwichIsland); 
		
		// add routes 
		
		//RemoteRefuge 
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
	
	public static String name = "";
	public static int home = -1;
			 
	
	
	 
	private void initItems() { 
		 
		items.add(new Item("Banana", "A yummy fruit", "Food", 1, 5)); 
		items.add(new Item("Apple", "A round fruit", "Food", 1, 2)); 
		items.add(new Item("Orange", "An orange fruit", "Food", 1, 3)); 
		items.add(new Item("Pear", "A weird looking fruit", "Food", 1, 7)); 
		
		weapons.add(new Weapon("Single Cannon", "Adds 5 to the ships damage multiplier", "Weapon", 7, 60, 5));
		weapons.add(new Weapon("Double Cannon", "Adds 9 to the ships damage multiplier", "Weapon", 16, 70, 9));
		weapons.add(new Weapon("Grappling Hook", "Adds 3 to the ships damage multiplier", "Weapon", 5, 35, 3));
		weapons.add(new Weapon("Prow Armour", "Adds 10 to the ships damage multiplier", "Weapon", 0, 85, 10));
		weapons.add(new Weapon("Triple Cannon", "Adds 15 to the ships damage multiplier", "Weapon", 35, 95, 15));
		 
		
	} 
	 
	private void initStores() { 
		 
		for (Item i:items) { 
			for (Store s:stores) {
				s.addItem(i);
			}
		} 
		
		for (int i=0;i<stores.size();i++) {
			stores.get(i).addWeapon(weapons.get(i));
		}
		 
		 
	}
	
	public void repairShip() {
		player.repairShip();
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public ArrayList<Ship> getShips() {
		return this.ships;
	}
	
	public ArrayList<Island> getIslands() {
		return this.islands;
	}
	
	public void createPlayer(Ship ship, Island island, String name, int days) {
		player = new Player(ship, island, name, days);
	}
	
	public void exitStore() {
		mainMenuWindow = new MainMenuWindow(this);
		storeWindow.exitStore();
	}
	
	public void openStore() {
		storeWindow = new StoreWindow(this);
		mainMenuWindow.exitMenu();
	}
	
	public void openInventory() {
		inventoryWindow = new InventoryWindow(this);
		mainMenuWindow.exitMenu();
	}
	
	public void setSail() {
		selectDestinationWindow = new SelectDestinationWindow(this);
		mainMenuWindow.exitMenu();
	}
	
	public void exitInventory() {
		mainMenuWindow = new MainMenuWindow(this);
		inventoryWindow.exitInventory();
	}
	
	public void startGame() {
		setupWindow.exitSetup();
		mainMenuWindow = new MainMenuWindow(this);
	}
	
	public void playGame() {
		initShips();
		initGame();
		initItems();
		initStores();

		setupWindow = new SetupWindow(this);
	}
	public static void main(String[] args) {
		Game game = new Game();
		game.playGame();
	}

}
