package dnd;

public class Shield {
	private String type;
	private float cost;

	public Shield(String type, float cost) {
		this.type = type;
		this.cost = cost;
	}

	public String getType() {
		return this.type;
	}
	
	public float getCost() {
		return this.cost;
	}

	public boolean equals(Object object) {
		boolean isEquals = false;
		Shield shield = (Shield) object;
		
		if (type.equals(shield.getType())) {
			isEquals = true;
		} 
		
		return isEquals;
	}
}
