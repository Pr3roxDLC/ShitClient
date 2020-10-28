package me.pr3.shitclient.GUI;

import me.pr3.shitclient.modules.Module;
import me.pr3.shitclient.plumbing.ModuleManager;
import me.pr3.shitclient.utils.settings.Setting;
import net.minecraft.client.gui.GuiScreen;

import java.util.ArrayList;
import java.util.List;

public class GUISettingsPanel {

    public static RectWithText settingsPanelElement = (RectWithText) ClickGUI.guiElementList.get(0);
    public static List<Setting> settings = new ArrayList<Setting>();
    public static List<GUISettingsPanelButton> buttons = new ArrayList<GUISettingsPanelButton>();
    public static Module currentModule = ModuleManager.getModules().get(0);

    public static void updatePanel() {
        for (Module m : ModuleManager.getModules()) {
            if (m.getName().equalsIgnoreCase(settingsPanelElement.getStr())) {
                currentModule = m;
                break;
            }
        }

       settings = currentModule.getSettings();



    }







}
