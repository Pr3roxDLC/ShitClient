package me.pr3.shitClient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.lwjgl.opengl.GL11;

public class WaterMark extends Module {

    public WaterMark() {
        setName("watermark");

        setEnabled(true);

    }

    //WICHTIG: HIER @Subscribe BENUTZEN NICHT @SubscribeEvent !!!
    @Subscribe
    public void onRender(RenderGameOverlayEvent e) {




        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("ShitClient V1.0.0", 5, 5, -1);
        Minecraft.getMinecraft().getTextureManager().bindTexture(Gui.ICONS);


    }
}
