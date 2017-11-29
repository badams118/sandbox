package dnd;

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
	private CharacterClass[] characterClasses;
	private int cureDamageLow;
	private int cureDamageHigh;
	
	public Spell(String name, int level, int areaOfEffect, int cureDamageLow, int cureDamageHigh, SavingThrow savingThrow) {
		this(name, level, 0, areaOfEffect, 1, savingThrow, null, null, cureDamageLow, cureDamageHigh);
	}
	
	public Spell(String name, /*SpellType spellType,*/ int level, int duration, int areaOfEffect, /*Component[] components,*/ int castingTime,
			SavingThrow savingThrow, String description, CharacterClass[] characterClasses, int cureDamageLow, int cureDamageHigh) {
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
		this.cureDamageHigh = cureDamageHigh;
		this.cureDamageLow = cureDamageLow;
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
