package com.tweakcraft.TweakStats.listeners;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
			long seconds = timediff / 1000 % 60;
			long minutes = ((timediff / 1000) - seconds) % 60;
			long hours = ((timediff / 1000) - seconds - minutes) % 60;
			log.info("Player "  + eventPlayer.getDisplayName() + " Was online for h: " + hours + " m: "  + minutes + " s: " + seconds);

			playerList.remove(eventPlayer);
		}

	}
}
