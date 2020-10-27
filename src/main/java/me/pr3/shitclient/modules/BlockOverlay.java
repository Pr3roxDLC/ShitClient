package me.pr3.shitclient.modules;




import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.utils.BlockUtils;
import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.RenderUtils;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;

public class BlockOverlay extends Module{

    public BlockOverlay(){

        super("BlockOverlay", true);


    }

    @Subscribe
    public void onRenderWorldLast(RenderWorldLastEvent e){
        BlockPos pos = mc.player.rayTrace(5, e.getPartialTicks()).getBlockPos();
        Block block = BlockUtils.getBlock(pos.getX(), pos.getY(), pos.getZ());
       if(block.isAir(block.getBlockState().getBaseState(),mc.world, pos))return;
        RenderUtils.drawOutlineBox((float)pos.getX(), (float)pos.getY(), (float)pos.getZ(), 1, 1 , 1 ,1 , 917248);
    }

}
