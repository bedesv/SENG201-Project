package main;

import java.util.ArrayList;

public class Island {

	private String islandName;
	private Store store;
	private ArrayList<Route> routeList;
	
	public Island(String name, Store store) {
		this.islandName = name;
		this.store = store;
		this.routeList = new ArrayList<Route>();
	}
	
	public void addRoute(Route route) {
		routeList.add(route);
	}


	public String getName() {
		return islandName;
	}
	
	public Store getStore() {
		return store;
	}
	
	public ArrayList<Route> getRoutes(){
		return routeList;
	}
	
	public void viewPropertyIsland() {
		
		System.out.println(islandName);
		
		//route info
		System.out.println("\nPossible routes from " + islandName + ":\n");
		
		for (Route route : routeList) {
			Island destination;
			int routeDistance = route.getDistance();
			String routeDescription = route.getDescription();
			int eventMultiplier = route.getMultiplier();
			Island island1 = route.getIsland1();
			Island island2 = route.getIsland2();
			if (islandName.equals(island2.getName())) {
				destination = island1;
			}
			else {
				destination = island2;
			}
			String destinationName = destination.getName();
			
			System.out.println("\t" + routeDescription);
			System.out.println("\tDestination: " + destinationName + " (" + routeDistance + "km)");
			System.out.println("\tThis route has " + eventMultiplier + "% chance of random events occurring\n");
		}
		
		//store info
		String storeName = store.getStoreName();
		System.out.println("Store: " + storeName);
		store.viewItemsBought();
		store.viewItemsSold();
	}
	
	

}
