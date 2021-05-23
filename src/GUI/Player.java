package GUI; 

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
	
	public boolean buyItem(Item item, int price, StoreWindow storeWindow) {
		return selectedShip.buyItem(item, price, storeWindow);
	}
	
	public boolean buyWeapon(Weapon weapon, int price, StoreWindow storeWindow) {
		return selectedShip.buyWeapon(weapon, price, storeWindow);
	}
	
	public boolean sellItem(Item item, int price, StoreWindow storeWindow) {
		return selectedShip.sellItem(item, price, storeWindow);
	}
	
	public boolean sellWeapon(Weapon weapon, int price, StoreWindow storeWindow) {
		return selectedShip.sellWeapon(weapon, price, storeWindow);
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
	
	public int setSail(Route route, Island destination, SelectRouteWindow selectRouteWindow) {
		return selectedShip.useRoute(route, destination, selectRouteWindow, this);
	}
	
	public int getMaxDays() {
		return this.maxDays;
	}
	
	public int getCurrDay() {
		return selectedShip.getDays();
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
