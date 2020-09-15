package me.pr3.shitClient.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class WaterMark extends Module {

    public WaterMark(){

        setEnabled(true);
        setName("WaterMark");

    }

    @Override
    public void onRender(RenderGameOverlayEvent e) {
        super.onRender(e);

        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("ShitClient V1.0.0", 5,5,-1);

    }
}
