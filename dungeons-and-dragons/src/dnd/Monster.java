package dnd;

import java.util.Random;

import dnd.Weapon.TargetSize;

public class Monster {
	private int armorClass;
	private int hitPoints;
	private int attacks;
	private int damageLow;
	private int damageHigh;
	private CharacterClass characterClass;
	private int level;
	private int morale;
	
	public Monster(int armorClass, int hitDice, int hitDiceModifier, int damageLow, int damageHigh, 
			CharacterClass characterClass, int level, int morale) {
		this.armorClass = armorClass;
		this.hitPoints = 4 * hitDice + hitDiceModifier;
		this.damageLow = damageLow;
		this.damageHigh = damageHigh;
		this.characterClass = characterClass;
		this.level = level;
		this.morale = morale;
	}
	
	public void strikeMelee(Object target) {
		int damage = new Random().nextInt(damageHigh - damageLow + 1) + damageLow;
	}
}
