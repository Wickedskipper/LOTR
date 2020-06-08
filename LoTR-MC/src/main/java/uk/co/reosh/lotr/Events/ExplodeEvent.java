package uk.co.reosh.lotr.Events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplodeEvent implements Listener {

	@EventHandler(priority=EventPriority.HIGHEST)
	public void onEntityExplode(EntityExplodeEvent event){
		event.setCancelled(true);
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onEntityDeath(EntityDeathEvent event){
		event.setDroppedExp(0);
	}
}
