package gui;

/**
 * A type of the random events player may meet while sailing
 * @author Aerinn Nguyen, Bede Skinnier-Vennell
 *
 */
public class Weather extends RandomEvent{
	
	public Weather() {
	}
	
	/**
	 * A storm hits the ship when the player is sailing
	 * <br> This will add some damage to the ship and requires repair before sailing again
	 * @param ship
	 * @return true (if the game continues) or false (otherwise)
	 */
	public boolean storm(Ship ship) {
		System.out.println("A storm hits you unexpectedly, brace yourself.");
		boolean gameCont = true;
		// randomise the damage that will be caused to the ship
		int damage = (int) (Math.random() * (6)) * ship.getDamageMultiplier();
		if (damage == 0) {
			System.out.println("You managed to pass through the storm unscathed");
		} 
		else if (damage == 100) {
			System.out.println("The storm was much worse than you feared. It ripped your ship apart and your whole crew drowned");
			gameCont = false;
		} 
		else {
			System.out.println("The storm has damaged " + damage + "% of your ship.\nYou must repair it before you can depart the next island");
			ship.takeDamage(damage);
		}
		return gameCont;
	}

	
	public static void main(String[] args) {
		for (int i=0; i<1000;i++) {
			System.out.println((int) (Math.random() * (300 - 50 + 1) + 50));
		}
	}

}