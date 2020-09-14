package me.pr3.shitClient.modules;

import me.pr3.shitClient.Main;
import me.pr3.shitClient.util.Logger;
import me.pr3.shitClient.util.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.event.entity.living.LivingEvent;
import org.apache.logging.log4j.Level;


public class AimBot extends Module{
	
	public static boolean enabled = false;
	public static Entity[] entities = null;

	@Override
	public void changeEnabled() {

		enabled =!enabled;

	}

	
	public static Entity getClosestEntity() {
		float distance = Integer.MAX_VALUE;
		Entity closestEntity = null;

		if(Minecraft.getMinecraft().world == null) {
			return null;
		}

		for(Entity e : Minecraft.getMinecraft().world.loadedEntityList) {

			if(distance > e.getDistance(Minecraft.getMinecraft().player) && !Minecraft.getMinecraft().player.equals(e) ) {
				distance = e.getDistance(Minecraft.getMinecraft().player);
				closestEntity = e;
			}
		}
		
		return closestEntity;
		
	}


	public static void onLiving(LivingEvent e) {
		if(enabled) {
			if (Minecraft.getMinecraft().player == null) return;
			Entity closestEnt = getClosestEntity();


			if (closestEnt != null) {
				Utils.faceEntity(closestEnt, 15,15);
			}
		}
	}

}
