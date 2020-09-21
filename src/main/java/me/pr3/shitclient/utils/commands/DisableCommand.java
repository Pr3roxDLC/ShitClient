package me.pr3.shitclient.utils.commands;

import me.pr3.shitclient.modules.Module;
import me.pr3.shitclient.modules.ModuleManager;
import me.pr3.shitclient.utils.Log;

public class DisableCommand extends Command {


    public DisableCommand() {

        setName("disable");
        Log.info("Registered disable Command");

    }

    @Override
    public void exec(String[] params) {

        Module mod = ModuleManager.getModuleByName(params[0]);
        if (mod != null) {
            mod.setEnabled(false);
        }
    }
}
