package main;

import java.util.ArrayList;

public class Route {
	
	private int distance;
	private Island island1;
	private Island island2;
	private String name;
	private int eventMultiplier;
	
	public Route(int distance, Island island1, Island island2, String name, int eventMultiplier) {
		this.name = name;
		this.distance = distance;
		this.island1 = island1;
		this.island2 = island2;
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
		ArrayList<Island> islands = new ArrayList<Island>();
		islands.add(this.island1);
		islands.add(this.island2);
		return islands;
	}
	

	public void getDescription(String islandName) {
		Island destination;
		Island island1 = this.getIsland1();
		Island island2 = this.getIsland2();
		if (islandName.equals(island2.getName())) {
			destination = island1;
		}
		else {
			destination = island2;
		}
		String destinationName = destination.getName();
		
		System.out.println("\t" + this.name);
		System.out.println("\tDestination: " + destinationName + " (" + this.distance + "km)");
		System.out.println("\tThis route has " + this.eventMultiplier + "% chance of random events occurring\n");
	}
	
	public void getDescriptionNumbered(String islandName, int i) {
		Island destination;
		Island island1 = this.getIsland1();
		Island island2 = this.getIsland2();
		if (islandName.equals(island2.getName())) {
			destination = island1;
		}
		else {
			destination = island2;
		}
		String destinationName = destination.getName();
		
		System.out.println(i + " " + this.name);
		System.out.println("  Destination: " + destinationName + " (" + this.distance + "km)");
		System.out.println("  This route has " + this.eventMultiplier + "% chance of random events occurring\n");
	}
	
	public int getMultiplier() {
		return eventMultiplier;
	}
	
	public Island getIsland1() {
		return island1;
	}
	
	public Island getIsland2() {
		return island2;
	}
	
	public void travel(Ship shipName) {
		
	}

}
