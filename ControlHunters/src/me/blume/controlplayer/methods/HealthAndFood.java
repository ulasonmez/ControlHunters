package me.blume.controlplayer.methods;

import org.bukkit.entity.Player;
import me.blume.controlplayer.Main;
public class HealthAndFood {

	public void changeHealthAtStart(Player controller,Player controlling) {
		Main.healthLevetlController = controller.getHealth();
		Main.healthLevelControlling = controlling.getHealth();
		Main.foodLevelController = controller.getFoodLevel();
		Main.foodLevelControlling = controlling.getFoodLevel();
		controller.setFoodLevel(Main.foodLevelControlling);
		controller.setHealth(Main.healthLevelControlling);
	}
	public void changeHealthAtStop(Player controller,Player controlling) {
		controlling.setHealth(controller.getHealth());
		controlling.setFoodLevel(controller.getFoodLevel());
		controller.setHealth(Main.healthLevetlController);
		controller.setFoodLevel(Main.foodLevelController);
	}
}
