package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backEnd.Island;
import backEnd.Item;
import backEnd.Route;
import backEnd.Ship;
import backEnd.Store;

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
	Item testItem;
	Item testItem2;
	ArrayList<Island> testIslandList = new ArrayList<Island>();
	
	@BeforeEach
	void init() {
		testShip = new Ship("Test Ship", 10, 100, 10, 10, 5, "");
		testStore = new Store("Test Store", 5);

		testIsland = new Island("Test Island", testStore);
		
		testItem = new Item("Item", "A yummy fruit", "Food", 1, 10);
		testItem2 = new Item("Item", "A yummy fruit", "Food", 101, 5);
	}
	
	@Test
	public void repairShipTest() {
		testShip.takeDamage(50);
		assertEquals(50, testShip.getCurrentDamage());
		testShip.repairShip();
		assertEquals(950, testShip.getCoins());
		assertEquals(0, testShip.getCurrentDamage());
	}
	
	@Test
	public void getRepairCostTest() {
		assertEquals(0, testShip.getRepairCost());
		testShip.takeDamage(50);
		assertEquals(50, testShip.getRepairCost());
	}
	
	@Test
	public void getImgStringTest() {
		assertEquals("", testShip.getImgString());
	}
	
	@Test
	public void getCoinsTest() {
		assertEquals(1000, testShip.getCoins());
	}
	
	@Test
	public void getSpeedTest() {
		assertEquals(5, testShip.getSpeed());
	}
	
	@Test
	public void getSetLocationTest() {
		testShip.setLocation(testIsland);
		assertEquals(testIsland, testShip.getLocation());
	}
	
	@Test
	public void takeDamageTest() {
		assertEquals(0, testShip.getCurrentDamage());
		testShip.takeDamage(50);
		assertEquals(50, testShip.getCurrentDamage());
	}
	
	@Test
	public void getMultipliersTest() {
		assertEquals(10, testShip.getAttackMultiplier());
		assertEquals(10, testShip.getDefenceMultiplier());
	}
	
	@Test
	public void buyItemTest() {
		// Successfully purchases item
		testShip.buyItem(testItem, 10);
		assertTrue(testShip.getInventory().get(0).equals(testItem));
		assertEquals(990, testShip.getCoins());
	}
	
	@Test
	public void sellItemTest() {
		testShip.buyItem(testItem, 10);
		
		testShip.sellItem(testItem, 10);
		assertEquals(1000, testShip.getCoins());
		
		assertEquals(0, testShip.getInventory().size());
		
		
	}
	
	@Test
	public void inventoryTotalTest() {
		testShip.buyItem(testItem, 10);
		assertEquals(10, testShip.inventoryValue());
	}
	
	@Test
	public void inventoryContainsTest() {
		testShip.buyItem(testItem, 10);
		
		assertTrue(testShip.inventoryContains(testItem));
	}
	
	@Test
	public void clearInventoryTest() {
		testShip.buyItem(testItem, 10);
		
		testShip.clearInventory();
		
		assertEquals(0, testShip.getInventory().size());
	}
	
	@Test
	public void getNameTest() {
		assertEquals("Test Ship", testShip.getName());
	}
	
	@Test
	public void getItemTest() {
		testShip.buyItem(testItem, 10);
		
		assertTrue(testItem.equals(testShip.getItemFromInventory(testItem)));
	}

}
