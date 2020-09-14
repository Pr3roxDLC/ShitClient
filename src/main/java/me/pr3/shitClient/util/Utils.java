package me.pr3.shitClient.util;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

public class Utils {

    private static Minecraft mc = Minecraft.getMinecraft();

    public static void faceEntity(Entity entity, int yaw, int pitch){

        Logger.logInfo("Facing " + entity.getName() );

        double diffX = entity.posX - mc.player.posX;
        double diffZ = entity.posZ - mc.player.posZ;

        double yDifference;

        if (entity instanceof EntityLivingBase)
        {
            EntityLivingBase entityLivingBase = (EntityLivingBase)entity;
            yDifference = entityLivingBase.posY + entityLivingBase.getEyeHeight() - (
                    mc.player.posY + mc.player.getEyeHeight());
        }
        else
        {
            yDifference = (entity.getEntityBoundingBox().minY + entity.getEntityBoundingBox().maxY) / 2.0D - (
                    mc.player.posY + mc.player.getEyeHeight());
        }

        double dist = MathHelper.sqrt(diffX * diffX + diffZ * diffZ);
        float rotationYaw = (float)(Math.atan2(diffZ, diffX) * 180.0D / Math.PI) - 90.0F;
        float rotationPitch = (float)-(Math.atan2(yDifference, dist) * 180.0D / Math.PI);

        if(yaw > 0) {
            mc.player.rotationYaw = updateRotation(mc.player.rotationYaw, rotationYaw, yaw / 4);
        }
        if(pitch > 0) {
            mc.player.rotationPitch = updateRotation(mc.player.rotationPitch, rotationPitch, pitch / 4);
        }

    }

    public static float updateRotation(float p_70663_1_, float p_70663_2_, float p_70663_3_) {
        float var4 = MathHelper.wrapDegrees(p_70663_2_ - p_70663_1_);
        if (var4 > p_70663_3_) {
            var4 = p_70663_3_;
        }
        if (var4 < -p_70663_3_) {
            var4 = -p_70663_3_;
        }
        return p_70663_1_ + var4;
    }

}
