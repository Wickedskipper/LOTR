package uk.co.reosh.lotr.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;

import uk.co.reosh.lotr.LoTR;
import uk.co.reosh.lotr.SettingsManager;
import uk.co.reosh.lotr.Chests.ItemChest;
import uk.co.reosh.lotr.Chests.LoTRChest;

import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.Selection;

public class CMD_SetChest implements SubCommand {
	
	private boolean adminOnly = true;
	private String permission = "lotr.admin.setchest";
	
	public boolean onCommand(Player player, String[] args) {
		if(player.hasPermission(permission) || player.isOp()){
			if(args.length >= 2){
				WorldEditPlugin worldEdit = (WorldEditPlugin) Bukkit.getServer().getPluginManager().getPlugin("WorldEdit");
				Selection selection = worldEdit.getSelection(player);
				 
				if (selection != null) {
				    Location min = selection.getMinimumPoint();
				    if(min.getBlock().getType() == Material.CHEST){
				    	LoTRChest chest = new LoTRChest(args[0], min, ItemChest.StringToType(args[1]));
				    	LoTR.Chests.add(chest);
				    	SettingsManager.getInstance().addChest(args[0], min, ItemChest.StringToType(args[1]));
				    	ItemChest.FillChest((Chest)min.getBlock().getState(), ItemChest.StringToType(args[1]));
				    	LoTR.sendMsg(player, "Chest '" + args[0] + "' (" + args[1] + ") added successful!");
				    } else {
				    	LoTR.sendMsg(player, "Select single chest!");
				    }
				} else {
					LoTR.sendMsg(player, "Use WorldEdit to select chest (left then right click with wooden axe).");
				}
			} else {
				LoTR.sendMsg(player, "Use /lotr setchest [Chest Name] [Chest Type]");
			}
		}
        return false;
    }
	
	public void help(Player p) {
        String help = "/lotr setchest - Sets chest respawn point with current WorldEdit selection.";
        if (adminOnly == true) {
        	if (p.hasPermission(permission) || p.isOp()) {
        		p.sendMessage(ChatColor.AQUA + help);
        	}
        } else {
        	p.sendMessage(ChatColor.AQUA + help);
        }
    }

}
