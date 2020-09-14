package me.pr3.shitClient.modules;

public abstract class Module {
    public static boolean enabled = false;

    public void changeEnabled() {

        enabled =!enabled;

    }

}
