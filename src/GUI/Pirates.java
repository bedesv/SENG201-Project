package gui;

/**
 * A type of the random events player may meet while sailing
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class Pirates extends RandomEvent{
	
	/**
	 * Constructor of pirate event
	 */
	public Pirates() {
	}
	
	/**
	 * Player meets pirates and needs to play a dice game to battle with them
	 * @param shipName The name of the ship the player is using
	 * @return true (if the player overcomes the battle) or false (if the player loses the entire game)
	 */
	public int pirateBattle(Ship shipName, SelectRouteWindow selectRouteWindow) {
		int shipAttackMultiplier = shipName.getAttackMultiplier();
		// the player has to get a greater number from the dice than this to win
		// higher ship attack multiplier yields higher probability to win
		int bound = 25 - shipAttackMultiplier;
		if (bound < 0) {
			bound = 0;
		}
		
		selectRouteWindow.rollDice("Oh no! You encounter pirates. They will try to board your ship and steal your goods.\n"
				+ "The pirates challenge you to a 30 sided dice battle.\nYour number needs to be greater than " + bound + " to beat the pirates and secure your goods.");
		
		// the dice has the values ranging from 1 to 30
		int small = 1;
		int big = 30;
		// run a random number as the player's result
		int randomNum = (int) (Math.random() * (big - small + 1) + small);
		
		// player wins the dice game
		if (randomNum > bound) {
			selectRouteWindow.showMessage("Congratulations! You've got a " + randomNum + " from your dice battle with the pirates and WON!!!");
			selectRouteWindow.showMessage("You can keep all of your items and continue on your journey. Good luck!");
		}
		
		// player loses to dice game
		else {
			selectRouteWindow.showMessage("Bad luck... You've got a " + randomNum + " and the pirates won.\nThey are going to take your items.");
			// randomize how much the pirates want
			int pirateRandom = (int) (Math.random() * (7 - 1 + 1) + 1);
			int pirateWants = 2000 * (30 - randomNum * pirateRandom);
			
			// if the inventory satisfies the pirates and they take it all
			if (shipName.inventoryValue() >= pirateWants) {
				shipName.clearInventory();
				selectRouteWindow.showMessage("Your goods satisfy the pirates.\nThey will let you go now.");	
			}
			
			// if the pirates do not satisfy with the inventory
			else {
				selectRouteWindow.showMessage("Too bad... Your goods don't satisfy the pirates.\n"
						+ "They will take your ship and make you and your crew walk the plank.\n");
				// the whole game ends here
				return 1;
			}
		}
		// keep playing
		return 0;
	}

}
