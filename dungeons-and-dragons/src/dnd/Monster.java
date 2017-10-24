package dnd;

import java.util.Random;

import dnd.Weapon.TargetSize;

public class Monster {
	private String type;
	private CharacterClass characterClass;
	private int level;
	private int armorClass;
	private int hitPoints;
	private int damageLow;
	private int damageHigh;
	
	public Monster(String type, CharacterClass characterClass, int level, int armorClass, int hitPoints, int damageLow, int damageHigh) {
		this.type = type;
		this.characterClass = characterClass;
		this.armorClass = armorClass;
		this.hitPoints = hitPoints;
		this.damageLow = damageLow;
		this.damageHigh = damageHigh;
	}
	
	public void strikeMelee(Object target) {
		int damage = new Random().nextInt(damageHigh - damageLow + 1) + damageLow;
	}
}
