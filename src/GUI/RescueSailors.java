package GUI;

/**
 * A type of the random events player may meet while sailing
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
 *
 */
public class RescueSailors extends RandomEvent{
	
	/**
	 * Constructor of rescue sailor event
	 */
	public RescueSailors() {
	}
	
	/**
	 * Player finds another sailor and rescue him
	 * <br>In return, that sailor will reward the player with coins
	 * @param ship The ship they the player is using
	 */
	public void findSailors(Ship ship, SelectRouteWindow selectRouteWindow) {
		selectRouteWindow.showMessage("You come across the floating wreckage of another ship. It looks like a storm ripped it apart\n" +
		"You see some survivors waving from a part of the wreckage and rescue them\n" +
		"They have a chest of coins with them and give it to you for saving them");
		// randomize the amount the player will receive, from 500 to 2000 coins
		int randomCoinReceived = (int) (Math.random() * (2000 - 500 + 1) + 500);
		selectRouteWindow.showMessage("The chest contains " + randomCoinReceived + " coins");
		ship.addCoins(randomCoinReceived);
		ship.printCoins();
		
		
		
	}

}
