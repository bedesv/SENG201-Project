package main;

import java.util.ArrayList;

/**
 * Island is either home or destination for a ship. There are 5 in total.
 * <br> Each has a shop and 2 routes to each of the other islands.
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
 *
 */
public class Island {

	private String islandName;
	private Store store;
	private ArrayList<Route> routeList;
	
	/**
	 * A constructor for an island object. Also creates an array list for possible routes from it.
	 * @param name Default by button, the name of the island
	 * @param store Default, a specific store only on that island
	 */
	public Island(String name, Store store) {
		this.islandName = name;
		this.store = store;
		this.routeList = new ArrayList<Route>();
	}
	
	/**
	 * A method to add routes from a specific island to other islands in its route list
	 * @param route A specific way from one island to another with unique characteristics
	 */
	public void addRoute(Route route) {
		routeList.add(route);
	}
	
	//getter
	/**
	 * Get an Island's name
	 * @return island's name
	 */
	public String getName() {
		return islandName;
	}
	
	//getter
		/**
		 * Get the store (object) on the island
		 * @return island's store
		 */
	public Store getStore() {
		return store;
	}
	
	//getter
	/**
	 * Get the list of the possible routes player can travel from home island
	 * @return island's list of routes
	 */
	public ArrayList<Route> getRoutes(Island destination){
		ArrayList<Route> possibleRoutes = new ArrayList<Route>();
		for (Route route : routeList) {
			if (route.getIslands().contains(this) && route.getIslands().contains(destination)) {
				possibleRoutes.add(route);
			}
		}
		return possibleRoutes;	
	}
	
	/**
	 * To view the property on the island
	 */
	public void viewPropertyIsland() {
		//island name
		System.out.println(islandName);
		//route info
		System.out.println("\nPossible routes from " + islandName + ":\n");
		
		for (Route route : routeList) {
			route.getDescription(islandName);
		}
		//store info
		String storeName = store.getStoreName();
		System.out.println("Store: " + storeName);
		//call methods to view items bought and sold from the store on the island
		store.viewItemsBought();
		store.viewItemsSold();
	}
	
	/**
	 * To show the property of an island when calling it as an object
	 * @return the string that has all the details of the property of an island
	 */
	public String toString() {
		String mess = "Possible routes from " + islandName + ":\n";
		for (Route route : routeList) {
			mess += route.getDescription(islandName);
		}
		String storeName = store.getStoreName();
		mess += "Store: " + storeName + "\n";
		mess += store;
		return mess;
	}
	
	

}
