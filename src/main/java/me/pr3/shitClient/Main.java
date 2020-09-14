package me.pr3.shitClient;



import me.pr3.shitClient.modules.AimBot;
import me.pr3.shitClient.modules.ESP;
import me.pr3.shitClient.modules.FullBright;
import me.pr3.shitClient.modules.WaterMark;
import me.pr3.shitClient.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

import java.io.File;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION )
public class Main {

	public static AimBot ab = new AimBot();
	public static ESP esp = new ESP();
	public static FullBright fb = new FullBright();
	public static WaterMark wm = new WaterMark();



	@Instance
	public static Main instance;



	
	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event) {



	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event) {
		//MinecraftForge.EVENT_BUS.register(new MyEventHandler());
		//MinecraftForge.EVENT_BUS.register(new BlockPlacer());
		MinecraftForge.EVENT_BUS.register(new CommandHandler());
		MinecraftForge.EVENT_BUS.register(me.pr3.shitClient.eventHandler.EventHandler.class);

	}
	
	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event) {
		
	}
	
	
	
	
}
