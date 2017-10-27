package dnd;

public abstract class MobileObject {
	private int armorClass;
	private int hitPoints;
	private CharacterClass characterClass;
	private int level;
	
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
