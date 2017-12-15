package dnd;

import java.util.HashMap;

public class Party {
	private HashMap<String, Character> characters;

	public Party(HashMap<String, Character> characters) {
		this.characters = new HashMap<String, Character>(characters);
	}
	
	public Character getMonster(String name) {
		return characters.get(name);
	}
}
