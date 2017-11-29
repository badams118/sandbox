package dnd;

import java.util.ArrayList;
import java.util.List;

public class SpellEncyclopedia {
	private List<Spell> spells;
	
	public SpellEncyclopedia() {
		List<CharacterClass> characterClasses = new ArrayList<CharacterClass>();
		
		characterClasses.add(CharacterClass.MAGIC_USER);
		spells.add(new Spell("Magic Missile", 1, 0, characterClasses, 2, 5, null));
		characterClasses.clear();
		
		
	}
}
