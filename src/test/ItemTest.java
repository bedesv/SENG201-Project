package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commandLineApplication.Island;
import commandLineApplication.Item;
import commandLineApplication.Store;

class ItemTest {
	Item testItem;
	Store testStore;
	Island testIsland;
	
	@BeforeEach
	void init() {
		testItem = new Item("Test Item", "An Item used for testing", "Test", 5, 10);
		testStore = new Store("Test Store", 5);
		testIsland = new Island("Test Island", testStore);
	}
	

	@Test
	public void getNameTest() {
		assertEquals("Test Item", testItem.getName());
	}
	
	@Test
	public void copyTest() {
		assertTrue(testItem.equals(testItem.copy()));
	}
	
	@Test
	public void getPriceTest() {
		assertEquals(10, testItem.getPrice());
	}
	
	@Test
	public void getTypeTest() {
		assertEquals("Test", testItem.getType());
	}
	
	@Test
	public void getSizeTest() {
		assertEquals(5, testItem.getSize());
	}
	
	@Test
	public void getDescriptionTest() {
		assertEquals("An Item used for testing", testItem.getDescription());
	}
	
	@Test
	public void sellItemTest() {
		testItem.sellItem(testIsland, 100);
		
		assertEquals(testIsland, testItem.getIslandSoldOn());
		assertEquals(100, testItem.getSoldPrice());
		
	}
	
	@Test
	public void buyItemTest() {
		testItem.buyItem(100);
		assertEquals(100, testItem.getPurchasedPrice());
	}	
	
	
	

}
