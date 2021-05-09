package main;

public class RescueSailors extends RandomEvent{
	
	public RescueSailors() {
	}
	
	public void findSailors(Ship ship) {
		
		System.out.println("You come across the floating wreckage of another ship. It looks like a storm ripped it apart");
		System.out.println("You see some survivors waving from a part of the wreckage and rescue them");
		System.out.println("They have a chest of coins with them and give it to you for saving them");
		int randomCoinReceived = (int) (Math.random() * (2000 - 500 + 1) + 500);
		System.out.println("The chest contains " + randomCoinReceived + " coins");
		ship.addCoins(randomCoinReceived);
		ship.printCoins();
		
		
		
	}

}
