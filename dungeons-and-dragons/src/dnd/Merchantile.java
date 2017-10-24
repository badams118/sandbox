package dnd;

import java.util.ArrayList;
import java.util.List;

public class Merchantile {
	List<Armor> armors;
	
	public static Weapon buyWeapon(String type) {
		List<Weapon> weapons = new ArrayList<Weapon>();
		
		weapons.add(new Weapon("Long Sword", 0, 1, 8));
		
		return weapons.get(weapons.indexOf(new Weapon(type, 0, 0, 0)));
	}
}
