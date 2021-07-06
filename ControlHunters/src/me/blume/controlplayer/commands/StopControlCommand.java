package me.blume.controlplayer.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.blume.controlplayer.Main;
import me.blume.controlplayer.items.NetherStarItem;
import me.blume.controlplayer.methods.ChangeName;
import me.blume.controlplayer.methods.StartControlling;

public class StopControlCommand implements CommandExecutor{

	@SuppressWarnings("unused")
	private Main plugin;
	public StopControlCommand(Main plugin) {
		this.plugin=plugin;
	}
	int slot;
	ChangeName cn = new ChangeName();
	NetherStarItem nsi = new NetherStarItem();
	StartControlling sc = new StartControlling();
	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(label.equals("stopcontrol")) {
				if(args.length==0) {
					if(plugin.inControl.containsKey(player.getUniqueId())) {
						cn.changeName(plugin.controllerName, player);
						Player controllingPlayer = Bukkit.getPlayer(plugin.controllingName);
						sc.stopControlling(player, controllingPlayer);
						plugin.inControl.remove(player.getUniqueId());
						
						
						plugin.startTask.cancel();
					}else {
						player.sendMessage("You dont control anyone");
					}
				}else {
					player.sendMessage("Wrong usage");
				}
			}
		}
		return false;
	}
}
