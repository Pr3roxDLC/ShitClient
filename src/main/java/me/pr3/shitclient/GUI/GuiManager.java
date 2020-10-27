package me.pr3.shitclient.GUI;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.events.GUIClickEvent;
import me.pr3.shitclient.events.KeyPressEvent;
import me.pr3.shitclient.modules.Module;
import me.pr3.shitclient.plumbing.ModuleManager;
import me.pr3.shitclient.utils.Log;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Keyboard;

import java.awt.*;

public class GuiManager {

    public GuiManager() {

        Main.BUS.register(this);

    }

    @Subscribe
    public void onKey(KeyPressEvent e) {

        if (e.getKeyId() == Keyboard.KEY_Y && Minecraft.getMinecraft().currentScreen == null) {

            Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());

        } else if (e.getKeyId() == Keyboard.KEY_ESCAPE) {

            Minecraft.getMinecraft().currentScreen = null;

        }

    }


    @Subscribe
    public void onClick(GUIClickEvent e) {
        int i = 0;


        for (GUIElement element : ClickGUI.guiElementList) {




            if (e.getX() > ((RectWithText) element).getX() && e.getX() < ((RectWithText) element).getX() + ((RectWithText) element).getW()) {

                if (e.getY() > ((RectWithText) element).getY() && e.getY() < ((RectWithText) element).getY() + ((RectWithText) element).getH()) {



                    ModuleManager.modules.get(i).setEnabled(!ModuleManager.modules.get(i).isEnabled());


                    int j = 20;


                   ClickGUI.guiElementList.clear();
                    for (Module m : ModuleManager.getModules()) {
                        if (m.isEnabled())
                            ClickGUI.guiElementList.add(new RectWithText(20, j, Minecraft.getMinecraft().fontRenderer.getStringWidth(m.getName().toString()), 10, Color.GREEN, Color.LIGHT_GRAY, m.getName()));
                        if (!m.isEnabled())
                            ClickGUI.guiElementList.add(new RectWithText(20, j, Minecraft.getMinecraft().fontRenderer.getStringWidth(m.getName().toString()), 10, Color.GREEN, Color.DARK_GRAY, m.getName()));

                        j += 12;
                    }


                    break;

                }
            }
            i++;
        }

    }

}
