package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import net.minecraft.client.gui.Gui;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.input.Keyboard;

@SuppressWarnings("UnstableApiUsage")
public class WaterMark extends Module {

    public WaterMark() {
        setName("Watermark");
        setKeyID(Keyboard.KEY_P);
        setEnabled(true);
    }

    //WICHTIG: HIER @Subscribe BENUTZEN NICHT @SubscribeEvent !!!
    @Subscribe
    public void onRender(RenderGameOverlayEvent e) {
        mc.fontRenderer.drawStringWithShadow(Main.MOD_ID + " v" + Main.MOD_VER, 5, 5, -1);
        mc.getTextureManager().bindTexture(Gui.ICONS);
    }

}
