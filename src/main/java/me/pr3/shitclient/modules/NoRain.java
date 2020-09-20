package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class NoRain extends Module{


    public NoRain(){
        setName("NoRain");
        setEnabled(false);

    }

    @Override
    public void onEnable() {
        super.onEnable();


        System.out.println("Enabled NoRain");

    }

    @Subscribe
    public void onTick(TickEvent.ClientTickEvent e){
if(Minecraft.getMinecraft().world != null) {
    if (Minecraft.getMinecraft().world.isRaining()) Minecraft.getMinecraft().world.setRainStrength(0.0f);
    if (Minecraft.getMinecraft().world.isThundering()) Minecraft.getMinecraft().world.setThunderStrength(0.0f);
}
    }

}
