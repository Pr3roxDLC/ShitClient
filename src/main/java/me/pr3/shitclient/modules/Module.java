package me.pr3.shitclient.modules;

import me.pr3.shitclient.Main;
import me.pr3.shitclient.utils.Log;
import net.minecraft.client.Minecraft;

@SuppressWarnings("UnstableApiUsage")
public abstract class Module {

    protected static final Minecraft mc = Minecraft.getMinecraft();

    private boolean enabled = false;
    private int keyID = 0;
    private String name = "unnamed";

    public int getKeyID() {
        return keyID;
    }

    public void setKeyID(int keyID) {
        this.keyID = keyID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Overwrite this to execute logic on enable!
     */
    protected void onEnable() {
    }

    /**
     * Overwrite this to execute logic on disable!
     */
    protected void onDisable() {
    }

    protected boolean isInGame() {
        return mc.player != null && mc.world != null;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean state) {
        if (this.enabled == state) {
            return;
        }
        // uncomment if local chat is implemented:
        // Log.info((state ? ChatFormatting.GREEN : ChatFormatting.RED) + name + ChatFormatting.RESET, true);
        this.enabled = state;
        if (state) {
            Main.BUS.register(this);
            onEnable();
            Log.info("Module " + this.getName() + " was enabled!");
        } else {
            Main.BUS.unregister(this);
            onDisable();
            Log.info("Module " + this.getName() + " was disabled!");
        }
    }

}
