package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import commandLineApplication.Island;
import commandLineApplication.Route;
import commandLineApplication.Ship;
import commandLineApplication.Store;

class RouteTest {

	@Test
	public void getDaysTest() {
		Ship testShip = new Ship("Test Ship", 10, 100, 10, 10, 5);
		Store testStore = new Store("Test Store", 5);
		Store testStore2 = new Store("Test Store 2", 5);
		Island testIsland = new Island("Test Island", testStore);
		Island testIsland2 = new Island("Test Island 2", testStore2);
		Route testRoute = new Route(10, testIsland, testIsland2, "Test Route", 100); 
		testShip.setLocation(testIsland);
		
		assertEquals(2, testRoute.getDays(testShip));
	}
	
	@Test
	public void getNameTest() {
		Store testStore = new Store("Test Store", 5);
		Store testStore2 = new Store("Test Store 2", 5);
		Island testIsland = new Island("Test Island", testStore);
		Island testIsland2 = new Island("Test Island 2", testStore2);
		Route testRoute = new Route(10, testIsland, testIsland2, "Test Route", 100); 
		assertEquals("Test Route", testRoute.getName());
	}
	
	@Test
	public void getDistanceTest() {
		Store testStore = new Store("Test Store", 5);
		Store testStore2 = new Store("Test Store 2", 5);
		Island testIsland = new Island("Test Island", testStore);
		Island testIsland2 = new Island("Test Island 2", testStore2);
		Route testRoute = new Route(10, testIsland, testIsland2, "Test Route", 100); 
		assertEquals(10, testRoute.getDistance());
	}
	
	@Test
	public void getIslandsTest() {
		Store testStore = new Store("Test Store", 5);
		Store testStore2 = new Store("Test Store 2", 5);
		Island testIsland = new Island("Test Island", testStore);
		Island testIsland2 = new Island("Test Island 2", testStore2);
		Route testRoute = new Route(10, testIsland, testIsland2, "Test Route", 100); 
		ArrayList<Island> testIslandsArray = new ArrayList<Island>();
		testIslandsArray.add(testIsland);
		testIslandsArray.add(testIsland2);
		assertEquals(testIslandsArray, testRoute.getIslands());
	}
	
	@Test
	public void getMultiplierTest() {
		Store testStore = new Store("Test Store", 5);
		Store testStore2 = new Store("Test Store 2", 5);
		Island testIsland = new Island("Test Island", testStore);
		Island testIsland2 = new Island("Test Island 2", testStore2);
		Route testRoute = new Route(10, testIsland, testIsland2, "Test Route", 100); 
		assertEquals(100, testRoute.getMultiplier());
	}
	
	
	
	
	

}
