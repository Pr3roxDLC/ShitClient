package me.pr3.shitClient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.Sys;

public class NoRain extends Module{

    public NoRain(){
        setName("norain");
        setEnabled(false);

    }

    @Override
    public void onEnable() {
        super.onEnable();


        System.out.println("Enabled NoRain");

    }

    @Subscribe
    public void onTick(TickEvent.ClientTickEvent e){

        if(Minecraft.getMinecraft().world.isRaining()) Minecraft.getMinecraft().world.setRainStrength(0.0f);
        if(Minecraft.getMinecraft().world.isThundering()) Minecraft.getMinecraft().world.setThunderStrength(0.0f);

    }

}
