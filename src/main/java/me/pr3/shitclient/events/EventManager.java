package me.pr3.shitclient.events;

import me.pr3.shitclient.Main;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventManager {

    public EventManager(){



    }



    @SubscribeEvent
    public void onChat(ClientChatEvent e){

        Main.BUS.post(e);



    }

    @SubscribeEvent
    public void onLivingUpdate(LivingEvent e){

        Main.BUS.post(e);

    }



    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent e){

        Main.BUS.post(e);

    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent e){

        Main.BUS.post(e);

    }

    @SubscribeEvent
    public void onRender(RenderLivingEvent e){

        Main.BUS.post(e);

    }

}
