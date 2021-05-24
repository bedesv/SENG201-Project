package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commandLineApplication.Island;
import commandLineApplication.Item;
import commandLineApplication.Route;
import commandLineApplication.Ship;
import commandLineApplication.Store;

class ShipTest {
	Ship testShip;
	Store testStore;
	Store testStore2;
	Store testStore3;
	Store testStore4;
	Store testStore5;
	Island testIsland;
	Island testIsland2;
	Island testIsland3;
	Island testIsland4;
	Island testIsland5;
	Route testRoute;
	Route testRoute2;
	Item testBanana;
	Item testBanana2;
	ArrayList<Island> testIslandList = new ArrayList<Island>();
	
	@BeforeEach
	void init() {
		testShip = new Ship("Test Ship", 10, 100, 10, 10, 5);
		testStore = new Store("Test Store", 5);
		testStore2 = new Store("Test Store 2", 5);
		testStore3 = new Store("Test Store 3", 5);
		testStore4 = new Store("Test Store", 5);
		testStore5 = new Store("Test Store 2", 5);
		testIsland = new Island("Test Island", testStore);
		testIsland2 = new Island("Test Island 2", testStore2);
		testIsland3 = new Island("Test Island 3", testStore3);
		testIsland4 = new Island("Test Island 4", testStore4);
		testIsland5 = new Island("Test Island 5", testStore5);
		
		testRoute = new Route(10, testIsland, testIsland2, "Test Route", 0); 
		testRoute2 = new Route(10, testIsland, testIsland2, "Test Route", 0); 
		
		testIslandList.add(testIsland);
		testIslandList.add(testIsland2);
		testIslandList.add(testIsland3);
		testIslandList.add(testIsland4);
		testIslandList.add(testIsland5);
		
		testBanana = new Item("Banana", "A yummy fruit", "Food", 1, 10);
		testBanana2 = new Item("Banana", "A yummy fruit", "Food", 101, 5);
	}
	
	@Test
	public void getLocationTest() {
		testShip.setLocation(testIsland);
		assertEquals(testIsland, testShip.getLocation());
	}
	
	@Test
	public void getMultipliersTest() {
		assertEquals(10, testShip.getAttackMultiplier());
		assertEquals(10, testShip.getDamageMultiplier());
	}
	
	@Test
	public void takeDamageTest() {
		assertEquals(0, testShip.getCurrentDamage());
		testShip.takeDamage(50);
		assertEquals(50, testShip.getCurrentDamage());
	}

	
	@Test
	public void repairShipTest() {
		testShip.takeDamage(50);
		assertEquals(50, testShip.getCurrentDamage());
		Scanner input = new Scanner("g\ny");
		testShip.repairShip(input);
		assertEquals(500, testShip.getCoins());
		assertEquals(0, testShip.getCurrentDamage());
		
		
		testShip.takeDamage(50);
		testShip.addCoins(-5);
		testShip.repairShip(input);
		assertEquals(495, testShip.getCoins());
		assertEquals(50, testShip.getCurrentDamage());
	}
	
	@Test
	public void useRouteTest() {
		testShip.setLocation(testIsland);
		
		testShip.useRoute(testRoute, testIsland2);
		
		assertEquals(2, testShip.getDays());
		assertEquals(testIsland2, testShip.getLocation());
	}
	
	@Test
	public void travelTest() {
		testShip.setLocation(testIsland);
		testIsland.addRoute(testRoute);
		testIsland2.addRoute(testRoute);
		testIsland.addRoute(testRoute2);
		testIsland2.addRoute(testRoute2);
		
		Scanner input = new Scanner("6\n"
								  + "1\n"
								  + "g\n"
								  + "n\n"
								  + "1\n"
								  + "y\n"
								  + "1\n"
								  + "n\n"
								  + "4\n"
								  + "3\n"
								  + "1\n"
								  + "y\n"
								  + "1\n"
								  + "g\n"
								  + "y\n");
		testShip.travel(input, testIslandList);
		
		assertEquals(2, testShip.getDays());
		assertEquals(testIsland2, testShip.getLocation());
	}
	
	@Test
	public void buyItemTest() {
		// Successfully purchases item
		testShip.buyItem(testBanana, 10);
		assertTrue(testShip.getInventory().get(0).equals(testBanana));
		assertEquals(990, testShip.getCoins());
		
		// Purchase fails because the ship doesn't have enough coins
		testShip.buyItem(testBanana, 10000);
		assertEquals(1, testShip.getInventory().size());
		assertEquals(990, testShip.getCoins());
		
		// Purchase fails because the ship doesn't have enough free inventory space
		testShip.buyItem(testBanana2, 10);
		assertEquals(1, testShip.getInventory().size());
		assertEquals(990, testShip.getCoins());
		
		
	}
	
	@Test
	public void sellItemTest() {
		testShip.buyItem(testBanana, 10);
		
		testShip.sellItem(testBanana, 10);
		assertEquals(1000, testShip.getCoins());
		
		assertEquals(0, testShip.getInventory().size());
		
		
	}
	
	@Test
	public void inventoryTotalTest() {
		testShip.buyItem(testBanana, 10);
		assertEquals(10, testShip.inventoryTotal());
	}
	
	@Test
	public void inventoryContainsTest() {
		testShip.buyItem(testBanana, 10);
		
		assertTrue(testShip.inventoryContains(testBanana));
	}
	
	@Test
	public void clearInventoryTest() {
		testShip.buyItem(testBanana, 10);
		
		testShip.clearInventory();
		
		assertEquals(0, testShip.getInventory().size());
	}
	
	@Test
	public void getNameTest() {
		assertEquals("Test Ship", testShip.getName());
	}
	
	@Test
	public void getItemTest() {
		testShip.buyItem(testBanana, 10);
		
		assertTrue(testBanana.equals(testShip.getItem(testBanana)));
	}

}
