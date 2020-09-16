package me.pr3.shitClient.events;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitClient.Main;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class EventManager {

    public EventManager(){



    }

    @SubscribeEvent
    public void onRenderRain(RenderWorldLastEvent e){
        Main.BUS.post(e);

    }

    @SubscribeEvent
    public void onChat(ClientChatEvent e){

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

}
