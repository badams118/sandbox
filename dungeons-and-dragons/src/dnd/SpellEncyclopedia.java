package dnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpellEncyclopedia {
	private static HashMap<String, Spell> spells;
	
	public SpellEncyclopedia() {
		spells = new HashMap<String, Spell>();
		HashMap<MobileObjectClass, Integer> classLevels = new HashMap<MobileObjectClass, Integer>();

		classLevels.put(MobileObjectClass.CLERIC, 1);
		classLevels.put(MobileObjectClass.DRUID, 2);
		spells.put("Cure Light Wounds", new Spell("Cure Light Wounds", 0, classLevels, 1, 8, 0, 0, null));
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.MAGIC_USER, 1);
		spells.put("Magic Missile", new Spell("Magic Missile", 0, classLevels, 0, 0, 2, 5, null));
		classLevels.clear();
	}
	
	public static Spell getSpell(String type) {
		return spells.get(type);
	}
}