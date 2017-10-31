package dnd;

import java.util.Random;

public abstract class MobileObject {
	private int armorClass;
	private int hitPoints;
	private CharacterClass characterClass;
	private int level;
	private int[][] hitMatrix;
	
	public MobileObject(int armorClass, int hitPoints, CharacterClass characterClass, int level) {
		this.armorClass = armorClass;
		this.hitPoints = hitPoints;
		this.characterClass = characterClass;
		this.level = level;
		this.hitMatrix = CombatMatrix.getHitMatrix(characterClass, level);
	}
	
	public MobileObject(int armorClass, int hitDice, int hitDiceModifier, int hitPoints, CharacterClass characterClass, int level) {
		this.armorClass = armorClass;
		this.hitPoints = hitPoints;
		this.characterClass = CharacterClass.NONE;
		this.level = level;
		this.hitMatrix = CombatMatrix.getHitMatrix(CharacterClass.NONE, hitDice);
	}
	
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}
	
	public int getArmorClass() {
		return armorClass;
	}
	
	public int strikeMelee(MobileObject target, int damageLow, int damageHigh) {
		int damage = 0;
		
		if (this.isHit(target)) {			
			damage = new Random().nextInt(damageHigh - damageLow + 1) + damageLow;
			target.updateHitPoints(-damage);
		}
		
		return damage;
	}
	
	private boolean isHit(MobileObject target) {
		Random random = new Random();
		int roll = random.nextInt(20) + 1;
		boolean isHit;
		
		System.out.println("Roll " + Integer.toString(roll));
		System.out.println("Target armor class: " + this.hitMatrix[target.armorClass + 10][0]);
		System.out.println("Attacker to hit: " + Integer.toString(this.hitMatrix[target.armorClass + 10][1]));
		
		if (roll >= this.hitMatrix[target.armorClass + 10][1]) {
			isHit = true;
		} else {
			isHit = false;
		}
		
		return isHit;
	}
	
	public void updateHitPoints(int value) {
		this.hitPoints += value;
	}

	public int getHitPoints() {
		return this.hitPoints;
	}
	
	public CharacterClass getCharacterClass() {
		return characterClass;
	}
	
	public int getLevel() {
		return level;
	}
}
