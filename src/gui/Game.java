package GUI;

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
	private SelectRouteWindow selectRouteWindow;
	private SecretMenuWindow secretMenuWindow;
	private ShipInformationWindow shipInformationWindow;
	
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
	
	private void initWindows() {
		storeWindow = new StoreWindow();
		selectDestinationWindow = new SelectDestinationWindow();
		selectRouteWindow = new SelectRouteWindow();
		inventoryWindow = new InventoryWindow();
		mainMenuWindow = new MainMenuWindow();
		secretMenuWindow = new SecretMenuWindow();
		shipInformationWindow = new ShipInformationWindow();
		
		
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
		mainMenuWindow.open(this);
		storeWindow.close();
	}
	
	public void openStore() {
		storeWindow.open(this);
		mainMenuWindow.close();
	}
	
	public void openInventory() {
		inventoryWindow.open(this);
		mainMenuWindow.close();
	}
	
	public void exitInventory() {
		mainMenuWindow.open(this);
		inventoryWindow.close();
	}
	
	public void openSelectDestination() {
		selectDestinationWindow.open(this);
		mainMenuWindow.close();
	}
	
	public void exitSelectDestination() {
		mainMenuWindow.open(this);
		selectDestinationWindow.close();
	}
	
	public void openSelectRoute(Island destination) {
		selectRouteWindow.open(this, destination);
		selectDestinationWindow.close();
	}

	public void exitSelectRoute() {
		selectDestinationWindow.open(this);
		selectRouteWindow.close();
	}
	
	public void setSail() {
		mainMenuWindow.open(this);
		selectRouteWindow.close();
	}
	
	public void openSecretMenu() {
		secretMenuWindow.open(this);
		mainMenuWindow.close();
	}
	
	public void exitSecretMenu() {
		mainMenuWindow.open(this);
		secretMenuWindow.close();
	}
	
	public void openShipInformation() {
		shipInformationWindow.open(this);
		mainMenuWindow.close();
	}
	
	public void exitShipInformation() {
		mainMenuWindow.open(this);
		shipInformationWindow.close();
	}
	
	public void gameOver(SelectRouteWindow selectRouteWindow, int deathType) {
		int pirates = 1;
		int weather = 2;
		selectRouteWindow.close();
		if (deathType == pirates) {
			selectRouteWindow.showMessage("Game Finished: Thanks for playing " + player.getName() + "! You lasted for " + player.getCurrDay() + " days before you were killed by pirates");
		} else if (deathType == weather) {
			selectRouteWindow.showMessage("Game Finished: Thanks for playing " + player.getName() + "! You lasted for " + player.getCurrDay() + " days before your ship was destroyed in a storm");
		}
	}

	
	public void startGame() {
		initWindows();
		mainMenuWindow.open(this);
		setupWindow.close();
	}
	public void endGame() {
		mainMenuWindow.close();
	}
	
	public void playGame() {
		initShips();
		initGame();
		initItems();
		initStores();
		setupWindow = new SetupWindow();
		setupWindow.open(this);
		

		
	}
	public static void main(String[] args) {
		
		Game game = new Game();
		game.playGame();
	}

}
