package me.pr3.shitClient.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.potion.PotionEffect;

public class FullBright {
	
	public static boolean enabled = false;

	public static void ChangeEnabled() {
		
		enabled = !enabled;
		
		if(enabled) Minecraft.getMinecraft().gameSettings.gammaSetting = 100;
		if(!enabled) Minecraft.getMinecraft().gameSettings.gammaSetting = 1;
	}
	
}
