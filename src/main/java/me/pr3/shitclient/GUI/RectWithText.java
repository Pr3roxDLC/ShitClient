package me.pr3.shitclient.GUI;

import java.awt.*;

public class RectWithText extends GUIElement {

    private int x , y, w, h;
    private Color c, c2;
    private String str;

    public RectWithText(int x, int y, int w, int h, Color c, Color c2, String str){

    this.x = x;
    this.y = y;
    this.w = w;
    this.h = h;
    this.c = c;
    this.c2 = c2;
    this.str = str;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public Color getC2() {
        return c2;
    }

    public void setC2(Color c2) {
        this.c2 = c2;
    }
}
