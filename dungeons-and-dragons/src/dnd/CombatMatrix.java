package dnd;

public class CombatMatrix {
	public static int[][] getHitMatrix(Race race, int level) {  
		int[][] hitMatrix = new int[21][2];
		
		if ((race == Race.HALFLING || race == Race.HUMAN) && level == 0) {
			hitMatrix = getHitMatrix(CharacterClass.FIGHTER, level);
		} else {
			hitMatrix = getHitMatrix(CharacterClass.NONE, level);
		}
		
		return hitMatrix;
	}
	
	public static int[][] getHitMatrix(CharacterClass characterClass, int level) { 
		int[][] hitMatrix = new int[21][2];
		
		switch (characterClass) {
		case CLERIC:
		case DRUID:
			if (level <= 3) {
				int tempMatrix[][] = {
						{-10, 25},
						{ -9, 24},
						{ -8, 23},
						{ -7, 22},
						{ -6, 21},
						{ -5, 20},
						{ -4, 20},
						{ -3, 20},
						{ -2, 20},
						{ -1, 20},
						{  0, 20},
						{  1, 19},
						{  2, 18},
						{  3, 17},
						{  4, 16},
						{  5, 15},
						{  6, 14},
						{  7, 13},
						{  8, 12},
						{  9, 11},
						{ 10, 10}};
				hitMatrix = tempMatrix;
			}
			break;
		case MAGIC_USER:
		case ILLUSIONIST:
			break;
		case FIGHTER:
		case PALADIN:
		case ANTI_PALADIN:
		case RANGER:
		case BARD:
			if (level == 0) {
				int tempMatrix[][] = {
						{-10, 26},
						{ -9, 25},
						{ -8, 24},
						{ -7, 23},
						{ -6, 22},
						{ -5, 21},
						{ -4, 20},
						{ -3, 20},
						{ -2, 20},
						{ -1, 20},
						{  0, 20},
						{  1, 20},
						{  2, 19},
						{  3, 18},
						{  4, 17},
						{  5, 16},
						{  6, 15},
						{  7, 14},
						{  8, 13},
						{  9, 12},
						{ 10, 11}};
				hitMatrix = tempMatrix;
			} else if (level <= 2) {
				int tempMatrix[][] = {
						{-10, 25},
						{ -9, 24},
						{ -8, 23},
						{ -7, 22},
						{ -6, 21},
						{ -5, 20},
						{ -4, 20},
						{ -3, 20},
						{ -2, 20},
						{ -1, 20},
						{  0, 20},
						{  1, 19},
						{  2, 18},
						{  3, 17},
						{  4, 16},
						{  5, 15},
						{  6, 14},
						{  7, 13},
						{  8, 12},
						{  9, 11},
						{ 10, 10}};
				hitMatrix = tempMatrix;
			} else if (level <= 4) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 6) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 8) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 10) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 12) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 14) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 16) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level >= 17) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			}
			break;
		case THIEF:
		case ASSASSIN:
			break;
		default: //Attack matrix for monsters
			if (level < 1) { //level ~ hit dice
				int tempMatrix[][] = {
						{-10, 25},
						{ -9, 24},
						{ -8, 23},
						{ -7, 22},
						{ -6, 21},
						{ -5, 20},
						{ -4, 20},
						{ -3, 20},
						{ -2, 20},
						{ -1, 20},
						{  0, 20},
						{  1, 19},
						{  2, 18},
						{  3, 17},
						{  4, 16},
						{  5, 15},
						{  6, 14},
						{  7, 13},
						{  8, 12},
						{  9, 11},
						{ 10, 10}};
				hitMatrix = tempMatrix;
			} else if (level == 1) {
				int tempMatrix[][] = {
						{-10, 24},
						{ -9, 23},
						{ -8, 22},
						{ -7, 21},
						{ -6, 20},
						{ -5, 20},
						{ -4, 20},
						{ -3, 20},
						{ -2, 20},
						{ -1, 20},
						{  0, 19},
						{  1, 18},
						{  2, 17},
						{  3, 16},
						{  4, 15},
						{  5, 14},
						{  6, 13},
						{  7, 12},
						{  8, 11},
						{  9, 10},
						{ 10,  9}};
				hitMatrix = tempMatrix;
			} else if (level <= 3) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 5) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 7) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 9) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 11) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 13) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level <= 15) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			} else if (level >= 16) {
				int tempMatrix[][] = {
						{-10, },
						{ -9, },
						{ -8, },
						{ -7, },
						{ -6, },
						{ -5, },
						{ -4, },
						{ -3, },
						{ -2, },
						{ -1, },
						{  0, },
						{  1, },
						{  2, },
						{  3, },
						{  4, },
						{  5, },
						{  6, },
						{  7, },
						{  8, },
						{  9, },
						{ 10, }};
				hitMatrix = tempMatrix;
			}
			break;
		}
		
		return hitMatrix;
	}
}
