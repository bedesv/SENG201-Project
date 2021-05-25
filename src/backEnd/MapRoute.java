package backEnd;

import java.util.ArrayList;

/**
 * To find routes between 2 islands and shows map of them
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class MapRoute {
	/** The string of location of the image */
	private String imgString;
	/** The route with less chance of random events */
	private Route safeRoute;
	/** The route with more chance of random events */
	private Route dangerousRoute;
	
	/**
	 * Constructor of the map
	 * Empty
	 */
	public MapRoute() {
	}
	
	/**
	 * Constructor of the map
	 * @param imgString The string of location of the image
	 * @param safeRoute The route with less chance of random events
	 * @param dangerousRoute route with more chance of random events
	 */
	public MapRoute(String imgString, Route safeRoute, Route dangerousRoute) {
		this.imgString = imgString;
		this.safeRoute = safeRoute;
		this.dangerousRoute = dangerousRoute;
	}
	
	//getter
	/**
	 * Get the string of location of the image
	 * @return image string
	 */
	public String getImgString() {
		return this.imgString;
	}
	
	//getter
	/**
	 * Get the route with less chance of random events
	 * @return safe route
	 */
	public Route getSafeRoute() {
		return this.safeRoute;
	}
	
	//getter
	/**
	 * Get the route with more chance of random events
	 * @return dangerous route
	 */
	public Route getDangerousRoute() {
		return this.dangerousRoute;
	}
	
	/**
	 * Show to map of the rooutes between islands
	 * @param selectedIsland The islands that are selected to be the next destination
	 * @param player The player of the game
	 * @param safeRoute The route with less chance of random events
	 * @param dangerousRoute The route with more chance of random events
	 * @return
	 */
	public MapRoute findMapImage(Island selectedIsland, Player player, Route safeRoute, Route dangerousRoute) {
		String imageString = "";
		Island currentLocation = player.getCurrLocation();
		ArrayList<Route> routes = currentLocation.getRoutes(selectedIsland);
		
		safeRoute = routes.get(0);
		dangerousRoute = routes.get(1);
		
		switch(routes.get(0).getName()) {
		case "Arid Trail":
			imageString = "/Images/Remote Refuge and Raining Archipelago No Label.png";
			break;
			
		case "Dragonfire Route":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Remote Refuge and Raining Archipelago No Label.png";
			break;
			
		case "Trepidation Pass":
			imageString = "/Images/Remote Refuge and Brightwich Island No Label.png";
			break;
			
		case "The Glistening Deep":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Remote Refuge and Brightwich Island No Label.png";
			break;
		
		case "Salfil Waters":
			imageString = "/Images/Remote Refuge and Crosser Peninsula No Label.png";
			break;
			
		case "Terrenronto Waters":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Remote Refuge and Crosser Peninsula No Label.png";
			break;
			
		case "The Empty Bay":
			imageString = "/Images/Remote Refuge and Arborland Islet No Label.png";
			break;
			
		case "The Bursting Waves":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Remote Refuge and Arborland Islet No Label.png";
			break;
			
		case "Chillwater Sea":
			imageString = "/Images/Raining Archipelago and Brightwich Island No Label.png";
			break;
			
		case "The Darkest Depths":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Raining Archipelago and Brightwich Island No Label.png";
			break;
			
		case "Cartvons Bay":
			imageString = "/Images/Raining Archipelago and Crosser Peninsula No Label.png";
			break;
			
		case "The Troubled Ocean":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Raining Archipelago and Crosser Peninsula No Label.png";
			break;
			
		case "The Narrow Gulf":
			imageString = "/Images/Arborland Islet and Raining Archipelago No Label.png";
			break;
			
		case "The Ocean of Woodbourg":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Arborland Islet and Raining Archipelago No Label.png";
			break;
			
		case "The Sunny Domain":
			imageString = "/Images/Brightwich Island and Crosser Peninsula No Label.png";
			break;
			
		case "The Dark Ocean":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Brightwich Island and Crosser Peninsula No Label.png";
			break;
			
		case "The Coral Ocean":
			imageString = "/Images/Arborland Islet and Brightwich Island No Label.png";
			break;
			
		case "The Hungry Depths":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Arborland Islet and Brightwich Island No Label.png";
			break;
			
		case "The Wasting Bay":
			imageString = "/Images/Arborland Islet and Crosser Peninsula No Label.png";
			break;
			
		case "The Grave Sea":
			safeRoute = routes.get(1);
			dangerousRoute = routes.get(0);
			imageString = "/Images/Arborland Islet and Crosser Peninsula No Label.png";
			break;
		}
		MapRoute result = new MapRoute(imageString, safeRoute, dangerousRoute);
		return result;
	}
}
