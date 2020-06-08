package uk.co.reosh.lotr.Items;

import org.bukkit.event.player.PlayerInteractEvent;

public class BreadLembas {

	static float HealthValue = (float)5.0;
	
	public static void onUsed(PlayerInteractEvent event) { 
		if(event.getPlayer().getHealth() + HealthValue < 20) {
			event.getPlayer().setHealth(event.getPlayer().getHealth() + HealthValue);
			if(event.getItem().getAmount() > 1){
				event.getItem().setAmount(event.getItem().getAmount() - 1);
			} else {
				event.getPlayer().setItemInHand(null);
			}
		} else if(event.getPlayer().getHealth() != 20){
			event.getPlayer().setHealth(20);
			if(event.getItem().getAmount() > 1){
				event.getItem().setAmount(event.getItem().getAmount() - 1);
			} else {
				event.getPlayer().setItemInHand(null);
			}
		}
    }
}
