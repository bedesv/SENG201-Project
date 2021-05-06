package main;

public class RescueSailors extends RandomEvents{
	
	public RescueSailors() {
		super("Rescue a sailor");
	}
	
	public void sailorReward(Ship shipName) {
		
		// receive between 50 and 300 coins
		int randomCoinRecieved = (int) (Math.random() * (300 - 50 + 1) + 50);
		
		shipName.addCoin(randomCoinRecieved);
		
	}

}
