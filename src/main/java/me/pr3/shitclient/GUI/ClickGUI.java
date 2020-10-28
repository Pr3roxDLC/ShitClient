package me.pr3.shitclient.GUI;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.modules.Module;
import me.pr3.shitclient.plumbing.ModuleManager;
import me.pr3.shitclient.utils.ColorUtils;
import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.RenderUtils;
import me.pr3.shitclient.utils.settings.BooleanSetting;
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

    public void renderSettingsPanel(GUISettingsPanel guiSettingsPanel) {

        ScaledResolution sr = new ScaledResolution(mc);

        if (Minecraft.getMinecraft().world == null) return;

        if (Minecraft.getMinecraft().currentScreen instanceof ClickGUI) {
            GuiScreen.drawRect(sr.getScaledWidth() - 23, 23, sr.getScaledWidth() / 2 - 2, sr.getScaledHeight() - 23, Color.GREEN.getRGB());
            GuiScreen.drawRect(sr.getScaledWidth() - 25, 25, sr.getScaledWidth() / 2, sr.getScaledHeight() - 25, Color.DARK_GRAY.getRGB());
            RenderUtils.drawLine(GUISettingsPanel.settingsPanelElement.getX() + GUISettingsPanel.settingsPanelElement.getW(),
                    GUISettingsPanel.settingsPanelElement.getY() + GUISettingsPanel.settingsPanelElement.getH() / 2,
                    sr.getScaledWidth() / 2,
                    sr.getScaledHeight() / 2,
                    1,
                    ColorUtils.RenderColor);

            GUISettingsPanel.buttons.clear();
            int y = 37;
            for (Setting setting : GUISettingsPanel.settings) {

                if (setting instanceof BooleanSetting) {
                    mc.fontRenderer.drawString(setting.name, sr.getScaledWidth() / 2 + 12, y, Color.GREEN.getRGB(), false);
                    GUISettingsPanel.buttons.add(new GUISettingsPanelButton(sr.getScaledWidth() - 37 - 12,
                            y,
                            12,
                            12,
                            setting
                    ));
                }
                y += 12;
            }

            for(GUISettingsPanelButton button: GUISettingsPanel.buttons){
                int x1 = button.x;
                int y1 = button.y;
                int x2 = button.x + button.w;
                int y2 = button.y + button.h;
                GuiScreen.drawRect(x1, y1, x2, y2, Color.GREEN.getRGB());
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