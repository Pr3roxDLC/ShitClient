package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@SuppressWarnings("UnstableApiUsage")
public class FastPlace extends Module {

    public FastPlace() {
        super("FastPlace", false);
    }

    @Subscribe
    public void onClientTick(TickEvent.ClientTickEvent e) {
        mc.rightClickDelayTimer = 0;
        
    }

}
