package dnd;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Random;
import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		String action;
		
		new Merchantile();
		new SpellEncyclopedia();
		
		Scanner scanner = new Scanner(System.in);
		
		Character joe = new Character("Joe", Race.HUMAN, MobileObjectClass.MAGIC_USER);
		System.out.println(joe.toString());
//		joe.buyWeapon("Sword, long");
//		joe.buyArmor("Chain");
//		joe.buyShield("Shield, small, wooden");
		joe.buyWeapon("Dagger");
		joe.memorizeSpell("Magic Missile");
		
//		Character joe = null;
//		
//		try {
//			FileInputStream fileIn = new FileInputStream("tmp/joe.ser");
//			ObjectInputStream in = new ObjectInputStream(fileIn);
//			joe = (Character) in.readObject();
//			in.close();
//			fileIn.close();            
//			System.out.println(joe.getName() + " has been deserialized.\n");
//		} catch (IOException i) {
//			i.printStackTrace();
//			return;
//		} catch (ClassNotFoundException c) {
//			System.out.println("Character class not found.");
//			c.printStackTrace();
//			return;
//		}

		System.out.println(joe.toString());
		
		Monster skeleton = new Monster("skeleton", 7, 1, 1, 6);
		System.out.println(skeleton.toString());
		
		if (new Random().nextBoolean()) {
			System.out.print(joe.getName() + " action: ");
			action = scanner.nextLine();
			//System.out.println("you entered: '" + action + "'\n");
			joe.combatAction(action, skeleton);
			
//			if (joe.hasSpell("magic missile")) {
//				joe.combatAction("cast magic missile", skeleton);
//			} else {
//				joe.combatAction("melee", skeleton);
//			}
			System.out.println(skeleton.getType() + " hit points: " + Integer.toString(skeleton.getHitPoints()) + "\n");
		}
		while (true) {	
			if (skeleton.getHitPoints() <= 0) {
				System.out.println(skeleton.getType() + " has died.\n");
				joe.addExperience(skeleton.getExperience());
				break;
			}
			
			System.out.println(skeleton.getType() + " strikes " + joe.getName() + " for " + 
					Integer.toString(skeleton.strikeMelee(joe)) + " damage.");
			System.out.println(joe.getName() + " hit points: " + Integer.toString(joe.getHitPoints()) + "\n");
			if (joe.getHitPoints() <= 0 || skeleton.getHitPoints() <= 0) {
				System.out.println(joe.getName() + " has died.\n");
				break;
			}

			System.out.print(joe.getName() + " action: ");
			action = scanner.nextLine();
			//System.out.println("you entered: '" + action + "'\n");
			joe.combatAction(action, skeleton);

//			if (joe.hasSpell("Magic Missile")) {
//				joe.combatAction("cast magic missile", skeleton);
//			} else {
//				joe.combatAction("melee", skeleton);
//			}
			System.out.println(skeleton.getType() + " hit points: " + Integer.toString(skeleton.getHitPoints()) + "\n");
		}
		
		scanner.close();
		
		//System.out.println(joe.toString() + "\n");
		
        try {   
            FileOutputStream file = new FileOutputStream("tmp/" + joe.getName().toLowerCase() + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
             
            out.writeObject(joe);
             
            out.close();
            file.close();
             
            System.out.println(joe.getName() + " has been serialized.");
        } catch(IOException e) {
            System.out.println("IOException is caught.");
			e.printStackTrace();
        }
	}
}