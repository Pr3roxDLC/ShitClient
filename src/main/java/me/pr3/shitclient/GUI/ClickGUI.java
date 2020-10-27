package me.pr3.shitclient.GUI;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.modules.Module;
import me.pr3.shitclient.plumbing.ModuleManager;
import me.pr3.shitclient.utils.ColorUtils;
import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.RenderUtils;
import me.pr3.shitclient.utils.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import scala.collection.parallel.ParIterableLike;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ClickGUI extends GuiScreen {

    public static List<GUIElement> guiElementList = new ArrayList<GUIElement>();

    public ClickGUI() {

        Main.BUS.register(this);

        int i = 20;

        guiElementList.clear();
        for (Module m : ModuleManager.getModules()) {
            if (m.isEnabled())
                guiElementList.add(new RectWithText(20, i, Minecraft.getMinecraft().fontRenderer.getStringWidth(m.getName().toString()), 10, Color.GREEN, Color.LIGHT_GRAY, m.getName()));
            if (!m.isEnabled())
                guiElementList.add(new RectWithText(20, i, Minecraft.getMinecraft().fontRenderer.getStringWidth(m.getName().toString()), 10, Color.GREEN, Color.DARK_GRAY, m.getName()));

            i += 12;
        }

    }


    public static void renderModules() {

        if (Minecraft.getMinecraft().world == null) return;


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

    public void renderSettingsPanel(GUISettingsPanel guiSettingsPanel){

        ScaledResolution sr = new ScaledResolution(mc);

        if (Minecraft.getMinecraft().world == null) return;

        if (Minecraft.getMinecraft().currentScreen instanceof ClickGUI) {
            GuiScreen.drawRect(sr.getScaledWidth() - 23, 23, sr.getScaledWidth()  / 2 - 2 , sr.getScaledHeight() - 23, Color.GREEN.getRGB());
            GuiScreen.drawRect(sr.getScaledWidth() - 25, 25, sr.getScaledWidth()  / 2 , sr.getScaledHeight() - 25, Color.DARK_GRAY.getRGB());
            RenderUtils.drawLine(GUISettingsPanel.settingsPanelElement.getX() + GUISettingsPanel.settingsPanelElement.getW(),
                    GUISettingsPanel.settingsPanelElement.getY() + GUISettingsPanel.settingsPanelElement.getH()/2,
                    sr.getScaledWidth()/2,
                    sr.getScaledHeight()/2,
                    1,
                     ColorUtils.RenderColor);


            int y = 37;
            for(Setting setting : GUISettingsPanel.settings){
                Log.info("Drew A Setting Named " + setting.name );
                mc.fontRenderer.drawString(setting.name, sr.getScaledWidth()/ 2 + 12, y, Color.GREEN.getRGB(), false);
                y += 12;
            }
        }
    }


    @Subscribe
    public void onRenderGameOverlay(RenderGameOverlayEvent e) {

        if (e.getType() != RenderGameOverlayEvent.ElementType.TEXT) return;
        renderSettingsPanel(null);
        renderModules();





    }
}