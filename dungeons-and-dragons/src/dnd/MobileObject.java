package dnd;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;
import java.util.Map.Entry;

public class MobileObject implements Serializable {
	private static final long serialVersionUID = -1211342146528001795L;
	private int armorClass;
	private int hitPoints;
	private int maxHitPoints;
	private MobileObjectClass mobileObjectClass;
	protected int experience;
	private int level;
	private TargetSize size;
	private int[][] hitMatrix;
	public HashMap<String, Spell> spellBook;
	
	public MobileObject() {		
		spellBook = new HashMap<String, Spell>();
	}
	
	public void setArmorClass(int armorClass) {
		this.armorClass = armorClass;
	}
	
	public int getArmorClass() {
		return armorClass;
	}

	public int getHitPoints() {
		return this.hitPoints;
	}
	
	public int getDamage() {
		return this.maxHitPoints - this.hitPoints;
	}
	
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	
	public void setMaxHitPoints(int hitPoints) {
		this.maxHitPoints = hitPoints;
	}
	
	public void setCharacterClass(MobileObjectClass mobileObjectClass) {
		this.mobileObjectClass = mobileObjectClass;
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
	
	public void populateHitMatrix(MobileObjectClass mobileObjectClass, int level) {
		this.hitMatrix = CombatMatrix.getHitMatrix(mobileObjectClass, level);
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
		boolean isHit = false;
		
		System.out.println("Attack roll " + Integer.toString(roll));
		System.out.println("Target armor class: " + this.hitMatrix[target.armorClass + 10][0]);
		System.out.println("Attacker to hit: " + Integer.toString(this.hitMatrix[target.armorClass + 10][1]));
		
		if (roll >= this.hitMatrix[target.armorClass + 10][1]) {
			isHit = true;
		}
		
		return isHit;
	}
	
	public void memorizeSpell(String type) {
		spellBook.put(type, SpellEncyclopedia.getSpell(type));
	}
	
	public boolean hasSpell(String type) {
		Spell spell = SpellEncyclopedia.getSpell(type);
		return spellBook.containsValue(spell);
	}
	
	public boolean hasSpell() {
		boolean result = false;
		
		if (spellBook.size() > 0) {
			result = true;
		}
		
		return result;
	}
	
	public Spell getHighestDamageSpell() {
		Iterator<Entry<String, Spell>> iterator = spellBook.entrySet().iterator();
		HashMap.Entry<String, Spell> entry;
		Spell currentSpell;
		Spell highestDamageSpell = new Spell();
		
		while (iterator.hasNext()) {
			entry = (HashMap.Entry<String, Spell>) iterator.next();
			currentSpell = (Spell) entry.getValue();
			if (currentSpell.getDamageHigh() > highestDamageSpell.getDamageHigh()) {
				highestDamageSpell = currentSpell;
			}
		}

		if (highestDamageSpell.getName() == null) {
			highestDamageSpell = null;
		}
		
		return highestDamageSpell;
	}

	public Spell getHighestHealingSpell() {
		Iterator<Entry<String, Spell>> iterator = spellBook.entrySet().iterator();
		HashMap.Entry<String, Spell> entry;
		Spell currentSpell;
		Spell highestHealingSpell = new Spell();
		
		while (iterator.hasNext()) {
			entry = (HashMap.Entry<String, Spell>) iterator.next();
			currentSpell = (Spell) entry.getValue(); 
			if (currentSpell.getHealHigh() > highestHealingSpell.getHealHigh()) {
				highestHealingSpell = currentSpell; 
			}
		}
		
		if (highestHealingSpell.getName() == null) { 
			highestHealingSpell = null;
		}
				
		return highestHealingSpell;
	}
	
	public int castSpell(String type, MobileObject target) {
		int healOrDamage = 0;
		Spell spell = SpellEncyclopedia.getSpell(type);

		if (spell.getHealHigh() + spell.getHealBonus() > 0) {			
			healOrDamage = new Random().nextInt(spell.getHealHigh() - spell.getHealLow() + 1) + spell.getHealLow() + spell.getHealBonus();
			target.updateHitPoints(healOrDamage);
		} else if (!this.isSaved(target, spell.getSavingThrow()) && spell.getDamageHigh() + spell.getDamageBonus() > 0) {			
			healOrDamage = new Random().nextInt(spell.getDamageHigh() - spell.getDamageLow() + 1) + spell.getDamageLow() + spell.getDamageBonus();
			target.updateHitPoints(-healOrDamage);
		}
		
		//spellBook.remove(spell);
		
		return healOrDamage;
	}
	
	public void removeSpell(String spell) {
		this.spellBook.remove(spell);
	}

	private boolean isSaved(MobileObject target, SavingThrow savingThrow) {
		return SavingThrow.checkSavingThrow(target, savingThrow);
	}
	
	public void updateHitPoints(int value) {
		this.hitPoints += value;
		
		if (this.hitPoints > this.maxHitPoints) {
			this.hitPoints = this.maxHitPoints;
		}
	}
	
	public MobileObjectClass getMobileObjectClass() {
		return this.mobileObjectClass;
	}
	
	public int getLevel() {
		return this.level;
	}
}
