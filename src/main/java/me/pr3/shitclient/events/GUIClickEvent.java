package me.pr3.shitclient.events;

import me.pr3.shitclient.utils.Log;

public class GUIClickEvent {

    private int x, y;



    private int mouseButton;

    public GUIClickEvent(int x, int y, int mouseButton){

        Log.info("Click");

        this.mouseButton = mouseButton;
        this.x = x;
        this.y = y;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) { this.x = x; }

    public int getY() { return y; }

    public void setY(int y) { this.y = y; }

    public int getMouseButton() { return mouseButton;}

    public void setMouseButton(int mouseButton) { this.mouseButton = mouseButton; }


}
