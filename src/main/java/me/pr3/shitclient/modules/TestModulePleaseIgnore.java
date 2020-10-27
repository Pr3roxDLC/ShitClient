package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.utils.ColorUtils;
import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.RenderUtils;
import me.pr3.shitclient.utils.settings.BooleanSetting;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.opengl.GL11;


import java.awt.*;

public class TestModulePleaseIgnore extends Module{

   public TestModulePleaseIgnore(){

       super("TMPI", true);
       addSetting(new BooleanSetting(true, "DummySetting1"));
       addSetting(new BooleanSetting(true, "DummySetting2"));

   }


   @Subscribe
    public void onRenderWorldLast(RenderWorldLastEvent e){

        AxisAlignedBB bb = new AxisAlignedBB(0, 10, 0 , 1, 11, 1);

        RenderUtils.drawFlledCube(bb, ColorUtils.RenderColor);

    }

}
