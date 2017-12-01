package dnd;

import java.io.Serializable;
import java.util.List;

public class Spell implements Serializable {
	private static final long serialVersionUID = -219947950436259116L;
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
	private int healLow;
	private int healHigh;
	private int healBonus;
	private int damageLow;
	private int damageHigh;
	private int damageBonus;
	
	public Spell(String name, int level, int areaOfEffect, List<CharacterClass> characterClasses, 
			int healLow, int healHigh, int damageLow, int damageHigh, SavingThrow savingThrow) {
		this(name, level, 0, areaOfEffect, 1, savingThrow, null, characterClasses, healLow, healHigh, 0, damageLow, damageHigh, 0);
	}
	
	public Spell(String name, /*SpellType spellType,*/ int level, int duration, int areaOfEffect, /*Component[] components,*/ int castingTime,
			SavingThrow savingThrow, String description, List<CharacterClass> characterClasses, 
			int healLow, int healHigh, int healBonus, int damageLow, int damageHigh, int damageBonus) {
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
		this.healLow = healLow;
		this.healHigh = healHigh;
		this.healBonus = healBonus;
		this.damageLow = damageLow;
		this.damageHigh = damageHigh;
		this.damageBonus = damageBonus;
	}
	
	public String getName() {
		return this.name;
	}
	
	public SavingThrow getSavingThrow() {
		return this.savingThrow;
	}
	
	public int getHealLow() {
		return this.healLow;
	}
	
	public int getHealHigh() {
		return this.healHigh;
	}
	
	public int getHealBonus() {
		return this.healBonus;
	}
	
	public int getDamageLow() {
		return this.damageLow;
	}
	
	public int getDamageHigh() {
		return this.damageHigh;
	}
	
	public int getDamageBonus() {
		return this.damageBonus;
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
