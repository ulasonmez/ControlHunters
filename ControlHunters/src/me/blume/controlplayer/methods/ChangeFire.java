package me.blume.controlplayer.methods;

import org.bukkit.entity.Player;
import me.blume.controlplayer.Main;

public class ChangeFire {
	public void startFire(Player controller,Player controlling) {
		Main.fireticksController = controller.getFireTicks();
		Main.fireticksControlling = controlling.getFireTicks();
		controller.setFireTicks(Main.fireticksControlling);
		
	}
	public void stopFire(Player controller,Player controlling) {
		controlling.setFireTicks(controller.getFireTicks());
		controller.setFireTicks(Main.fireticksController);
	}

}
