package dnd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;

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
		
		MobileObject mob = getLowestAC(new HashMap<String, MobileObject>(monsters));
		
//		if (new Random().nextBoolean()) {
//			party.getCharacter("Joe Test").combatAction("melee", encounter.getMonster("skeleton 01"));
//			System.out.println(encounter.getMonster("skeleton 01").getType() + " hit points: " + 
//					Integer.toString(encounter.getMonster("skeleton 01").getHitPoints()) + "\n");
//		}
//		while (true) {	
//			if (encounter.getMonster("skeleton 01").getHitPoints() <= 0) {
//				System.out.println(encounter.getMonster("skeleton 01").getType() + " has died.\n");
//				party.getCharacter("Joe Test").addExperience(encounter.getMonster("skeleton 01").getExperience());
//				break;
//			}
//			
//			System.out.println(encounter.getMonster("skeleton 01").getType() + " strikes " + party.getCharacter("Joe Test").getName() + " for " + 
//					Integer.toString(encounter.getMonster("skeleton 01").strikeMelee(party.getCharacter("Joe Test"))) + " damage.");
//			System.out.println(party.getCharacter("Joe Test").getName() + " hit points: " + 
//					Integer.toString(party.getCharacter("Joe Test").getHitPoints()) + "\n");
//			if (party.getCharacter("Joe Test").getHitPoints() <= 0 || encounter.getMonster("skeleton 01").getHitPoints() <= 0) {
//				System.out.println(party.getCharacter("Joe Test").getName() + " has died.\n");
//				break;
//			}
//
//			party.getCharacter("Joe Test").combatAction("melee", encounter.getMonster("skeleton 01"));
//			System.out.println(encounter.getMonster("skeleton 01").getType() + " hit points: " + 
//					Integer.toString(encounter.getMonster("skeleton 01").getHitPoints()) + "\n");
//		}
		
		return party.getCharacters();
	}
	
	private static MobileObject getLowestAC(HashMap<String, MobileObject> mobs) {
		MobileObject currentMob;
		MobileObject lowestACMob = new Monster();
		lowestACMob.setArmorClass(Integer.MAX_VALUE);
		Iterator<Entry<String, MobileObject>> iterator = mobs.entrySet().iterator();
		
		while (iterator.hasNext()) {
			HashMap.Entry<String, MobileObject> entry = (HashMap.Entry<String, MobileObject>) iterator.next();
			currentMob = (MobileObject) entry.getValue();
			if (currentMob.getArmorClass() < lowestACMob.getArmorClass()) {
				lowestACMob = currentMob;
			}
			
			iterator.remove();
		}
		
		return lowestACMob;
	}
}
