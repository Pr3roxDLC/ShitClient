package me.pr3.shitClient.utils.commands;

import me.pr3.shitClient.modules.Module;
import me.pr3.shitClient.modules.ModuleManager;

public class EnableCommand extends Command {

    public EnableCommand(){

        setName("enable");
        System.out.println("Registered enable Command");

    }

    @Override
    public void exec( String[] params ) {


        Module mod = ModuleManager.getModuleByName(params[0]);
        if (mod != null) {
            mod.setEnabled(true);
        }

    }
}
