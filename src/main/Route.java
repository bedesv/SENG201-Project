package main;

public class Route {
	
	private int days;
	private int distance;
	private Island island1;
	private Island island2;
	private String description;
	private int eventMultiplier;
	
	public Route(int days, int distance, Island island1, Island island2, String description, int eventMultiplier) {
		this.days = days;
		this.distance = distance;
		this.island1 = island1;
		this.island2 = island2;
		this.description = description;
		this.eventMultiplier = eventMultiplier;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public String getDescription() {
		return description;
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
