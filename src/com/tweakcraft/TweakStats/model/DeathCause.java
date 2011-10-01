package com.tweakcraft.TweakStats.model;

import java.util.ArrayList;
import java.util.List;

public enum DeathCause {
	
	FLAMES("%1$s went up in flames"),
	ONFIRE("%1$s burned to death"),
	LAVA("%1$s tried to swim in lava"),
	INWALL("%1$s suffocated in a wall"),
	DROWN("%1$s drowned"),
	STARVE("%1$s starved to death"),
	CACTUS("%1$s was pricked to death"),
	FALL("%1$s hit the ground too hard"),
	OUTOFWORLD("%1$s fell out of the world"),
	GENERIC("%1$s died"),
	EXPLOTION("%1$s blew up"),
	MAGIC("%1$s was killed by magic"),
	MOB("%1$s was slain by %2$s"),
	PLAYER("%1$s was slain by %2$s"),
	ARROW("%1$s was shot by %2$s"),
	FIREBALL("%1$s was fireballed by %2$s"),
	THROWN("%1$s was pummeled by %2$s");
			
	private String cause;
	
	private DeathCause(String cause){
		this.cause = cause;
	}
	
	public static DeathCause getDeathCause(String cause){
		for(DeathCause dc : DeathCause.values()){
			dc.getCause().replaceAll("%1$s", "").replaceAll("%2$s", "");
			if(cause.contains(dc.getCause())){
				return dc;
			}
		}
		
		return GENERIC;
	}

	private String getCause() {
		// TODO Auto-generated method stub
		return cause;
	}
}
