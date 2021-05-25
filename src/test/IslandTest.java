package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import backEnd.Island;
import backEnd.Route;
import backEnd.Store;

class IslandTest {
	Store testStore;
	Store testStore2;
	Island testIsland;
	Island testIsland2;
	Route testRoute;
	
	
	@BeforeEach
	void init() {
		testStore = new Store("Test Store", 5);
		testStore2 = new Store("Test Store 2", 5);
		testIsland = new Island("Test Island", testStore);
		testIsland2 = new Island("Test Island 2", testStore2);	
		testRoute = new Route(10, testIsland, testIsland2, "Test Route", 100); 
	}
	
	

	@Test
	public void getNameTest() {
		assertEquals("Test Island", testIsland.getName());
	}
	
	@Test
	public void getStoreTest() {
		assertEquals(testStore, testIsland.getStore());
	}
	
	@Test
	public void getRoutesTest() {
		Route testRoute = new Route(10, testIsland, testIsland2, "Test Route", 100); 
		testIsland.addRoute(testRoute);
		testIsland2.addRoute(testRoute);
		
		assertEquals(testRoute, testIsland.getRoutes(testIsland2).get(0));
	}
	
	

}
