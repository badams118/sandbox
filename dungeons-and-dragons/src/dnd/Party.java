package dnd;

import java.util.HashMap;

public class Party {
	private HashMap<String, Character> characters;

	public Party(Character...characters) {
		this.characters = new HashMap<String, Character>();
		for (Character character : characters) {
			this.characters.put(character.getName(), character);
		}
	}
	
	public Party(HashMap<String, Character> characters) {
		this.characters = new HashMap<String, Character>(characters);
	}

	public HashMap<String, Character> getCharacters() {
		return this.characters;
	}
	
	public void updateCharacters(HashMap<String, Character> characters) {
		this.characters = characters;
	}
	
	public Character getCharacter(String name) {
		return this.characters.get(name);
	}
}