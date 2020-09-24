package me.pr3.shitclient.mixins;

import io.netty.channel.ChannelHandlerContext;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.events.PacketEvent;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// see cookiedragons 24/7 forge support: https://forums.minecraftforge.net/topic/74173-on-packet-sendrecieve-events/

@SuppressWarnings("UnstableApiUsage")
@Mixin(NetworkManager.class)
public class MixinNetworkManager {

    @Inject(method = "channelRead0", at = @At("HEAD"), cancellable = true)
    private void onChannelRead(ChannelHandlerContext context, Packet<?> packet, CallbackInfo callbackInfo) {
        PacketEvent event = new PacketEvent.In(packet);
        Main.BUS.post(event);
        if (event.isCanceled()) {
            callbackInfo.cancel();
        }
    }

    @Inject(method = "sendPacket(Lnet/minecraft/network/Packet;)V", at = @At("HEAD"), cancellable = true)
    private void onSendPacket(Packet<?> packet, CallbackInfo callbackInfo) {
        PacketEvent event = new PacketEvent.Out(packet);
        Main.BUS.post(event);
        if (event.isCanceled()) {
            callbackInfo.cancel();
        }
    }

}
