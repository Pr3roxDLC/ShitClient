package me.pr3.shitClient.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ESP {
	
	public ESP() {
		
		System.out.println("Registered ESP");
		
	}
	private static boolean enabled = true;

	public static void ChangeEnable() {

		System.out.println("Changed ESP");
		enabled = !enabled;

	}

	public static void onPlayerRender(LivingEvent e) {
		
		if(e.getEntity() != null && enabled) {
			e.getEntity().setGlowing(true);
			}
		if(e.getEntity() != null && !enabled) {
			
			e.getEntity().setGlowing(false);
			
		}
		
	}

}
