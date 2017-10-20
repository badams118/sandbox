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
			case POISON:
			case DEATH_MAGIC:
				if (level <= 3 && roll >= 10) {
					isSaved = true; 
				} else if (level <= 6 && roll >= 9) {
					isSaved = true; 
				} else if (level <= 9 && roll >= 7) {
					isSaved = true; 
				} else if (level <= 12 && roll >= 6) {
					isSaved = true; 
				} else if (level <= 15 && roll >= 5) {
					isSaved = true; 
				} else if (level <= 18 && roll >= 4) {
					isSaved = true; 
				} else if (roll >= 2) {
					isSaved = true; 
				}
				break;
			case PETRIFICATION:
			case POLYMORPH:
				if (level <= 3 && roll >= 13) {
					isSaved = true; 
				} else if (level <= 6 && roll >= 12) {
					isSaved = true; 
				} else if (level <= 9 && roll >= 10) {
					isSaved = true; 
				} else if (level <= 12 && roll >= 9) {
					isSaved = true; 
				} else if (level <= 15 && roll >= 8) {
					isSaved = true; 
				} else if (level <= 18 && roll >= 7) {
					isSaved = true; 
				} else if (roll >= 5) {
					isSaved = true; 
				}
				break;
			case ROD:
			case STAFF:
			case WAND:
				if (level <= 3 && roll >= 14) {
					isSaved = true; 
				} else if (level <= 6 && roll >= 13) {
					isSaved = true; 
				} else if (level <= 9 && roll >= 11) {
					isSaved = true; 
				} else if (level <= 12 && roll >= 10) {
					isSaved = true; 
				} else if (level <= 15 && roll >= 9) {
					isSaved = true; 
				} else if (level <= 18 && roll >= 8) {
					isSaved = true; 
				} else if (roll >= 6) {
					isSaved = true; 
				}
				break;
			case BREATH_WEAPON:
				if (level <= 3 && roll >= 16) {
					isSaved = true; 
				} else if (level <= 6 && roll >= 15) {
					isSaved = true; 
				} else if (level <= 9 && roll >= 13) {
					isSaved = true; 
				} else if (level <= 12 && roll >= 12) {
					isSaved = true; 
				} else if (level <= 15 && roll >= 11) {
					isSaved = true; 
				} else if (level <= 18 && roll >= 10) {
					isSaved = true; 
				} else if (roll >= 8) {
					isSaved = true; 
				}
				break;
			case SPELL:
				if (level <= 3 && roll >= 15) {
					isSaved = true; 
				} else if (level <= 6 && roll >= 14) {
					isSaved = true; 
				} else if (level <= 9 && roll >= 12) {
					isSaved = true; 
				} else if (level <= 12 && roll >= 11) {
					isSaved = true; 
				} else if (level <= 15 && roll >= 10) {
					isSaved = true; 
				} else if (level <= 18 && roll >= 9) {
					isSaved = true; 
				} else if (roll >= 7) {
					isSaved = true; 
				}
				break;				
			}
			break;
		}
		
		return isSaved;
	}
}
