package dnd;

import java.util.HashMap;
import java.util.Map;

public class Character {
	private String name;
	private Race race;
	private CharacterClass characterClass;
	private int level;
	private int armorClass;
	private int hitPoints;
	private float goldPieces;
	private int experience;
	
	public Character(String name, Race race, CharacterClass characterClass, int level) {
		this.name = name;
		this.race = race;
		this.characterClass = characterClass;
		this.level = level;
		this.armorClass = setArmorClass(characterClass, level);
		this.hitPoints = setHitPoints(characterClass, level);
		this.goldPieces = Money.setMoney(characterClass);
		this.experience = setExperience(characterClass, level);
	}
	
	private int setArmorClass(CharacterClass characterClass, int level) {
		return 0;
	}
	
	private int setHitPoints(CharacterClass characterClass, int level) {
		return 0;
	}
	
	private int setExperience(CharacterClass characterClass, int level) {
		return 0;
	}
}