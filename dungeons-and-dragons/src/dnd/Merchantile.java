package dnd;

import java.util.ArrayList;
import java.util.List;

public class Merchantile {
	
	public static Weapon buyWeapon(String type) {
		List<Weapon> weapons = new ArrayList<Weapon>();
		
		weapons.add(new Weapon("Long Sword", 15, 1, 8, 1, 12));
		
		return weapons.get(weapons.indexOf(new Weapon(type, 0, 0, 0, 0, 0)));
	}
	
	public static Armor buyArmor(String type) {
		List<Armor> armor = new ArrayList<Armor>();
		
		armor.add(new Armor("Chain", 75, 5));
		
		return armor.get(armor.indexOf(new Armor(type, 0, 0)));
	}
}
