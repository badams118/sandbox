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
	
	public int getMaxHitPoints() {
		return this.maxHitPoints;
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

	public int getLevel() {
		return this.level;
	}

	public int getHitDice() {
		return this.level;
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
		Spell spell = SpellEncyclopedia.getSpell(type);

		if (type.equals("Cone of Cold") || type.equals("Fire Ball II")) {
			spell.setDamageLow((spell.getDamageLow() + 1) * this.level);
			spell.setDamageHigh((spell.getDamageHigh() + 1) * this.level);
		}
		
		if (type.equals("Fire Ball") || type.equals("Lightning Bolt")) {
			spell.setDamageLow(spell.getDamageLow() * this.level);
			spell.setDamageHigh(spell.getDamageHigh() * this.level);
		}
		
		if (type.equals("Lay On Hands")) {
			spell.setHealLow(spell.getHealLow() * this.level);
			spell.setHealHigh(spell.getHealHigh() * this.level);
		} 
		
		if (type.equals("Magic Missile")) {
			spell.setDamageLow(spell.getDamageLow() * (int) Math.floor(this.level/2));
			spell.setDamageHigh(spell.getDamageHigh() * (int) Math.floor(this.level/2));
		}

		if (type.equals("Shocking Grasp")) {
			spell.setDamageLow(spell.getDamageLow() + this.level);
			spell.setDamageHigh(spell.getDamageHigh() + this.level);
		}
		
		spellBook.put(type, spell);
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
	
	public Spell getHighestDamageSpell(MobileObject target) {
		Iterator<Entry<String, Spell>> iterator = spellBook.entrySet().iterator();
		HashMap.Entry<String, Spell> entry;
		Spell currentSpell;
		Spell highestDamageSpell = new Spell();
		
		while (iterator.hasNext()) {
			entry = (HashMap.Entry<String, Spell>) iterator.next();
			currentSpell = (Spell) entry.getValue();
			
			if (currentSpell.getName().equals("Cloudkill") && target.getHitDice() > 6) {
				currentSpell.setDamageLow(0);
				currentSpell.setDamageHigh(0);
			}

			if (currentSpell.getName().equals("Power Word, Kill") && target.getHitPoints() > 60) {
				currentSpell.setDamageLow(0);
				currentSpell.setDamageHigh(0);
			}
			
			if (currentSpell.getDamageLow() + currentSpell.getDamageHigh() > highestDamageSpell.getDamageLow() + highestDamageSpell.getDamageHigh()) {
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
			if (currentSpell.getHealHigh() > highestHealingSpell.getHealHigh() && currentSpell.getDamageHigh() == 0) {
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
		int saveModifier = 0;
		Spell spell = SpellEncyclopedia.getSpell(type);

		if (spell.getHealHigh() + spell.getHealBonus() > 0) {			
			healOrDamage = new Random().nextInt(spell.getHealHigh() - spell.getHealLow() + 1) + spell.getHealLow() + spell.getHealBonus();
			target.updateHitPoints(healOrDamage);
			if (spell.getDamageHigh() + spell.getDamageBonus() > 0) {				
				healOrDamage = new Random().nextInt(spell.getDamageHigh() - spell.getDamageLow() + 1) + spell.getDamageLow() + spell.getDamageBonus();
				target.updateHitPoints(-healOrDamage);
				healOrDamage = target.getMaxHitPoints() - healOrDamage;
			}
		} else if (spell.getDamageHigh() + spell.getDamageBonus() > 0) {
			if (spell.getName().equals("Cloudkill")) {
				if (target.getHitDice() < 4) {
					saveModifier = -Integer.MAX_VALUE;
				} else if (target.getHitDice() > 3 && target.getHitDice() < 6) {
					saveModifier = -4;
				} else if (target.getHitDice() == 6) {
					saveModifier = 0;
				} else if (target.getHitDice() > 6) {
					saveModifier = Integer.MAX_VALUE;
				}
			}
			
			if (this.isSaved(target, spell.getSavingThrow(), saveModifier)) {
				if (spell.getName().equals("Cloudkill")) {					
				} else {
					healOrDamage = new Random().nextInt(Math.round(spell.getDamageHigh()/2) - Math.round(spell.getDamageLow()/2) + 1) + Math.round(spell.getDamageLow()/2) + Math.round(spell.getDamageBonus()/2);
					target.updateHitPoints(-healOrDamage);
				}
			} else {
				healOrDamage = new Random().nextInt((spell.getDamageHigh()) - spell.getDamageLow() + 1) + spell.getDamageLow() + spell.getDamageBonus();
				target.updateHitPoints(-healOrDamage);
			}
		}
		
		//spellBook.remove(spell);
		
		return healOrDamage;
	}
	
	public void removeSpell(String spell) {
		this.spellBook.remove(spell);
	}

	private boolean isSaved(MobileObject target, SavingThrow savingThrow, int modifier) {
		return SavingThrow.checkSavingThrow(target, savingThrow, modifier);
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
}
