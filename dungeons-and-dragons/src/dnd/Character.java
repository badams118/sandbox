package dnd;

import dnd.Weapon.TargetSize;

public class Character {
	private String name;
	private Race race;
	private CharacterClass characterClass;
	private int level;
	private int armorClass;
	private int hitPoints;
	private float goldPieces;
	private int experience;
	private Weapon weapon;
	private Armor armor;

	public Character(String name, Race race, CharacterClass characterClass) {
		this(name, race, characterClass, 1);
	}
	
	public Character(String name, Race race, CharacterClass characterClass, int level) {
		this.name = name;
		this.race = race;
		this.characterClass = characterClass;
		this.level = level;
		this.armorClass = 10;
		this.hitPoints = CharacterClass.getHitPoints(characterClass, level);
		this.goldPieces = Money.setMoney(characterClass);
		this.experience = setExperience(characterClass, level);
	}
	
	private int setExperience(CharacterClass characterClass, int level) {
		return 0;
	}
	
	public void buyWeapon(String type) {
		this.weapon = Merchantile.buyWeapon(type);
	}
	
	public void buyArmor(String type) {
		this.armor = Merchantile.buyArmor(type);
		this.armorClass = armor.getArmorClass();
	}
	
	public void strikeMelee(Object target) {
		strikeMelee(target, TargetSize.MEDIUM);
	}
	
	public void strikeMelee(Object target, TargetSize targetSize) {
		System.out.print(Integer.toString(weapon.calculateDamage()) + " ");
	}
	
	public String toString() {
		String characterToString;
		
		characterToString = "Character name: " + name + "\n";
		characterToString += "Race: " + this.race.toString() + "\n";
		characterToString += "Class: " + this.characterClass.toString() + "\n";
		characterToString += "Level: " + Integer.toString(this.level) + "\n";
		characterToString += "Armor class: " + Integer.toString(this.armorClass) + "\n";
		characterToString += "Hit Points: " + Integer.toString(this.hitPoints) + "\n";
		characterToString += "Experience: " + Integer.toString(this.experience) + "\n";
		characterToString += "Money: " + Float.toString(goldPieces) + "\n";
		
		return characterToString;
	}
}