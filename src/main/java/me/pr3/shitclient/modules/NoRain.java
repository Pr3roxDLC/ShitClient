package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@SuppressWarnings("UnstableApiUsage")
public class NoRain extends Module {


    public NoRain() {
        super("NoRain", false);
    }

    @Subscribe
    public void onTick(TickEvent.ClientTickEvent e) {
        if (isInGame()) {
            if (mc.world.isRaining()) mc.world.setRainStrength(0.0f);
            if (mc.world.isThundering()) mc.world.setThunderStrength(0.0f);
        }
    }

}
