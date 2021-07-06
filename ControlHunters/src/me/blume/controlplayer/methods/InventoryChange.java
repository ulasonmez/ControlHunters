package me.blume.controlplayer.methods;

import org.bukkit.entity.Player;

import me.blume.controlplayer.Main;

public class InventoryChange {
	public void startingInventory(Player controller,Player controlling) {
		Main.inventoryController = controller.getInventory().getContents();
		Main.inventoryControlling = controlling.getInventory().getContents();
		controller.getInventory().clear();
		controller.getInventory().setContents(Main.inventoryControlling);
	}
	public void stopingInventory(Player controller,Player controlling) {
		controlling.getInventory().setContents(controller.getInventory().getContents());
		controller.getInventory().clear();
		controller.getInventory().setContents(Main.inventoryController);
	}

}
