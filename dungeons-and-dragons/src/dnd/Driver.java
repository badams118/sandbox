package dnd;

import java.util.Random;

public class Driver {

	public static void main(String[] args) {
		
		Character joe = new Character("Joe", Race.HUMAN, CharacterClass.ANTI_PALADIN);
		System.out.println(joe.toString());
		joe.buyWeapon("Sword, long, Unholy Reaver");
		joe.buyArmor("Chain");
		joe.buyShield("Shield, small, wooden");
		System.out.println(joe.toString());
		
		Monster skeleton = new Monster("skeleton", 7, 1, 0, 1, 6, CharacterClass.FIGHTER, 1, 12);
		System.out.println(skeleton.toString());
		
		if (new Random().nextBoolean()) {
			System.out.println(joe.getName() + " strikes " + skeleton.getType() + " for " + 
					Integer.toString(joe.strikeMelee(skeleton)) + " damage.");
			System.out.println(skeleton.getType() + " hit points: " + Integer.toString(skeleton.getHitPoints()) + "\n");
		}
		while (true) {	
			if (skeleton.getHitPoints() <= 0) {
				System.out.println(skeleton.getType() + " has died.");
				break;
			}
			
			System.out.println(skeleton.getType() + " strikes " + joe.getName() + " for " + 
					Integer.toString(skeleton.strikeMelee(joe)) + " damage.");
			System.out.println(joe.getName() + " hit points: " + Integer.toString(joe.getHitPoints()) + "\n");
			if (joe.getHitPoints() <= 0 || skeleton.getHitPoints() <= 0) {
				System.out.println(joe.getName() + " has died.");
				break;
			}
			
			System.out.println(joe.getName() + " strikes " + skeleton.getType() + " for " + 
					Integer.toString(joe.strikeMelee(skeleton)) + " damage.");
			System.out.println(skeleton.getType() + " hit points: " + Integer.toString(skeleton.getHitPoints()) + "\n");
		}
		
	}
}
