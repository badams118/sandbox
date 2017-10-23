package dnd;

public class Driver {

	public static void main(String[] args) {
		//boolean x = SavingThrow.checkSavingThrow(CharacterClass.ASSASSIN, 5, SavingThrow.DEATH_MAGIC);
		//System.out.println(x);
		
		Character joe = new Character("Joe", Race.HUMAN, CharacterClass.FIGHTER);
		System.out.println(joe.toString());
		
	}
}
