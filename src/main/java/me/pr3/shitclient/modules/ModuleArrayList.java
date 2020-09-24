package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class ModuleArrayList extends Module {

    public ModuleArrayList() {
        super("ModuleArrayList", true);
    }

    @Subscribe
    public void onRender(RenderGameOverlayEvent e) {

        ScaledResolution sr = new ScaledResolution(mc);

        List<String> activeModules = new ArrayList<>();

        for (Module m : Main.mm.getModules()) {
            if (m.isEnabled()) {
                activeModules.add(m.getName());
            }
        }

        int y = 5;
        for (String name : activeModules) {
            int x = sr.getScaledWidth() - mc.fontRenderer.getStringWidth(name);
            mc.fontRenderer.drawStringWithShadow(name, x - 5, y, -1);
            y += 12;
        }

        //Rebind ICONS texture to not fuck up the Hot Bar
        mc.getTextureManager().bindTexture(Gui.ICONS);

    }

}
