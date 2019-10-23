package dnd;

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
		System.out.println("********************************************************************************");
		System.out.println("Begin character creation test");
		System.out.println("********************************************************************************\n");
        FileOutputStream file;
        ObjectOutputStream out;
		
		Character joeTest = new Character("Joe_Test", Race.HUMAN, MobileObjectClass.FIGHTER);
		joeTest.buyWeapon("Sword");
		Assert.assertEquals(joeTest.getWeapon().getType(), "Sword");
		joeTest.buyArmor("Chain");
		Assert.assertEquals(joeTest.getArmor().getType(), "Chain");
		joeTest.buyShield("Shield");
		Assert.assertEquals(joeTest.getShield().getType(), "Shield");

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
        
		Character stanTest = new Character("Stan_Test", Race.HUMAN, MobileObjectClass.MAGIC_USER);
		stanTest.buyWeapon("Dagger");
		stanTest.memorizeSpell("Magic Missile");
		Assert.assertTrue(stanTest.hasSpell("Magic Missile"));

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
        
        System.out.println();
	}

	@Test
	void testMeleeCombat() {
		System.out.println("********************************************************************************");
		System.out.println("Begin melee combat test");
		System.out.println("********************************************************************************\n");
		
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
		
		System.out.println(joeTest.toString());
		System.out.println(skeleton.toString());

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
	
	@Test
	void testSpellCombat() {
		System.out.println("********************************************************************************");
		System.out.println("Begin spell combat test");
		System.out.println("********************************************************************************\n");
		
		Character stanTest = null;
		Monster skeleton = new Monster("skeleton", 7, 1, 1, 6);
		
		try {
			FileInputStream fileIn = new FileInputStream("tmp/stan_test.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			stanTest = (Character) in.readObject();
			in.close();
			fileIn.close();            
			System.out.println(stanTest.getName() + " has been deserialized.\n");
		} catch (IOException i) {
			i.printStackTrace();
			Assert.fail("IOException");
			return;
		} catch (ClassNotFoundException c) {
			c.printStackTrace();
			Assert.fail("ClassNotFoundException");
			return;
		}	

		System.out.println(stanTest.toString());
		System.out.println(skeleton.toString());
		
		if (new Random().nextBoolean()) {
			if (stanTest.hasSpell("Magic Missile")) {
				stanTest.combatAction("cast Magic Missile", skeleton);
				Assert.assertFalse(stanTest.hasSpell("Magic Missile"));				
			} else {
				stanTest.combatAction("melee", skeleton);
			}
			System.out.println(skeleton.getType() + " hit points: " + Integer.toString(skeleton.getHitPoints()) + "\n");
		}
		while (true) {	
			if (skeleton.getHitPoints() <= 0) {
				System.out.println(skeleton.getType() + " has died.\n");
				stanTest.addExperience(skeleton.getExperience());
				break;
			}
			
			System.out.println(skeleton.getType() + " strikes " + stanTest.getName() + " for " + 
					Integer.toString(skeleton.strikeMelee(stanTest)) + " damage.");
			System.out.println(stanTest.getName() + " hit points: " + Integer.toString(stanTest.getHitPoints()) + "\n");
			if (stanTest.getHitPoints() <= 0 || skeleton.getHitPoints() <= 0) {
				System.out.println(stanTest.getName() + " has died.\n");
				break;
			}

			if (stanTest.hasSpell("Magic Missile")) {
				stanTest.combatAction("cast Magic Missile", skeleton);
				Assert.assertFalse(stanTest.hasSpell("Magic Missile"));	
			} else {
				stanTest.combatAction("melee", skeleton);
			}
			System.out.println(skeleton.getType() + " hit points: " + Integer.toString(skeleton.getHitPoints()) + "\n");
		}
	}
	
	@Test
	void testEncounter() {
		System.out.println("********************************************************************************");
		System.out.println("Begin encounter test");
		System.out.println("********************************************************************************\n");
		Monster skeleton01 = new Monster("skeleton 01", 7, 1, 1, 6);
		Monster skeleton02 = new Monster("skeleton 02", 7, 1, 1, 6);
		Monster skeleton03 = new Monster("skeleton 03", 7, 1, 1, 6);
		
		Encounter encounter = new Encounter(skeleton01, skeleton02, skeleton03);

		Character joeTest = new Character("Joe_Test", Race.HUMAN, MobileObjectClass.FIGHTER);
		joeTest.buyWeapon("Sword");
		Assert.assertEquals(joeTest.getWeapon().getType(), "Sword");
		joeTest.buyArmor("Chain");
		Assert.assertEquals(joeTest.getArmor().getType(), "Chain");
		joeTest.buyShield("Shield");
		Assert.assertEquals(joeTest.getShield().getType(), "Shield");
		
		Character stanTest = new Character("Stan_Test", Race.HUMAN, MobileObjectClass.MAGIC_USER);
		stanTest.buyWeapon("Dagger");
		stanTest.memorizeSpell("Magic Missile");
		Assert.assertTrue(stanTest.hasSpell("Magic Missile"));
		
		Character larryTest = new Character("Larry_Test", Race.DWARF, MobileObjectClass.CLERIC);
		larryTest.buyWeapon("Flail");
		larryTest.buyArmor("Chain");
		larryTest.buyShield("Shield");
			
		Party party = new Party(joeTest, stanTest, larryTest);
		
		party.updateCharacters(CombatEngine.doCombat(encounter, party));
	}
}