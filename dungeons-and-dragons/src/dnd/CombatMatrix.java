package dnd;

public class CombatMatrix {
	public static int[][] getHitMatrix(CharacterClass characterClass, int level) { 
		int[][] hitMatrix = new int[21][2];
		
		switch (characterClass) {
		case CLERIC:
		case DRUID:
			if (level <= 3) {
				int tempMatrix[][] = {
						{-10, 25},
						{ -9, 24}
						};
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
			break;
		case THIEF:
		case ASSASSIN:
			break;
		default:
			break;
		}
		
		return hitMatrix;
	}
}
