package dnd;

public enum CharacterClass {
	CLERIC {
		public String toString() {
			return "Cleric";
		}
	},
	DRUID {
		public String toString() {
			return "Druid";
		}
	},
	FIGHTER {
		public String toString() {
			return "Fighter";
		}
	},
	PALADIN {
		public String toString() {
			return "Paladin";
		}
	},
	ANTI_PALADIN {
		public String toString() {
			return "Anti-Paladin";
		}
	},
	RANGER {
		public String toString() {
			return "Ranger";
		}
	},
	MAGIC_USER {
		public String toString() {
			return "Magic User";
		}
	},
	ILLUSIONIST {
		public String toString() {
			return "Illusionist";
		}
	},
	THIEF {
		public String toString() {
			return "Thief";
		}
	},
	ASSASSIN {
		public String toString() {
			return "Assassin";
		}
	};
	
	public static int getHitPoints(CharacterClass characterClass, int level) {
		int hitPoints;
		
		switch (characterClass) {
		case CLERIC:
			if (level <= 9) {
				hitPoints = 4 * level;
			} else {
				hitPoints = (4 * 9) + (2 * (level - 9));
			}
			break;
		case DRUID:
			hitPoints = 4 * level;
			break;
		case ANTI_PALADIN:
		case PALADIN:
		case FIGHTER:
			if (level <= 9) {
				hitPoints = 5 * level;
			} else {
				hitPoints = (5 * 9) + (3 * (level - 9));
			}
			break;
		case RANGER:
			if (level <= 10) {
				hitPoints = 4 * (level + 1);
			} else {
				hitPoints = (4 * (10 + 1)) + (2 * (level - 10));
			}
			break;
		case MAGIC_USER:
			if (level <= 11) {
				hitPoints = 2 * level;
			} else {
				hitPoints = (2 * 11) + (1 * (level - 11));
			}
			break;
		case ILLUSIONIST:
			if (level <= 10) {
				hitPoints = 2 * level;
			} else {
				hitPoints = (2 * 10) + (1 * (level - 10));
			}
			break;
		case THIEF:
			if (level <= 10) {
				hitPoints = 3 * level;
			} else {
				hitPoints = (3 * 10) + (2 * (level - 10));
			}
			break;
		case ASSASSIN:
			hitPoints = 3 * level;
			break;
		default:
			hitPoints = 0;
		}
		
		return hitPoints;
	}
}