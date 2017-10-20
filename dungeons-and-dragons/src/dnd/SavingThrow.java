package dnd;

import java.util.Random;

public enum SavingThrow {
	PARALYZATION,
	POISON,
	DEATH_MAGIC,
	PETRIFICATION,
	POLYMORPH,
	ROD,
	STAFF,
	WAND,
	BREATH_WEAPON,
	SPELL;
	
	public static boolean checkSavingThrow(CharacterClass characterClass, int level, SavingThrow attack) {
		boolean isSaved = false;
		
		int roll = new Random().nextInt(20) + 1;
		System.out.println("Saving throw roll: " + roll);
				
		switch (characterClass) {
		case CLERIC: 
			switch (attack) {
			case PARALYZATION:
				if (level >= 3 && roll > 1) {
				  isSaved = true; 
				}
				break;
			}
			break;
		}
		
		return isSaved;
	}
}
