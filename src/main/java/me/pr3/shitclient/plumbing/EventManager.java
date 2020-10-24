package me.pr3.shitclient.plumbing;

import me.pr3.shitclient.Main;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@SuppressWarnings("UnstableApiUsage")
public class EventManager {

    @SubscribeEvent
    public void onChat(ClientChatEvent e) {
        Main.BUS.post(e);
    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent e) {
        Main.BUS.post(e);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent e) {
        Main.BUS.post(e);
    }

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent e) {
        Main.BUS.post(e);
    }

    @SubscribeEvent
    public void onRenderLiving(RenderLivingEvent.Pre<?> e) {
        Main.BUS.post(e);
    }

    @SubscribeEvent
    public void onRenderWorldLast(RenderWorldLastEvent e) { Main.BUS.post(e); }

}
