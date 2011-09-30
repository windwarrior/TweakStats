package com.tweakcraft.TweakStats.test;

import com.tweakcraft.TweakStats.listeners.PlayerOnlineListener;

public class TimeTest {
	
	public static void main(String[] args){
		PlayerOnlineListener test = new PlayerOnlineListener();
		int[] time = test.getHumanReadableTime(4511000);
		System.out.println("h: " + time[0] + " m: " + time[1] + " s: " + time[2]);
		

		time = test.getHumanReadableTime(4511023);
		System.out.println("h: " + time[0] + " m: " + time[1] + " s: " + time[2] + " ms: " + time[3]);
	}

}
