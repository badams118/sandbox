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
	
	public Weapon(String type, float cost, int damageLowVsSmallMedium, int damageHighVsSmallMedium, int damageLowVsLarge, int damageHighVsLarge) {
		this.type = type;
		this.cost = cost;
		this.damageLowVsSmallMedium = damageLowVsSmallMedium;
		this.damageHighVsSmallMedium = damageHighVsSmallMedium;
		this.damageLowVsLarge = damageLowVsLarge;
		this.damageHighVsLarge = damageHighVsLarge;
	}
	
	public int calculateDamage() {
		return calculateDamage(TargetSize.MEDIUM);
	}
	
	public int calculateDamage(TargetSize targetSize) {		
		int damage;
		
		if (targetSize == TargetSize.SMALL || targetSize == TargetSize.MEDIUM) {
			damage = new Random().nextInt(damageHighVsSmallMedium - damageLowVsSmallMedium + 1) + damageLowVsSmallMedium;
		} else {
			damage = new Random().nextInt(damageHighVsLarge - damageLowVsLarge + 1) + damageLowVsLarge;
		}
		
		return damage;
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
