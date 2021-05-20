package GUI; 
 
import java.util.*;

public class Player { 
	private static ArrayList<Item> items = new ArrayList<Item>(); 
	private static ArrayList<Weapon> weapons = new ArrayList<Weapon>();
	private static ArrayList<Ship> ships = new ArrayList<Ship>(); 
	private static ArrayList<Island> islands = new ArrayList<Island>(); 
	private static ArrayList<String> activities = new ArrayList<String>(); 
	private static ArrayList<Store> stores = new ArrayList<Store>();
	protected Ship selectedShip;
	protected StoreWindow storeWindow;
	 
	public Player() {
		initGame();
		initItems();
		initStores();
		initShips();
		
		selectedShip = ships.get(2);
		selectedShip.setLocation(islands.get(0));
		selectedShip.buyItem(items.get(0), 5);
		selectedShip.buyWeapon(weapons.get(1), 100);
	}
	 
	 
	public static void initShips() {
		// Create Ships
		
		Ship Delight = new Ship("Delight", 10, 100, 12, 8, 40); 
		Ship Defender = new Ship("Defender", 10, 100, 6, 18, 50); 
		Ship Mantis = new Ship("Mantis", 10, 100, 17, 5, 37); 
		Ship Pioneer = new Ship("Pioneer", 10, 100, 10, 10, 89);
		
		ships.add(Pioneer);
		ships.add(Defender);
		ships.add(Delight);
		ships.add(Mantis);
	}
	
	 
	public static void initGame() {
		
		
		
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
		 
		Route ChilwaterSea = new Route(18200, RainingArchipelago, BrightwichIsland, "Chilwater Sea", 30); 
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
		RainingArchipelago.addRoute(ChilwaterSea); 
		RainingArchipelago.addRoute(TheDarkestDepths); 
		RainingArchipelago.addRoute(CartvonsBay); 
		RainingArchipelago.addRoute(TheTroubledOcean); 
		RainingArchipelago.addRoute(TheNarrowGulf); 
		RainingArchipelago.addRoute(TheOceanOfWoodbourg); 
		 
		//BrightwichIsland 
		BrightwichIsland.addRoute(TrepidationPass); 
		BrightwichIsland.addRoute(TheGlisteningDeep); 
		BrightwichIsland.addRoute(ChilwaterSea); 
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
			 
	
	
	 
	public static void initItems() { 
		 
		items.add(new Item("Banana", "A yummy fruit", "Food", 1, 5)); 
		items.add(new Item("Apple", "A round fruit", "Food", 1, 2)); 
		items.add(new Item("Orange", "An orange fruit", "Food", 1, 3)); 
		items.add(new Item("Pear", "A weird looking fruit", "Food", 1, 7)); 
		
		weapons.add(new Weapon("Single Cannon", "Adds 5 to the ships damage multiplier.", "Weapon", 7, 60, 5));
		weapons.add(new Weapon("Double Cannon", "Adds 9 to the ships damage multiplier.", "Weapon", 16, 70, 9));
		weapons.add(new Weapon("Grappling Hook", "Adds 3 to the ships damage multiplier.", "Weapon", 5, 35, 3));
		weapons.add(new Weapon("Prow Armour", "Adds 10 to the ships damage multiplier.", "Weapon", 0, 85, 10));
		weapons.add(new Weapon("Triple Cannon", "Adds 15 to the ships damage multiplier.", "Weapon", 35, 95, 15));
		 
		
	} 
	 
	public static void initStores() { 
		 
		for (Item i:items) { 
			for (Store s:stores) {
				s.addItem(i);
			}
		} 
		
		for (int i=0;i<stores.size();i++) {
			stores.get(i).addWeapon(weapons.get(i));
		}
		 
		 
	} 
	 
	public static void initActivities() { 
		activities.add("Enter Shop"); 
		activities.add("Repair Ship"); 
		activities.add("Set Sail"); 
		activities.add("View Coin Balance"); 
		activities.add("View Ship Details"); 
		activities.add("End Game"); 
	} 
	 
	public static void selectStartingIsland(int island_index) { 
		//islands.remove(5); 
//		switch(island_index) { 
//		case 0: 
//			islands.add(ArborlandIslet); 
//		case 1: 
//			islands.add(CrosserPeninsula); 
//		case 2: 
//			islands.add(RainingArchipelago); 
//		case 3: 
//			islands.add(RemoteRefuge); 
//		case 4: 
//			islands.add(BrightwichIsland);
//		} 
//		System.out.println(islands.size());
		home = island_index;
	} 
	
	public static Island getIsland() {
		return islands.get(home);
	}
	 
	
	public static int selectActivity(Scanner input, Ship ship) { 
		System.out.println(); 
		System.out.println("Please select the desired activity from the following:"); 
		int i = 1; 
		for (String s : activities) { 
			System.out.println(i++ + ": " + s); 
		} 
		 
		int selectedActivity = 0; 
		char answer = 'p'; 
		while (answer != 'y') { 
			selectedActivity = input.nextInt(); 
		 
			while (selectedActivity < 1 || selectedActivity > 6) { 
				System.out.println("Error: Invalid selection."); 
				selectedActivity = input.nextInt(); 
			} 
			if (selectedActivity == 3 && ship.getCurrentDamage() != 0) { 
				System.out.println("Please repair your ship before setting sail\n"); 
				 
			} else if (selectedActivity == 2 && ship.getCurrentDamage() == 0)  { 
				System.out.println("No repairs needed, your ship isn't damaged\n"); 
			} else { 
				System.out.println("You've selected " + activities.get(selectedActivity-1) + ". Is this correct? y/n"); 
		 
			 
				answer = input.next().charAt(0); 
				while (answer != 'y' && answer != 'n') { 
				 
					System.out.println("Please enter a valid answer (y/n)."); 
					answer = input.next().charAt(0); 
				} 
			} 
			if (answer == 'n' || (selectedActivity == 3 && ship.getCurrentDamage() != 0) || (selectedActivity == 2 && ship.getCurrentDamage() == 0)) { 
				System.out.println("Please select the desired activity from the following:"); 
				i = 1; 
				for (String s : activities) { 
					System.out.println(i++ + ": " + s); 
				} 
			} 
		 
		} 
		return selectedActivity; 
		 
		 
	} 
	 
	 
	public void startGame() { 
 
		boolean gameCont = true; 
		 
		while (gameCont) { 
			// options to play... 
			 
			// if pirates 
				// gameCont = pirateBattle (func in Pirates) 
		} 
	} 
	  
	public void finishGame() { 
		
		
		
		storeWindow = new StoreWindow(this);
	} 
	
	public static void main(String[] args) {
		
		
	}
 
} 
