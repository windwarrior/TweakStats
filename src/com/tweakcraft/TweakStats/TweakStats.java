package com.tweakcraft.TweakStats;

import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Event;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.tweakcraft.TweakStats.listeners.DeathListener;
import com.tweakcraft.TweakStats.listeners.PlayerOnlineListener;

public class TweakStats extends JavaPlugin{
	private static Logger log = Logger.getLogger("Minecraft");
	private Listener playerDeathListener = new DeathListener();
	private Listener playerOnlineListener = new PlayerOnlineListener();
	@Override
	public void onDisable() {
		log.info("TweakStats disabled :(");
		
	}

	@Override
	public void onEnable() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvent(Event.Type.ENTITY_DEATH, playerDeathListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_JOIN, playerOnlineListener, Priority.Normal, this);
		pm.registerEvent(Event.Type.PLAYER_QUIT, playerOnlineListener, Priority.Normal, this);
		log.info("TweakStats enabled :D");
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
		
		if(command.getName().equalsIgnoreCase("onlinetime") && args.length == 1){
			int[] time = ((PlayerOnlineListener) playerOnlineListener).getOnlineTime(args[0]);
			if(time != null){
				sender.sendMessage("Player: " + args[0] + " is online for " + time[0] + ":" + time[1] + ":" + time[2]);
				return true;
			}
		}
		return false;
	}
	
}
