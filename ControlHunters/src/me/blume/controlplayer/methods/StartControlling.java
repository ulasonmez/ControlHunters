package me.blume.controlplayer.methods;

import org.bukkit.entity.Player;


public class StartControlling {

	ChangeName cn = new ChangeName();
	ChangeLocations cl = new ChangeLocations();
	HideAndShowPlayer hasp = new HideAndShowPlayer();
	HealthAndFood haf = new HealthAndFood();
	InventoryChange ic = new InventoryChange();
	ChangeExperience ce = new ChangeExperience();
	ChangePotions cp = new ChangePotions();
	ChangeFire cf = new ChangeFire();
	ChangeAir ca = new ChangeAir();
	public void startControlling(Player controller,Player controlling) {
		hasp.hidePlayer(controlling);
		cl.startControlling(controller, controlling);
		ic.startingInventory(controller, controlling);
		haf.changeHealthAtStart(controller, controlling);
		ce.startExperience(controller, controlling);
		cp.startPotions(controller, controlling);
		cf.startFire(controller, controlling);
		ca.startAir(controller, controlling);
		controlling.setSpectatorTarget(controller);
		
	}
	public void stopControlling(Player controller,Player controlling) {
		hasp.showPlayer(controlling);
		cl.stopControlling(controller);
		haf.changeHealthAtStop(controller, controlling);
		ic.stopingInventory(controller, controlling);
		ce.stopExperience(controller, controlling);
		cp.stopPotions(controller, controlling);
		cf.stopFire(controller, controlling);
		ca.stopAir(controller, controlling);
		
	}
}
