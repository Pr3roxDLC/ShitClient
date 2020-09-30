package me.pr3.shitclient.GUI;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.modules.Module;
import me.pr3.shitclient.plumbing.ModuleManager;
import me.pr3.shitclient.utils.Log;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import scala.collection.parallel.ParIterableLike;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClickGUI extends GuiScreen {

    public static List<GUIElement> guiElementList = new ArrayList<GUIElement>();

    public ClickGUI() {

        Main.BUS.register(this);

        int i = 20;

        for (Module m : ModuleManager.getModules()) {
            guiElementList.add(new RectWithText(i, 40, 60, 20, Color.GREEN, Color.gray, m.getName()));
            i += 70;
        }

    }


    @Subscribe
    public void onRenderGameOverlay(RenderGameOverlayEvent e) {
        if (Minecraft.getMinecraft().world == null) return;
        if (e.getType() != RenderGameOverlayEvent.ElementType.TEXT) return;


        if (Minecraft.getMinecraft().currentScreen instanceof ClickGUI) {
            for (GUIElement element : ClickGUI.guiElementList) {

                if (element instanceof RectWithText) {

                    int x1 = ((RectWithText) element).getX();
                    int y1 = ((RectWithText) element).getY();
                    int x2 = ((RectWithText) element).getX() + ((RectWithText) element).getW();
                    int y2 = ((RectWithText) element).getY() + ((RectWithText) element).getH();

                    int c = ((RectWithText) element).getC().getRGB();
                    int c2 = ((RectWithText) element).getC2().getRGB();

                    GuiScreen.drawRect(x1 - 2, y1 - 2, x2 + 2, y2 + 2, c);
                    GuiScreen.drawRect(x1, y1, x2, y2, c2);
                    Minecraft.getMinecraft().fontRenderer.drawString(((RectWithText) element).getStr(),
                            ((RectWithText) element).getX() - Minecraft.getMinecraft().fontRenderer.getStringWidth(((RectWithText) element).getStr()) / 2 + ((RectWithText) element).getW() / 2,
                            ((RectWithText) element).getY() - Minecraft.getMinecraft().fontRenderer.FONT_HEIGHT / 2 + ((RectWithText) element).getH() / 2,
                            Color.black.getRGB());


                }


            }
        }
    }

}
