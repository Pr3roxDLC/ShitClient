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

        if (e.getKeyId() == Keyboard.KEY_Y) {

            Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());

        } else if (e.getKeyId() == Keyboard.KEY_ESCAPE) {

            Minecraft.getMinecraft().currentScreen = null;

        }

    }


    @Subscribe
    public void onClick(GUIClickEvent e) {
        int i = 0;


        for (GUIElement element : ClickGUI.guiElementList) {

            Log.info(Integer.toString(i));


            if (e.getX() > ((RectWithText) element).getX() && e.getX() < ((RectWithText) element).getX() + ((RectWithText) element).getW()) {

                if (e.getY() > ((RectWithText) element).getY() && e.getY() < ((RectWithText) element).getY() + ((RectWithText) element).getH()) {

                    Log.info("Click on a Button : " + ((RectWithText) element).getStr());

                    ModuleManager.modules.get(i).setEnabled(!ModuleManager.modules.get(i).isEnabled());
                    if (ModuleManager.modules.get(i).isEnabled()) {
                        ((RectWithText) ClickGUI.guiElementList.get(i)).setC2(Color.LIGHT_GRAY);
                    } else {

                        ((RectWithText) ClickGUI.guiElementList.get(i)).setC2(Color.DARK_GRAY);
                    }

                    break;

                }
            }
            i++;
        }

    }

}
