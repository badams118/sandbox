package dnd;

import java.util.HashMap;

public class Monster extends MobileObject {
	private String type;
	private int hitDice;
	private int hitDiceModifier;
	private int attacks;
	private int damageLow;
	private int damageHigh;
	private int morale;
	
	public Monster() {
		super();
	}

	public Monster(String type, int armorClass, int hitDice, int damageLow, int damageHigh) {
		this(type, armorClass, hitDice, 0, damageLow, damageHigh, CharacterClass.NONE, hitDice, 50 + 5 * hitDice, TargetSize.MEDIUM);
	}
	
	public Monster(String type, int armorClass, int hitDice, int hitDiceModifier, int damageLow, int damageHigh, 
			CharacterClass characterClass, int level, int morale) {
		this(type, armorClass, hitDice, hitDiceModifier, damageLow, damageHigh, characterClass, level, morale, TargetSize.MEDIUM);
	}
	
	public Monster(String type, int armorClass, int hitDice, int hitDiceModifier, int damageLow, int damageHigh, 
			CharacterClass characterClass, int level, int morale, TargetSize size) {
		super.setArmorClass(armorClass);
		this.hitDice = hitDice;
		this.hitDiceModifier = hitDiceModifier;
		super.setHitPoints(4 * hitDice + hitDiceModifier);
		super.setCharacterClass(characterClass);
		super.setLevel(level);
		this.type = type;
		this.hitDice = hitDice;
		this.hitDiceModifier = hitDiceModifier;
		this.damageLow = damageLow;
		this.damageHigh = damageHigh;
		this.morale = morale;
		this.experience = calculateExperience();
		super.populateHitMatrix(characterClass, level);
		super.setSize(size);
	}
	
	public int strikeMelee(MobileObject target) {
		return super.strikeMelee(target, this.damageLow, this.damageHigh);
	}
	
	public String getType() {
		return this.type;
	}
	
	private int calculateExperience() {
		int xp = 0;
		int hd = this.hitDice;
		
		if (this.hitDiceModifier > 0) {
			hd += .5;
		}
		
		if (hd < 1) {
			xp = 5 + super.getHitPoints();
		} else if (hd <= 1) {
			xp = 10 + super.getHitPoints();
		} else if (hd <= 2) {
			xp = 20 + super.getHitPoints();
		} else if (hd <= 3) {
			xp = 35 + 2*super.getHitPoints();
		} else if (hd <= 4) {
			xp = 60 + 4*super.getHitPoints();
		} else if (hd <= 5) {
			xp = 90 + 5*super.getHitPoints();
		} else if (hd <= 6) {
			xp = 150 + 6*super.getHitPoints();
		} else if (hd <= 7) {
			xp = 225 + 8*super.getHitPoints();
		} else if (hd <= 8) {
			xp = 375 + 10*super.getHitPoints();
		} else if (hd <= 9) {
			xp = 600 + 12*super.getHitPoints();
		} else if (hd < 11) {
			xp = 900 + 14*super.getHitPoints();
		} else if (hd < 13) {
			xp = 1300 + 16*super.getHitPoints();
		} else if (hd < 15) {
			xp = 1800 + 18*super.getHitPoints();
		} else if (hd < 17) {
			xp = 2400 + 20*super.getHitPoints();
		} else if (hd < 19) {
			xp = 3000 + 25*super.getHitPoints();
		} else if (hd < 21) {
			xp = 4000 + 30*super.getHitPoints();
		} else if (hd >= 21) {
			xp = 5000 + 35*super.getHitPoints();
		}
		
		return xp;
	}
	
	public int getExperience() {
		return this.experience;
	}
	
	public String toString() {
		String monsterToString;
		
		monsterToString = "Type: " + this.type + "\n";
		monsterToString += "Armor Class: " + Integer.toString(getArmorClass()) + "\n";
		monsterToString += "Hit Points: " + Integer.toString(getHitPoints()) + "\n";
		monsterToString += "Damage: " + Integer.toString(this.damageLow) + "-" + Integer.toString(this.damageHigh) + "\n";
		monsterToString += "Experience Points: " + this.getExperience() + "\n";
		
		return monsterToString;
	}

	public boolean equals(Object object) {
		boolean isEquals = false;
		Monster monster = (Monster) object;
		
		if (type.equals(monster.getType())) {
			isEquals = true;
		} 
		
		return isEquals;
	}
}
