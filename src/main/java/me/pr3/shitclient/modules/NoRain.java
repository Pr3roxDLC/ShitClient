package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.utils.Log;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoRain extends Module {


    public NoRain() {
        setName("NoRain");
        setEnabled(false);
    }

    @Override
    public void onEnable() {
        super.onEnable();
        Log.info("Enabled NoRain");
    }

    @Subscribe
    public void onTick(TickEvent.ClientTickEvent e) {
        if (mc.world != null) {
            if (mc.world.isRaining()) mc.world.setRainStrength(0.0f);
            if (mc.world.isThundering()) mc.world.setThunderStrength(0.0f);
        }
    }

}
