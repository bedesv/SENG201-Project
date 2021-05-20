package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commandLineApplication.Item;
import commandLineApplication.Ship;
import commandLineApplication.Store;

import java.util.*;

class StoreTest {

	@Test
	public void buysItemTest() {
		Store testStore = new Store("Test Store", 5);
		Item testBanana = new Item("Banana", "A yummy fruit", "Food", 1, 5);
		
		assertFalse(testStore.buysItem(testBanana));
		testStore.addItem(testBanana);
		
		assertTrue(testStore.buysItem(testBanana));
	}
	
	@Test
	public void getStoreNameTest() {
		Store testStore = new Store("Test Store", 5);
		assertEquals("Test Store", testStore.getStoreName());
	}
	
	@Test
	public void getPurchasePriceTest() {
		Store testStore = new Store("Test Store", 5);
		Item testBanana = new Item("Banana", "A yummy fruit", "Food", 1, 5);
		
		// Item not sold by store
		assertEquals(0, testStore.getPurchasePrice(testBanana));
		
		// Item sold by store
		testStore.addItem(testBanana);
		assertEquals(25, testStore.getPurchasePrice(testBanana));
	}
	
	@Test
	public void enterStoreTest() {
		Store testStore = new Store("Test Store", 5);
		Ship testShip = new Ship("Test Ship", 10, 100, 10, 10, 5);
		Item testBanana = new Item("Banana", "A yummy fruit", "Food", 1, 5);
		testStore.addItem(testBanana);
		
		Scanner input = new Scanner("4\n"
								  + "1\n"
								  + "2\n"
								  + "1\n"
								  + "4\n"
								  + "1\n"
								  + "g\n"
								  + "n\n"
								  + "1\n"
								  + "y\n"
								  + "3\n");
		
		testStore.enterStore(input, testShip);
		
		input = new Scanner("2\n"
						  + "2\n"
						  + "2\n"
						  + "4\n"
						  + "1\n"
						  + "g\n"
						  + "n\n"
						  + "1\n"
						  + "y\n"
						  + "3\n");
		testStore.enterStore(input, testShip);
		
		input = new Scanner("2\n"
						  + "3\n");
		testStore.enterStore(input, testShip);
	}

}
