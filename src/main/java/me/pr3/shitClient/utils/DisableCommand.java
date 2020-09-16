package me.pr3.shitClient.utils;

import me.pr3.shitClient.modules.ModuleManager;

public class DisableCommand extends Command{


    public DisableCommand(){

        setName("disable");
        System.out.println("Registered disable Command");

    }

    @Override
    public void exec( String[] params ) {

        ModuleManager.getModuleByName(params[0]).setEnabled(false);

    }
}
