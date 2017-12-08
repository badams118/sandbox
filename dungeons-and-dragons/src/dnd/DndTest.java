package dnd;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

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
		Character joeTest = new Character("Joe Test", Race.HUMAN, CharacterClass.FIGHTER);
		joeTest.buyWeapon("Sword, long");
		joeTest.buyArmor("Chain");
		joeTest.buyShield("Shield, small, wooden");

		Character stanTest = new Character("Stan Test", Race.HUMAN, CharacterClass.MAGIC_USER);
		joeTest.buyWeapon("Dagger");
		joeTest.memorizeSpell("magic missile");
		
        try {   
            FileOutputStream file = new FileOutputStream("tmp/" + joeTest.getName().toLowerCase() + ".ser");
            ObjectOutputStream out = new ObjectOutputStream(file);
             
            out.writeObject(joeTest);
             
            out.close();
            file.close();
        } catch(IOException e) {
			e.printStackTrace();
			Assert.fail("IOException");
        }
	}

}
