package dnd;

import java.util.ArrayList;
import java.util.List;

public class Merchantile {
	private static List<Weapon> weapons;
	private static List<Armor>  armor;
	private static List<Shield> shields;
	
	public Merchantile() {
		weapons = new ArrayList<Weapon>();
		armor   = new ArrayList<Armor>();
		shields = new ArrayList<Shield>();
		
		weapons.add(new Weapon("Blackrazor", 0, 1, 8, 1, 12, 3));
		weapons.add(new Weapon("Dagger", 2, 1, 4, 1, 3));
		weapons.add(new Weapon("Sword, long", 15, 1, 8, 1, 12, 0));
		weapons.add(new Weapon("Sword, long, Unholy Reaver", 0, 1, 8, 1, 12, 5));

		armor.add(new Armor("Chain", 75, 5));		
		armor.add(new Armor("Plate", 400, 3));

		shields.add(new Shield("Shield, small, wooden", 1));
	}
	
	public static Weapon getWeapon(String type) {
		return weapons.get(weapons.indexOf(new Weapon(type, 0, 0, 0, 0, 0)));
	}
	
	public static Armor getArmor(String type) {
		return armor.get(armor.indexOf(new Armor(type, 0, 0)));
	}

	public static Shield getShield(String type) {
		return shields.get(shields.indexOf(new Shield(type, 0)));
	}
}
