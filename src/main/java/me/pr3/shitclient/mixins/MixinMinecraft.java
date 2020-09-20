package me.pr3.shitclient.mixins;

import me.pr3.shitclient.Main;
import me.pr3.shitclient.events.KeyPressEvent;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {

    @Inject(method = "dispatchKeypresses", at = @At("HEAD"))
    public void onDispatchKeypresses(CallbackInfo callbackInfo) {

        int i = Keyboard.getEventKey() == 0 ? Keyboard.getEventCharacter() + 256 : Keyboard.getEventKey();
        if(Keyboard.getEventKeyState()) {
            KeyPressEvent e = new KeyPressEvent(i);
            Main.BUS.post(e);
        }



    }

}
