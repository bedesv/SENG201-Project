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
	
	public ArrayList<Route> getRoutes(Island destination){
		ArrayList<Route> possibleRoutes = new ArrayList<Route>();
		for (Route route : routeList) {
			if (route.getIslands().contains(this) && route.getIslands().contains(destination)) {
				possibleRoutes.add(route);
			}
		}
		return possibleRoutes;
		
	}
	
	public void viewPropertyIsland() {
		
		System.out.println(islandName);
		
		//route info
		System.out.println("\nPossible routes from " + islandName + ":\n");
		
		for (Route route : routeList) {
			route.getDescription(islandName);
		}
		
		//store info
		String storeName = store.getStoreName();
		System.out.println("Store: " + storeName);
		store.viewItemsBought();
		store.viewItemsSold();
	}
	
	

}
