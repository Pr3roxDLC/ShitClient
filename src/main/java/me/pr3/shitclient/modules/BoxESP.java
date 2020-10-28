package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;

import me.pr3.shitclient.utils.ColorUtils;
import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.RenderUtils;
import me.pr3.shitclient.utils.settings.BooleanSetting;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.client.event.RenderWorldLastEvent;

import java.util.Objects;


public class BoxESP extends Module {

    public BoxESP(){
        super("BoxESP", false);

        addSetting(new BooleanSetting(false, "useOutlineBox"));

    }

    @Subscribe
    public void onWorldRenderLast(RenderWorldLastEvent e){

        for(Entity entity : mc.world.loadedEntityList) {
            if(!(entity instanceof EntityPlayerSP)) {
                if (((BooleanSetting) getSettingByName("useOutlineBox")).isValue()) {
                    RenderUtils.drawOutlineBox((float) entity.posX - entity.width / 2, (float) entity.posY, (float) entity.posZ - entity.width / 2, entity.width, entity.height, entity.width, 1, 917248);
                }else{
                    
                    RenderUtils.drawFlledCube(new AxisAlignedBB( entity.posX - entity.width / 2,  entity.posY,  entity.posZ - entity.width / 2,
                            entity.posX - entity.width / 2 + entity.width,  entity.posY + entity.height,  entity.posZ - entity.width / 2 + entity.width), ColorUtils.RenderColor);

                }
            }
        }
    }

}
