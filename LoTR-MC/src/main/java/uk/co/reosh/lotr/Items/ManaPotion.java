package uk.co.reosh.lotr.Items;

import org.bukkit.event.player.PlayerInteractEvent;

public class ManaPotion {

	static float ManaValue = (float) 0.2;
	
	public static void onUsed(PlayerInteractEvent event) { 
		if(event.getPlayer().getExp() + ManaValue < 1) {
			event.getPlayer().setExp(event.getPlayer().getExp() + ManaValue);
			if(event.getItem().getAmount() > 1){
				event.getItem().setAmount(event.getItem().getAmount() - 1);
			} else {
				event.getPlayer().setItemInHand(null);
			}
		} else if(event.getPlayer().getExp() != 1){
			event.getPlayer().setExp(1);
			if(event.getItem().getAmount() > 1){
				event.getItem().setAmount(event.getItem().getAmount() - 1);
			} else {
				event.getPlayer().setItemInHand(null);
			}
		}
    }
}
