package com.tweakcraft.TweakStats;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.tweakcraft.TweakStats.listeners.DeathListener;

public class TweakStats extends JavaPlugin{
	private static Logger log = Logger.getLogger("Minecraft");
	private Listener playerDeathListener = new DeathListener();
	@Override
	public void onDisable() {
		log.info("TweakStats disabled :(");
		
	}

	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.ENTITY_DEATH, playerDeathListener, Priority.Normal, this);
		
		log.info("TweakStats enabled :D");
	}
	
}
