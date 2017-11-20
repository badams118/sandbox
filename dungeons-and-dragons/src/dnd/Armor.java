package dnd;

public class Armor {
	private String type;
	private float cost;
	private int armorClass;

	public Armor(String type, float cost) {
		this.type = type;
		this.cost = cost;
	}
	
	public Armor(String type, float cost, int armorClass) {
		this(type, cost);
		this.armorClass = armorClass;
	}
	
	public String getType() {
		return this.type;
	}

	public float getCost() {
		return this.cost;
	}
	
	public int getArmorClass() {
		return this.armorClass;
	}
	
	public boolean equals(Object object) {
		boolean isEquals = false;
		Armor armor = (Armor) object;
		
		if (type.equals(armor.getType())) {
			isEquals = true;
		} 
		
		return isEquals;
	}
}
