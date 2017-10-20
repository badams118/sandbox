package dnd;

import java.util.Random;

public enum Money {
	COPPER,
	SILVER,
	ELECTRUM,
	GOLD,
	PLATINUM;
	
	public static float setMoney(CharacterClass characterClass) {
		float goldPieces = 0;
		Random random = new Random();
		
		switch (characterClass) {
		case DRUID: 
		case CLERIC: 
			goldPieces = random.nextInt(150) + 30;
			break;
		case PALADIN:
		case ANTI_PALADIN:
		case RANGER:
		case FIGHTER:
			goldPieces = random.nextInt(150) + 50;
			break;
		case ILLUSIONIST:
		case MAGIC_USER:
			goldPieces = random.nextInt(60) + 20;
			break;
		case ASSASSIN:
		case THIEF:
			goldPieces = random.nextInt(100) + 20;
			break;
		}
		
		return goldPieces;
	}
	
	public static float convertMoney(Money type, int pieces) {
		float goldPieces;
		
		switch (type) {
		case COPPER:
			goldPieces = pieces/200;
			break;
		case SILVER:
			goldPieces = pieces/20;
			break;
		case ELECTRUM:
			goldPieces = pieces/2;
			break;
		case GOLD:
			goldPieces = pieces;
			break;
		case PLATINUM: 
			goldPieces = pieces * 5;
			break;
		default: 
			goldPieces = pieces;
			break;
		}
		
		return goldPieces;
	}
}
