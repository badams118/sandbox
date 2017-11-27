package dnd;

import java.util.ArrayList;
import java.util.List;

public class Merchantile {
	private List<Weapon> weapons = new ArrayList<Weapon>();
	private List<Armor>  armor   = new ArrayList<Armor>();
	private List<Shield> shields = new ArrayList<Shield>();
	
	public Merchantile() {
		weapons.add(new Weapon("Blackrazor", 0, 1, 8, 1, 12, 3));
		weapons.add(new Weapon("Sword, long", 15, 1, 8, 1, 12, 0));
		weapons.add(new Weapon("Sword, long, Unholy Reaver", 0, 1, 8, 1, 12, 5));

		armor.add(new Armor("Chain", 75, 5));		
		armor.add(new Armor("Plate", 400, 3));

		shields.add(new Shield("Shield, small, wooden", 1));
	}
	
	public  Weapon getWeapon(String type) {
		return weapons.get(weapons.indexOf(new Weapon(type, 0, 0, 0, 0, 0)));
	}
	
	public  Armor getArmor(String type) {
		return armor.get(armor.indexOf(new Armor(type, 0, 0)));
	}

	public  Shield getShield(String type) {
		return shields.get(shields.indexOf(new Shield(type, 0)));
	}
}
