package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backEnd.Item;
import backEnd.Ship;
import backEnd.Store;
import backEnd.Weapon;

import java.util.*;

class StoreTest {
	Store testStore = new Store();
	Item testItem;
	Item testItem2;
	Ship testShip;
	Weapon testWeapon;
	Weapon testWeapon2;
	ArrayList<Item> testItems = new ArrayList<Item>();
	ArrayList<Weapon> testWeapons = new ArrayList<Weapon>();
	
	@BeforeEach
	void init() {
		testStore = new Store("Test Store", 5);;
		testItem = new Item("Test Item", "Testing 123", "Item", 1, 5);
		testItem2 = new Item("Test Item 2", "Testing 123", "Item", 1, 5);
		testShip = new Ship("Test Ship", 10, 100, 10, 10, 5, "");
		testWeapon = new Weapon("Test Weapon", "Testing 123", "Weapon", 1, 5, 1);
		testWeapon2 = new Weapon("Test Weapon 2", "Testing 123", "Weapon", 1, 5, 1);
	}

	@Test
	public void buysItemTest() {
		assertFalse(testStore.buysItem(testItem));
		testStore.addItemBought(testItem);
		testStore.addSpecialItemBought(testItem2);
		
		assertTrue(testStore.buysItem(testItem));
		assertTrue(testStore.buysItem(testItem2));
	}
	
	@Test
	public void buysWeaponTest() {
		assertFalse(testStore.buysWeapon(testWeapon));
		testStore.addWeaponBought(testWeapon);
		
		assertTrue(testStore.buysWeapon(testWeapon));
	}
	
	@Test
	public void getItemsBoughtTest() {
		// Check store items bought is empty initially
		assertEquals(testItems, testStore.getItemsBought());
		
		testStore.addItemBought(testItem);
		testStore.addItemBought(testItem2);
		
		testItems.add(testItem);
		testItems.add(testItem2);
		
		// Have to check names because store creates a new object so it can modify the price
		assertEquals(testItems.get(0).getName(), testStore.getItemsBought().get(0).getName());
		assertEquals(testItems.get(1).getName(), testStore.getItemsBought().get(1).getName());
	}
	
	@Test
	public void getItemsSoldTest() {
		// Check store items bought is empty initially
		assertEquals(testItems, testStore.getItemsSold());
		
		testStore.addItemSold(testItem);
		testStore.addItemSold(testItem2);
		
		testItems.add(testItem);
		testItems.add(testItem2);
		
		// Have to check names because store creates a new object so it can modify the price
		assertEquals(testItems.get(0).getName(), testStore.getItemsSold().get(0).getName());
		assertEquals(testItems.get(1).getName(), testStore.getItemsSold().get(1).getName());
	}
	
	@Test
	public void getWeaponsBoughtTest() {
		// Check store items bought is empty initially
		assertEquals(testWeapons, testStore.getWeaponsBought());
		
		testStore.addWeaponBought(testWeapon);
		testStore.addWeaponBought(testWeapon2);
		
		testWeapons.add(testWeapon);
		testWeapons.add(testWeapon2);
		
		// Have to check names because store creates a new object so it can modify the price
		assertEquals(testWeapons.get(0).getName(), testStore.getWeaponsBought().get(0).getName());
		assertEquals(testWeapons.get(1).getName(), testStore.getWeaponsBought().get(1).getName());
	}
	
	@Test
	public void getWeaponsSoldTest() {
		// Check store items bought is empty initially
		assertEquals(testWeapons, testStore.getWeaponsSold());
		
		testStore.addWeaponSold(testWeapon);
		testStore.addWeaponSold(testWeapon2);
		
		testWeapons.add(testWeapon);
		testWeapons.add(testWeapon2);
		
		// Have to check names because store creates a new object so it can modify the price
		assertEquals(testWeapons.get(0).getName(), testStore.getWeaponsSold().get(0).getName());
		assertEquals(testWeapons.get(1).getName(), testStore.getWeaponsSold().get(1).getName());
	}
	
	@Test
	public void initStoreTest() {
		// Check testStore is a Store object
		assertTrue(testStore instanceof Store);
		// Check store name is correct
		assertEquals("Test Store", testStore.getStoreName());
		
	}
	
	@Test
	public void getPurchasePriceTest() {
		// Item not sold by store
		assertEquals(0, testStore.getPurchasePrice(testItem));
		assertEquals(0, testStore.getPurchasePrice(testWeapon));
		
		// Item sold by store
		testStore.addItemSold(testItem);
		testStore.addWeaponSold(testWeapon);
		assertEquals(25, testStore.getPurchasePrice(testItem));
		assertEquals(25, testStore.getPurchasePrice(testWeapon));
	}
	
	@Test
	public void getSalePriceTest() {
		// Item not sold by store
		assertEquals(0, testStore.getSalePrice(testItem));
		assertEquals(0, testStore.getSalePrice(testWeapon));
		
		// Item sold by store
		testStore.addItemBought(testItem);
		testStore.addWeaponBought(testWeapon);
		assertEquals(15, testStore.getSalePrice(testItem));
		assertEquals(15, testStore.getSalePrice(testWeapon));
	}
	
	@Test
	public void getItemsPlayerCanSellTest() {
		// Bought twice so the full functionality of store method is used
		testShip.buyItem(testItem, 5);
		testShip.buyItem(testItem, 5);
		testStore.addItemBought(testItem);
		assertEquals(testItem.getName(), testStore.getItemsPlayerCanSell(testShip).get(0).getName());
	}
	
	@Test
	public void getWeaponsPlayerCanSellTest() {
		// Bought twice so the full functionality of store method is used
		testShip.buyWeapon(testWeapon, 5);
		testShip.buyWeapon(testWeapon, 5);
		testStore.addWeaponBought(testWeapon);
		assertEquals(testWeapon.getName(), testStore.getWeaponsPlayerCanSell(testShip).get(0).getName());
	}
	

}
