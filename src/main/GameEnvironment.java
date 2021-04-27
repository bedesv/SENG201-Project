package main;

import java.util.ArrayList;

public class GameEnvironment {
	private static ArrayList<Item> foodItems = new ArrayList<Item>();
	
	
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
	//Route(int days, int distance, Island island1, Island island2, String description, int eventMultiplier)
	private static Route AridTrail = new Route(6, 10000, RemoteRefuge, RainingArchipelago, "Arid Trail", 20);
	private static Route DragonfireRoute = new Route(3, 4000, RemoteRefuge, RainingArchipelago, "Dragonfire Route", 60);
	private static Route TrepidationPass = new Route(4, 4600, RemoteRefuge, BrightwichIsland, "Trepidation Pass", 40);
	private static Route TheGlisteningDeep = new Route(7, 1100, RemoteRefuge, BrightwichIsland, "The Glistening Deep", 20);
	private static Route TerrenrontoWaters = new Route(5, 5200, RemoteRefuge, CrosserPeninsula, "Terrenronto Waters", 40);
	private static Route SalfilWaters = new Route(10, 18000, RemoteRefuge, CrosserPeninsula, "Salfil Waters", 10);
	private static Route TheBurstingWaves = new Route(2, 2500, RemoteRefuge, ArborlandIslet, "The Bursting Waves", 50);
	private static Route TheEmptyBay = new Route(11, 19500, RemoteRefuge, ArborlandIslet, "The Empty Bay", 10);
	
	private static Route ChilwaterSea = new Route(10, 18200, RainingArchipelago, BrightwichIsland, "Chilwater Sea", 30);
	private static Route TheDarkestDepths = new Route(5, 5150, RainingArchipelago, BrightwichIsland, "The Darkest Depths", 40);
	private static Route CartvonsBay = new Route(7, 1230, RainingArchipelago, CrosserPeninsula, "Cartvons Bay", 20);
	private static Route TheTroubledOcean = new Route(3, 4130, RainingArchipelago, CrosserPeninsula, "The Troubled Ocean", 50);
	private static Route TheNarrowGulf = new Route(8, 15000, RainingArchipelago, ArborlandIslet, "The Narrow Gulf", 20);
	private static Route TheOceanOfWoodbourg = new Route(6, 10050, RainingArchipelago, ArborlandIslet, "The Ocean of Woodbourg", 30);
	
	private static Route TheSunnyDomain = new Route(9, 17000, BrightwichIsland, CrosserPeninsula, "The Sunny Domain", 10);
	private static Route TheDarkOcean = new Route(3, 5300, BrightwichIsland, CrosserPeninsula, "The Dark Ocean", 50);
	private static Route TheCoralOcean = new Route(10, 17050, BrightwichIsland, ArborlandIslet, "The Coral Ocean", 10);
	private static Route TheHungryDepths = new Route(2, 3500, BrightwichIsland, ArborlandIslet, "The Hungry Depths", 70);
	
	private static Route TheWastingBay = new Route(12, 20000, CrosserPeninsula, ArborlandIslet, "The Wasting Bay", 10);
	private static Route TheGraveSea = new Route(2, 4000, CrosserPeninsula, ArborlandIslet, "The Grave Sea", 100);
			
	
	
	public static void initIslands() {
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
	
	
	public static void initItems() {
		foodItems.add(new Item("Banana", "A yummy fruit", "Food", 1, 5));
		foodItems.add(new Item("Apple", "A round fruit", "Food", 1, 2));
		foodItems.add(new Item("Orange", "An orange fruit", "Food", 1, 3));
		foodItems.add(new Item("Pear", "A weird looking fruit", "Food", 1, 7));
	}
	
	public static void initStores() {
		
		for (Item i:foodItems) {
			JollyNut.addItem(i);
		}
		
		
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
		
	}

	
	
	public static void main(String[] args) {
		
		Item Banana = new Item("Banana", "A yummy fruit", "Food", 1, 10);
		Item Apple = new Item("Banana", "A round fruit", "Food", 4, 2);
		Ship Ship = new Ship("Ship", 4, 5);
		
		initItems();
		initStores();
		JollyNut.viewItemsBought();
		Ship.buyItem(Apple, 50);
		Ship.viewShipProperties();
		Ship.sellItem(Apple, 40);
		Ship.viewShipProperties();
		
		initIslands();
		CrosserPeninsula.viewPropertyIsland();
		
		
	}
}
