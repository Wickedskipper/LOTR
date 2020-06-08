package uk.co.reosh.lotr.Commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Vector;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import uk.co.reosh.lotr.LoTR;

public class CommandHandler implements CommandExecutor
{
    @SuppressWarnings("unused")
	private Plugin plugin;
    private HashMap<String, SubCommand> commands;
    
    public CommandHandler(Plugin plugin)
    {
        this.plugin = plugin;
        commands = new HashMap<String, SubCommand>();
        loadCommands();
    }

    private void loadCommands()
    {
        //commands.put("createarena", new CreateArena());
    	commands.put("setchest", new CMD_SetChest());
    	commands.put("restock", new CMD_RestockChests());
    }

    public boolean onCommand(CommandSender sender, Command cmd1, String commandLabel, String[] args){
        String cmd = cmd1.getName();

        Player player = null;
        if (sender instanceof Player) {
            player = (Player) sender;
        }
        
        if(cmd.equalsIgnoreCase("lotr")){ 
            if(args == null || args.length < 1){
                player.sendMessage(ChatColor.AQUA +""+ ChatColor.BOLD +"Lord of The Rings");
                player.sendMessage(ChatColor.WHITE +"Type /lotr help for help" );

                return true;
            }
            if(args[0].equalsIgnoreCase("help")){
                help(player);
                return true;
            }
            String sub = args[0];

            Vector<String> l  = new Vector<String>();
            l.addAll(Arrays.asList(args));
            l.remove(0);
            args = (String[]) l.toArray(new String[0]);
            try{
            commands.get(sub).onCommand(player, args);
            }catch(NullPointerException ne){
            	LoTR.sendMsg(player, "Command not found! " + ChatColor.BOLD + "Try /lotr help");
            }catch(Exception e){e.printStackTrace(); player.sendMessage(ChatColor.BLUE +"Type /lotr help for help" );
            }
            return true;
        }
        return false;
    }
    
    public void help(Player p){
        //p.sendMessage("/lotr <command> <args>");
        for(SubCommand v: commands.values()){
        	v.help(p);
        }
    }
}
