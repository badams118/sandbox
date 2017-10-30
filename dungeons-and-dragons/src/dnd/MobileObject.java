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
	}
	
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}
	
	public int getArmorClass() {
		return armorClass;
	}
	
	private void setHitArray() {
		this.hitMatrix = CombatMatrix.getHitMatrix(this.characterClass, this.level);
	}
	
	public int strikeMelee(MobileObject target, int damageLow, int damageHigh) {
		int damage = new Random().nextInt(damageHigh - damageLow + 1) + damageLow;
		target.updateHitPoints(-damage);
		return damage;
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
