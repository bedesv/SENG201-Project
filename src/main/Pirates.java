package main;


public class Pirates extends RandomEvent{
	
	
	public Pirates() {
		super("Encounter Pirates");
	}
	
	public boolean pirateBattle(Ship shipName) {
		int shipAttackMultiplier = shipName.getAttackMultiplier();
		int bound = 25 - shipAttackMultiplier;
		int coins = shipName.getCoins();
		
		System.out.println("Oh no! You encounter pirates. They will try to board your ship and steal your goods.\n"
				+ "The pirates challenge you to a dice battle.\nYour number need to be greater than " + bound + " to beat the pirates and secure your goods.");
		
		// run a random number
		int small = 1;
		int big = 30;
		
		int randomNum = (int) (Math.random() * (big - small + 1) + small);
		
		// for generic case, need to be over 20 out of 30
		
		
		if (randomNum > bound) {
			System.out.println("Congratulations! You've got a " + randomNum + " from your dice battle with the pirates and WON!!!");
			System.out.println("You can keep all of your items and continue on your journey. Good luck!");
		}
		
		else {
			System.out.println("Bad luck... You've got a " + randomNum + " and the pirates won.\nThey are going to take your items.");
			int pirateRandom = (int) (Math.random() * (7 - 1 + 1) + 1);
			int pirateWants = 2000 * (30 - randomNum * pirateRandom);
			
			
			if (shipName.inventoryTotal() >= pirateWants) {
				// create a method to delete all of the items on the ship in Ship class
				shipName.clearInventory();
				System.out.println("Your goods satisfy the pirates.\nThey will let you go now.");	
			}
			else {
				System.out.println("Too bad... Your goods don't satisfy the pirates.\n"
						+ "They will take your ship and items and make you and your crew walk the plank.\n"
						+ "Unfortunately, the game is over.");
				return false;
				// go to GE to end game
				
			}
		}
		return true;
		// keep playing
	}

}
