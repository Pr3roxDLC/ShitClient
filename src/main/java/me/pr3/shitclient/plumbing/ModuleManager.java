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

    public static final Minecraft MC = Minecraft.getMinecraft();
    private static final List<Module> modules = new ArrayList<>();

    public ModuleManager() {
        Main.BUS.register(this);
    }

    public static Module getModuleByName(String str) {

        for (Module m : modules) {
            if (m.getName().equalsIgnoreCase(str)) return m;
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

        modules.forEach(command -> Log.info("Registered Module: " + command.getName()));

    }

    public static List<Module> getModules() {
        return modules;
    }

    @Subscribe
    public void onKeyPressEvent(KeyPressEvent e) {

        for (Module m : modules) {
            if (m.getKeyID() == e.getKeyID() && !(MC.currentScreen instanceof GuiChat)) {
                m.setEnabled(!m.getEnabled());
            }
        }

    }

}
