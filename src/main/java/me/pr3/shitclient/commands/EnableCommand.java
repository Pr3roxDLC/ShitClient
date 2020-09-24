package me.pr3.shitclient.commands;

import me.pr3.shitclient.modules.Module;
import me.pr3.shitclient.plumbing.ModuleManager;

import java.util.List;

public class EnableCommand extends Command {

    public EnableCommand() {
        setName("enable");
    }

    @Override
    public void exec(List<String> params) {

        Module mod = ModuleManager.getModuleByName(params.get(0));
        if (mod != null) {
            mod.setEnabled(true);
        }

    }

}
