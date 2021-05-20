package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import commandLineApplication.Island;
import commandLineApplication.Route;
import commandLineApplication.Store;

class IslandTest {

	@Test
	public void getNameTest() {
		Store testStore = new Store("Test Store", 5);
		Island testIsland = new Island("Test Island", testStore);
		assertEquals("Test Island", testIsland.getName());
	}
	
	@Test
	public void getStoreTest() {
		Store testStore = new Store("Test Store", 5);
		Island testIsland = new Island("Test Island", testStore);
		
		assertEquals(testStore, testIsland.getStore());
	}
	
	@Test
	public void getRoutesTest() {
		Store testStore = new Store("Test Store", 5);
		Store testStore2 = new Store("Test Store 2", 5);
		Island testIsland = new Island("Test Island", testStore);
		Island testIsland2 = new Island("Test Island 2", testStore2);
		
		Route testRoute = new Route(10, testIsland, testIsland2, "Test Route", 100); 
		testIsland.addRoute(testRoute);
		testIsland2.addRoute(testRoute);
		
		assertEquals(testRoute, testIsland.getRoutes(testIsland2).get(0));
	}
	
	

}
