package dnd;

public class Driver {

	public static void main(String[] args) {
		//boolean x = SavingThrow.checkSavingThrow(CharacterClass.ASSASSIN, 5, SavingThrow.DEATH_MAGIC);
		//System.out.println(x);
		
		Character joe = new Character("Joe", Race.HUMAN, CharacterClass.FIGHTER);
		joe.buyWeapon("Long Sword");
		//System.out.println(joe.toString());
		
		for (int i = 1; i <= 30; i++) {
		  joe.strikeMelee(new Object());;
		}
		
	}
}
