package com.tweakcraft.TweakStats.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerOnlineListener extends PlayerListener{
	Map<Player, Long> playerList = new HashMap<Player, Long>();

	private static Logger log = Logger.getLogger("Minecraft");

	@Override
	public void onPlayerJoin(PlayerJoinEvent event) {
		log.info("hai");
		super.onPlayerJoin(event);
		Player eventPlayer = event.getPlayer();
		playerList.put(eventPlayer, System.currentTimeMillis());
	}

	@Override
	public void onPlayerQuit(PlayerQuitEvent event)  {
		super.onPlayerQuit(event);
		Player eventPlayer = event.getPlayer();
		if(playerList.containsKey(eventPlayer)){
			long timediff = System.currentTimeMillis() -  playerList.get(eventPlayer);
			playerList.remove(eventPlayer);
		}

	}
	
	public int[] getOnlineTime(String player){
		for(Entry<Player, Long> p: playerList.entrySet()){
			if (p.getKey().getDisplayName().equalsIgnoreCase(player)){
				long joinTime = p.getValue();
				long timediff = System.currentTimeMillis() - joinTime;
				return getHumanReadableTime(timediff);
			}
		}
		
		return null;
		
	}
	
	
	public int[] getHumanReadableTime(long timediff){
		int milliseconds = (int)(timediff % 1000);
		long time = timediff/1000;
		int seconds = (int) time % 60;
		int minutes = (int) (((time - seconds) / 60) % 60) ;
		int hours =  (int) (((time - seconds  - minutes*60)) / 3600);
		
		return new int[]{hours,minutes,seconds, milliseconds};
	}
}
