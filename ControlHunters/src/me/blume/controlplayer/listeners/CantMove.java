package me.blume.controlplayer.listeners;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import me.blume.controlplayer.Main;

public class CantMove implements Listener{

	@SuppressWarnings("unused")
	private Main plugin;
	public CantMove(Main plugin) {
		this.plugin=plugin;
	}
	@EventHandler
	public void onDontMove(PlayerMoveEvent event) {
		Player player = event.getPlayer();
		if(plugin.inControl.containsValue(player.getUniqueId())) {
			event.setCancelled(true);
		}
		else if(plugin.inControl.containsKey(player.getUniqueId())) {
			UUID playeruuid = plugin.inControl.get(player.getUniqueId());
			Player controllingPlayer = Bukkit.getPlayer(playeruuid);
			Location loc = player.getLocation();
			controllingPlayer.teleport(loc);
			controllingPlayer.setSpectatorTarget(player);
		}
	}
}
