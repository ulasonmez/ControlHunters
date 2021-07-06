package me.blume.controlplayer.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler; 
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import me.blume.controlplayer.Main;
import me.blume.controlplayer.items.NetherStarItem;

public class GUIthings implements Listener{
	@SuppressWarnings("unused")
	private Main plugin;
	public GUIthings(Main plugin) {
		this.plugin=plugin;
	}
	boolean itemPlaced = false;
	NetherStarItem nsi = new NetherStarItem();
	ItemStack itemdrop;
	@SuppressWarnings("static-access")
	@EventHandler
	public void onClickOnGUI(InventoryClickEvent event) {
		Player player = (Player) event.getWhoClicked();

		if(!event.getInventory().equals(plugin.inv)) return;
		if(event.getCurrentItem()==null) return;
		if(event.getCurrentItem().getItemMeta().getDisplayName()==null) return;
		event.setCancelled(true);
		if(!player.equals(plugin.playerController)) return;
		event.setCancelled(true);
			ItemStack item = event.getCurrentItem();
			plugin.playerControlling = Bukkit.getPlayer(item.getItemMeta().getDisplayName());
			//plugin.playerControlling.getInventory().addItem(nsi.stopPlayerController());
			itemPlaced = false;
			for(int slot = 0 ; slot < 36; slot++) {
				if(plugin.playerControlling.getInventory().getItem(slot) == null) {
					plugin.playerControlling.getInventory().setItem(slot, nsi.stopPlayerController());
					itemPlaced = true;
					break;
				}
			}
			if(!itemPlaced) {
				plugin.playerControlling.getInventory().setItem(9, nsi.stopPlayerController());
			}

			Bukkit.getServer().dispatchCommand(player, "control "+item.getItemMeta().getDisplayName());
			player.closeInventory();
			
		
		
		
		return;
	}

}
