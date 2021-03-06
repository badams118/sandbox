package dnd;

import java.io.Serializable;

public class Weapon implements Serializable {
	private static final long serialVersionUID = 2010415718746392761L;
	
	private String type;
	private double cost;
	private int damageLowVsSmallMedium;
	private int damageHighVsSmallMedium;
	private int damageLowVsLarge;
	private int damageHighVsLarge;
	private int damageBonus;

	public Weapon(String type, double cost, int damageLowVsSmallMedium, int damageHighVsSmallMedium, int damageLowVsLarge, int damageHighVsLarge) {
		this(type, cost, damageLowVsSmallMedium, damageHighVsSmallMedium, damageLowVsLarge, damageHighVsLarge, 0);
	}
	
	public Weapon(String type, double cost, int damageLowVsSmallMedium, int damageHighVsSmallMedium, int damageLowVsLarge, int damageHighVsLarge,
			int damageBonus) {
		this.type = type;
		this.cost = cost;
		this.damageLowVsSmallMedium = damageLowVsSmallMedium;
		this.damageHighVsSmallMedium = damageHighVsSmallMedium;
		this.damageLowVsLarge = damageLowVsLarge;
		this.damageHighVsLarge = damageHighVsLarge;
		this.damageBonus = damageBonus;
	}

	public int getDamageLow() {
		return this.damageLowVsSmallMedium;
	}
	
	public int getDamageHigh() {
		return this.damageLowVsSmallMedium;
	}

	public int getDamageLow(TargetSize targetSize) {
		int damage;
		
		if (targetSize == TargetSize.LARGE) {
			damage = this.damageLowVsLarge;
		} else {
			damage = this.damageLowVsSmallMedium;
		}
		
		return damage;
	}
	
	public int getDamageHigh(TargetSize targetSize) {
		int damage;
		
		if (targetSize == TargetSize.LARGE) {
			damage = this.damageHighVsLarge;
		} else {
			damage = this.damageHighVsSmallMedium;
		}
		
		return damage;
	}
	
	public int getDamageBonus() {
		return this.damageBonus;
	}
	
	public String getType() {
		return type;
	}
	
	public double getCost() {
		return cost;
	}
	
	public String toString() {
		String weaponToString;
		
		weaponToString = "Weapon type: " + getType() + "\n";
		weaponToString += "Weapon cost: " + Double.toString(getCost()) + "\n";
		weaponToString += "Weapon damage vs small/medium low: " + Integer.toString(getDamageLow(TargetSize.MEDIUM)) + "\n";
		weaponToString += "Weapon damage vs small/medium high: " + Integer.toString(getDamageHigh(TargetSize.MEDIUM)) + "\n";
		weaponToString += "Weapon damage vs large low: " + Integer.toString(getDamageLow(TargetSize.LARGE)) + "\n";
		weaponToString += "Weapon damage vs large high: " + Integer.toString(getDamageHigh(TargetSize.LARGE)) + "\n";
		weaponToString += "Weapon damage bonus: " + Integer.toString(getDamageBonus()) + "\n";		
		
		return weaponToString;
	}
	
	public boolean equals(Object object) {
		boolean isEquals = false;
		Weapon weapon = (Weapon) object;
		
		if (type.equals(weapon.getType())) {
			isEquals = true;
		} 
		
		return isEquals;
	}
}