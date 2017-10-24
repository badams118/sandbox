package dnd;

public class Driver {

	public static void main(String[] args) {
		//boolean x = SavingThrow.checkSavingThrow(CharacterClass.ASSASSIN, 5, SavingThrow.DEATH_MAGIC);
		//System.out.println(x);
		
		//Character joe = new Character("Joe", Race.HUMAN, CharacterClass.FIGHTER);
		//System.out.println(joe.toString());

		Merchantile merchant = new Merchantile();
		Weapon weapon = merchant.buyWeapon("sword");
		for (int i = 1; i <= 30; i++) {
		  System.out.print(Integer.toString(weapon.calculateDamage()) + " ");
		}
		
	}
}
