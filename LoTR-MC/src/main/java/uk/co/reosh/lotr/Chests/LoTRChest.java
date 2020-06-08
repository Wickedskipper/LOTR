package uk.co.reosh.lotr.Chests;

import org.bukkit.Location;

import uk.co.reosh.lotr.Chests.ItemChest.Type;

public class LoTRChest {
	private String chestname;
	private Location chestloc;
	private Type chesttype;
	
	public LoTRChest(String ChestName, Location ChestLocation, Type ChestType){
		chestname = ChestName;
		chestloc = ChestLocation;
		chesttype = ChestType;
	}
	
	public String getName(){
		return chestname;
	}
	public Location getLocation(){
		return chestloc;
	}
	public Type getType(){
		return chesttype;
	}
}
