package dnd;

public enum Money {
	COPPER,
	SILVER,
	ELECTRUM,
	GOLD,
	PLATINUM;
	
	public static float setMoney(MobileObjectClass mobileObjectClass) {
		float goldPieces = 0;
		
		switch (mobileObjectClass) {
		case DRUID: 
		case CLERIC: 
			goldPieces = 90;
			break;
		case PALADIN:
		case ANTI_PALADIN:
		case RANGER:
		case FIGHTER:
			goldPieces = 100;
			break;
		case ILLUSIONIST:
		case MAGIC_USER:
			goldPieces = 40;
			break;
		case ASSASSIN:
		case THIEF:
			goldPieces = 60;
			break;
		}
		
		return goldPieces;
	}
	
	public static double toGold(int pieces, Money type) {
		double goldPieces;
		
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