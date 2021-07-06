package me.blume.controlplayer.items;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class NetherStarItem {

	public ItemStack getPlayerController() {
		ItemStack item = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE+"Control Players");
		meta.addEnchant(Enchantment.DURABILITY, 3, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}
	public ItemStack stopPlayerController() {
		ItemStack item = new ItemStack(Material.NETHER_STAR);
		ItemMeta meta = item.getItemMeta();
		meta.setDisplayName(ChatColor.DARK_PURPLE+"Stop Control");
		meta.addEnchant(Enchantment.DURABILITY, 3, false);
		meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
		item.setItemMeta(meta);
		return item;
	}

}
