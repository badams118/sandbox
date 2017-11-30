package dnd;

import java.io.Serializable;

import dnd.Weapon.TargetSize;

public class Character extends MobileObject implements Serializable {
	private static final long serialVersionUID = -5878197738378533947L;
	private String name;
	private Race race;
	private float goldPieces;
	private Weapon weapon;
	private Armor armor;
	private Shield shield;

	public Character() {
		super();
	}
	
	public Character(String name, Race race, CharacterClass characterClass) {
		this(name, race, characterClass, 1);
	}
	
	public Character(String name, Race race, CharacterClass characterClass, int level) {
		super(10, CharacterClass.getHitPoints(characterClass, level), characterClass, level);
		this.name = name;
		this.race = race;
		this.goldPieces = Money.setMoney(characterClass);
		setExperience(characterClass, level);
	}
		
	public String getName() {
		return this.name;
	}
	
	public void addExperience(int experience) {
		this.experience += experience;
	}
	
	private void setExperience(CharacterClass characterClass, int level) {
		this.experience = 0;
	}
	
	public void buyWeapon(Merchantile merchantile, String type) {
		if (this.getCharacterClass() == CharacterClass.CLERIC &&
				(!type.toLowerCase().contains("club") ||
						!type.toLowerCase().contains("flail") ||
						!type.toLowerCase().contains("hammer") ||
						!type.toLowerCase().contains("mace") ||
						!type.toLowerCase().contains("staff"))) {
			System.out.println("The " + this.getCharacterClass().toString().toLowerCase() + " class cannot use this weapon.");
			return;
		}
		
		if (this.getCharacterClass() == CharacterClass.DRUID &&
				(!type.toLowerCase().contains("club") ||
						!type.toLowerCase().contains("dagger") ||
						!type.toLowerCase().contains("dart") ||
						!type.toLowerCase().contains("hammer") ||
						!type.toLowerCase().contains("scimitar") ||
						!type.toLowerCase().contains("sling") ||
						!type.toLowerCase().contains("spear") ||
						!type.toLowerCase().contains("staff"))) {
			System.out.println("The " + this.getCharacterClass().toString().toLowerCase() + " class cannot use this weapon.");
			return;
		}
		
		if ((this.getCharacterClass() == CharacterClass.MAGIC_USER ||
				this.getCharacterClass() == CharacterClass.ILLUSIONIST) &&
				(!type.toLowerCase().contains("dagger") ||
						!type.toLowerCase().contains("dart") ||
						!type.toLowerCase().contains("staff"))) {
			System.out.println("The " + this.getCharacterClass().toString().toLowerCase() + " class cannot use this weapon.");
			return;
		}
		
		if (this.getCharacterClass() == CharacterClass.THIEF) {
			if (!type.toLowerCase().contains("club") ||
					!type.toLowerCase().contains("dagger") ||
					!type.toLowerCase().contains("dart") ||
					!type.toLowerCase().contains("sling") ||
					!type.toLowerCase().contains("sword")) {
				System.out.println("The " + this.getCharacterClass().toString().toLowerCase() + " class cannot use this weapon.");
				return;
			}			
			if (type.toLowerCase().contains("sword") &&
					(type.toLowerCase().contains("bastard") ||
							type.toLowerCase().contains("two-handed"))) {
				System.out.println("The " + this.getCharacterClass().toString().toLowerCase() + " class cannot use this weapon.");
				return;
			}
		}
		
		Weapon weapon = merchantile.getWeapon(type);
		
		if (this.goldPieces >= weapon.getCost()) {
			this.weapon = weapon;
			this.goldPieces -= weapon.getCost();
		} else {
			System.out.println(this.name + " does not have enough gold to buy a(n) " + type);
		}
	}
	
	public void buyArmor(Merchantile merchantile, String type) {
		if (this.getCharacterClass() == CharacterClass.MAGIC_USER || this.getCharacterClass() == CharacterClass.ILLUSIONIST) {
			System.out.println("The " + this.getCharacterClass().toString().toLowerCase() + " class cannot wear armor.");
			return;
		}
		
		if ((this.getCharacterClass() == CharacterClass.DRUID ||
				this.getCharacterClass() == CharacterClass.THIEF ||
				this.getCharacterClass() == CharacterClass.ASSASSIN) &&
				!type.toLowerCase().contains("leather")) {
			System.out.println("The " + this.getCharacterClass().toString().toLowerCase() + " class cannot wear this armor.");
			return;
		}
		
		Armor armor = merchantile.getArmor(type);
		if (this.goldPieces >= armor.getCost()) {
			this.armor = armor;
			setArmorClass(armor.getArmorClass());
			this.goldPieces -= armor.getCost();
		} else {
			System.out.println(this.name + " does not have enough gold to buy " + type);
		}
	}

	public void buyShield(Merchantile merchantile, String type) {
		if (this.getCharacterClass() == CharacterClass.MAGIC_USER || 
				this.getCharacterClass() == CharacterClass.ILLUSIONIST || 
				this.getCharacterClass() == CharacterClass.THIEF) {
			System.out.println("The " + this.getCharacterClass().toString().toLowerCase() + " class cannot use a shield.");
			return;
		}

		if (this.getCharacterClass() == CharacterClass.DRUID && !type.toLowerCase().contains("wooden")) {
			System.out.println("The " + this.getCharacterClass().toString().toLowerCase() + " class cannot use this shield.");
			return;
		}
		
		Shield shield = merchantile.getShield(type);
		
		if (this.goldPieces >= shield.getCost()) {
			if (this.shield == null) {
				setArmorClass(this.getArmorClass() - 1);
			}
			this.shield = shield;
			this.goldPieces -= shield.getCost();
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