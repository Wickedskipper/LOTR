package uk.co.reosh.lotr.Commands;

import org.bukkit.entity.Player;

public interface SubCommand {
	
	public boolean adminOnly = false;

    public boolean onCommand(Player player, String[] args);

    public void help(Player p);
    
}
