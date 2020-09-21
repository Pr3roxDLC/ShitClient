package me.pr3.shitclient.utils.commands;

import me.pr3.shitclient.modules.Module;
import me.pr3.shitclient.modules.ModuleManager;
import me.pr3.shitclient.utils.Log;

public class EnableCommand extends Command {

    public EnableCommand(){

        setName("enable");
        Log.info("Registered enable Command");

    }

    @Override
    public void exec( String[] params ) {


        Module mod = ModuleManager.getModuleByName(params[0]);
        if (mod != null) {
            mod.setEnabled(true);
        }

    }
}
