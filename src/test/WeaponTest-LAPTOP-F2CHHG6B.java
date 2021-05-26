package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import backEnd.Weapon;

class WeaponTest {
	Weapon testWeapon;
	
	@BeforeEach
	void init() {
		testWeapon = new Weapon("Weapon", "Testing 123", "Weapon", 5, 10, 5);
	}
	
	@Test
	public void copyTest() {
		Weapon testWeaponCopy = testWeapon.copy();
		assertTrue(testWeapon.equals(testWeaponCopy));
	}

}
