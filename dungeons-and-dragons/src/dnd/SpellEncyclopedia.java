package dnd;

import java.util.HashMap;

public class SpellEncyclopedia {
	private static HashMap<String, Spell> spells;
	
	public SpellEncyclopedia() {
		spells = new HashMap<String, Spell>();
		HashMap<MobileObjectClass, Integer> classLevels = new HashMap<MobileObjectClass, Integer>();

//		public Spell(String name, int areaOfEffect, HashMap<MobileObjectClass, Integer> classLevels, 
//				int healLow, int healHigh, int damageLow, int damageHigh, SavingThrow savingThrow)
		
		classLevels.put(MobileObjectClass.CLERIC, 5);
		classLevels.put(MobileObjectClass.DRUID, 6);
		spells.put("Cure Critical Wounds", new Spell("Cure Critical Wounds", 0, classLevels, 6, 27, 0, 0, null));
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.CLERIC, 1);
		classLevels.put(MobileObjectClass.DRUID, 2);
		spells.put("Cure Light Wounds", new Spell("Cure Light Wounds", 0, classLevels, 1, 8, 0, 0, null));
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.CLERIC, 4);
		classLevels.put(MobileObjectClass.DRUID, 4);
		spells.put("Cure Serious Wounds", new Spell("Cure Serious Wounds", 0, classLevels, 3, 17, 0, 0, null));
		classLevels.clear();

		classLevels.put(MobileObjectClass.MAGIC_USER, 5);
		spells.put("Cloudkill", new Spell("Cloudkill", 0, classLevels, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, SavingThrow.POISON));
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.MAGIC_USER, 5);
		spells.put("Cone of Cold", new Spell("Cone of Cold", 0, classLevels, 0, 0, 1, 4, SavingThrow.SPELL));
		classLevels.clear();

		classLevels.put(MobileObjectClass.MAGIC_USER, 6);
		spells.put("Death Spell", new Spell("Death Spell", 0, classLevels, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, null));
		classLevels.clear();
		
//		classLevels.put(MobileObjectClass.CLERIC, 7);
//		spells.put("Destruction", new Spell("Destruction", 0, classLevels, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0, null)); 
//		classLevels.clear();

		classLevels.put(MobileObjectClass.DRUID, 7);
		spells.put("Finger of Death", new Spell("Finger of Death", 0, classLevels, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 0, SavingThrow.SPELL)); 
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.MAGIC_USER, 3);
		spells.put("Fire Ball", new Spell("Fire Ball", 0, classLevels, 0, 0, 1, 6, SavingThrow.SPELL));
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.MAGIC_USER, 7);
		spells.put("Fire Ball II", new Spell("Fire Ball II", 0, classLevels, 0, 0, 1, 6, SavingThrow.SPELL));
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.CLERIC, 5); 
		spells.put("Flame Strike", new Spell("Flame Strike", 0, classLevels, 0, 0, 6, 48, SavingThrow.SPELL));
		classLevels.clear();

		classLevels.put(MobileObjectClass.CLERIC, 6);
		spells.put("Heal", new Spell("Heal", 0, classLevels, Integer.MAX_VALUE, Integer.MAX_VALUE, 1, 4, null));
		classLevels.clear();

		classLevels.put(MobileObjectClass.MAGIC_USER, 4);
		spells.put("Ice Storm", new Spell("Ice Storm", 0, classLevels, 0, 0, 3, 30, null));
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.PALADIN, 1);
		spells.put("Lay On Hands", new Spell("Lay On Hands", 0, classLevels, 2, 2, 0, 0, null));
		classLevels.clear();

		classLevels.put(MobileObjectClass.MAGIC_USER, 3);
		spells.put("Lightening Bolt", new Spell("Lightening Bolt", 0, classLevels, 0, 0, 1, 6, SavingThrow.SPELL));
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.MAGIC_USER, 1);
		spells.put("Magic Missile", new Spell("Magic Missile", 0, classLevels, 0, 0, 2, 5, null));
		classLevels.clear();

		classLevels.put(MobileObjectClass.MAGIC_USER, 9);
		spells.put("Meteor Swarm", new Spell("Meteor Swarm", 0, classLevels, 0, 0, 10*4, 40*4, null));
		classLevels.clear();

		classLevels.put(MobileObjectClass.MAGIC_USER, 9);
		spells.put("Power Word, Kill", new Spell("Power Word, Kill", 0, classLevels, 0, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, null));
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.CLERIC, 5);
		spells.put("Raise Dead", new Spell("Raise Dead", 0, classLevels, 0, 0, 2, 5, SavingThrow.SPECIAL)); // TODO add saving throw logic
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.CLERIC, 7);
		spells.put("Resurrection", new Spell("Resurrection", 0, classLevels, 0, 0, 2, 5, null)); 
		classLevels.clear();
		
		classLevels.put(MobileObjectClass.MAGIC_USER, 1);
		spells.put("Shocking Grasp", new Spell("Shocking Grasp", 0, classLevels, 0, 0, 1, 8, null));
		classLevels.clear();
	}
	
	public static Spell getSpell(String type) {
		Spell spell = spells.get(type);
		
		return spell;
	}
}