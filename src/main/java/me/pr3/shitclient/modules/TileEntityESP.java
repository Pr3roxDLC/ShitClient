package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.utils.RenderUtils;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class TileEntityESP extends Module {

    public TileEntityESP(){

        super("TileEntityESP", false);

    }

    @Subscribe
    public void onRenderWorldLast(RenderWorldLastEvent e){

        for(TileEntity te : mc.world.loadedTileEntityList){

            RenderUtils.drawOutlineBox((float)te.getPos().getX(), (float)te.getPos().getY(), (float)te.getPos().getZ(), 1, 1, 1,1,917248);

        }

    }


}
