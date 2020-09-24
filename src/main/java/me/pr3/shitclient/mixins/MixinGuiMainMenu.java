package me.pr3.shitclient.mixins;

import me.pr3.shitclient.Main;
import me.pr3.shitclient.utils.Log;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import org.spongepowered.asm.mixin.*;
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



        TITLE_PANORAMA_PATHS[0] = new ResourceLocation("shitclient/skybox/panorama_0.png");
        TITLE_PANORAMA_PATHS[1] = new ResourceLocation("shitclient/skybox/panorama_1.png");
        TITLE_PANORAMA_PATHS[2] = new ResourceLocation("shitclient/skybox/panorama_2.png");
        TITLE_PANORAMA_PATHS[3] = new ResourceLocation("shitclient/skybox/panorama_3.png");
        TITLE_PANORAMA_PATHS[4] = new ResourceLocation("shitclient/skybox/panorama_4.png");
        TITLE_PANORAMA_PATHS[5] = new ResourceLocation("shitclient/skybox/panorama_5.png");



    }







}
