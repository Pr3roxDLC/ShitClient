package me.pr3.shitclient.utils;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class BlockUtils {


    public static void scaffoldPlacer(BlockPos pos){



    }

    private static Vec3d getEyePos(){

        return new Vec3d(Minecraft.getMinecraft().player.posX, Minecraft.getMinecraft().player.posY + Minecraft.getMinecraft().player.eyeHeight, Minecraft.getMinecraft().player.posZ);

    }

    public static Block getBlock(int x, int y, int z){
        BlockPos pos = new BlockPos(x, y, z);
        IBlockState ibs = Minecraft.getMinecraft().world.getBlockState(pos);
        Block block = ibs.getBlock();
        return block;
    }




}
