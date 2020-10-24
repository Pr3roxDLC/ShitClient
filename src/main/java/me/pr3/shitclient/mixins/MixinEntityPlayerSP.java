package me.pr3.shitclient.mixins;

import me.pr3.shitclient.plumbing.ModuleManager;
import me.pr3.shitclient.utils.Log;
import net.minecraft.client.entity.EntityPlayerSP;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityPlayerSP.class)
public class MixinEntityPlayerSP {

    @Shadow private int autoJumpTime;

    @Inject(method = "onUpdate", at = @At("HEAD"))
    public void onUpdate(CallbackInfo callbackInfo){

        if(ModuleManager.getModuleByName("NoJumpDelay").isEnabled()){

            autoJumpTime = 0;

            Log.info(Integer.toString(autoJumpTime));

        }

    }

}
