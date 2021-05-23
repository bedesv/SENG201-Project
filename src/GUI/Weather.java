package GUI;

/**
 * A type of the random events player may meet while sailing
 * @author Aerinn Nguyen, Bede Skinner-Vennell
 *
 */
public class Weather extends RandomEvent{
	
	/**
	 * Constructor of meeting unfavorable weather event
	 */
	public Weather() {
	}
	
	/**
	 * A storm hits the ship when the player is sailing
	 * <br> This will add some damage to the ship and requires repair before sailing again
	 * @param ship
	 * @return true (if the game continues) or false (otherwise)
	 */
	public int storm(Ship ship, SelectRouteWindow selectRouteWindow) {
		selectRouteWindow.showMessage("A storm hits you unexpectedly, brace yourself.");
		int sailSuccess = 0;
		// randomise the damage that will be caused to the ship
		int damage = (int) (Math.random() * (6)) * ship.getDefenceMultiplier();
		if (damage == 0) {
			selectRouteWindow.showMessage("You managed to pass through the storm unscathed");
		} 
		else if (damage == 100) {
			selectRouteWindow.showMessage("The storm was much worse than you feared. It ripped your ship apart and your whole crew drowned");
			sailSuccess = 2;
		} 
		else {
			selectRouteWindow.showMessage("The storm has damaged " + damage + "% of your ship.\nYou must repair it before you can depart the next island");
			ship.takeDamage(damage);
		}
		return sailSuccess;
	}

	

}