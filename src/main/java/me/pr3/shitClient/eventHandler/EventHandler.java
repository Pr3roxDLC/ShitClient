package me.pr3.shitClient.eventHandler;


import me.pr3.shitClient.modules.AimBot;
import me.pr3.shitClient.modules.ESP;
import me.pr3.shitClient.modules.WaterMark;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public static void onRenderOverlay(RenderGameOverlayEvent e){

        WaterMark.onRenderOverlay(e);

    }



    @SubscribeEvent
    public static void onLiving(LivingEvent e) {

        ESP.onPlayerRender(e);
        AimBot.onLiving(e);

    }

}
