package me.blume.controlplayer.methods;

import org.bukkit.entity.Player;

import me.blume.controlplayer.Main;

public class ChangeLocations {


	public void startControlling(Player controller,Player controlling) {
		Main.getBackToLocationController=controller.getLocation();
		Main.getBackToLocationControlling=controlling.getLocation();
		controller.teleport(Main.getBackToLocationControlling);
	}
	public void stopControlling(Player controller) {
		controller.teleport(Main.getBackToLocationController);
	}
}
