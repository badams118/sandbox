package dnd;

public class Armor {
	private String type;
	private float cost;
	private int armorClass;
	
	public Armor(String type, float cost, int armorClass) {
		this.type = type;
		this.cost = cost;
		this.armorClass = armorClass;
	}
	
	public int getArmorClass() {
		return this.armorClass;
	}
	
	public boolean equals(Object armor) {
		boolean isEquals = false;
		
		if (type.equals(this.type)) {
			isEquals = true;
		} 
		
		return isEquals;
	}
}
