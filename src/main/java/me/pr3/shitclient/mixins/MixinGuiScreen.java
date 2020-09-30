package me.pr3.shitclient.mixins;

import me.pr3.shitclient.GUI.ClickGUI;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.events.GUIClickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.io.IOException;

@Mixin(GuiScreen.class)
public class MixinGuiScreen {

    @Inject(method = "mouseReleased", at = @At("HEAD"))
    public void mouseReleased(int mouseX, int mouseY, int state, CallbackInfo callbackInfo) throws IOException{

        if(Minecraft.getMinecraft().currentScreen instanceof ClickGUI)
            Main.BUS.post(new GUIClickEvent(mouseX, mouseY, state));

    }

}
