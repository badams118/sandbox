package dnd;

import java.util.HashMap;

public class Encounter {
	private HashMap<String, Monster> monsters;
	private Party party;

	public Encounter(Monster...monsters) {
		this.monsters = new HashMap<String, Monster>();
		for (Monster monster : monsters) {
			this.monsters.put(monster.getType(), monster);
		}
	}
	
	public Encounter(HashMap<String, Monster> monsters) {
		this.monsters = new HashMap<String, Monster>(monsters);
	}
	
	public Monster getMonster(String name) {
		return monsters.get(name);
	}
	
	public void combat(Party party) {
		
	}
}
