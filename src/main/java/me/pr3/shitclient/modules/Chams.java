package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.settings.BooleanSetting;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.client.event.RenderLivingEvent;
import org.lwjgl.opengl.GL11;

@SuppressWarnings("UnstableApiUsage")
public class Chams extends Module {

   BooleanSetting disableLightning = new BooleanSetting(false, "disableLightning");


    public Chams() {
        super("Chams", false);
        addSetting(new BooleanSetting(true, "disableLightning"));
    }

    @Subscribe
    public void onRenderLivingPre(RenderLivingEvent.Pre<? extends EntityLivingBase> event) {
        GL11.glEnable(GL11.GL_POLYGON_OFFSET_FILL);
        GlStateManager.enablePolygonOffset();
        if(((BooleanSetting)getSettingByName("disableLightning")).isValue()) {
            GlStateManager.disableLighting();
        }
        GlStateManager.doPolygonOffset(1.0F, -2000000);
    }

    @Subscribe
    public void onRenderLivingPost(RenderLivingEvent.Post<? extends EntityLivingBase> event) {
        GL11.glDisable(GL11.GL_POLYGON_OFFSET_FILL);
        GlStateManager.doPolygonOffset(1.0F, 2000000);
        if(((BooleanSetting)getSettingByName("disableLightning")).isValue()) {
            GlStateManager.enableLighting();
        }
        GlStateManager.disablePolygonOffset();
    }

}
