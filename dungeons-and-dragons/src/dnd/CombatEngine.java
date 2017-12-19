package dnd;

import java.util.HashMap;

public class CombatEngine {
	private HashMap<String, Monster> monsters;
	private HashMap<String, Character> characters;

	public CombatEngine(Encounter encounter, Party party) {
		this.monsters = new HashMap<String, Monster>(encounter.getMonsters());
		this.characters = new HashMap<String, Character>(party.getCharacters());		
	}
	
	public static HashMap<String, Character> doCombat(Encounter encounter, Party party) {
		HashMap<String, Monster> monsters = encounter.getMonsters();
		HashMap<String, Character> characters = party.getCharacters();
		
		return party.getCharacters();
	}
}
