package me.blume.controlplayer.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.blume.controlplayer.Main;
import me.blume.controlplayer.methods.ChangeName;
import me.blume.controlplayer.methods.StartControlling;
import net.md_5.bungee.api.ChatColor;

public class ControlPlayerCommand implements CommandExecutor {

	@SuppressWarnings("unused")
	private Main plugin;
	public ControlPlayerCommand(Main plugin) {
		this.plugin=plugin;
	}
	ChangeName cn = new ChangeName();
	StartControlling sc = new StartControlling();
	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(label.equals("control")) {
				if(plugin.controlTime>0) {
					if(args.length==1) {
						Player changeTo = Bukkit.getPlayer(args[0]);
						if(changeTo!=null) {
							if(changeTo!= player) {
								if(!plugin.inControl.containsKey(player.getUniqueId())) {
									if(plugin.inControl.size()==0) {
										if(!plugin.inControl.containsValue(changeTo.getUniqueId())) {
											plugin.controllerName = player.getName();
											plugin.controllingName = args[0];
											cn.changeName(args[0], player);
											sc.startControlling(player, changeTo);
											plugin.inControl.put(player.getUniqueId(), changeTo.getUniqueId());
											plugin.startTask=Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
												@Override
												public void run() {
													if(plugin.controlTime!=0) {
														plugin.controlTime--;
													}else {
														Bukkit.getServer().dispatchCommand(player, "stopcontrol");
													}
												}
											}, 0, 20L);
										}else {
											player.sendMessage("That player is already controlled by a player");
										}
									}
									else {
										player.sendMessage("You are already in a control");
									}
								}
							}
							else {
								player.sendMessage("You cant control yourself");
							}
						}else {
							player.sendMessage("Wrong username");
						}
					}else {
						player.sendMessage("Wrong usage");
					}
				}else {
					player.sendMessage(ChatColor.RED+"You dont have control time!");
				}
				
			}
		}
		return false;
	}
}
