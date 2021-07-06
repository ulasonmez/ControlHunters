package me.blume.controlplayer.methods;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

import me.blume.controlplayer.Main;

public class ChangePotions {
	public void startPotions(Player controller,Player controlling) {
		for(PotionEffect pe : controller.getActivePotionEffects()) {
			Main.potionController.add(pe);
		}
		for(PotionEffect pe: controlling.getActivePotionEffects()) {
			Main.potionControlling.add(pe);
		}
		for(PotionEffect pe:Main.potionController) {
			controller.removePotionEffect(pe.getType());
		}
		for(PotionEffect pe:Main.potionControlling) {
			controlling.removePotionEffect(pe.getType());
			controller.addPotionEffect(pe);
		}
	}
	public void stopPotions(Player controller,Player controlling) {
		for(PotionEffect pe:controller.getActivePotionEffects()) {
			controlling.addPotionEffect(pe);
			controller.removePotionEffect(pe.getType());
		}
		for(PotionEffect pe:Main.potionController) {
			controller.addPotionEffect(pe);
		}
		Main.potionController.clear();
		Main.potionControlling.clear();
	}
}
