package dnd;

import java.util.HashMap;

public class Merchantile {
	private static HashMap<String, Weapon> weapons;
	private static HashMap<String, Armor>  armor;
	private static HashMap<String, Shield> shields;
	
	public Merchantile() {
		weapons = new HashMap<String, Weapon>();
		armor   = new HashMap<String, Armor>();
		shields = new HashMap<String, Shield>();
		
		weapons.put("BlackRazor", new Weapon("Blackrazor", 0, 1, 8, 1, 12, 3));
		weapons.put("Dagger", new Weapon("Dagger", 2, 1, 4, 1, 3));
		weapons.put("Sword, long", new Weapon("Sword, long", 15, 1, 8, 1, 12, 0));
		weapons.put("Sword, long, Unholy Reaver", new Weapon("Sword, long, Unholy Reaver", 0, 1, 8, 1, 12, 5));

		armor.put("Chain", new Armor("Chain", 75, 5));		
		armor.put("Plate", new Armor("Plate", 400, 3));

		shields.put("Shield, small, wooden", new Shield("Shield, small, wooden", 1));
	}
	
	public static Weapon getWeapon(String type) {
		System.out.println(type);
		return weapons.get(type);
	}
	
	public static Armor getArmor(String type) {
		return armor.get(type);
	}

	public static Shield getShield(String type) {
		return shields.get(type);
	}
}
