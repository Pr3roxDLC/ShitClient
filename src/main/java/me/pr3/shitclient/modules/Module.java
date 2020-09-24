package me.pr3.shitclient.modules;

import me.pr3.shitclient.Main;
import me.pr3.shitclient.utils.Log;
import net.minecraft.client.Minecraft;

public abstract class Module {

    protected static final Minecraft mc = Minecraft.getMinecraft();

    private boolean enabled = false;
    private int keyID = 0;
    private String name = "unnamed";

    public int getKeyID() {
        return keyID;
    }

    public void setKeyID(int keyID) {
        this.keyID = keyID;
    }

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
                Log.info(this.getName() + " was enabled!");


            }else if(!enabled){
                Main.BUS.register(this);
                Main.BUS.unregister(this);
                onDisable();
                Log.info(this.getName() + " was disabled!");

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
