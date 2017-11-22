package dnd;

import java.io.Serializable;

public class Shield implements Serializable {
	private static final long serialVersionUID = -8209938835680668343L;
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
