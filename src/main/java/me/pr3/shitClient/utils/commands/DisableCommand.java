package me.pr3.shitClient.utils.commands;

import me.pr3.shitClient.modules.Module;
import me.pr3.shitClient.modules.ModuleManager;

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
