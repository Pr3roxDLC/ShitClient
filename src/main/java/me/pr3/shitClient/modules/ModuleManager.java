package me.pr3.shitClient.modules;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import scala.actors.threadpool.Arrays;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ModuleManager {

    public static List<Module> modules = new ArrayList<Module>();

    public static void initModules() {

        modules.add(new WaterMark());
        modules.add(new ESP());

    }

    public static List<Module> getModules() {
        return modules;
    }


    public static void onRender(RenderGameOverlayEvent e) {

        for (Module m : modules) {
            if (m.getEnabled()) {
                m.onRender(e);
            }
        }

    }

    public static void onUpdate(TickEvent.ClientTickEvent e) {

        for (Module m : modules) {
            if (m.getEnabled()) {
                m.onUpdate(e);
            }
        }

    }




}
