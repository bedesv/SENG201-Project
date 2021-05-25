package backEnd;

import java.util.ArrayList;

/**
 * The path that the player can take from the island they are based to another island
 * <br>There are 2 different routes connecting each pair of islands, in total there are 20 routes in the game
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class Route {
	/** the length of the route in km */
	private int distance;
	/** the name of the route */
	private String name;
	/** the likelihood of the random events during a voyage on that route */
	private int eventMultiplier;
	/** the list of islands that the route will lead to */
	ArrayList<Island> islands = new ArrayList<Island>();
	
	/**
	 * Constructor of a route
	 * Constructs an empty route
	 */
	public Route() {
	}
	
	/**
	 * Constructor of a route
	 * @param distance The length of the route (km)
	 * @param island1 The island on one end of the route
	 * @param island2 The island on the other end of the route
	 * @param name The name of the route
	 * @param eventMultiplier The likelihood that a random event will occur on the route
	 */
	public Route(int distance, Island island1, Island island2, String name, int eventMultiplier) {
		this.name = name;
		this.distance = distance;
		islands.add(island1);
		islands.add(island2);
		this.name = name;
		this.eventMultiplier = eventMultiplier;
	}
	
	//getter
	/**
	 * Get the amount of days the route will take for a ship to travel
	 * @param ship The name of the ship that the player is using
	 * @return The number of days it will take the given ship to travel the route
	 */
	public int getDaysToTravel(Ship ship) {
		int speed = ship.getSpeed();
		int days = distance / speed;
		return days;
	}
	
	//getter
	/**
	 * Get the cost for the travel
	 * @param ship The name of the ship that the player is using
	 * @return The cost for the given ship to travel the route
	 */
	public int getCost(Ship ship) {
		return ship.getCostToSail(this.getDaysToTravel(ship));
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
	 * Get the event multiplier of the route, the likelihood of random events
	 * @return route's event multiplier
	 */
	public int getMultiplier() {
		return eventMultiplier;
	}
	
	
	

}
