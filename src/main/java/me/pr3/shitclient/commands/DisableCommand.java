package me.pr3.shitclient.commands;

import me.pr3.shitclient.modules.Module;
import me.pr3.shitclient.modules.ModuleManager;

import java.util.List;

public class DisableCommand extends Command {

    public DisableCommand() {
        setName("disable");
    }

    @Override
    public void exec(List<String> params) {

        Module mod = ModuleManager.getModuleByName(params.get(0));
        if (mod != null) {
            mod.setEnabled(false);
        }

    }

}
