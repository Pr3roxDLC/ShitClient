package me.pr3.shitclient.utils.settings;

public class BooleanSetting extends Setting {

    public boolean value = false;

    public boolean isValue() {
        return value;
    }

    public void setValue(boolean value) {
        this.value = value;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    public BooleanSetting(boolean value, String name){

        this.value = value;
        this.name = name;

    }

}
