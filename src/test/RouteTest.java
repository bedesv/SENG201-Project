package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import commandLineApplication.Island;
import commandLineApplication.Route;
import commandLineApplication.Ship;
import commandLineApplication.Store;

class RouteTest {
	Ship testShip;
	Store testStore;
	Store testStore2;
	Island testIsland;
	Island testIsland2;
	Route testRoute;
	ArrayList<Island> testIslandsArray = new ArrayList<Island>();
	
	@BeforeEach
	void init() {
		testShip = new Ship("Test Ship", 10, 100, 10, 10, 5);
		testStore = new Store("Test Store", 5);
		testStore2 = new Store("Test Store 2", 5);
		testIsland = new Island("Test Island", testStore);
		testIsland2 = new Island("Test Island 2", testStore2);
		testRoute = new Route(10, testIsland, testIsland2, "Test Route", 100); 
		
		testIslandsArray.add(testIsland);
		testIslandsArray.add(testIsland2);
		
	}

	@Test
	public void getDaysTest() {
		testShip.setLocation(testIsland);
		
		assertEquals(2, testRoute.getDays(testShip));
	}
	
	@Test
	public void getNameTest() {
		assertEquals("Test Route", testRoute.getName());
	}
	
	@Test
	public void getDistanceTest() {
		assertEquals(10, testRoute.getDistance());
	}
	
	@Test
	public void getIslandsTest() {
		assertEquals(testIslandsArray, testRoute.getIslands());
	}
	
	@Test
	public void getMultiplierTest() {
		assertEquals(100, testRoute.getMultiplier());
	}
	


}
