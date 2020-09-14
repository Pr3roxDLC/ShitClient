package me.pr3.shitClient.modules;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class WaterMark {
    public static boolean enabled = true;

   public static Minecraft mc = Minecraft.getMinecraft();

    public static void changeEnabled(){

        enabled = !enabled;

    }

    public static void onRenderOverlay(RenderGameOverlayEvent e){

        mc.fontRenderer.drawString("ShitClient v1.0", 5, 5 ,-1);

    }

}
