package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commandLineApplication.Island;
import commandLineApplication.Item;
import commandLineApplication.Store;

class ItemTest {

	@Test
	public void getNameTest() {
		Item testItem = new Item("Test Item", "An Item used for testing", "Test", 5, 10);
		assertEquals("Test Item", testItem.getName());
	}
	
	@Test
	public void copyTest() {
		Item testItem = new Item("Test Item", "An Item used for testing", "Test", 5, 10);
		assertTrue(testItem.equals(testItem.copy()));
	}
	
	@Test
	public void getPriceTest() {
		Item testItem = new Item("Test Item", "An Item used for testing", "Test", 5, 10);
		assertEquals(10, testItem.getPrice());
	}
	
	@Test
	public void getTypeTest() {
		Item testItem = new Item("Test Item", "An Item used for testing", "Test", 5, 10);
		assertEquals("Test", testItem.getType());
	}
	
	@Test
	public void getSizeTest() {
		Item testItem = new Item("Test Item", "An Item used for testing", "Test", 5, 10);
		assertEquals(5, testItem.getSize());
	}
	
	@Test
	public void getDescriptionTest() {
		Item testItem = new Item("Test Item", "An Item used for testing", "Test", 5, 10);
		assertEquals("An Item used for testing", testItem.getDescription());
	}
	
	@Test
	public void sellItemTest() {
		Item testItem = new Item("Test Item", "An Item used for testing", "Test", 5, 10);
		Store testStore = new Store("Test Store", 5);
		Island testIsland = new Island("Test Island", testStore);
		
		testItem.sellItem(testIsland, 100);
		
		assertEquals(testIsland, testItem.getIslandSoldOn());
		assertEquals(100, testItem.getSoldPrice());
		
	}
	
	@Test
	public void buyItemTest() {
		Item testItem = new Item("Test Item", "An Item used for testing", "Test", 5, 10);
		testItem.buyItem(100);
		assertEquals(100, testItem.getPurchasedPrice());
	}	
	
	
	

}
