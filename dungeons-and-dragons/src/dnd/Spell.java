package dnd;

import java.util.List;

public class Spell {
	private String name;
	//private SpellType type;
	private int level;
	private int duration; 
	private int areaOfEffect;
	//private Component[] components;
	private int castingTime;
	private SavingThrow savingThrow;
	private String description;
	private List<CharacterClass> characterClasses;
	private int healOrDamageLow;
	private int healOrDamageHigh;
	
	public Spell(String name, int level, int areaOfEffect, List<CharacterClass> characterClasses, int healOrDamageLow, int healOrDamageHigh, SavingThrow savingThrow) {
		this(name, level, 0, areaOfEffect, 1, savingThrow, null, characterClasses, healOrDamageLow, healOrDamageHigh);
	}
	
	public Spell(String name, /*SpellType spellType,*/ int level, int duration, int areaOfEffect, /*Component[] components,*/ int castingTime,
			SavingThrow savingThrow, String description, List<CharacterClass> characterClasses, int healOrDamageLow, int healOrDamageHigh) {
		this.name = name;
		//this.spellType = spellType;
		this.level = level;
		this.duration = duration;
		this.areaOfEffect = areaOfEffect;
		//this.components = components;
		this.castingTime = castingTime;
		this.savingThrow = savingThrow;
		this.description = description;
		this.characterClasses = characterClasses;
		this.healOrDamageLow = healOrDamageLow;
		this.healOrDamageHigh = healOrDamageHigh;
	}
	
	public String getName() {
		return this.name;
	}
	
	public boolean equals(Object object) {
		boolean isEquals = false;
		Spell spell = (Spell) object;
		
		if (name.equals(spell.getName())) {
			isEquals = true;
		} 
		
		return isEquals;
	}
}
