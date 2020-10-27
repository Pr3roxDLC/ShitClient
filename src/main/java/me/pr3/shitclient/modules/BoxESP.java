package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;

import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.RenderUtils;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import java.util.Objects;


public class BoxESP extends Module {

    public BoxESP(){
        super("BoxESP", false);

    }

    @Subscribe
    public void onWorldRenderLast(RenderWorldLastEvent e){

        for(Entity entity : mc.world.loadedEntityList) {
            if(!(entity instanceof EntityPlayerSP)) {
                RenderUtils.drawOutlineBox((float) entity.posX - (float) mc.getRenderManager().viewerPosX - entity.width / 2, (float) entity.posY - (float) mc.getRenderManager().viewerPosY, (float) entity.posZ - (float) mc.getRenderManager().viewerPosZ - entity.width / 2, entity.width, entity.height, entity.width, 1, 917248);
            }
        }
    }

}
