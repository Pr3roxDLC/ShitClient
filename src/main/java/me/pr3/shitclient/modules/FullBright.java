package me.pr3.shitclient.modules;

public class FullBright extends Module {

    private float gamma = 0;

    public FullBright() {
        setName("FullBright");
    }

    @Override
    public void onEnable() {
        gamma = mc.gameSettings.gammaSetting;
        mc.gameSettings.gammaSetting = 100;
    }

    @Override
    public void onDisable() {
        mc.gameSettings.gammaSetting = gamma;
    }

}
