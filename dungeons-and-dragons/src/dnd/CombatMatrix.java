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
		}
		
		return hitMatrix;
	}
}
