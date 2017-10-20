package dnd;

public class Driver {

	public static void main(String[] args) {
			boolean x = SavingThrow.checkSavingThrow(CharacterClass.ASSASSIN, 5, SavingThrow.DEATH_MAGIC);
			System.out.println(x);
	}
}
