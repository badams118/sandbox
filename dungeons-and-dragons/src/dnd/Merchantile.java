package dnd;

import java.util.HashMap;

public class Merchantile {
	private static HashMap<String, Weapon> weapons;
	private static HashMap<String, Armor>  armor;
	private static HashMap<String, Shield> shields;
	
	public Merchantile() {
		weapons = new HashMap<String, Weapon>();
		armor   = new HashMap<String, Armor>();
		shields = new HashMap<String, Shield>();

		weapons.put("Arrow", new Weapon("Arrow", Money.toGold(2, Money.SILVER), 0, 0, 0, 0));
		weapons.put("Arrow, normal", new Weapon("Arrow, normal", Money.toGold(2, Money.SILVER), 0, 0, 0, 0));
		weapons.put("Arrow, silver", new Weapon("Arrow, silver", 1, 0, 0, 0, 0));
		weapons.put("Axe, battle", new Weapon("Axe, battle", 5, 1, 8, 1, 8));
		weapons.put("Axe, hand or throwing", new Weapon("Axe, hand or throwing", 1, 1, 6, 1, 4));
		weapons.put("Bardiche", new Weapon("Bardiche", 7, 2, 8, 3, 12));
		weapons.put("Bec de corbin", new Weapon("Bec de corbin", 6, 1, 8, 1, 6));
		weapons.put("Bill", new Weapon("Bill", 5, 2, 8, 1, 8));
		weapons.put("Bill-Guisarme", new Weapon("Bill-Guisarme", 6, 2, 8, 1, 10));
		weapons.put("Bill Hook", new Weapon("Bill Hook", 5, 2, 8, 1, 8));
		weapons.put("BlackRazor", new Weapon("Blackrazor", 0, 1, 8, 1, 12, 3));
		weapons.put("Bohemian Ear-Spoon", new Weapon("Bohemian Ear-Spoon", 10, 1, 6, 2, 7));
		weapons.put("Bolt, light", new Weapon("Bolt, light", Money.toGold(1, Money.SILVER), 0, 0, 0, 0));
		weapons.put("Bolt, heavy", new Weapon("Bolt, heavy", Money.toGold(2, Money.SILVER), 0, 0, 0, 0));
		weapons.put("Bow, composite, short", new Weapon("Bow, composite, short", 75, 1, 6, 1, 6));
		weapons.put("Bow, composite, long", new Weapon("Bow, composite, long", 100, 1, 6, 1, 6));
		weapons.put("Bow, short", new Weapon("Bow, short", 60, 1, 6, 1, 6));
		weapons.put("Bow, long", new Weapon("Bow, long", 15, 1, 6, 1, 6));
		weapons.put("Chauves Souris", new Weapon("Chauves Souris", 4, 2, 8, 2, 8));
		weapons.put("Crossbow, heavy", new Weapon("Crossbow, heavy", 20, 2, 5, 2, 7));
		weapons.put("Crossbow, light", new Weapon("Crossbow, light", 12, 1, 4, 1, 4));
		weapons.put("Club", new Weapon("Club", 0, 1, 6, 1, 3));
		weapons.put("Corseque", new Weapon("Corseque", 3, 2, 7, 2, 12));
		weapons.put("Couteaux de Breche", new Weapon("Couteaux de Breche", 6, 1, 6, 1, 10));
		weapons.put("Cutlass", new Weapon("Cutlass", 15, 1, 8, 1, 8));
		weapons.put("Dagger", new Weapon("Dagger", 2, 1, 4, 1, 3));
		weapons.put("Dart", new Weapon("Dart", Money.toGold(5, Money.SILVER), 1, 3, 1, 2));
		weapons.put("Fauchard", new Weapon("Fauchard", 3, 1, 6, 1, 8));
		weapons.put("Fauchard-Fork", new Weapon("Fauchard-Fork", 8, 1, 8, 1, 10));
		weapons.put("Flail, footman's", new Weapon("Flail, footman's", 3, 2, 7, 2, 8));
		weapons.put("Flail", new Weapon("Flail", 3, 2, 7, 2, 8));
		weapons.put("Flail, horseman's", new Weapon("Flail, hourseman's", 8, 2, 5, 2, 5));
		weapons.put("Fork, Military", new Weapon("Fork, Military", 4, 1, 8, 2, 8));
		weapons.put("Glaive", new Weapon("Glaive", 6, 1, 6, 1, 10));
		weapons.put("Glaive-Guisarme", new Weapon("Glaive-Guisarme", 10, 2, 8, 2, 12));
		weapons.put("Godentag", new Weapon("Godentag", 5, 2, 8, 2, 7));
		weapons.put("Guisarme", new Weapon("Guisarme", 5, 2, 8, 1, 8));
		weapons.put("Guisarme-Voulage", new Weapon("Guisarme-Voulage", 7, 2, 8, 2, 8));
		weapons.put("Halbert", new Weapon("Halbert", 9, 1, 10, 2, 12));
		weapons.put("Hammer, Lucern", new Weapon("Hammer, Lucern", 7, 2, 8, 1, 6));
		weapons.put("Hammer", new Weapon("Hammer", 1, 2, 5, 1, 4));
		weapons.put("Holy Water Sprinkler", new Weapon("Holy Water Sprinkler", 5, 2, 8, 2, 7));
		weapons.put("Javelin", new Weapon("Javelin", Money.toGold(10, Money.SILVER), 1, 6, 1, 6));
		weapons.put("Korseke", new Weapon("Korseke", 3, 2, 7, 2, 12));
		weapons.put("Lance (light horse)", new Weapon("Lance (light horse)", 6, 1, 6, 1, 8));
		weapons.put("Lance (medium horse)", new Weapon("Lance (medium horse)", 6, 2, 7, 2, 12));
		weapons.put("Lance (heavy horse)", new Weapon("Lance (heavy horse)", 6, 3, 9, 3, 18));
		weapons.put("Lochaber Axe", new Weapon("Lochaber Axe", 7, 2, 8, 2, 8));
		weapons.put("Mace, footman's", new Weapon("Mace, footman's", 8, 2, 7, 1, 6));
		weapons.put("Mace", new Weapon("Mace", 8, 2, 7, 1, 6));
		weapons.put("Mace, horseman's", new Weapon("Mace, horseman's", 4, 1, 6, 1, 4));
		weapons.put("Morning Star", new Weapon("Morning Star", 5, 2, 8, 2, 7));
		weapons.put("Partisan", new Weapon("Partisan", 10, 1, 6, 2, 7));
		weapons.put("Pick, Military, footman's", new Weapon("Pick, Military, footman's", 8, 2, 7, 2, 8));
		weapons.put("Pick, Military, horseman's", new Weapon("Pick, Military, horseman's", 5, 2, 5, 1, 4));
		weapons.put("Pike, Awl", new Weapon("Pike, Awl", 3, 1, 6, 1, 12));
		weapons.put("Quarrel, light", new Weapon("Quarrel, light", Money.toGold(1, Money.SILVER), 0, 0, 0, 0));
		weapons.put("Quarrel, heavy", new Weapon("Quarrel, heavy", Money.toGold(2, Money.SILVER), 0, 0, 0, 0));
		weapons.put("Ranseur", new Weapon("Ranseur", 4, 2, 8, 2, 8));
		weapons.put("Ransom", new Weapon("Ransom", 4, 2, 8, 2, 8));
		weapons.put("Rhonca", new Weapon("Rhonca", 4, 2, 8, 2, 8));
		weapons.put("Roncie", new Weapon("Roncie", 4, 2, 8, 2, 8));
		weapons.put("Runka", new Weapon("Runka", 4, 2, 8, 2, 8));
		weapons.put("Sabre", new Weapon("Sabre", 15, 1, 8, 1, 8));
		weapons.put("Scimitar", new Weapon("Scimitar", 15, 1, 8, 1, 8));
		weapons.put("Scorpion", new Weapon("Scorpion", 6, 2, 8, 1, 10));
		weapons.put("Sickle-sword", new Weapon("Sickle-sword", 15, 1, 8, 1, 8));
		weapons.put("Sling", new Weapon("Sling", Money.toGold(5, Money.SILVER), 2, 5, 2, 7));
		weapons.put("Sling bullet", new Weapon("Sling bullet", Money.toGold(5, Money.COPPER), 0, 0, 0, 0));
		//weapons.put("Sling stone", new Weapon("Sling stone", 0, 0, 0, 0, 0));
		weapons.put("Spear", new Weapon("Spear", 1, 1, 6, 1, 8));
		weapons.put("Septum", new Weapon("Septum", 3, 2, 7, 2, 12));
		weapons.put("Staff, Quarter", new Weapon("Staff, Quarter", 0, 1, 6, 1, 6));
		weapons.put("Sword", new Weapon("Sword", 15, 1, 8, 1, 12));
		weapons.put("Sword, Bastard", new Weapon("Sword, Bastard", 25, 2, 8, 2, 16));
		weapons.put("Sword, Broad", new Weapon("Sword, Broad", 10, 2, 8, 2, 7));
		weapons.put("Sword, Long", new Weapon("Sword, Long", 15, 1, 8, 1, 12));
		weapons.put("Sword, Short", new Weapon("Sword, Short", 8, 1, 6, 1, 8));
		weapons.put("Sword, Two-handed", new Weapon("Sword, Two-handed", 30, 1, 10, 3, 18));
		weapons.put("Trident", new Weapon("Trident", 4, 2, 7, 3, 12));
		weapons.put("Tulwar", new Weapon("Tulwar", 15, 1, 8, 1, 8));
		weapons.put("Voulage", new Weapon("Voulage", 2, 2, 8, 2, 8));

		armor.put("Banded", new Armor("Banded", 90, 4));
		armor.put("Chain", new Armor("Chain", 75, 5));
		armor.put("Leather", new Armor("Leather", 5, 8));
		armor.put("Padded", new Armor("Padded", 4, 8));		
		armor.put("Plate", new Armor("Plate", 400, 3));
		armor.put("Ring", new Armor("Ring", 30, 7));
		armor.put("Scale", new Armor("Scale", 45, 5));
		armor.put("Splinted", new Armor("Splinted", 80, 4));
		armor.put("Studded", new Armor("Studded", 15, 7));

		shields.put("Shield", new Shield("Shield", 1));
		shields.put("Shield, large", new Shield("Shield, large", 15));
		shields.put("Shield, small", new Shield("Shield, small", 10));
		shields.put("Shield, small, wooden", new Shield("Shield, small, wooden", 1));
	}
	
	public static Weapon getWeapon(String type) {
		return weapons.get(type);
	}
	
	public static Armor getArmor(String type) {
		return armor.get(type);
	}

	public static Shield getShield(String type) {
		return shields.get(type);
	}
}