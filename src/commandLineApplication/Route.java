package commandLineApplication;

import java.util.ArrayList;

public class Route {
	
	private int distance;
	private Island island1;
	private Island island2;
	private String name;
	private int eventMultiplier;
	ArrayList<Island> islands = new ArrayList<Island>();
	
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
	
	public int getDays(Ship shipName) {
		int speed = shipName.getSpeed();
		int days = distance / speed;
		return days;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public ArrayList<Island> getIslands() {
		return islands;
	}
	

	public String getDescription(String islandName) {
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
	
	public int getMultiplier() {
		return eventMultiplier;
	}
	
	
	

}
