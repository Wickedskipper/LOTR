package uk.co.reosh.lotr;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import uk.co.reosh.lotr.DB.Database;
import uk.co.reosh.lotr.DB.MySQLAPI;
import uk.co.reosh.lotr.Events.ChestPunchEvent;
import uk.co.reosh.lotr.Events.CustomItemEvent;
import uk.co.reosh.lotr.Events.ExplodeEvent;
import uk.co.reosh.lotr.Chests.ItemChest;
import uk.co.reosh.lotr.Chests.LoTRChest;
import uk.co.reosh.lotr.Commands.CommandHandler;

public class LoTR extends JavaPlugin {
	Logger logger;
	LoTR p = this;
	public static List<LoTRChest> Chests = new ArrayList<LoTRChest>();
	
	public void onEnable() {
		logger = p.getLogger();
		PluginManager pm = getServer().getPluginManager();
		this.saveDefaultConfig();
		this.getConfig().options().copyDefaults(true);
		setCommands();
		Bukkit.getServer().clearRecipes();
		logger.fine("Cleared recipes.");
		Recipes.initRecipes();
		logger.fine("Loaded recipes.");
		SettingsManager.getInstance().setup(p);
		logger.fine("Loaded configs.");
		ItemChest.LoadChests();
		logger.info("[MySQL] Connecting to MySQL");
		Database.MySQL = new MySQLAPI(p);
		Database.MySQL.Connect(this.getConfig().getString("database.host"), this.getConfig().getString("database.port"), this.getConfig().getString("database.database"), this.getConfig().getString("database.user"), this.getConfig().getString("database.pass"));
		logger.info("[MySQL] Registered users: " + Database.MySQL.countEntries("users"));
		
		// Timer
		timer.schedule(twominTask, 1000*60, 1000*60*2); // Delay = 1 minute, interval = 2 minutes
		
		pm.registerEvents(new ExplodeEvent(), p);
		pm.registerEvents(new ChestPunchEvent(), p);
		pm.registerEvents(new CustomItemEvent(), p);
	}
	
	public void onDisable() {
		
	}
	
	public void setCommands(){
        getCommand("lotr").setExecutor(new CommandHandler(p));
    }
	
	public static void sendMsg(Player pl, String msg){
    	pl.sendMessage(ChatColor.AQUA + "[LoTR] " + ChatColor.WHITE + msg);
    }
	
	Timer timer = new Timer ();
	TimerTask twominTask = new TimerTask () {
	    @Override
	    public void run() {
	        ItemChest.RestockChests();
	        System.out.println("Chests restocked");
	    }
	};

}
