package dnd;

import java.util.Random;

public class Weapon {
	public enum TargetSize {SMALL, MEDIUM, LARGE}
	
	private String type;
	private float cost;
	private int damageLowVsSmallMedium;
	private int damageHighVsSmallMedium;
	private int damageLowVsLarge;
	private int damageHighVsLarge;
	private int damageBonus;

	public Weapon(String type, float cost, int damageLowVsSmallMedium, int damageHighVsSmallMedium, int damageLowVsLarge, int damageHighVsLarge) {
		this(type, cost, damageLowVsSmallMedium, damageHighVsSmallMedium, damageLowVsLarge, damageHighVsLarge, 0);
	}
	
	public Weapon(String type, float cost, int damageLowVsSmallMedium, int damageHighVsSmallMedium, int damageLowVsLarge, int damageHighVsLarge,
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
	
	public float getCost() {
		return cost;
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
