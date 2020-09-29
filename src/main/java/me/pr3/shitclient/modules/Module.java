package me.pr3.shitclient.modules;

import me.pr3.shitclient.Main;
import me.pr3.shitclient.utils.Log;
import net.minecraft.client.Minecraft;

@SuppressWarnings("UnstableApiUsage")
public abstract class Module {

    protected static final Minecraft mc = Minecraft.getMinecraft();

    private final String name;

    private boolean enabled;
    private int keyID;

    public Module(String name) {
        this(name, false, Integer.MIN_VALUE);
    }

    public Module(String name, boolean enabled) {
        this(name, enabled, Integer.MIN_VALUE);
    }

    public Module(String name, int keyID) {
        this(name, false, keyID);
    }

    public Module(String name, boolean enabled, int keyID) {
        this.name = name;
        this.enabled = enabled;
        this.keyID = keyID;
        if (enabled) {
            enable();
        } else {
            disable();
        }
    }

    protected boolean isInGame() {
        return mc.player != null && mc.world != null;
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

    public String getName() {
        return name;
    }

    public int getKeyID() {
        return keyID;
    }

    public void setKeyID(int keyID) {
        this.keyID = keyID;
    }

    public boolean isEnabled() {
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
            enable();
        } else {
            disable();
        }
    }

    private void enable() {
        onEnable();
        Main.BUS.register(this);
        Log.info("Module " + this.getName() + " was enabled!");
    }

    private void disable() {
        try {
            Main.BUS.unregister(this);
        } catch (IllegalArgumentException ignored) {
        }
        onDisable();
        Log.info("Module " + this.getName() + " was disabled!");
    }

}
