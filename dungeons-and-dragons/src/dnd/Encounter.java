package dnd;

import java.util.HashMap;

public class Encounter {
	private HashMap<String, Monster> monsters;
	
	public Encounter(Monster...monsters) {
		this.monsters = new HashMap<String, Monster>();
		for (Monster monster : monsters) {
			this.monsters.put(monster.getType(), monster);
		}
	}
	
	public Encounter(HashMap<String, Monster> monsters) {
		this.monsters = new HashMap<String, Monster>(monsters);
	}
	
	public HashMap<String, Monster> getMonsters() {
		return this.monsters;
	}
	
	public Monster getMonster(String name) {
		return this.monsters.get(name);
	}
}
