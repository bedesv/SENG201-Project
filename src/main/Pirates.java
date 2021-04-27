package main;

import java.util.ArrayList;

public class Pirates extends RandomEvents{
	
	
	public Pirates() {
		super("Encounter Pirates");
	}
	
	public boolean pirateBattle(Ship shipName) {
		int shipMultiplier = shipName.getShipMultiplier();
		int bound = 20 * (int) shipMultiplier;
		ArrayList<Item> listOfItems = shipName.getItems();
		int coins = shipName.getCoins();
		
		System.out.println("Oh no! You encounter pirates. They will try to board your ship and steal your goods.\n"
				+ "Please accept the battle challenge and roll your dice\nYour number need to be greater than " + bound + " to win the pirates and secure your goods.");
		
		// run a random number
		int small = 1;
		int big = 30;
		
		int randomNum = (int) (Math.random() * (big - small + 1) + small);
		
		// for generic case, need to be over 20 out of 30
		if (randomNum > bound) {
			System.out.println("Congratulations! You've got a " + randomNum + " from your dice battle with the pirate and WON!!!");
			System.out.println("You can keep all of your inventories and continue with your journey. Good luck!");
		}
		
		else {
			System.out.println("Bad luck... You've got a " + randomNum + " and the Pirate won.\nHe is going to take your inventories.");
			int pirateRandom = (int) (Math.random() * (7 - 1 + 1) + 1);
			int pirateWants = 2000 * (30 - randomNum * pirateRandom);
			
			
			if (coins >= pirateWants) {
				// create a method to delete all of the items on the ship in Ship class
				listOfItems = shipName.getItems();
				System.out.println("Your goods satisfy the pirate.\nHe will let you go now.");	
			}
			else {
				System.out.println("Too bad... Your goods don't satisfy the pirate.\n"
						+ "He'll take your ship and your money and make you and your crew walk the plank.\n"
						+ "Unfortunately, the game is over.");
				return false;
				
			}
		}
		return true;
	}

}
