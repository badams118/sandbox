package dnd;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.junit.Assert;

import java.util.Random;

public class CombatEngine {
	private static HashMap<String, Monster> monsters;
	private static HashMap<String, Character> characters;
	private static Iterator<Entry<String, Monster>> encounterIterator;
	private static Iterator<Entry<String, Character>> partyIterator;
	private static Monster currentMonster;
	private static Character currentCharacter;
	private static Monster encounterTarget;
	private static Character partyTarget, partyHealTarget;
	
	public static HashMap<String, Character> doCombat(Encounter encounter, Party party) {
		monsters = encounter.getMonsters();
		characters = party.getCharacters();
		encounterIterator = monsters.entrySet().iterator();
		partyIterator = characters.entrySet().iterator();
		encounterTarget = (Monster) getLowestAC(new HashMap<String, MobileObject>(monsters));
		partyTarget = (Character) getLowestAC(new HashMap<String, MobileObject>(characters));
		partyHealTarget = (Character) getHealTarget(new HashMap<String, MobileObject>(characters));
		
		if (partyHealTarget == null) {
			partyHealTarget = new Character();
		}
		
		System.out.println("Party target:");
		System.out.println(partyTarget.toString());
		
		System.out.println("Encounter target:");
		System.out.println(encounterTarget.toString());

		if (new Random().nextBoolean()) {
			System.out.println("Party has initiative.\n");
			
			combatRound("party");
		} else {
			System.out.println("Encounter has initiative.\n");
		}
		
		while (true) {
			combatRound("encounter");
			combatRound("party");
			
			if (monsters.isEmpty() || characters.isEmpty()) {
				break;
			}
		}
		
		System.out.println(partyTarget.toString());

		return party.getCharacters();
	}	

	private static void combatRound(String attacker) {
		if (attacker.equals("party")) {
			partyIterator = characters.entrySet().iterator();
			while (partyIterator.hasNext()) {
				currentCharacter = partyIterator.next().getValue();
				currentCharacter.combatAction(encounterTarget, partyHealTarget);
				System.out.println(encounterTarget.getType() + " hit points: " + 
						Integer.toString(encounterTarget.getHitPoints()) + "\n");
			}
			
			if (encounterTarget.getHitPoints() <= 0) {
				System.out.println(encounterTarget.getType() + " has died.\n");
				monsters.remove(encounterTarget.getType());
				System.out.println("Monsters hashmap size: " + monsters.size() + "\n");
				if (!monsters.isEmpty()) {
					encounterTarget = (Monster) getLowestAC(new HashMap<String, MobileObject>(monsters));
					System.out.println("New target: " + encounterTarget.getType() + "\n");
				}
			}
		} else if (attacker.equals("encounter")) {
			encounterIterator = monsters.entrySet().iterator();
			while (encounterIterator.hasNext()) {
				currentMonster = encounterIterator.next().getValue();
				currentMonster.combatAction(partyTarget);
			}
			
			if (partyTarget.getHitPoints() <= 0) {
				System.out.println(partyTarget.getName() + " has died.\n");
				characters.remove(partyTarget.getName());
				System.out.println("Characters hashmap size: " + characters.size() + "\n");
				if (!characters.isEmpty()) {
					partyTarget = (Character) getLowestAC(new HashMap<String, MobileObject>(characters));
					System.out.println("New target: " + partyTarget.getName() + "\n");
				}
			}
			
			partyHealTarget = (Character) getHealTarget(new HashMap<String, MobileObject>(characters));
		} else {
			System.out.println("Error in combatRound, unrecognized attacker: " + attacker);
		}
	}
	
	private static MobileObject getLowestAC(HashMap<String, MobileObject> mobs) {
		MobileObject currentMob;
		MobileObject lowestACMob = new Monster();
		lowestACMob.setArmorClass(Integer.MAX_VALUE);
		Iterator<Entry<String, MobileObject>> iterator = mobs.entrySet().iterator();
		HashMap.Entry<String, MobileObject> entry;
		
		while (iterator.hasNext()) {
			entry = (HashMap.Entry<String, MobileObject>) iterator.next();
			currentMob = (MobileObject) entry.getValue();
			if (currentMob.getArmorClass() < lowestACMob.getArmorClass()) {
				lowestACMob = currentMob;
			} else if (currentMob.getArmorClass() == lowestACMob.getArmorClass()) {
				if (currentMob.getHitPoints() > lowestACMob.getHitPoints()) {
					lowestACMob = currentMob;
				}
			}
			
			iterator.remove();
		}
		
		return lowestACMob;
	}
	
	private static MobileObject getHealTarget(HashMap<String, MobileObject> mobs) {
		MobileObject currentMob;
		MobileObject mostDamagedMob = new Monster();
		Iterator<Entry<String, MobileObject>> iterator = mobs.entrySet().iterator();
		HashMap.Entry<String, MobileObject> entry;
				
		while (iterator.hasNext()) {
			entry = (HashMap.Entry<String, MobileObject>) iterator.next();
			currentMob = (MobileObject) entry.getValue(); 
			
			if (currentMob.getDamage() > mostDamagedMob.getDamage()) {
				mostDamagedMob = currentMob;
			}
		}
		
		if (mostDamagedMob.getDamage() == 0) { 
			mostDamagedMob = null;
		}
		
		return mostDamagedMob;
	}
}