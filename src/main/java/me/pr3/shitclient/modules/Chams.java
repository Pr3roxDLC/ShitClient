package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderLivingEvent;
import org.lwjgl.opengl.GL11;

@SuppressWarnings("UnstableApiUsage")
public class Chams extends Module {

    public Chams() {
        super("Chams", false);
    }

    @Subscribe
    public void onRenderLivingPre(RenderLivingEvent.Pre<? extends EntityLivingBase> event) {
        GL11.glEnable(GL11.GL_POLYGON_OFFSET_FILL);
        GlStateManager.enablePolygonOffset();
        GlStateManager.disableLighting();
        GlStateManager.doPolygonOffset(1.0F, -2000000);
    }

    @Subscribe
    public void onRenderLivingPost(RenderLivingEvent.Post<? extends EntityLivingBase> event) {
        GL11.glDisable(GL11.GL_POLYGON_OFFSET_FILL);
        GlStateManager.doPolygonOffset(1.0F, 2000000);
        GlStateManager.enableLighting();
        GlStateManager.disablePolygonOffset();
    }

}
