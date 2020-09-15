package me.pr3.shitClient.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WaterMark extends Module {

    public WaterMark(){
        setName("WaterMark");

        setEnabled(true);

    }

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent e) {

        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("ShitClient V1.0.0", 5,5,-1);

    }
}
