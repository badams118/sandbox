package dnd;

public class Driver {

	public static void main(String[] args) {
		
		Character joe = new Character("Joe", Race.HUMAN, CharacterClass.FIGHTER);
		System.out.println(joe.toString());
		joe.buyWeapon("Long Sword");
		joe.buyArmor("Chain");
		System.out.println("\n" + joe.toString());
		
		Monster skeleton = new Monster(7, 1, 0, 1, 6, CharacterClass.FIGHTER, 1, 12);
		System.out.println(skeleton.toString());
		
		for (int i = 1; i <= 30; i++) {
		  joe.strikeMelee(skeleton);
		}
		
	}
}
