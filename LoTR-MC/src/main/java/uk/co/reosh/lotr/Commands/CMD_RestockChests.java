package uk.co.reosh.lotr.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import uk.co.reosh.lotr.LoTR;
import uk.co.reosh.lotr.Chests.ItemChest;

public class CMD_RestockChests implements SubCommand {
	
	private boolean adminOnly = true;
	private String permission = "lotr.admin.restockchests";
	
	public boolean onCommand(Player player, String[] args) {
		if(player.hasPermission(permission) || player.isOp()){
			ItemChest.RestockChests();
			LoTR.sendMsg(player, "Chests have been restocked!");
		}
        return false;
    }
	
    public void help(Player p) {
        String help = "/lotr restock - Restocks all chests.";
        if (adminOnly == true) {
        	if (p.hasPermission(permission) || p.isOp()) {
        		p.sendMessage(ChatColor.AQUA + help);
        	}
        } else {
        	p.sendMessage(ChatColor.AQUA + help);
        }
    }

}
