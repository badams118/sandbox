package dnd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public abstract class MobileObject implements Serializable {
	private static final long serialVersionUID = -1211342146528001795L;
	private int armorClass;
	private int hitPoints;
	private CharacterClass characterClass;
	protected int experience;
	private int level;
	private TargetSize size;
	private int[][] hitMatrix;
	private HashMap<String, Spell> spellBook;
	
	public MobileObject() {		
		spellBook = new HashMap<String, Spell>();
	}
	
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}
	
	public int getArmorClass() {
		return armorClass;
	}
	
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	public void setCharacterClass(CharacterClass characterClass) {
		this.characterClass = characterClass;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	
	public TargetSize getSize() {
		return this.size;
	}
	
	public void setSize (TargetSize size) {
		this.size = size;
	}
	
	public void populateHitMatrix(CharacterClass characterClass, int level) {
		this.hitMatrix = CombatMatrix.getHitMatrix(characterClass, level);
	}
	
	public int strikeMelee(MobileObject target, int damageLow, int damageHigh) {
		return strikeMelee(target, damageLow, damageHigh, 0);
	}
	
	public int strikeMelee(MobileObject target, int damageLow, int damageHigh, int damageBonus) {
		int damage = 0;
		
		if (this.isHit(target)) {			
			damage = new Random().nextInt(damageHigh - damageLow + 1) + damageLow + damageBonus;
			target.updateHitPoints(-damage);
		}
		
		return damage;
	}
	
	private boolean isHit(MobileObject target) {
		Random random = new Random();
		int roll = random.nextInt(20) + 1;
		boolean isHit;
		
		System.out.println("Attack roll " + Integer.toString(roll));
		System.out.println("Target armor class: " + this.hitMatrix[target.armorClass + 10][0]);
		System.out.println("Attacker to hit: " + Integer.toString(this.hitMatrix[target.armorClass + 10][1]));
		
		if (roll >= this.hitMatrix[target.armorClass + 10][1]) {
			isHit = true;
		} else {
			isHit = false;
		}
		
		return isHit;
	}
	
	public void memorizeSpell(String type) {
		spellBook.put(type.toLowerCase(), SpellEncyclopedia.getSpell(type));
	}
	
	public boolean hasSpell(String type) {
		Spell spell = SpellEncyclopedia.getSpell(type.toLowerCase());
		return spellBook.containsValue(spell);
	}
	
	public int castSpell(String type, MobileObject target) {
		int healOrDamage = 0;
		Spell spell = SpellEncyclopedia.getSpell(type);

		if (spell.getHealHigh() + spell.getHealBonus() > 0) {			
			healOrDamage = new Random().nextInt(spell.getHealHigh() - spell.getHealLow() + 1) + spell.getHealLow() + spell.getHealBonus();
			target.updateHitPoints(healOrDamage);
		}
		
		if (!this.isSaved(target, spell.getSavingThrow()) && spell.getDamageHigh() + spell.getDamageBonus() > 0) {			
			healOrDamage = new Random().nextInt(spell.getDamageHigh() - spell.getDamageLow() + 1) + spell.getDamageLow() + spell.getDamageBonus();
			target.updateHitPoints(-healOrDamage);
		}
		
		spellBook.remove(spell);
		
		return healOrDamage;
	}

	private boolean isSaved(MobileObject target, SavingThrow savingThrow) {
		return SavingThrow.checkSavingThrow(target, savingThrow);
	}
	
	public void updateHitPoints(int value) {
		this.hitPoints += value;
	}

	public int getHitPoints() {
		return this.hitPoints;
	}
	
	public CharacterClass getCharacterClass() {
		return this.characterClass;
	}
	
	public int getLevel() {
		return this.level;
	}
}
