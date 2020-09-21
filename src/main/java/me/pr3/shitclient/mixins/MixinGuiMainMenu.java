package me.pr3.shitclient.mixins;

import me.pr3.shitclient.utils.Log;
import net.minecraft.client.gui.GuiMainMenu;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public class MixinGuiMainMenu {

    @Inject(method = "<init>", at = @At("RETURN"))
    public void initMainMenu(CallbackInfo callbackInfo){

        Log.info("Main Menu Initialized!!");

    }





}
