package me.pr3.shitclient.modules;

import ca.weblite.objc.Client;
import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class FastPlace extends Module {

    public FastPlace(){

        setName("FastPlace");
        setEnabled(true);

    }

    @Subscribe
    public void onClientTick(TickEvent.ClientTickEvent e){

    Minecraft.getMinecraft().rightClickDelayTimer = 0;

    }


}
