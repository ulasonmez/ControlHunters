package me.blume.controlplayer.methods;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class HideAndShowPlayer {

	@SuppressWarnings("deprecation")
	public void hidePlayer(Player p) {
		p.setGameMode(GameMode.SPECTATOR);
		for(Player player: Bukkit.getOnlinePlayers()) {
			if(player==p) continue;
			player.hidePlayer(p);
		}
	}
	@SuppressWarnings("deprecation")
	public void showPlayer(Player p) {
		p.setGameMode(GameMode.SURVIVAL);
		for(Player player: Bukkit.getOnlinePlayers()) {
			if(player==p) continue;
			player.showPlayer(p);
		}
	}
}
