package dnd;

import java.io.Serializable;

public class Character extends MobileObject implements Serializable {
	private static final long serialVersionUID = -5878197738378533947L;
	private String name;
	private Race race;
	private float goldPieces;
	private Weapon weapon;
	private Armor armor;
	private Shield shield;

	public Character() {
		super();
	}
	
	public Character(String name, Race race, MobileObjectClass characterClass) {
		this(name, race, characterClass, 1);
	}
	
	public Character(String name, Race race, MobileObjectClass characterClass, int level) {
		int hitPoints = MobileObjectClass.getHitPoints(characterClass, level);
		
		super.setArmorClass(10);
		super.setHitPoints(hitPoints);
		super.setMaxHitPoints(hitPoints);
		super.setCharacterClass(characterClass);
		super.setLevel(level);
		super.populateHitMatrix(characterClass, level);
		this.name = name;
		this.race = race;
		this.setSize(TargetSize.MEDIUM);
		this.goldPieces = Money.setMoney(characterClass);
		setExperience(characterClass, level);
	}
		
	public String getName() {
		return this.name;
	}
	
	public String getRace() {
		return this.race.toString();
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
	
	public Armor getArmor() {
		return this.armor;
	}
	
	public Shield getShield() {
		return this.shield;
	}
	
	public int getExperience() {
		return this.experience;
	}
	
	public void addExperience(int experience) {
		this.experience += experience;
	}
	
	private void setExperience(MobileObjectClass characterClass, int level) {
		this.experience = 0;
	}
	
	public float getGoldPieces() {
		return this.goldPieces;
	}
	
	public void buyWeapon(String type) {
		if (this.getMobileObjectClass() == MobileObjectClass.CLERIC &&
				!(type.toLowerCase().contains("club") ||
						type.toLowerCase().contains("flail") ||
						type.toLowerCase().contains("hammer") ||
						type.toLowerCase().contains("mace") ||
						type.toLowerCase().contains("staff"))) {
			System.out.println("The " + this.getMobileObjectClass().toString().toLowerCase() + " class cannot use this weapon.");
			return;
		}
		
		if (this.getMobileObjectClass() == MobileObjectClass.DRUID &&
				!(type.toLowerCase().contains("club") ||
						type.toLowerCase().contains("dagger") ||
						type.toLowerCase().contains("dart") ||
						type.toLowerCase().contains("hammer") ||
						type.toLowerCase().contains("scimitar") ||
						type.toLowerCase().contains("sling") ||
						type.toLowerCase().contains("spear") ||
						type.toLowerCase().contains("staff"))) {
			System.out.println("The " + this.getMobileObjectClass().toString().toLowerCase() + " class cannot use this weapon.");
			return;
		}
		
		if ((this.getMobileObjectClass() == MobileObjectClass.MAGIC_USER ||
				this.getMobileObjectClass() == MobileObjectClass.ILLUSIONIST) &&
				!(type.toLowerCase().contains("dagger") ||
						type.toLowerCase().contains("dart") ||
						type.toLowerCase().contains("staff"))) {
			System.out.println("The " + this.getMobileObjectClass().toString().toLowerCase() + " class cannot use this weapon.");
			return;
		}
		
		if (this.getMobileObjectClass() == MobileObjectClass.THIEF) {
			if (!(type.toLowerCase().contains("club") ||
					type.toLowerCase().contains("dagger") ||
					type.toLowerCase().contains("dart") ||
					type.toLowerCase().contains("sling") ||
					type.toLowerCase().contains("sword"))) {
				System.out.println("The " + this.getMobileObjectClass().toString().toLowerCase() + " class cannot use this weapon.");
				return;
			}			
			if (type.toLowerCase().contains("sword") &&
					(type.toLowerCase().contains("bastard") ||
							type.toLowerCase().contains("two-handed"))) {
				System.out.println("The " + this.getMobileObjectClass().toString().toLowerCase() + " class cannot use this weapon.");
				return;
			}
		}
		
		Weapon weapon = Merchantile.getWeapon(type);
		
		if (this.goldPieces >= weapon.getCost()) {
			this.weapon = weapon;
			this.goldPieces -= weapon.getCost();
		} else {
			System.out.println(this.name + " does not have enough gold to buy a(n) " + type);
		}
	}
	
	public boolean hasWeapon() {
		boolean result = false;
		
		if (this.weapon != null) {
			result = true;
		}
		
		return result;
	}
	
	public void buyArmor(String type) {
		if (this.getMobileObjectClass() == MobileObjectClass.MAGIC_USER || this.getMobileObjectClass() == MobileObjectClass.ILLUSIONIST) {
			System.out.println("The " + this.getMobileObjectClass().toString().toLowerCase() + " class cannot wear armor.");
			return;
		}
		
		if ((this.getMobileObjectClass() == MobileObjectClass.DRUID ||
				this.getMobileObjectClass() == MobileObjectClass.THIEF ||
				this.getMobileObjectClass() == MobileObjectClass.ASSASSIN) &&
				!type.toLowerCase().contains("leather")) {
			System.out.println("The " + this.getMobileObjectClass().toString().toLowerCase() + " class cannot wear this armor.");
			return;
		}
		
		Armor armor = Merchantile.getArmor(type);
		if (this.goldPieces >= armor.getCost()) {
			this.armor = armor;
			setArmorClass(armor.getArmorClass());
			this.goldPieces -= armor.getCost();
		} else {
			System.out.println(this.name + " does not have enough gold to buy " + type);
		}
	}

	public void buyShield(String type) {
		if (this.getMobileObjectClass() == MobileObjectClass.MAGIC_USER || 
				this.getMobileObjectClass() == MobileObjectClass.ILLUSIONIST || 
				this.getMobileObjectClass() == MobileObjectClass.THIEF) {
			System.out.println("The " + this.getMobileObjectClass().toString().toLowerCase() + " class cannot use a shield.");
			return;
		}

		if (this.getMobileObjectClass() == MobileObjectClass.DRUID && !type.toLowerCase().contains("wooden")) {
			System.out.println("The " + this.getMobileObjectClass().toString().toLowerCase() + " class cannot use this shield.");
			return;
		}
		
		Shield shield = Merchantile.getShield(type);
		
		if (this.goldPieces >= shield.getCost()) {
			if (this.shield == null) {
				setArmorClass(this.getArmorClass() - 1);
			}
			this.shield = shield;
			this.goldPieces -= shield.getCost();
		} else {
			System.out.println(this.name + " does not have enough gold to buy " + type);
		}
	}

	public void combatAction(MobileObject attackTarget, MobileObject healTarget) {
		Spell healSpell = this.getHighestHealingSpell();
		Spell attackSpell = this.getHighestDamageSpell();
				
		if (healSpell != null && healTarget != null && healTarget.getDamage() > 0) {
			this.combatAction("cast " + this.getHighestHealingSpell(), healTarget);
		} else if (attackSpell != null && attackTarget != null) {
			this.combatAction("cast " + this.getHighestDamageSpell(), attackTarget);
		} else {
			this.combatAction("melee", attackTarget);
		}		
	}
	
	public void combatAction(String action, MobileObject target) {
		String spellName;
		Spell spell;
		String targetName = "";
		int damage;
		
		if (target instanceof Monster) {
			Monster monster = (Monster) target;
			targetName = monster.getType();
		} else if (target instanceof Character) {
			Character character = (Character) target;
			targetName = character.getName();
		}
		
		if (action.toLowerCase().contains("cast")) {
			spellName = action.substring(5);
			spell = SpellEncyclopedia.getSpell(spellName);
			
			if (this.hasSpell(spellName)) {
				if (spell.getHealHigh() > 0) {
					System.out.println(this.getName() + " casts " + spellName + " on " + targetName + " for " +
							Integer.toString(super.castSpell(spellName, target)) + " healing.");
				} else {
					System.out.println(this.getName() + " casts " + spellName + " on " + targetName + " for " +
							Integer.toString(super.castSpell(spellName, target)) + " damage.");
				}
				removeSpell(spellName);
			} else {
				System.out.println(this.getName() + " does not have this spell memorized.");
			}
			
		} else if (action.toLowerCase().contains("melee") || action.isEmpty()) {
			if (this.hasWeapon()) {
				damage = super.strikeMelee(target, 
							this.weapon.getDamageLow(target.getSize()), this.weapon.getDamageHigh(target.getSize()), 
							this.weapon.getDamageBonus());
				if (damage == 0) {
					System.out.println(this.getName() + " misses!");
				} else {
					System.out.println(this.getName() + " strikes " + targetName + " for " + 
							Integer.toString(damage) + " damage.");
				}
			} else {
				System.out.println(this.getName() + " has no weapon!");
			}
		}
	}
	
	public String toString() {
		String characterToString;
		
		characterToString = "Character name: " + getName() + "\n";
		characterToString += "Race: " + getRace() + "\n";
		characterToString += "Class: " + getMobileObjectClass().toString() + "\n";
		characterToString += "Level: " + Integer.toString(getLevel()) + "\n";
		characterToString += "Armor class: " + Integer.toString(getArmorClass()) + "\n";
		characterToString += "Hit Points: " + Integer.toString(getHitPoints()) + "\n";
		if (this.hasWeapon()) {
			characterToString += "Damage: " + Integer.toString(this.weapon.getDamageLow(TargetSize.MEDIUM)) + 
									"-" + Integer.toString(this.weapon.getDamageHigh(TargetSize.MEDIUM));
			if (this.weapon.getDamageBonus() > 0) {
				characterToString += "+" + Integer.toString(this.weapon.getDamageBonus());
			}
			characterToString += "\n";
		}		
		characterToString += "Experience: " + Integer.toString(getExperience()) + "\n";
		characterToString += "Money: " + Float.toString(getGoldPieces()) + "\n";
		
		return characterToString;
	}
}