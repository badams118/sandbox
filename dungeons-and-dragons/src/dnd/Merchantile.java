package dnd;

import java.util.ArrayList;
import java.util.List;

public class Merchantile {
	List<Weapon> weapons;
	List<Armor> armors;
	
	public Merchantile() {
		weapons = new ArrayList<Weapon>();
		
		weapons.add(new Weapon("sword", 0, 1, 8));
	}
	
	public Weapon buyWeapon(String type) {
		//return new Weapon("sword", 0, 1, 8);
		System.out.println(Integer.toString(weapons.indexOf(new Weapon(type))));
		return weapons.get(0);
	}
}
