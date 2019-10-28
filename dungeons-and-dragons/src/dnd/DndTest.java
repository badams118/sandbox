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
//		Monster(String type, int armorClass, int hitDice, int hitPoints, int damageLow, int damageHigh)
//		Monster troglodyte01 = new Monster("troglodyte 01", 5, 2, 9, 1, 6);
//		Monster troglodyte02 = new Monster("troglodyte 02", 5, 2, 9, 1, 6);
//		Monster troglodyte03 = new Monster("troglodyte 03", 5, 2, 9, 1, 6);
//		
//		Encounter encounter = new Encounter(troglodyte01, troglodyte02, troglodyte03);
		
		Monster giantFrog01 = new Monster("giant frog 01", 7, 2, 13, 1, 6);
		Monster giantFrog02 = new Monster("giant frog 02", 7, 2, 10, 1, 6);
		Monster giantFrog03 = new Monster("giant frog 03", 7, 1, 7, 1, 3);
		Monster giantFrog04 = new Monster("giant frog 04", 7, 1, 6, 1, 3);
		Monster giantFrog05 = new Monster("giant frog 05", 7, 1, 4, 1, 3);
		Monster giantFrog06 = new Monster("giant frog 06", 7, 1, 4, 1, 3);

		Encounter encounter = new Encounter(giantFrog01, giantFrog02, giantFrog03, giantFrog04, giantFrog05, giantFrog06);
		
		Character joeTest = new Character("Joe_Test", Race.HUMAN, MobileObjectClass.FIGHTER);
		joeTest.buyWeapon("Sword, Bastard");
		joeTest.buyArmor("Chain");
		
		Character danTest = new Character("Dan_Test", Race.HALF_ELF, MobileObjectClass.RANGER);
		danTest.buyWeapon("Sword");
		danTest.buyArmor("Chain");
		danTest.buyShield("Shield");
		
		Character stanTest = new Character("Stan_Test", Race.HUMAN, MobileObjectClass.MAGIC_USER);
		stanTest.buyWeapon("Dagger");
		stanTest.memorizeSpell("Magic Missile");
		Assert.assertTrue(stanTest.hasSpell("Magic Missile"));
		
		Character harryTest = new Character("Harry_Test", Race.HUMAN, MobileObjectClass.PALADIN);
		harryTest.buyWeapon("Sword, Bastard");
		harryTest.buyArmor("Chain");
		stanTest.memorizeSpell("Lay On Hands");
		
		Character larryTest = new Character("Larry_Test", Race.HUMAN, MobileObjectClass.CLERIC);
		larryTest.buyWeapon("Flail");
		larryTest.buyArmor("Chain");
		larryTest.buyShield("Shield");
		larryTest.memorizeSpell("Cure Light Wounds");
		Assert.assertTrue(larryTest.hasSpell("Cure Light Wounds"));

		Character otisTest = new Character("Otis_Test", Race.HALFLING, MobileObjectClass.THIEF);
		otisTest.buyWeapon("Sword");
		otisTest.buyArmor("Leather");
		
		Character davidTest = new Character("David_Test", Race.HUMAN, MobileObjectClass.ASSASSIN);
		davidTest.buyWeapon("Sword");
		davidTest.buyArmor("Leather");

		Character ernieTest = new Character("Ernie_Test", Race.HALF_ELF, MobileObjectClass.BARD);
		ernieTest.buyWeapon("Sword, Bastard");
		ernieTest.buyArmor("Chain");
			
		Party party = new Party(joeTest, danTest, stanTest, harryTest, larryTest, otisTest, davidTest, ernieTest);
		
		party.updateCharacters(CombatEngine.doCombat(encounter, party));
	}
}