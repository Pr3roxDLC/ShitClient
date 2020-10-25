package me.pr3.shitclient.plumbing;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.events.KeyPressEvent;
import me.pr3.shitclient.modules.*;
import me.pr3.shitclient.utils.Log;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiChat;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class ModuleManager {

    public static final Minecraft mc = Minecraft.getMinecraft();
    public static List<Module> modules = new ArrayList<>();


    public ModuleManager() {
        Main.BUS.register(this);
    }

    public static Module getModuleByName(String str) {
        for (Module mod : modules) {
            if (mod.getName().equalsIgnoreCase(str)) return mod;
        }
        return null;
    }

    public void initModules() {

        modules.add(new WaterMark());
        modules.add(new ESP());
        modules.add(new FullBright());
        modules.add(new NoRain());
        modules.add(new ModuleArrayList());
        modules.add(new ChatSuffix());
        modules.add(new NameTags());
        modules.add(new FastPlace());
        modules.add(new Chams());
        modules.add(new Scaffold());
        modules.add(new NoJumpDelay());
        modules.add(new Tracers());
        modules.add(new BoxESP());
        modules.add(new BlockOverlay());
        modules.add(new TileEntityESP());
        modules.add(new TestModulePleaseIgnore());

        modules.forEach(command -> Log.info("Registered Module: " + command.getName()));

    }

    public static List<Module> getModules() {
        return modules;
    }

    @Subscribe
    public void onKeyPressEvent(KeyPressEvent e) {

        Log.debug("KeyId: " + e.getKeyId());

        for (Module mod : modules) {
            if (mod.getKeyID() == e.getKeyId() && !(mc.currentScreen instanceof GuiChat)) {
                mod.setEnabled(!mod.isEnabled());
            }
        }

    }

}
