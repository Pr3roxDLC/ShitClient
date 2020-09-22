package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraftforge.client.event.RenderLivingEvent;
import org.lwjgl.opengl.GL11;

public class Chams extends Module {

    public Chams(){

        setEnabled(true);
        setName("Chams");

    }

    @Subscribe
    public void onPreRenderLiving(RenderLivingEvent.Pre event) {
        GL11.glEnable(GL11.GL_POLYGON_OFFSET_FILL);
        GlStateManager.enablePolygonOffset();
        GlStateManager.disableLighting();
        GlStateManager.doPolygonOffset(1.0F, -2000000);
    }

    @Subscribe
    public void onPostRenderLiving(RenderLivingEvent.Post event) {
        GL11.glDisable(GL11.GL_POLYGON_OFFSET_FILL);
        GlStateManager.doPolygonOffset(1.0F, 2000000);
        GlStateManager.enableLighting();
        GlStateManager.disablePolygonOffset();
    }
}


