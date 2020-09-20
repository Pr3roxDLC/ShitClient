package me.pr3.shitclient.modules;

import me.pr3.shitclient.Main;

public abstract class Module {

    private boolean enabled = false;
    private String name = "unnamed";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


        public void setEnabled(boolean enabled){

            this.enabled = enabled;

            if(enabled){

                 Main.BUS.register(this);
                onEnable();
                System.out.println(this.getName() + " was enabled!");


            }else if(!enabled){
                Main.BUS.register(this);
                Main.BUS.unregister(this);
                onDisable();
                System.out.println(this.getName() + " was disabled!");

            }




    }

    public void onEnable(){


    }

    public void onDisable(){



    }

    public boolean getEnabled(){

        return enabled;

    }

}
