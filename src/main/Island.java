package main;

import java.util.ArrayList;

public class Island {

	private String islandName;
	private Store store;
	private ArrayList<Route> routeList;
	
	public Island(String name, Store store, ArrayList<Route> routeList) {
		this.islandName = name;
		this.store = store;
		this.routeList = routeList;
	}
	
	public void addRoute() {
		
	}
	
	

	public String getName() {
		return islandName;
	}
	


}
