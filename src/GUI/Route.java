package gui;

import java.util.ArrayList;

/**
 * The path thet the player can take from the island they are based to another island
 * <br>There are 2 different routes connecting 2 random islands, in total there are 20 routes in the systems
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
 *
 */
public class Route {
	/** the length of the route in km */
	private int distance;
	/** one island in one of the end of the route */
	private Island island1;
	/** the other island from the other end of the route */
	private Island island2;
	/** the name of the route */
	private String name;
	/** the likelihood of the random events during the trip on that route */
	private int eventMultiplier;
	/** the list of islands that the route will lead to */
	ArrayList<Island> islands = new ArrayList<Island>();
	
	/**
	 * Constructor of a route
	 * @param distance The length of the route (km)
	 * @param island1 The island on one end of the route
	 * @param island2 The island on the other end of the route
	 * @param name The name of the route
	 * @param eventMultiplier the likelihood that a random event will occur on the route
	 */
	public Route(int distance, Island island1, Island island2, String name, int eventMultiplier) {
		this.name = name;
		this.distance = distance;
		this.island1 = island1;
		this.island2 = island2;
		islands.add(island1);
		islands.add(island2);
		this.name = name;
		this.eventMultiplier = eventMultiplier;
	}
	
	//getter
	/**
	 * Get the amount of days the route will take for a ship to travel
	 * @param shipName The name of the ship that the player is using
	 * @return days
	 */
	public int getDays(Ship shipName) {
		int speed = shipName.getSpeed();
		int days = distance / speed;
		return days;
	}
	
	//getter
	/**
	 * Get the name of the route
	 * @return route's name
	 */
	public String getName() {
		return this.name;
	}
	
	//getter
	/**
	 * Get the length of the route
	 * @return route's distance
	 */
	public int getDistance() {
		return distance;
	}
	
	//getter
	/**
	 * Get a list of islands that the route connects
	 * @return island list
	 */
	public ArrayList<Island> getIslands() {
		return islands;
	}
	
	//getter
	/**
	 * Get the description of the route
	 * @param islandName The island where the player is situated at the moment
	 * @return message of description
	 */
	public String getDescription(String islandName) {
		// find which one of the 2 islands on the 2 ends of the route 
		// is the home island
		Island destination;
		if (islandName.equals(this.island2.getName())) {
			destination = this.island1;
		}
		else {
			destination = this.island2;
		}
		String destinationName = destination.getName();
		
		String mess = "\t" + this.name;
		mess += "\tDestination: " + destinationName + " (" + this.distance + "km)";
		mess += "\tThis route has " + this.eventMultiplier + "% chance of random events occurring\n";
		return mess;
	}
	

	public void getDescriptionNumbered(String islandName, int i) {
		Island destination;
		if (islandName.equals(this.island2.getName())) {
			destination = this.island1;
		}
		else {
			destination = this.island2;
		}
		String destinationName = destination.getName();
		
		System.out.println(i + " " + this.name);
		System.out.println("  Destination: " + destinationName + " (" + this.distance + "km)");
		System.out.println("  This route has " + this.eventMultiplier + "% chance of random events occurring\n");
	}
	
	//getter
	/**
	 * Get the event multiplier of the route, the likelihood of random events
	 * @return route's event multiplier
	 */
	public int getMultiplier() {
		return eventMultiplier;
	}
	
	
	

}
