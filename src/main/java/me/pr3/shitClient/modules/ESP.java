package me.pr3.shitClient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ESP extends Module {

    public ESP() {
        setName("esp");


        setEnabled(false);

    }

    @Override
    public void onDisable() {
        super.onDisable();
        if (Minecraft.getMinecraft().world != null) {
            for (Entity ent : Minecraft.getMinecraft().world.loadedEntityList) {

                ent.setGlowing(false);

            }
        }

    }

    @Subscribe
    public void onUpdate(TickEvent.ClientTickEvent e) {
        if (Minecraft.getMinecraft().world != null) {
            for (Entity ent : Minecraft.getMinecraft().world.loadedEntityList) {

                ent.setGlowing(true);

            }
        }

    }
}
