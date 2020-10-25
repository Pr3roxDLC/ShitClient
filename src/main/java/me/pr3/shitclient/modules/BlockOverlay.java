package me.pr3.shitclient.modules;




import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.RenderUtils;
import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class BlockOverlay extends Module{

    public BlockOverlay(){

        super("BlockOverlay", true);

    }

    @Subscribe
    public void onRenderWorldLast(RenderWorldLastEvent e){
        BlockPos pos = mc.player.rayTrace(5, e.getPartialTicks()).getBlockPos();
        RenderUtils.drawOutlineBox((float)pos.getX() - (float)mc.player.posX, (float)pos.getY() - (float)mc.player.posY, (float)pos.getZ() - (float)mc.player.posZ, 1, 1 , 1 ,1 , 917248);
    }

}
