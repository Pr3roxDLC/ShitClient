package me.pr3.shitclient.GUI;

import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.settings.Setting;

public class GUISettingsPanelButton {
    public int x,y,w,h;
    public Setting setting;

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }



    public GUISettingsPanelButton(int x, int y, int w, int h, Setting setting){



        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.setting = setting;

    }






}
