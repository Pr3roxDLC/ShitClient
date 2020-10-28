package me.pr3.shitclient.GUI;

import me.pr3.shitclient.modules.Module;
import me.pr3.shitclient.plumbing.ModuleManager;
import me.pr3.shitclient.utils.settings.BooleanSetting;
import me.pr3.shitclient.utils.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GUISettingsPanel {

    public static RectWithText settingsPanelElement = (RectWithText) ClickGUI.guiElementList.get(0);
    public static List<Setting> settings = new ArrayList<Setting>();
    public static List<GUISettingsPanelButton> buttons = new ArrayList<GUISettingsPanelButton>();
    public static Module currentModule = ModuleManager.getModules().get(0);

    public static void updatePanel() {

        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        for (Module m : ModuleManager.getModules()) {
            if (m.getName().equalsIgnoreCase(settingsPanelElement.getStr())) {
                currentModule = m;
                break;
            }
        }

       settings = currentModule.getSettings();

        GUISettingsPanel.buttons.clear();
        int y = 37;
        for (Setting setting : GUISettingsPanel.settings) {

            if (setting instanceof BooleanSetting) {
                Minecraft.getMinecraft().fontRenderer.drawString(setting.name, sr.getScaledWidth() / 2 + 12, y, Color.GREEN.getRGB(), false);
                GUISettingsPanel.buttons.add(new GUISettingsPanelButton(sr.getScaledWidth() - 37 - 12,
                        y,
                        12,
                        12,
                        setting
                ));
            }
            y += 12;
        }

    }







}
