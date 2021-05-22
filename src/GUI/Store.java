package gui;

import java.util.*;

public class Store {
	private String storeName;
	private ArrayList<Item> itemsBought = new ArrayList<Item>();
	private ArrayList<Item> itemsSold = new ArrayList<Item>();
	private ArrayList<Weapon> weaponsBought = new ArrayList<Weapon>();
	private ArrayList<Weapon> weaponsSold = new ArrayList<Weapon>();
	
	private int boughtMultiplier;
	private int soldMultiplier;
	
	public Store(String name, int multiplier) {
		storeName = name;
		boughtMultiplier = multiplier - 2;
		soldMultiplier = multiplier;
	}
	
	public void viewItemsBought() {
		System.out.println(String.format("Items bought at %s:\n", storeName));
		for (Item i : itemsBought) {
			System.out.println(String.format("%s\n", i));
		}
	}
	public void viewItemsSold() {
		System.out.println(String.format("Items sold at %s:\n", storeName));
		for (Item i : itemsSold) {
			System.out.println(String.format("%s\n", i));
		}
	}
	
	public String toString() {
		String mess = "Items bought at " + storeName + ": \n";
		for (Item i : itemsBought) {
			mess += String.format("%s\n", i);
		}
		mess += String.format("Items sold at %s:\n", storeName);
		for (Item i : itemsSold) {
			mess += String.format("%s\n", i);
		}
		return mess;
	}
	
	public boolean buysItem(Item i) {
		
		for (Item j: this.itemsBought) {
			if (j.equals(i)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean buysWeapon(Weapon w) {
		for (Weapon x:this.weaponsBought) {
			if(x.equals(w)) {
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Item> getItemsBought() {
		return this.itemsBought;
	}
	
	public ArrayList<Item> getItemsSold() {
		return this.itemsSold;
	}
	
	public ArrayList<Weapon> getWeaponsBought() {
		return this.weaponsBought;
	}
	
	public ArrayList<Weapon> getWeaponsSold() {
		return this.weaponsSold;
	}
	
	public void addItem(Item item) {
		itemsBought.add(new Item(item.getName(), item.getDescription(), item.getType(), item.getSize(), (item.getPrice() * boughtMultiplier)));
		itemsSold.add(new Item(item.getName(), item.getDescription(), item.getType(), item.getSize(), (item.getPrice() * soldMultiplier)));
	}
	
	public void addWeapon(Weapon weapon) {
		weaponsBought.add(new Weapon(weapon.getName(), weapon.getDescription(), weapon.getType(), weapon.getSize(), (weapon.getPrice() * boughtMultiplier), weapon.getMultChanged()));
		weaponsSold.add(new Weapon(weapon.getName(), weapon.getDescription(), weapon.getType(), weapon.getSize(), (weapon.getPrice() * soldMultiplier), weapon.getMultChanged()));
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public int getPurchasePrice(Item i) {
		if (i.getType() == "Weapon") {
			for (Weapon j: this.weaponsSold) {
				if (i.equals(j)) {
					return j.getPrice();
				}
			}
		} else {
			for (Item j: this.itemsSold) {
				if (i.equals(j)) {
					return j.getPrice();
				}
			}
		}
		return 0;
	}
	
	public int getSalePrice(Item i) {
		if (i.getType() == "Weapon") {
			for (Weapon j: this.weaponsBought) {
				if (i.equals(j)) {
					return j.getPrice();
				}
			}
		} else {
			for (Item j: this.itemsBought) {
				if (i.equals(j)) {
					return j.getPrice();
				}
			}
		}
		return 0;
	}
	
	public ArrayList<Item> getItemsPlayerCanSell(Ship playersShip) {
		ArrayList<Item> itemsCanSell = new ArrayList<Item>();
		// Find all items the player owns and the store will buy
		for (Item item:playersShip.getInventory()) {
			outerLoop:
				if (this.buysItem(item)) {
					// Ensure each item is only added once
					for (Item storeItem:itemsCanSell) {
						if (storeItem.equals(item)) {
							break outerLoop;
						}
					}
					itemsCanSell.add(item);
				}
		}
		return itemsCanSell;
	}
	
	public ArrayList<Weapon> getWeaponsPlayerCanSell(Ship playersShip) {
		ArrayList<Weapon> weaponsCanSell = new ArrayList<Weapon>();
		// Find all weapons the player owns and the store will buy
		for (Weapon weapon:playersShip.getWeapons()) {
			outerLoop:
				if (this.buysWeapon(weapon)) {
					// Ensure each weapon is only added once
					for (Weapon storeWeapon:weaponsCanSell) {
						if (storeWeapon.equals(weapon)) {
							break outerLoop;
						}
					}
					weaponsCanSell.add(weapon);
				}
		}
		return weaponsCanSell;
	}
}
