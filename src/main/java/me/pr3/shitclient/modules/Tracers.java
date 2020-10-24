package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.utils.RenderUtils;
import net.minecraft.entity.Entity;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class Tracers extends Module {

    public Tracers(){

        super("Tracers", false);

    }

    @Subscribe
    public void onRenderGameOverlay(RenderWorldLastEvent e){

        for(Entity entity : mc.world.loadedEntityList) {
            RenderUtils.drawLine3D(0, 0, 0, (float)entity.posX - (float)mc.player.posX , (float)entity.posY - (float)mc.player.posY + entity.getEyeHeight() , (float)entity.posZ -  (float)mc.player.posZ, 1, 917248);
        }
    }

}
