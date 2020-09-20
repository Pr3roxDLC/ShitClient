package me.pr3.shitclient.utils.commands;

import me.pr3.shitclient.modules.Module;
import me.pr3.shitclient.modules.ModuleManager;

public class DisableCommand extends Command {


    public DisableCommand() {

        setName("disable");
        System.out.println("Registered disable Command");

    }

    @Override
    public void exec(String[] params) {

        Module mod = ModuleManager.getModuleByName(params[0]);
        if (mod != null) {
            mod.setEnabled(false);
        }
    }
}
