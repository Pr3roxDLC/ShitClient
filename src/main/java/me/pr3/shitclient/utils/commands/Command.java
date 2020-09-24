package me.pr3.shitclient.utils.commands;

import java.util.List;

public abstract class Command {

    private String name = "unnamed";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void exec(List<String> params) {

    }

}
