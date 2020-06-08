package uk.co.reosh.lotr;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import uk.co.reosh.lotr.Chests.ItemChest;
import uk.co.reosh.lotr.Chests.ItemChest.Type;

public class SettingsManager {
	private static Plugin p;
	private static SettingsManager instance = new SettingsManager();
	
	private FileConfiguration chests;
	private File f;
	
	private SettingsManager(){

    }
	
	public static SettingsManager getInstance(){
        return instance;
    }
	
	public void setup(Plugin p){
        SettingsManager.p = p;

        p.getConfig().options().copyDefaults(true);
        p.saveDefaultConfig();

        f = new File(p.getDataFolder(),"chests.yml");
        try{
            if(!f.exists())
                f.createNewFile();
        }catch(Exception e){}
        reloadChests();
    }
	
	public void set(String arg0, Object arg1){
        p.getConfig().set(arg0, arg1);
    }

    public FileConfiguration getConfig(){
        return p.getConfig();
    }
    
    public FileConfiguration getChests(){
        return chests;
    }
    
    public void reloadChests(){
        chests = YamlConfiguration.loadConfiguration(f);
    }
    
    public void addChest(String name, Location loc, Type type){
    	chests.set("chests."+name+".x", loc.getBlockX());
        chests.set("chests."+name+".y", loc.getBlockY());
        chests.set("chests."+name+".z", loc.getBlockZ());
        chests.set("chests."+name+".type", ItemChest.TypeToString(type));
        
        try {
			chests.save(f);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
