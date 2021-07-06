package me.blume.controlplayer.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import me.blume.controlplayer.Main;
import me.blume.controlplayer.items.NetherStarItem;
import me.blume.controlplayer.methods.GetPlayerHead;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;

public class GetControlItem implements CommandExecutor{
	@SuppressWarnings("unused")
	private Main plugin;
	public GetControlItem(Main plugin) {
		this.plugin=plugin;
	}
	NetherStarItem nsi = new NetherStarItem();
	
	@SuppressWarnings("static-access")
	@Override
	public boolean onCommand(CommandSender sender, Command arg1, String label, String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			if(args.length==0) {
				if(label.equals("controlhunters")) {
					player.getInventory().addItem(nsi.getPlayerController());
					plugin.messageTask=Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
						@Override
						public void run() {
							player.spigot().sendMessage(ChatMessageType.ACTION_BAR,new TextComponent(ChatColor.AQUA+"Control Time: "+plugin.controlTime));
							
						}
					}, 0, 20L);
					plugin.playerController = player;
					createInv();
				}
			}
		}
		
		return false;
	}
	GetPlayerHead gph = new GetPlayerHead();
	int playerCount=0,arrayCount=0;
	
	
	@SuppressWarnings("static-access")
	public void createInv() {
		for(Player p: Bukkit.getOnlinePlayers()) {
			if(p==plugin.playerController) continue;
			playerCount++;
		}
		plugin.inv = Bukkit.createInventory(null, 9,ChatColor.DARK_PURPLE+"Control Players");
		for(Player p : Bukkit.getOnlinePlayers()) {
			if(p == plugin.playerController) continue;
			plugin.playersNames.add(p.getName());
			ItemStack item = gph.getPlayerHead(p.getName());
			plugin.inv.setItem(arrayCount, item);
			arrayCount++;
		}
	}

}
