package me.blume.controlplayer.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import me.blume.controlplayer.Main;
import me.blume.controlplayer.items.NetherStarItem;

public class OpenGUI implements Listener {

	private Main plugin;
	public OpenGUI(Main plugin) {
		this.plugin=plugin;
	}
	NetherStarItem nsi = new NetherStarItem();
	@SuppressWarnings("static-access")
	@EventHandler
	public void onNetherStarClick(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		ItemStack item = event.getItem();
		Action action = event.getAction();
		if(item==null) return;
		if(item.isSimilar(nsi.getPlayerController())) {
			if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
				player.openInventory(plugin.inv);
			}
		}
		if(item.isSimilar(nsi.stopPlayerController())) {
			if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)) {
				Bukkit.getServer().dispatchCommand(player, "stopcontrol");
				plugin.playerControlling.getInventory().remove(nsi.stopPlayerController());
				
			}
		}
	}
}
