package me.pr3.shitclient;


import com.google.common.eventbus.EventBus;
import me.pr3.shitclient.plumbing.CommandHandler;
import me.pr3.shitclient.plumbing.EventManager;
import me.pr3.shitclient.plumbing.ModuleManager;
import me.pr3.shitclient.utils.Log;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.nio.file.Path;
import java.nio.file.Paths;

@Mod(modid = "shitclient", name = "shitclient", version = "1.0.0")
public class Main {

    public static final String MOD_ID = "shitclient";

    public static final EventBus BUS = new EventBus(MOD_ID);

    public static final Path clientDir = Paths.get(MOD_ID);

    public static ModuleManager mm = new ModuleManager();

    @EventHandler
    public void PreInit(FMLPreInitializationEvent event) {
        Log.info("FMLPreInitialization");
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        MinecraftForge.EVENT_BUS.register(new EventManager());
        BUS.register(new CommandHandler());

        BUS.register(mm);

        mm.initModules();

    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
        Log.info("FMLPostInitializationEvent");
    }

}
