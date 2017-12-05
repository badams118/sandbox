package dnd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SpellEncyclopedia {
	private static HashMap<String, Spell> spells;
	
	public SpellEncyclopedia() {
		spells = new HashMap<String, Spell>();
		List<CharacterClass> characterClasses = new ArrayList<CharacterClass>();
		
		characterClasses.add(CharacterClass.MAGIC_USER);
		spells.put("magic missile", new Spell("Magic Missile", 1, 0, characterClasses, 0, 0, 2, 5, null));
		characterClasses.clear();
	}
	
	public static Spell getSpell(String type) {
		return spells.get(type.toLowerCase());
	}
}