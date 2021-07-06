package me.blume.controlplayer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitTask;

import me.blume.controlplayer.commands.ControlPlayerCommand;
import me.blume.controlplayer.commands.GetControlItem;
import me.blume.controlplayer.commands.StopControlCommand;
import me.blume.controlplayer.listeners.CantMove;
import me.blume.controlplayer.listeners.DeathEvent;
import me.blume.controlplayer.listeners.GUIthings;
import me.blume.controlplayer.listeners.GivingControlTime;
import me.blume.controlplayer.listeners.ItemsNotDropable;
import me.blume.controlplayer.listeners.OpenGUI;
import me.blume.controlplayer.methods.StartControlling;

public class Main extends JavaPlugin{
	public HashMap<UUID,UUID> inControl = new HashMap<UUID,UUID>();
	public String controllerName,controllingName;
	public static Location getBackToLocationController,getBackToLocationControlling;
	public static int foodLevelController,foodLevelControlling;
	public static double healthLevetlController,healthLevelControlling;
	public static ItemStack[] inventoryController,inventoryControlling;
	public static float experienceController,experienceControlling;
	public static int levelController,levelControlling;
	public static ArrayList<PotionEffect> potionController = new ArrayList<PotionEffect>();
	public static ArrayList<PotionEffect> potionControlling = new ArrayList<PotionEffect>();
	public static int fireticksController,fireticksControlling;
	public static int airController,airControlling;
	public static Player playerController,playerControlling;
	public static Inventory inv;
	public static ArrayList<String> playersNames = new ArrayList<String>();
	public static int controlTime = 45;
	public  BukkitTask messageTask,startTask,endTask;
	public static ItemStack leftOverItem;
	StartControlling sc = new StartControlling();
	@Override
	public void onEnable() {
		getCommand("control").setExecutor(new ControlPlayerCommand(this));
		getCommand("stopcontrol").setExecutor(new StopControlCommand(this));
		getCommand("controlhunters").setExecutor(new GetControlItem(this));
		getServer().getPluginManager().registerEvents(new CantMove(this), this);
		getServer().getPluginManager().registerEvents(new DeathEvent(this), this);
		getServer().getPluginManager().registerEvents(new OpenGUI(this), this);
		getServer().getPluginManager().registerEvents(new GUIthings(this), this);
		getServer().getPluginManager().registerEvents(new GivingControlTime(this), this);
		getServer().getPluginManager().registerEvents(new ItemsNotDropable(this), this);
	}
}
