package me.pr3.shitclient.modules;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static List<Module> modules = new ArrayList<Module>();

    public static void initModules() {

        modules.add(new WaterMark());
        modules.add(new ESP());
        modules.add(new FullBright());
        modules.add(new NoRain());
        modules.add(new ModuleArrayList());
        modules.add(new ChatSuffix());
        modules.add(new NameTags());

    }

    public static List<Module> getModules() {
        return modules;
    }

    public static Module getModuleByName(String str){

        for(Module m : modules){

            if(m.getName().equalsIgnoreCase(str)) return m;

        }

        return null;

    }






}
