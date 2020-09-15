package me.pr3.shitClient.modules;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ESP extends Module {

    public ESP() {

        setEnabled(true);

    }

    @Override
    public void onUpdate(TickEvent.ClientTickEvent e) {
        super.onUpdate(e);
        if (Minecraft.getMinecraft().world != null) {
            for (Entity ent : Minecraft.getMinecraft().world.loadedEntityList) {

                ent.setGlowing(true);

            }
        }
    }
}
