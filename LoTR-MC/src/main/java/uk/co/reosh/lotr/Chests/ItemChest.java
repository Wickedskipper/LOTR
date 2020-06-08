package uk.co.reosh.lotr.Chests;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import uk.co.reosh.lotr.LoTR;
import uk.co.reosh.lotr.SettingsManager;

public class ItemChest {
	public static ItemStack[] FoodList = { new ItemStack(Material.BREAD, 1), new ItemStack(Material.CAKE, 1), new ItemStack(Material.MUSHROOM_SOUP, 1), new ItemStack(Material.RED_MUSHROOM, 1), new ItemStack(Material.RED_MUSHROOM, 1), new ItemStack(Material.RED_MUSHROOM, 1), new ItemStack(Material.BROWN_MUSHROOM, 1), new ItemStack(Material.BROWN_MUSHROOM, 1), new ItemStack(Material.BROWN_MUSHROOM, 1), new ItemStack(Material.BOWL, 1), new ItemStack(Material.BOWL, 1), new ItemStack(Material.BOWL, 1), new ItemStack(Material.COCOA, 1), new ItemStack(Material.COCOA, 1), new ItemStack(Material.COCOA, 1), new ItemStack(Material.COCOA, 1), new ItemStack(Material.COCOA, 1), new ItemStack(Material.WHEAT, 1), new ItemStack(Material.WHEAT, 1), new ItemStack(Material.WHEAT, 1), new ItemStack(Material.WHEAT, 1), new ItemStack(Material.APPLE, 1), new ItemStack(Material.APPLE, 1), new ItemStack(Material.APPLE, 1), new ItemStack(Material.APPLE, 1), new ItemStack(Material.APPLE, 1), new ItemStack(Material.POTATO, 1) };
	public static ItemStack[] BasicMilList = { new ItemStack(Material.LEATHER_BOOTS, 1, (short) 65), new ItemStack(Material.LEATHER_LEGGINGS, 1, (short) 75), new ItemStack(Material.LEATHER_LEGGINGS, 1, (short) 75), new ItemStack(Material.LEATHER_LEGGINGS, 1, (short) 75), new ItemStack(Material.LEATHER_CHESTPLATE, 1, (short) 81), new ItemStack(Material.LEATHER_CHESTPLATE, 1, (short) 81), new ItemStack(Material.LEATHER_HELMET, 1, (short) 55), new ItemStack(Material.LEATHER_HELMET, 1, (short) 55), new ItemStack(Material.LEATHER_HELMET, 1, (short) 55), new ItemStack(Material.WOOD_SWORD, 1), new ItemStack(Material.WOOD_SWORD, 1, (short) 60), new ItemStack(Material.WOOD_SWORD, 1, (short) 60), new ItemStack(Material.WOOD_SWORD, 1, (short) 60), new ItemStack(Material.WOOD_SWORD, 1, (short) 60), new ItemStack(Material.STONE_SWORD, 1, (short) 132) };
	public static ItemStack[] NormalMilList = { new ItemStack(Material.CHAINMAIL_BOOTS, 1, (short) 195), new ItemStack(Material.CHAINMAIL_BOOTS, 1, (short) 195), new ItemStack(Material.CHAINMAIL_LEGGINGS, 1, (short) 225), new ItemStack(Material.CHAINMAIL_LEGGINGS, 1, (short) 225), new ItemStack(Material.CHAINMAIL_LEGGINGS, 1, (short) 225), new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1, (short) 241), new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1, (short) 241), new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1, (short) 241), new ItemStack(Material.CHAINMAIL_CHESTPLATE, 1, (short) 241), new ItemStack(Material.CHAINMAIL_HELMET, 1, (short) 165), new ItemStack(Material.STONE_SWORD, 1, (short) 132), new ItemStack(Material.STONE_SWORD, 1, (short) 132), new ItemStack(Material.STONE_SWORD, 1, (short) 132), new ItemStack(Material.STONE_SWORD, 1, (short) 132), new ItemStack(Material.STONE_SWORD, 1, (short) 132), new ItemStack(Material.IRON_SWORD, 1, (short) 251), new ItemStack(Material.IRON_SWORD, 1, (short) 251) };
	public static ItemStack[] RareMilList = { new ItemStack(Material.IRON_BOOTS, 1, (short) 195), new ItemStack(Material.IRON_LEGGINGS, 1, (short) 225), new ItemStack(Material.IRON_CHESTPLATE, 1, (short) 241), new ItemStack(Material.IRON_HELMET, 1, (short) 165), new ItemStack(Material.STONE_SWORD, 1, (short) 132), new ItemStack(Material.IRON_SWORD, 1, (short) 251), new ItemStack(Material.IRON_SWORD, 1, (short) 251) };
	public enum Type {
		FOOD,
		BASICMILITARY,
		NORMALMILITARY,
		RAREMILITARY;
	}
	
	public static void FillChest(Chest chest, Type type){
		Random generator = new Random();
		Inventory chestinv = chest.getInventory();
		chestinv.clear();
		if(type == Type.FOOD){
			int items = generator.nextInt(4); // Number of max items from list in chest.
			for(int i = 0; i <= items; i++){
				chestinv.setItem(generator.nextInt(26), RandomFood()); // 26 is number of chest slots, don't change.
			}
		} else if (type == Type.BASICMILITARY){
			int items = generator.nextInt(3); // Number of max items from list in chest.
			for(int i = 0; i <= items; i++){
				chestinv.setItem(generator.nextInt(26), RandomBasicMill()); // 26 is number of chest slots, don't change.
			}
		} else if (type == Type.NORMALMILITARY){
			int items = generator.nextInt(3); // Number of max items from list in chest.
			for(int i = 0; i <= items; i++){
				chestinv.setItem(generator.nextInt(26), RandomNormalMill()); // 26 is number of chest slots, don't change.
			}
		} else if (type == Type.RAREMILITARY){
			int items = generator.nextInt(3); // Number of max items from list in chest.
			for(int i = 0; i <= items; i++){
				chestinv.setItem(generator.nextInt(26), RandomRareMill()); // 26 is number of chest slots, don't change.
			}
		}
	}
	
	public static void LoadChests(){
		try {
			for(String key : SettingsManager.getInstance().getChests().getConfigurationSection("chests").getKeys(false)){
				String name = key;
				int x = SettingsManager.getInstance().getChests().getInt("chests."+key+".x");
				int y = SettingsManager.getInstance().getChests().getInt("chests."+key+".y");
				int z = SettingsManager.getInstance().getChests().getInt("chests."+key+".z");
				String type = SettingsManager.getInstance().getChests().getString("chests."+key+".type");
				Location loc = new Location(Bukkit.getServer().getWorlds().get(0), x, y, z);
				
				LoTR.Chests.add(new LoTRChest(name, loc, StringToType(type)));
				System.out.println("Loaded chest '" + name + "'. Loc("+x+","+y+","+z+") [" + type + "]");
			}
		} catch (Exception ex) {
			System.out.println("Didn't load any chests (chests.yml doesn't exist?)");
		}
	}
	
	public static void RestockChests(){
		for(LoTRChest chest : LoTR.Chests){
			try {
				FillChest((Chest)chest.getLocation().getBlock().getState(), chest.getType());
			} catch (Exception ex) { chest.getLocation().getBlock().setType(Material.CHEST); FillChest((Chest)chest.getLocation().getBlock().getState(), chest.getType()); }
		}
	}
	
	// Random stuff
	public static ItemStack RandomFood(){
		Random generator = new Random();
		int i = generator.nextInt(FoodList.length);
		return FoodList[i];
	}
	public static ItemStack RandomBasicMill(){
		Random generator = new Random();
		int i = generator.nextInt(BasicMilList.length);
		ItemStack is = BasicMilList[i];
		int dur = generator.nextInt(is.getDurability() + 1);
		is.setDurability((short)dur);
		return is;
	}
	public static ItemStack RandomNormalMill(){
		Random generator = new Random();
		int i = generator.nextInt(NormalMilList.length);
		ItemStack is = NormalMilList[i];
		int dur = generator.nextInt(is.getDurability() + 1);
		is.setDurability((short)dur);
		return is;
	}
	public static ItemStack RandomRareMill(){
		Random generator = new Random();
		int i = generator.nextInt(RareMilList.length);
		ItemStack is = RareMilList[i];
		int dur = generator.nextInt(is.getDurability() + 1);
		is.setDurability((short)dur);
		return is;
	}
	// End of random
	
	public static String TypeToString(Type chesttype){
		if(chesttype == Type.FOOD){
			return "Food";
		} else if (chesttype == Type.BASICMILITARY) {
			return "BasicMil";
		} else if (chesttype == Type.NORMALMILITARY) {
			return "NormalMil";
		} else if (chesttype == Type.RAREMILITARY) {
			return "RareMil";
		} else {
			return "UNKNOWN";
		}
	}
	
	public static Type StringToType(String chesttype){
		if(chesttype.toLowerCase().equals("food")){
			return Type.FOOD;
		} else if (chesttype.toLowerCase().equals("basicmil")){
			return Type.BASICMILITARY;
		} else if (chesttype.toLowerCase().equals("normalmil")){
			return Type.NORMALMILITARY;
		} else if (chesttype.toLowerCase().equals("raremil")){
			return Type.RAREMILITARY;
		} else {
			return Type.FOOD;
		}
	}
}
