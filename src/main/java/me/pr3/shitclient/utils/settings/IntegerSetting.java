package me.pr3.shitclient.utils.settings;

public class IntegerSetting extends Setting{

    public int value = 0;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public IntegerSetting(int value, String name){

        this.value = value;
        this.name = name;


    }


}
