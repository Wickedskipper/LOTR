package uk.co.reosh.lotr.Events;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import uk.co.reosh.lotr.Items.BreadLembas;
import uk.co.reosh.lotr.Items.FireStaff;
import uk.co.reosh.lotr.Items.ManaPotion;

public class CustomItemEvent implements Listener {
	
	@EventHandler(priority = EventPriority.HIGHEST)
    public void onInteract(PlayerInteractEvent event) { 
		try {
			if(event.getItem() != null){
				ItemStack useditem = event.getItem();
				String name = useditem.getItemMeta().getDisplayName();
				
				if(name.equals(ChatColor.WHITE + "Fire Staff")){
					FireStaff.onUsed(event);
				} else if(name.equals(ChatColor.WHITE + "Mana Potion")){
					ManaPotion.onUsed(event);
				} else if(name.equals(ChatColor.WHITE + "Lembas")){
					BreadLembas.onUsed(event);
				}
			}
		} catch (Exception ex) { }
    }

}
