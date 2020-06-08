package uk.co.reosh.lotr.Items;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.util.Vector;

public class FireStaff {

	static float ManaCost = (float) 0.05;
	
	public static void shootFireball(Double speed, Player player, Location shootLocation) {
		Vector directionVector = shootLocation.getDirection().normalize();
		double startShift = 2;
		Vector shootShiftVector = new Vector(directionVector.getX() * startShift, directionVector.getY() * startShift, directionVector.getZ() * startShift);
		shootLocation = shootLocation.add(shootShiftVector.getX(), shootShiftVector.getY(), shootShiftVector.getZ());
 
		Fireball fireball = shootLocation.getWorld().spawn(shootLocation.add(new Vector(0, 1.5, 0)), Fireball.class);
		shootLocation.getWorld().playEffect(shootLocation, Effect.MOBSPAWNER_FLAMES, 1);
		player.playSound(shootLocation, Sound.GHAST_FIREBALL, 10, 1);
		fireball.setVelocity(directionVector.multiply(speed));
 
		if(fireball instanceof Fireball) {
			((Fireball) fireball).setIsIncendiary(false);// Remove fire
			((Fireball) fireball).setBounce(true);
			((Fireball) fireball).setShooter(player.getPlayer());
		}
	}
	
	public static void onUsed(PlayerInteractEvent event) { 
		if(event.getPlayer().getExp() >= ManaCost) {
			shootFireball(2.0, event.getPlayer(), event.getPlayer().getLocation());
			event.getPlayer().setExp((event.getPlayer().getExp() - ManaCost));
		}
    }

}
