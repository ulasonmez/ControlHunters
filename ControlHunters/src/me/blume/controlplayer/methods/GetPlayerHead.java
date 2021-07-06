package me.blume.controlplayer.methods;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class GetPlayerHead {
	@SuppressWarnings("deprecation")
	public ItemStack getPlayerHead(String player) {
		boolean isNewVersion = Arrays.stream(Material.values())
				.map(Material::name).collect(Collectors.toList()).contains("PLAYER_HEAD");
		Material type = Material.matchMaterial(isNewVersion ? "PLAYER_HEAD" : "SKULL_ITEM");
		ItemStack item = new ItemStack(type,1);
		
		if(!isNewVersion) {
			item.setDurability((short) 3);
		}
		
		
		SkullMeta meta = (SkullMeta) item.getItemMeta();
		meta.setOwner(player);
		meta.setDisplayName(player);
		item.setItemMeta(meta);
		
		return item;
	}

}
