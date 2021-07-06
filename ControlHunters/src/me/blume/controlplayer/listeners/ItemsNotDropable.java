package me.blume.controlplayer.listeners;

import java.util.ArrayList;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

import me.blume.controlplayer.Main;
import me.blume.controlplayer.items.NetherStarItem;

public class ItemsNotDropable implements Listener{

	private Main plugin;
	public ItemsNotDropable(Main plugin) {
		this.plugin=plugin;
	}
	NetherStarItem nsi = new NetherStarItem();
	@SuppressWarnings("static-access")
	@EventHandler
	public void onDeaths(PlayerDeathEvent event) {
		if(plugin.playerController == event.getEntity()) {
			ArrayList<ItemStack> drops = new ArrayList<ItemStack>(event.getDrops());
			for(ItemStack drop : drops) {
				if(drop!=null) {
					if(drop.isSimilar(nsi.getPlayerController())) {
						event.getDrops().remove(event.getDrops().indexOf(drop));
					}
				}
			}
		}
		else if(plugin.playerControlling == event.getEntity()) {
			ArrayList<ItemStack> drops = new ArrayList<ItemStack>(event.getDrops());
			for(ItemStack drop : drops) {
				if(drop!=null) {
					if(drop.isSimilar(nsi.stopPlayerController())) {
						event.getDrops().remove(event.getDrops().indexOf(drop));
					}
				}
			}
		}
	}
	@EventHandler
	public void trackerDrops(PlayerDropItemEvent event) {
			if(event.getItemDrop().getItemStack().isSimilar(nsi.getPlayerController()) || event.getItemDrop().getItemStack().isSimilar(nsi.stopPlayerController())) {
				event.setCancelled(true);
				return;
			}
	}
}
