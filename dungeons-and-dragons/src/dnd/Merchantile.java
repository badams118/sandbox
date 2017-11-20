package dnd;

import java.util.ArrayList;
import java.util.List;

public class Merchantile {
	
	public static Weapon getWeapon(String type) {
		List<Weapon> weapons = new ArrayList<Weapon>();
		
		weapons.add(new Weapon("Long Sword", 15, 1, 8, 1, 12));
		weapons.add(new Weapon("Unholy Reaver", 0, 0, 0, 0, 0, 5));
		
		return weapons.get(weapons.indexOf(new Weapon(type, 0, 0, 0, 0, 0)));
	}
	
	public static Armor getArmor(String type) {
		List<Armor> armor = new ArrayList<Armor>();
		
		armor.add(new Armor("Chain", 75, 5));		
		armor.add(new Armor("Plate", 400, 3));
		
		return armor.get(armor.indexOf(new Armor(type, 0, 0)));
	}
}
