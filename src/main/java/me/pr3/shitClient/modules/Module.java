package me.pr3.shitClient.modules;

import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class Module {

    private boolean enabled = false;
    private String name = "unnamed";


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void onRender(RenderGameOverlayEvent e){



    }

    public void onUpdate(TickEvent.ClientTickEvent e){



    }


    public void setEnabled(boolean enabled){

        this.enabled = enabled;

    }

    public boolean getEnabled(){

        return enabled;

    }

}
