package dnd;

import java.util.Random;

public class Weapon {
	private String type;
	private float cost;
	private int damageLow;
	private int damageHigh;
	
	public Weapon(String type, float cost, int damageLow, int damageHigh) {
		this.type = type;
		this.cost = cost;
		this.damageLow = damageLow;
		this.damageHigh = damageHigh;
	}
	
	public int calculateDamage() {		
		int damage;
		
		damage = new Random().nextInt(damageHigh-damageLow + 1) + damageLow;
		
		return damage;
	}
	
	public String getType() {
		return type;
	}
	
	public boolean equals(Object weapon) {
		boolean isEquals = false;
		
		if (type.equals(this.type)) {
			isEquals = true;
		} 
		
		return isEquals;
	}
}
