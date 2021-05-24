package gui;

import java.util.ArrayList;

/**
 * A type of the random events player may meet while sailing
 * @author Aerinn Nguyen, Bede Skinner-Vennell
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
	public EventInfo findSailors(Ship ship) {
		ArrayList<String> messages = new ArrayList<String>();
		messages.add("You come across the floating wreckage of another ship. It looks like a storm ripped it apart\n" +
		"You see some survivors waving from a part of the wreckage and rescue them\n" +
		"They have a chest of coins with them and give it to you for saving them");
		
		// randomize the amount the player will receive, from 500 to 2000 coins
		int randomCoinReceived = (int) (Math.random() * (2000 - 500 + 1) + 500);
		messages.add("The chest contains " + randomCoinReceived + " coins");
		ship.addCoins(randomCoinReceived);
		
		EventInfo result = new EventInfo(0, 3, messages);
		
		return result;
		
		
		
	}

}
