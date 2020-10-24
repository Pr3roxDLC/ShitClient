package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.RenderUtils;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import java.util.Objects;


public class BoxESP extends Module {

    public BoxESP(){
        super("BoxESP", true);

    }

    @Subscribe
    public void onWorldRenderLast(RenderWorldLastEvent e){

        for(Entity entity : mc.world.loadedEntityList) {

            RenderUtils.drawOutlineBox( (float)entity.posX - (float) mc.player.posX, (float)entity.posY - (float) mc.player.posY, (float)entity.posZ - (float) mc.player.posZ, entity.width, entity.height, entity.width, 1, 917248);

        }
    }

}
