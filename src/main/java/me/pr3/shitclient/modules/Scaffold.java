package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class Scaffold extends Module {


    public Scaffold() {
        super("Scaffold", false, Keyboard.KEY_I);
    }

    @Subscribe
    public void onClientTick(TickEvent.ClientTickEvent e){
        if(mc.world == null) return;
        Vec3d vec = new Vec3d(mc.player.posX, mc.player.posY, mc.player.posZ);
        BlockPos blockPos = new BlockPos(vec).down();



       mc.playerController.processRightClickBlock(mc.player, mc.world, blockPos, EnumFacing.UP, new Vec3d(0.0,0.0,0.0), EnumHand.MAIN_HAND);

    }



}
