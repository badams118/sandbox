package dnd;

import java.util.Random;

import dnd.Weapon.TargetSize;

public class Monster extends MobileObject {
	private String type;
	private int attacks;
	private int damageLow;
	private int damageHigh;
	private int morale;
	
	public Monster(String type, int armorClass, int hitDice, int hitDiceModifier, int damageLow, int damageHigh, 
			CharacterClass characterClass, int level, int morale) {
		super(armorClass, 4 * hitDice + hitDiceModifier, characterClass, level);
		this.type = type;
		this.damageLow = damageLow;
		this.damageHigh = damageHigh;
		this.morale = morale;
	}
	
	public void strikeMelee(Object target) {
		int damage = new Random().nextInt(damageHigh - damageLow + 1) + damageLow;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		String monsterToString;
		
		monsterToString = "Type: " + this.type + "\n";
		monsterToString += "Armor Class: " + Integer.toString(getArmorClass()) + "\n";
		monsterToString += "Hit Points: " + Integer.toString(getHitPoints()) + "\n";
		monsterToString += "Damage: " + Integer.toString(this.damageLow) + "-" + Integer.toString(this.damageHigh) + "\n";;
		
		return monsterToString;
	}
}
