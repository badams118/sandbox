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
	
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}
	
	public int getArmorClass() {
		return armorClass;
	}
	
	public int strikeMelee(MobileObject target, int damageLow, int damageHigh) {
		int damage = 0;
		
		if (isHit()) {			
			damage = new Random().nextInt(damageHigh - damageLow + 1) + damageLow;
			target.updateHitPoints(-damage);
		}
		
		return damage;
	}
	
	private boolean isHit() {
		Random random = new Random();
		int roll = random.nextInt(20) + 1;
		boolean isHit;
		
	//	System.out.println("Roll " + Integer.toString(roll));
	//	System.out.println("To hit " + Integer.toString(this.hitMatrix[this.armorClass + 10][0]));
		
		if (this.hitMatrix[this.armorClass + 10][0] >= roll) {
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
