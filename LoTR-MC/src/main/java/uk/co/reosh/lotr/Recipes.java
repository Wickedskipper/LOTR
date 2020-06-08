package uk.co.reosh.lotr;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.ItemMeta;

public class Recipes {
	
	public static void initRecipes() {
		// Fire Staff recipe
		initFireStaff();
	    // Mana Potion recipe
	    initManaPotion();
	    // Lembas
	    initBreadLembas();
		// End
	}
	
	public static void initFireStaff(){
		ItemStack isFireStaff = new ItemStack(Material.INK_SACK, 1);
		isFireStaff.setDurability((short) 1);
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.AQUA + "4-5 Damage");
		lore.add(ChatColor.AQUA + "Mana cost: 5 MP");
		lore.add(ChatColor.WHITE + "Common Item");
		
		ItemMeta meta = isFireStaff.getItemMeta();
		meta.setLore(lore);
		meta.setDisplayName(ChatColor.WHITE + "Fire Staff");
		isFireStaff.setItemMeta(meta);
		
		ShapedRecipe rbw = new ShapedRecipe(isFireStaff);
	    rbw.shape("-B-", "-S-", "-S-");
	    rbw.setIngredient('B', Material.BLAZE_ROD);
	    rbw.setIngredient('S', Material.STICK);
	    Bukkit.getServer().addRecipe(rbw);
	}

	public static void initManaPotion(){
		ItemStack isManaPotion = new ItemStack(Material.INK_SACK, 1);
		isManaPotion.setDurability((short) 0);
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.AQUA + "+20 MP");
		
		ItemMeta meta = isManaPotion.getItemMeta();
		meta.setLore(lore);
		meta.setDisplayName(ChatColor.WHITE + "Mana Potion");
		isManaPotion.setItemMeta(meta);
		
		ShapelessRecipe rbw = new ShapelessRecipe(isManaPotion);
		rbw.addIngredient(Material.DIRT);
	    Bukkit.getServer().addRecipe(rbw);
	}
	
	public static void initBreadLembas(){
		ItemStack isBreadLembas = new ItemStack(Material.BREAD, 1);
		isBreadLembas.setDurability((short) 0);
		
		List<String> lore = new ArrayList<String>();
		lore.add("");
		lore.add(ChatColor.AQUA + "+10 HP");
		
		ItemMeta meta = isBreadLembas.getItemMeta();
		meta.setLore(lore);
		meta.setDisplayName(ChatColor.WHITE + "Lembas");
		isBreadLembas.setItemMeta(meta);
		
		ShapelessRecipe rbw = new ShapelessRecipe(isBreadLembas);
		rbw.addIngredient(Material.WHEAT);
		rbw.addIngredient(Material.WHEAT);
		rbw.addIngredient(Material.WHEAT);
	    Bukkit.getServer().addRecipe(rbw);
	}
}
