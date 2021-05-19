package main;

import java.util.*;
/** Class the game is run from */
public class GameEnvironment {
	private static ArrayList<Item> foodItems = new ArrayList<Item>();
	private static ArrayList<Ship> ships = new ArrayList<Ship>();
	private static ArrayList<Island> islands = new ArrayList<Island>();
	private static ArrayList<String> activities = new ArrayList<String>();
	private static ArrayList<Store> stores = new ArrayList<Store>();
	
	//create ships
	private static Ship Delight = new Ship("Delight", 10, 100, 12, 8, 40);
	private static Ship Defender = new Ship("Defender", 10, 100, 6, 18, 50);
	private static Ship Mantis = new Ship("Mantis", 10, 100, 17, 5, 37);
	private static Ship Pioneer = new Ship("Pioneer", 10, 100, 10, 10, 89);
	

	//create stores
	private static Store VelvetKnife = new Store("Velvet Knife", 10);
	private static Store EducatedMonkey = new Store("Educated Monkey", 15);
	private static Store ViciousKettle = new Store("Vicious Kettle", 20);
	private static Store JollyNut = new Store("Jolly Nut", 17);
	private static Store IronBear = new Store("Iron Bear", 13);
	
	
	//create islands attributes
	private static Island RemoteRefuge = new Island("Remote Refuge", VelvetKnife);
	private static Island RainingArchipelago = new Island("Raining Archipelago", EducatedMonkey);
	private static Island BrightwichIsland = new Island("Brightwich Island", ViciousKettle);
	private static Island CrosserPeninsula = new Island("Crosser Peninsula", JollyNut);
	private static Island ArborlandIslet = new Island("Arborland Islet", IronBear);
	
	//create routes
	//Route(int distance, Island island1, Island island2, String description, int eventMultiplier)
	private static Route AridTrail = new Route(10000, RemoteRefuge, RainingArchipelago, "Arid Trail", 20);
	private static Route DragonfireRoute = new Route(4000, RemoteRefuge, RainingArchipelago, "Dragonfire Route", 60);
	private static Route TrepidationPass = new Route(4600, RemoteRefuge, BrightwichIsland, "Trepidation Pass", 20);
	private static Route TheGlisteningDeep = new Route(1100, RemoteRefuge, BrightwichIsland, "The Glistening Deep", 40);
	private static Route TerrenrontoWaters = new Route(5200, RemoteRefuge, CrosserPeninsula, "Terrenronto Waters", 40);
	private static Route SalfilWaters = new Route(18000, RemoteRefuge, CrosserPeninsula, "Salfil Waters", 10);
	private static Route TheBurstingWaves = new Route(2500, RemoteRefuge, ArborlandIslet, "The Bursting Waves", 50);
	private static Route TheEmptyBay = new Route(19500, RemoteRefuge, ArborlandIslet, "The Empty Bay", 10);
	
	private static Route ChilwaterSea = new Route(18200, RainingArchipelago, BrightwichIsland, "Chilwater Sea", 30);
	private static Route TheDarkestDepths = new Route(5150, RainingArchipelago, BrightwichIsland, "The Darkest Depths", 40);
	private static Route CartvonsBay = new Route(1230, RainingArchipelago, CrosserPeninsula, "Cartvons Bay", 50);
	private static Route TheTroubledOcean = new Route(4130, RainingArchipelago, CrosserPeninsula, "The Troubled Ocean", 20);
	private static Route TheNarrowGulf = new Route(15000, RainingArchipelago, ArborlandIslet, "The Narrow Gulf", 20);
	private static Route TheOceanOfWoodbourg = new Route(10050, RainingArchipelago, ArborlandIslet, "The Ocean of Woodbourg", 30);
	
	private static Route TheSunnyDomain = new Route(17000, BrightwichIsland, CrosserPeninsula, "The Sunny Domain", 10);
	private static Route TheDarkOcean = new Route(5300, BrightwichIsland, CrosserPeninsula, "The Dark Ocean", 50);
	private static Route TheCoralOcean = new Route(17050, BrightwichIsland, ArborlandIslet, "The Coral Ocean", 10);
	private static Route TheHungryDepths = new Route(3500, BrightwichIsland, ArborlandIslet, "The Hungry Depths", 70);
	
	private static Route TheWastingBay = new Route(20000, CrosserPeninsula, ArborlandIslet, "The Wasting Bay", 10);
	private static Route TheGraveSea = new Route(4000, CrosserPeninsula, ArborlandIslet, "The Grave Sea", 100);
	
