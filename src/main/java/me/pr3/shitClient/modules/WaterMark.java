package me.pr3.shitClient.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class WaterMark  extends  Module{
    public static boolean enabled = true;

   public static Minecraft mc = Minecraft.getMinecraft();

    public void changeEnabled(){

        enabled = !enabled;

    }

    public static void onRenderOverlay(RenderGameOverlayEvent e){
        if(!Minecraft.getMinecraft().gameSettings.showDebugInfo && enabled) mc.fontRenderer.drawString("ShitClient v1.0", 5, 5 ,-1);

    }

}
