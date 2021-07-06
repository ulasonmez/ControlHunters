package me.blume.controlplayer.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.blume.controlplayer.Main;

public class GivingControlTime implements Listener{

	private Main plugin;
	public GivingControlTime(Main plugin) {
		this.plugin=plugin;
	}
	@SuppressWarnings("static-access")
	@EventHandler
	public void onHunterDeath(PlayerDeathEvent event) {
		Player player = event.getEntity();
		Player killer = player.getKiller();
		if(killer == plugin.playerController) {
			plugin.controlTime += 30;
		}
		else if(player == plugin.playerControlling) {
			plugin.controlTime += 25;
		}
		else {
			plugin.controlTime += 15;
		}
	}
}
