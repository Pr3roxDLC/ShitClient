package me.pr3.shitclient.utils;

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






}
