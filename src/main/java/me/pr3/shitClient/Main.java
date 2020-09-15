package me.pr3.shitClient;


import com.google.common.eventbus.EventBus;
import me.pr3.shitClient.events.EventManager;
import me.pr3.shitClient.modules.ModuleManager;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.ArrayList;
import java.util.List;

@Mod(modid = "shitclient", name = "ShitClient", version = "1.0.0" )
public class Main {

	public static final String MOD_ID = "shitclient";



	public static final EventBus BUS = new EventBus(MOD_ID);






	
	@EventHandler
	public  void PreInit(FMLPreInitializationEvent event) {



	}


	@EventHandler
	public void init(FMLInitializationEvent event) {


		MinecraftForge.EVENT_BUS.register(new EventManager());

		ModuleManager.initModules();



	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent event) {
		
	}











}
