package me.blume.controlplayer.methods;

import org.bukkit.entity.Player;

import me.blume.controlplayer.Main;

public class ChangeAir {
	public void startAir(Player controller,Player controlling) {
		Main.airController = controller.getRemainingAir();
		Main.airControlling = controlling.getRemainingAir();
		controller.setRemainingAir(Main.airControlling);
	}
	public void stopAir(Player controller,Player controlling) {
		controlling.setRemainingAir(controller.getRemainingAir());
		controller.setRemainingAir(Main.airController);
	}
}
