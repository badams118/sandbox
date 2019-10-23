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
	SPELL,
	NONE;
	
	public static boolean checkSavingThrow(MobileObject target, SavingThrow attack) {
		boolean isSaved = false;
		
		int level = target.getLevel();
		MobileObjectClass mobileObjectClass = target.getMobileObjectClass();
		
		int roll = new Random().nextInt(20) + 1;
		
		if (mobileObjectClass == MobileObjectClass.PALADIN || mobileObjectClass == MobileObjectClass.ANTI_PALADIN) {
			roll = roll + 2;
		}
		
		System.out.println("Saving throw roll: " + roll);
				
		switch (mobileObjectClass) {
		case DRUID: 
		case CLERIC: 
			switch (attack) {
			case PARALYZATION:
			case POISON:
			case DEATH_MAGIC:
				if (level <= 3 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 4 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 7 && roll >= 7) {
					isSaved = true; 
				} else if (level >= 10 && roll >= 6) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 5) {
					isSaved = true; 
				} else if (level >= 16 && roll >= 4) {
					isSaved = true; 
				} else if (level >= 19 && roll >= 2) {
					isSaved = true; 
				}
				break;
			case PETRIFICATION:
			case POLYMORPH:
				if (level <= 3 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 4 && roll >= 12) {
					isSaved = true; 
				} else if (level >= 7 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 10 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 8) {
					isSaved = true; 
				} else if (level >= 16 && roll >= 7) {
					isSaved = true; 
				} else if (level >= 19 && roll >= 5) {
					isSaved = true; 
				}
				break;
			case ROD:
			case STAFF:
			case WAND:
				if (level <= 3 && roll >= 14) {
					isSaved = true; 
				} else if (level >= 4 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 7 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 10 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 16 && roll >= 8) {
					isSaved = true; 
				} else if (level >= 19 && roll >= 6) {
					isSaved = true; 
				}
				break;
			case BREATH_WEAPON:
				if (level <= 3 && roll >= 16) {
					isSaved = true; 
				} else if (level >= 4 && roll >= 15) {
					isSaved = true; 
				} else if (level >= 7 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 10 && roll >= 12) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 16 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 19 && roll >= 8) {
					isSaved = true; 
				}
				break;
			case SPELL:
				if (level <= 3 && roll >= 15) {
					isSaved = true; 
				} else if (level >= 4 && roll >= 14) {
					isSaved = true; 
				} else if (level >= 7 && roll >= 12) {
					isSaved = true; 
				} else if (level >= 10 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 16 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 19 && roll >= 7) {
					isSaved = true; 
				}
				break;				
			}
			break;
		case PALADIN:
		case ANTI_PALADIN:
		case RANGER:
		case BARD:
		case FIGHTER:
			switch (attack) {
			case PARALYZATION:
			case POISON:
			case DEATH_MAGIC:
				if (level == 0 && roll >= 16) {
					isSaved = true; 
				} else if (level >= 1 && roll >= 14) {
					isSaved = true; 
				} else if (level >= 3 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 5 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 7 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 9 && roll >= 8) {
					isSaved = true; 
				} else if (level >= 11 && roll >= 7) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 5) {
					isSaved = true; 
				} else if (level >= 15 && roll >= 4) {
					isSaved = true; 
				} else if (level >= 17 && roll >= 3) {
					isSaved = true; 
				}
				break;
			case PETRIFICATION:
			case POLYMORPH:
				if (level == 0 && roll >= 17) {
					isSaved = true; 
				} else if (level >= 1 && roll >= 15) {
					isSaved = true; 
				} else if (level >= 3 && roll >= 14) {
					isSaved = true; 
				} else if (level >= 5 && roll >= 12) {
					isSaved = true; 
				} else if (level >= 7 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 9 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 11 && roll >= 8) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 6) {
					isSaved = true; 
				} else if (level >= 15 && roll >= 5) {
					isSaved = true; 
				} else if (level >= 17 && roll >= 4) {
					isSaved = true; 
				}
				break;
			case ROD:
			case STAFF:
			case WAND:
				if (level == 0 && roll >= 18) {
					isSaved = true; 
				} else if (level >= 1 && roll >= 16) {
					isSaved = true; 
				} else if (level >= 3 && roll >= 15) {
					isSaved = true; 
				} else if (level >= 5 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 7 && roll >= 12) {
					isSaved = true; 
				} else if (level >= 9 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 11 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 7) {
					isSaved = true; 
				} else if (level >= 15 && roll >= 6) {
					isSaved = true; 
				} else if (level >= 17 && roll >= 5) {
					isSaved = true; 
				}
				break;
			case BREATH_WEAPON:
				if (level == 0 && roll >= 16) {
					isSaved = true; 
				} else if (level >= 1 && roll >= 20) {
					isSaved = true; 
				} else if (level >= 3 && roll >= 17) {
					isSaved = true; 
				} else if (level >= 5 && roll >= 16) {
					isSaved = true; 
				} else if (level >= 7 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 9 && roll >= 12) {
					isSaved = true; 
				} else if (level >= 11 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 8) {
					isSaved = true; 
				} else if (level >= 15 && roll >= 5) {
					isSaved = true; 
				} else if (level >= 17 && roll >= 4) {
					isSaved = true; 
				}
				break;
			case SPELL:
				if (level == 0 && roll >= 19) {
					isSaved = true; 
				} else if (level >= 1 && roll >= 17) {
					isSaved = true; 
				} else if (level >= 3 && roll >= 16) {
					isSaved = true; 
				} else if (level >= 5 && roll >= 14) {
					isSaved = true; 
				} else if (level >= 7 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 9 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 11 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 8) {
					isSaved = true; 
				} else if (level >= 15 && roll >= 7) {
					isSaved = true; 
				} else if (level >= 17 && roll >= 6) {
					isSaved = true; 
				}
				break;				
			}
			break;
		case ILLUSIONIST:
		case MAGIC_USER:
			switch (attack) {
			case PARALYZATION:
			case POISON:
			case DEATH_MAGIC:
				if (level <= 5 && roll >= 14) {
					isSaved = true; 
				} else if (level >= 6 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 11 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 16 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 21 && roll >= 8) {
					isSaved = true; 
				}
				break;
			case PETRIFICATION:
			case POLYMORPH:
				if (level <= 5 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 6 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 11 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 16 && roll >= 7) {
					isSaved = true; 
				} else if (level >= 21 && roll >= 5) {
					isSaved = true; 
				}
				break;
			case ROD:
			case STAFF:
			case WAND:
				if (level <= 5 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 6 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 11 && roll >= 7) {
					isSaved = true; 
				} else if (level >= 16 && roll >= 5) {
					isSaved = true; 
				} else if (level >= 21 && roll >= 3) {
					isSaved = true; 
				}
				break;
			case BREATH_WEAPON:
				if (level <= 5 && roll >= 15) {
					isSaved = true; 
				} else if (level >= 6 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 11 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 16 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 21 && roll >= 7) {
					isSaved = true; 
				}
				break;
			case SPELL:
				if (level <= 5 && roll >= 12) {
					isSaved = true; 
				} else if (level >= 6 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 11 && roll >= 8) {
					isSaved = true; 
				} else if (level >= 16 && roll >= 6) {
					isSaved = true; 
				} else if (level >= 21 && roll >= 4) {
					isSaved = true; 
				}
				break;				
			}
			break;
		case ASSASSIN:
		case THIEF:
			switch (attack) {
			case PARALYZATION:
			case POISON:
			case DEATH_MAGIC:
				if (level <= 4 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 5 && roll >= 12) {
					isSaved = true; 
				} else if (level >= 9 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 17 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 21 && roll >= 8) {
					isSaved = true; 
				}
				break;
			case PETRIFICATION:
			case POLYMORPH:
				if (level <= 4 && roll >= 12) {
					isSaved = true; 
				} else if (level >= 5 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 9 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 17 && roll >= 8) {
					isSaved = true; 
				} else if (level >= 21 && roll >= 7) {
					isSaved = true; 
				}
				break;
			case ROD:
			case STAFF:
			case WAND:
				if (level <= 4 && roll >= 14) {
					isSaved = true; 
				} else if (level >= 5 && roll >= 12) {
					isSaved = true; 
				} else if (level >= 9 && roll >= 10) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 8) {
					isSaved = true; 
				} else if (level >= 17 && roll >= 6) {
					isSaved = true; 
				} else if (level >= 21 && roll >= 4) {
					isSaved = true; 
				}
				break;
			case BREATH_WEAPON:
				if (level <= 4 && roll >= 16) {
					isSaved = true; 
				} else if (level >= 5 && roll >= 15) {
					isSaved = true; 
				} else if (level >= 9 && roll >= 14) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 17 && roll >= 12) {
					isSaved = true; 
				} else if (level >= 21 && roll >= 11) {
					isSaved = true; 
				}
				break;
			case SPELL:
				if (level <= 4 && roll >= 15) {
					isSaved = true; 
				} else if (level >= 5 && roll >= 13) {
					isSaved = true; 
				} else if (level >= 9 && roll >= 11) {
					isSaved = true; 
				} else if (level >= 13 && roll >= 9) {
					isSaved = true; 
				} else if (level >= 17 && roll >= 7) {
					isSaved = true; 
				} else if (level >= 21 && roll >= 5) {
					isSaved = true; 
				}
				break;				
			}
			break;
		} // "NONE" defaults to false
		
		return isSaved;
	}
}