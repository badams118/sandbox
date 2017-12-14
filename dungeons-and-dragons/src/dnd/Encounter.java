package dnd;

import java.util.HashMap;

public class Encounter {
	private HashMap<String, Monster> monsters;

	public Encounter(HashMap<String, Monster> monsters) {
		this.monsters = new HashMap<String, Monster>(monsters);
	}
	
	public Monster getMonster(String name) {
		return monsters.get(name);
	}
}
