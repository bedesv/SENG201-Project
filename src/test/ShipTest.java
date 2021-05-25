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
import backEnd.Weapon;

class ShipTest {
	Ship testShip;
	Route testRoute;
	Route testRoute2;
	Store testStore;
	Island testIsland;
	Item testItem;
	Item testItem2;
	Item testRum;
	Weapon testWeapon;
	ArrayList<Island> testIslandList = new ArrayList<Island>();
	
	@BeforeEach
	public void init() {
		testStore = new Store();
		testIsland = new Island();
		testShip = new Ship("Test Ship", 10, 100, 29, 29, 5, "");
		testItem = new Item("Item", "A yummy fruit", "Food", 1, 10);
		testItem2 = new Item("Item", "A yummy fruit", "Food", 101, 5);
		testRum = new Item("Rum", "Delicous alcohol", "Drink", 5, 15);
		testWeapon = new Weapon("Weapon", "Testing 123", "Weapon", 5, 10, 5);
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
	public void takeGetDamageTest() {
		assertEquals(0, testShip.getCurrentDamage());
		testShip.takeDamage(50);
		assertEquals(50, testShip.getCurrentDamage());
	}
	
	@Test
	public void getCrewTest() {
		assertEquals(10, testShip.getCrew());
	}
	
	@Test
	public void hasRumTest() {
		assertTrue(!(testShip.hasRum()));
		testShip.buyItem(testRum, 0);
		assertTrue(testShip.hasRum());
	}
	
	@Test
	public void removeRumTest() {
		testShip.buyItem(testRum, 0);
		testShip.removeRum();
		assertEquals(0, testShip.getInventory().size());
	}
	
	@Test
	public void getItemsBoughtSoldTest() {
		testShip.buyItem(testItem, 10);
		assertEquals(testItem.getName(), testShip.getItemsBought().get(0).getName());
		testShip.sellItem(testItem, 10);
		assertEquals(testItem.getName(), testShip.getItemsSold().get(0).getName());
	}
	
	@Test
	public void getWeaponsBoughtSoldTest() {
		testShip.buyWeapon(testWeapon, 10);
		assertEquals(testWeapon.getName(), testShip.getWeaponsBought().get(0).getName());
		testShip.sellWeapon(testWeapon, 10);
		assertEquals(testWeapon.getName(), testShip.getWeaponsSold().get(0).getName());
	}
	
	@Test
	public void getCurrCapacityTest() {
		assertEquals(0, testShip.getCurrCapacity());
		testShip.buyItem(testItem, 10);
		assertEquals(testItem.getSize(), testShip.getCurrCapacity());
	}
	
	@Test
	public void getMaxCapacityTest() {
		assertEquals(100, testShip.getMaxCapacity());
	}
	
	
	@Test
	public void getMultipliersTest() {
		assertEquals(29, testShip.getAttackMultiplier());
		assertEquals(29, testShip.getDefenceMultiplier());
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
	public void inventoryValueTest() {
		testShip.clearInventory();
		testShip.buyItem(testItem, 10);
		testShip.buyWeapon(testWeapon, 10);
		assertEquals(20, testShip.inventoryValue());
	}
	
	@Test
	public void inventoryContainsTest() {
		assertTrue(!testShip.inventoryContains(testItem));
		testShip.buyItem(testItem, 10);
		assertTrue(testShip.inventoryContains(testItem));
	}
	
	@Test
	public void getWeaponsTest() {
		testShip.buyWeapon(testWeapon, 10);
		assertEquals(testWeapon.getName(), testShip.getWeapons().get(0).getName());
	}
	
	@Test
	public void getWeaponFromInventoryTest() {
		testShip.buyWeapon(testWeapon, 10);
		assertEquals(testWeapon.getName(), testShip.getWeaponFromInventory(testWeapon).getName());
	}
	
	@Test
	public void getCostToSailTest() {
		assertEquals(50, testShip.getCostToSail(1));
		assertEquals(350, testShip.getCostToSail(7));
		assertEquals(500, testShip.getCostToSail(10));
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
	
	@Test
	public void addRemoveCoinsTest() {
		testShip.addCoins(50);
		assertEquals(1050, testShip.getCoins());
		testShip.removeCoins(100);
		assertEquals(950, testShip.getCoins());
	}
	
	@Test
	public void increaseAttackMultTest() {
		assertEquals(29, testShip.getAttackMultiplier());
		testShip.increaseAttackMult();
		assertEquals(30, testShip.getAttackMultiplier());
		testShip.increaseAttackMult();
		assertEquals(30, testShip.getAttackMultiplier());
	}
	
	@Test
	public void increaseDefenceMultTest() {
		assertEquals(29, testShip.getDefenceMultiplier());
		testShip.increaseDefenceMult();
		assertEquals(30, testShip.getDefenceMultiplier());
		testShip.increaseDefenceMult();
		assertEquals(30, testShip.getDefenceMultiplier());
	}
	
	@Test
	public void increaseInventoryCapacityTest() {
		assertEquals(100, testShip.getMaxCapacity());
		testShip.increaseInventoryCapacity();
		assertEquals(110, testShip.getMaxCapacity());
	}

}
