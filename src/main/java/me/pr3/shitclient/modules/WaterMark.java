package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public class WaterMark extends Module {

    public WaterMark() {
        setName("Watermark");

        setEnabled(true);

    }

    //WICHTIG: HIER @Subscribe BENUTZEN NICHT @SubscribeEvent !!!
    @Subscribe
    public void onRender(RenderGameOverlayEvent e) {




        Minecraft.getMinecraft().fontRenderer.drawStringWithShadow("shitclient V1.0.0", 5, 5, -1);
        Minecraft.getMinecraft().getTextureManager().bindTexture(Gui.ICONS);


    }
}
