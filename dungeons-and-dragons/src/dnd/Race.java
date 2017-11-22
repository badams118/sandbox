package dnd;

import java.io.Serializable;

public enum Race implements Serializable {
	DROW {
		public String toString() {
			return "Drow";
		}
	},
	DWARF {
		public String toString() {
			return "Dwarf";
		}
	},
	ELF {
		public String toString() {
			return "Elf";
		}
	},
	HALF_ELF {
		public String toString() {
			return "Half-Elf";
		}
	},
	GNOME {
		public String toString() {
			return "Gnome";
		}
	},
	HALFLING {
		public String toString() {
			return "Halfling";
		}
	},
	HALF_ORC {
		public String toString() {
			return "Half-Orc";
		}
	},
	HUMAN {
		public String toString() {
			return "Human";
		}
	};
}