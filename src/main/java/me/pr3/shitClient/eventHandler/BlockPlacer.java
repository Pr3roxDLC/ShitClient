//package com.Pr3roxDLC.xXPLT.eventHandler;
//
//import net.minecraft.client.Minecraft;
//import net.minecraft.entity.player.EntityPlayer;
//import net.minecraft.util.math.BlockPos;
//import net.minecraftforge.event.entity.EntityEvent;
//import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
//import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
//
//public class BlockPlacer {
//
//	EntityPlayer player = Minecraft.getMinecraft().player;
//	Minecraft mc = Minecraft.getMinecraft();
//	float vel = 0;
//
//
//	@SubscribeEvent
//	public void blockPlacer(LivingUpdateEvent e) {
//		
//	
//		
//		if(e.getEntity() == mc.player) {
//			
//			if(mc.player.isSneaking()) {
//				
//				if(vel < 10) {
//					
//					vel =+ 0.01f;
//					
//				}
//				
//				
//				
//				e.getEntity().addVelocity(0, -1*vel, 0);
//				
//			}else if(e.getEntity().isAirBorne) {
//				
//				e.getEntity().setNoGravity(true);
//				
//			}
//			
//		}
//		
//	}
//}
