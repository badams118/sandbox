package dnd;

import dnd.Weapon.TargetSize;

public class Driver {

	public static void main(String[] args) {
		//boolean x = SavingThrow.checkSavingThrow(CharacterClass.ASSASSIN, 5, SavingThrow.DEATH_MAGIC);
		//System.out.println(x);
		
		PlayerCharacter joe = new PlayerCharacter("Joe", Race.HUMAN, CharacterClass.FIGHTER);
		System.out.println(joe.toString());
		joe.buyWeapon("Long Sword");
		joe.buyArmor("Chain");
		System.out.println("\n" + joe.toString());
		
		for (int i = 1; i <= 30; i++) {
		  joe.strikeMelee(new Object());
		}
		
	}
}
