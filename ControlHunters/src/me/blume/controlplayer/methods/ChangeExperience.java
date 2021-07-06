package me.blume.controlplayer.methods;

import org.bukkit.entity.Player;

import me.blume.controlplayer.Main;

public class ChangeExperience {
	public void startExperience(Player controller,Player controlling) {
		Main.experienceController = controller.getExp();
		Main.experienceControlling = controlling.getExp();
		controller.setExp(Main.experienceControlling);
		Main.levelController = controller.getLevel();
		Main.levelControlling = controlling.getLevel();
		controller.setLevel(Main.levelControlling);
		
	}
	public void stopExperience(Player controller,Player controlling) {
		controlling.setExp(controller.getExp());
		controller.setExp(Main.experienceController);
		controlling.setLevel(controller.getLevel());
		controller.setLevel(Main.levelController);
	}

}