	public static void initIslands() {
		
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
	
	public static void initShips() {
		ships.add(Delight);
		ships.add(Defender);
		ships.add(Mantis);
		ships.add(Pioneer);
	}
	
	/** Initialises items */
	public static void initItems() {
		
		
		for (Store s:stores) {
			s.addItem(new Item("Banana", "A yummy fruit", "Food", 1, 5));
			s.addItem(new Item("Apple", "A round fruit", "Food", 1, 2));
			s.addItem(new Item("Orange", "An orange fruit", "Food", 1, 3));
			s.addItem(new Item("Pear", "A weird looking fruit", "Food", 1, 7));
		}
		
		VelvetKnife.addItem(new Item("Single Cannon", "A single cannon, used to shoot at enemies. Adds 5 to the ships damage multiplier.", "Weapon", 7, 60));
		EducatedMonkey.addItem(new Item("Double Cannon", "A double cannon, used to shoot at enemies. Adds 9 to the ships damage multiplier.", "Weapon", 16, 70));
		IronBear.addItem(new Item("Grappling Hook", "A grappling hook, used to gain access to an enemies ship. Adds 3 to the ships damage multiplier.", "Weapon", 5, 35));
		ViciousKettle.addItem(new Item("Prow Armour", "Armour for the front of the ship, allows the ship to be used as a battering ram. Adds 10 to the ships damage multiplier.", "Weapon", 0, 85));
		JollyNut.addItem(new Item("Triple Cannon", "A triple cannon, used to shoot at enemies. Adds 15 to the ships damage multiplier.", "Weapon", 35, 95));
	}
	
	public static void initStores() {
		
		stores.add(EducatedMonkey);
		stores.add(IronBear);
		stores.add(VelvetKnife);
		stores.add(ViciousKettle);
		stores.add(JollyNut);
		
		
	}
	
	public static void initActivities() {
		activities.add("Enter Shop");
		activities.add("Repair Ship");
		activities.add("Set Sail");
		activities.add("View Coin Balance");
		activities.add("View Ship Details");
		activities.add("View purchased items");
		activities.add("End Game");
	}
	
	public static Ship selectShip(Scanner input) {
		System.out.println("Please select the ship you want to use from the following:");
		for (Ship s : ships) {
			s.shipInfo();
		}
		
		
		int selectedShip = 0;
		char answer = 'p';
		while (answer != 'y') {
			System.out.println("Enter 1 for Delight, 2 for Defender, 3 for Mantis, 4 for Pioneer.");
			selectedShip = input.nextInt();
		
			while (selectedShip < 1 || selectedShip > 4) {
				System.out.println("Error: Invalid selection.");
				System.out.println("Enter 1 for Delight, 2 for Defender, 3 for Mantis, 4 for Pioneer.");
				selectedShip = input.nextInt();
			}
		
			System.out.println("You've selected " + ships.get(selectedShip-1).getName() + ". Is this correct? y/n");
		
			
			answer = input.next().charAt(0);
			while (answer != 'y' && answer != 'n') {
				
				System.out.println("Please enter a valid answer (y/n).");
				answer = input.next().charAt(0);
			}
		
		}
		
		return ships.get(selectedShip-1);
		
		
	}
	
	public static Island selectStartingIsland(Scanner input) {
		System.out.println("Please select the island you want to start at from the following:");
		int i = 1;
		for (Island s : islands) {
			System.out.println(i++ + ": " + s.getName());
		}
		
		int selectedIsland = 0;
		char answer = 'p';
		while (answer != 'y') {
			selectedIsland = input.nextInt();
		
			while (selectedIsland < 1 || selectedIsland > 5) {
				System.out.println("Error: Invalid selection.");
				selectedIsland = input.nextInt();
			}
		
			System.out.println("You've selected " + islands.get(selectedIsland-1).getName() + ". Is this correct? y/n");
		
			
			answer = input.next().charAt(0);
			while (answer != 'y' && answer != 'n') {
				
				System.out.println("Please enter a valid answer (y/n).");
				answer = input.next().charAt(0);
			}
			if (answer == 'n') {
				System.out.println("Please select the island you want to start at from the following:");
				i = 1;
				for (Island s : islands) {
					System.out.println(i++ + ": " + s.getName());
				}
			}
		
		}
		
		return islands.get(selectedIsland-1);
		
		
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
		
			while (selectedActivity < 1 || selectedActivity > 7) {
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
	
	

	
	
	public static void main(String[] args) {
		
		
		initStores();
		initItems();
		initShips();
		initIslands();
		initActivities();
		
		Scanner input = new Scanner(System.in);
		
		//Item Banana = new Item("Banana", "A yummy fruit", "Food", 1, 5);
		Ship Ship = selectShip(input);
		Ship.setLocation(selectStartingIsland(input));
		Ship.addCoins(500000000);
		
		boolean gameCont = true;
		
		while (gameCont) {
			int activity = selectActivity(input, Ship);
			if (activity == 1) {
				Ship.getLocation().getStore().enterStore(input, Ship);
			} else if (activity == 2) {
				Ship.repairShip(input);
			} else if (activity == 3) {
				gameCont = Ship.travel(input, islands);
			} else if (activity == 4) {
				Ship.printCoins();
			} else if (activity == 5) {
				//view ship details
				continue;
			} else if (activity == 6) {
				Ship.viewPurchasedItems();
			}	else if (activity == 7) {
			
				gameCont = false;
			}
				
		}
		
		System.out.println("Game Over");
		System.out.println("You lasted for " + Ship.getDays() + " days and amassed " + Ship.getCoins() + " coins.");
		
		//JollyNut.viewItemsBought();
		//Ship.buyItem(Apple, 5);
		//Ship.viewShipProperties();
		//Ship.sellItem(Apple, 40);
		//Ship.viewShipProperties();
		
		//initIslands();
		//CrosserPeninsula.viewPropertyIsland();
		
		
	}
}
