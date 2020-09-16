package me.pr3.shitClient.modules;

import net.minecraft.client.Minecraft;

public class FullBright extends Module {

    private float gamma = 0;

    public FullBright(){

        setName("fullbright");


    }

    @Override
    public void onEnable() {
        super.onEnable();

        gamma = Minecraft.getMinecraft().gameSettings.gammaSetting;
        Minecraft.getMinecraft().gameSettings.gammaSetting = 100;
    }

    @Override
    public void onDisable() {
        super.onDisable();

        Minecraft.getMinecraft().gameSettings.gammaSetting = gamma;
    }
}
