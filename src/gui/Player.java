package gui; 

public class Player { 

	private Ship selectedShip;
	private String name;
	private int maxDays;
	private boolean unlimitedDays;
	
	 
	public Player(Ship ship, Island startingLocation, String name, int days) {
		
		this.selectedShip = ship;
		this.selectedShip.setLocation(startingLocation);
		this.name = name;
		
		if (days > 0) {
			this.maxDays = days;
			unlimitedDays = false;
		} else {
			unlimitedDays = true;
		}
	}
	
	public int getCoins() {
		return selectedShip.getCoins();
	}
	
	public void repairShip() {
		selectedShip.repairShip();
	}
	
	public String getShipCapacity() {
		return selectedShip.getCurrCapacity() + "/" + selectedShip.getMaxCapacity();
	}
	
	public boolean checkItemPurchase(Item item, int price) {
		return selectedShip.checkItemPurchase(item, price);
	}
	
	public void buyItem(Item item, int price) {
		selectedShip.buyItem(item, price);
	}
	
	public boolean checkWeaponPurchase(Weapon weapon, int price) {
		return selectedShip.checkWeaponPurchase(weapon, price);
	}
	
	public void buyWeapon(Weapon weapon, int price) {
		selectedShip.buyWeapon(weapon, price);
	}
	
	public void sellItem(Item item, int price) {
		selectedShip.sellItem(item, price);
	}
	
	public void sellWeapon(Weapon weapon, int price) {
		selectedShip.sellWeapon(weapon, price);
	}
	
	public boolean unlimitedDays() {
		return this.unlimitedDays;
	}
	
	public int getInventoryValue() {
		return selectedShip.inventoryValue();
	}
	
	public Island getCurrLocation() {
		return selectedShip.getLocation();
	}
	
	public boolean checkRoute(Route route) {
		return selectedShip.checkRoute(route, this);
	}
	
	public EventInfo setSail(Route route, Island destination) {
		return selectedShip.useRoute(route, destination, this);
	}
	
	public int getMaxDays() {
		return this.maxDays;
	}
	
	public int getCurrDay() {
		return selectedShip.getDays();
	}
	
	public int getAttackMultiplier() {
		return selectedShip.getAttackMultiplier();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getShipDamage() {
		return selectedShip.getCurrentDamage();
	}
	
	public int getRepairCost() {
		return selectedShip.getRepairCost();
	}
	
	public Ship getSelectedShip() {
		return this.selectedShip;
	}
	
	public int getCurrShipCapacity() {
		return selectedShip.getCurrCapacity();
	}
	
	public int getMaxShipCapacity() {
		return selectedShip.getMaxCapacity();
	}
	
	
 
} 
