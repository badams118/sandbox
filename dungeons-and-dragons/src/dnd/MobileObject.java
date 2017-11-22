package dnd;

import java.io.Serializable;
import java.util.Random;

public abstract class MobileObject implements Serializable {
	private static final long serialVersionUID = -1211342146528001795L;
	private int armorClass;
	private int hitPoints;
	private CharacterClass characterClass;
	protected int experience;
	private int level;
	private int[][] hitMatrix;
	
	public MobileObject() {
		
	}
	
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
		return strikeMelee(target, damageLow, damageHigh, 0);
	}
	
	public int strikeMelee(MobileObject target, int damageLow, int damageHigh, int damageBonus) {
		int damage = 0;
		
		if (this.isHit(target)) {			
			damage = new Random().nextInt(damageHigh - damageLow + 1) + damageLow + damageBonus;
			target.updateHitPoints(-damage);
		}
		
		return damage;
	}
	
	private boolean isHit(MobileObject target) {
		Random random = new Random();
		int roll = random.nextInt(20) + 1;
		boolean isHit;
		
		System.out.println("Attack roll " + Integer.toString(roll));
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
