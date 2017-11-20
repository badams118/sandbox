package dnd;

import dnd.Weapon.TargetSize;

public class Character extends MobileObject {
	private String name;
	private Race race;
	private float goldPieces;
	private int experience;
	private Weapon weapon;
	private Armor armor;

	public Character(String name, Race race, CharacterClass characterClass) {
		this(name, race, characterClass, 1);
	}
	
	public Character(String name, Race race, CharacterClass characterClass, int level) {
		super(10, CharacterClass.getHitPoints(characterClass, level), characterClass, level);
		this.name = name;
		this.race = race;
		this.goldPieces = Money.setMoney(characterClass);
		this.experience = setExperience(characterClass, level);
	}
	
	public String getName() {
		return this.name;
	}
	
	private int setExperience(CharacterClass characterClass, int level) {
		return 0;
	}
	
	public void buyWeapon(String type) {
		Weapon weapon = Merchantile.getWeapon(type);
		if (this.goldPieces >= weapon.getCost()) {
			this.weapon = weapon;
			this.goldPieces -= weapon.getCost();
		} else {
			System.out.println(this.name + " does not have enough gold to buy a(n) " + type);
		}
	}
	
	public void buyArmor(String type) {
		Armor armor = Merchantile.getArmor(type);
		if (this.goldPieces >= armor.getCost()) {
			this.armor = armor;
			setArmorClass(armor.getArmorClass());
			this.goldPieces -= armor.getCost();
		} else {
			System.out.println(this.name + " does not have enough gold to buy " + type);
		}
	}
	
	public int strikeMelee(MobileObject target) {
		return strikeMelee(target, TargetSize.MEDIUM);
	}
	
	public int strikeMelee(MobileObject target, TargetSize targetSize) {
		return super.strikeMelee(target, this.weapon.getDamageLow(targetSize), this.weapon.getDamageHigh(targetSize), this.weapon.getDamageBonus());
	}
	
	public String toString() {
		String characterToString;
		
		characterToString = "Character name: " + name + "\n";
		characterToString += "Race: " + this.race.toString() + "\n";
		characterToString += "Class: " + getCharacterClass().toString() + "\n";
		characterToString += "Level: " + Integer.toString(getLevel()) + "\n";
		characterToString += "Armor class: " + Integer.toString(getArmorClass()) + "\n";
		characterToString += "Hit Points: " + Integer.toString(getHitPoints()) + "\n";
		characterToString += "Experience: " + Integer.toString(this.experience) + "\n";
		characterToString += "Money: " + Float.toString(goldPieces) + "\n";
		
		return characterToString;
	}
}