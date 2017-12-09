package dnd;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Random;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DndTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		new Merchantile();
		new SpellEncyclopedia();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCharacterCreation() {
        FileOutputStream file;
        ObjectOutputStream out;
		
		Character joeTest = new Character("Joe_Test", Race.HUMAN, CharacterClass.FIGHTER);
		joeTest.buyWeapon("Sword, long");
		joeTest.buyArmor("Chain");
		joeTest.buyShield("Shield, small, wooden");

        try {   
            file = new FileOutputStream("tmp/" + joeTest.getName().toLowerCase() + ".ser");
            out = new ObjectOutputStream(file);
             
            out.writeObject(joeTest);
             
            out.close();
            file.close();
            
            System.out.println(joeTest.getName() + " has been serialized.");
        } catch(IOException e) {
			e.printStackTrace();
			Assert.fail("IOException");
        }
        
		Character stanTest = new Character("Stan_Test", Race.HUMAN, CharacterClass.MAGIC_USER);
		joeTest.buyWeapon("Dagger");
		joeTest.memorizeSpell("magic missile");

        try {   
            file = new FileOutputStream("tmp/" + stanTest.getName().toLowerCase() + ".ser");
            out = new ObjectOutputStream(file);
             
            out.writeObject(stanTest);
             
            out.close();
            file.close();
            
            System.out.println(stanTest.getName() + " has been serialized.");
        } catch(IOException e) {
			e.printStackTrace();
			Assert.fail("IOException");
        }
	}

	@Test
	void testCombat() { // TODO need to sub in Stan to test spell combat
		Character joeTest = null;
		Monster skeleton = new Monster("skeleton", 7, 1, 1, 6);
		
		try {
			FileInputStream fileIn = new FileInputStream("tmp/joe_test.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			joeTest = (Character) in.readObject();
			in.close();
			fileIn.close();            
			System.out.println(joeTest.getName() + " has been deserialized.\n");
		} catch (IOException i) {
			i.printStackTrace();
			Assert.fail("IOException");
			return;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			Assert.fail("ClassNotFoundException");
			return;
		}

		if (new Random().nextBoolean()) {
			joeTest.combatAction("melee", skeleton);
			System.out.println(skeleton.getType() + " hit points: " + Integer.toString(skeleton.getHitPoints()) + "\n");
		}
		while (true) {	
			if (skeleton.getHitPoints() <= 0) {
				System.out.println(skeleton.getType() + " has died.\n");
				joeTest.addExperience(skeleton.getExperience());
				break;
			}
			
			System.out.println(skeleton.getType() + " strikes " + joeTest.getName() + " for " + 
					Integer.toString(skeleton.strikeMelee(joeTest)) + " damage.");
			System.out.println(joeTest.getName() + " hit points: " + Integer.toString(joeTest.getHitPoints()) + "\n");
			if (joeTest.getHitPoints() <= 0 || skeleton.getHitPoints() <= 0) {
				System.out.println(joeTest.getName() + " has died.\n");
				break;
			}

			joeTest.combatAction("melee", skeleton);
			System.out.println(skeleton.getType() + " hit points: " + Integer.toString(skeleton.getHitPoints()) + "\n");
		}
	}
}
