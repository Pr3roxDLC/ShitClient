package me.pr3.shitclient.mixins;

import me.pr3.shitclient.Main;
import me.pr3.shitclient.utils.Log;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiMainMenu.class)
public class MixinGuiMainMenu {

    @Mutable
    @Shadow @Final private static ResourceLocation[] TITLE_PANORAMA_PATHS;

    @Inject(method = "<init>", at = @At("RETURN"))
    public void initMainMenu(CallbackInfo callbackInfo){

        Log.info("Main Menu Initialized!!");

        TITLE_PANORAMA_PATHS[0] = new ResourceLocation("/panoramaNorth.png");
        TITLE_PANORAMA_PATHS[1] = new ResourceLocation("/panoramaNorth.png");
        TITLE_PANORAMA_PATHS[2] = new ResourceLocation("/panoramaNorth.png");
        TITLE_PANORAMA_PATHS[3] = new ResourceLocation("/panoramaNorth.png");
        TITLE_PANORAMA_PATHS[4] = new ResourceLocation("/panoramaNorth.png");
        TITLE_PANORAMA_PATHS[5] = new ResourceLocation("/panoramaNorth.png");


    }





}
