package me.pr3.shitClient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ESP extends Module {

    public ESP() {
        setName("ESP");


        setEnabled(true);

    }

    @Subscribe
    public void onUpdate(TickEvent.ClientTickEvent e) {

        System.out.println("Event Fired");
        if (Minecraft.getMinecraft().world != null) {
            for (Entity ent : Minecraft.getMinecraft().world.loadedEntityList) {

                ent.setGlowing(true);

            }
        }
    }
}
