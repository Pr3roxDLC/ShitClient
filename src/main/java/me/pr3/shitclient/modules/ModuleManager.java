package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.events.KeyPressEvent;

import java.util.ArrayList;
import java.util.List;

public class ModuleManager {

    public static List<Module> modules = new ArrayList<Module>();

    public ModuleManager(){

        Main.BUS.register(this);

    }

    public void initModules() {



        modules.add(new WaterMark());
        modules.add(new ESP());
        modules.add(new FullBright());
        modules.add(new NoRain());
        modules.add(new ModuleArrayList());
        modules.add(new ChatSuffix());
        modules.add(new NameTags());

    }

    public List<Module> getModules() {
        return modules;
    }

    public static Module getModuleByName(String str){

        for(Module m : modules){

            if(m.getName().equalsIgnoreCase(str)) return m;

        }

        return null;

    }

    @Subscribe
    public void onKeyPressEvent(KeyPressEvent e){

        for(Module m: modules){

            if(m.getKeyID() == e.getKeyID()){




                m.setEnabled(!m.getEnabled());

            }

        }

    }






}
