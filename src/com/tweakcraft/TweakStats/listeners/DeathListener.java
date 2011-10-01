package com.tweakcraft.TweakStats.listeners;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityListener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.inventory.ItemStack;

import com.tweakcraft.TweakStats.model.DeathCause;

public class DeathListener extends EntityListener{


	/**
	 * 
	 */
	private static final long serialVersionUID = -4280381276775477229L;

	
	@Override
	public void onEntityDeath(EntityDeathEvent event) {
		// TODO Auto-generated method stub
		super.onEntityDeath(event);

		if(event instanceof PlayerDeathEvent){
			PlayerDeathEvent deathevent = (PlayerDeathEvent) event;
			String deadmessage = deathevent.getDeathMessage();
			Player deadplayer = (Player) deathevent.getEntity();
			//ALARM THE ONES, SOMEONE DIED
			System.out.println(deadmessage + " " + deadplayer.getDisplayName());
			DeathCause d = DeathCause.getDeathCause("deadmessage");
			System.out.println(d);
			
		}
	}

	

}
