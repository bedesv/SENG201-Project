package main;

public class Weather extends RandomEvents{
	
	public Weather() {
		super("Storm coming");
	}
	
	public void storm(Ship shipName) {
		
		// generate the damage
		int small = 10;
		int big = 70;
		int damage = (int) (Math.random() * (big - small + 1) + small);
		System.out.println("The storm has damaged " + damage + "% of your ship.\nPlease repair it upon your arrival to the new island");
		
		shipName.repairShip();
	}

}
