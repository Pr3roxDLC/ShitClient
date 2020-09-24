package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.utils.Log;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ModuleArrayList extends Module {







    public ModuleArrayList() {

        setEnabled(true);
        setName("ModuleArrayList");




    }

    @Subscribe
    public void onRender(RenderGameOverlayEvent e) {

        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());


        List<String> str =new  ArrayList<String>();

        for (Module m : Main.mm.getModules()) {

            if (m.getEnabled()) {
                str.add(m.getName());

            }

        }
        int y = 5;
        for(String modulestr : str) {
            int x = 0;

            x=sr.getScaledWidth()  - Minecraft.getMinecraft().fontRenderer.getStringWidth(modulestr);

            Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(modulestr, x -5  , y, -1);

            y += 12;
        }
        //Rebind ICONS texture to not fuck up the Hot Bar
        Minecraft.getMinecraft().getTextureManager().bindTexture(Gui.ICONS);


    }


}
