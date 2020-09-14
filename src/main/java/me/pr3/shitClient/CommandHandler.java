package me.pr3.shitClient;



import me.pr3.shitClient.modules.ESP;
import me.pr3.shitClient.modules.FullBright;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.ClientChatEvent;
import net.minecraftforge.client.event.EntityViewRenderEvent.RenderFogEvent;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;


public class CommandHandler {

	
	
	public CommandHandler() {

		System.out.println("Registered CommandHandler");
	}
	
	
	
	
	@SubscribeEvent
	public void onChat(ClientChatEvent e) {
		
		
		
		if(e.getMessage().charAt(0) == '+') {

			String messageWithPrefix = e.getMessage();
			String messageNoPrefix = messageWithPrefix.substring(1);
			System.out.println("Client executed command " + messageNoPrefix);
			
			switch(messageNoPrefix) {
			
			case "esp":
				ESP.ChangeEnable();
			break;
			case "fullbright":
				FullBright.ChangeEnabled();
				
				
			
			}
			
		}
	}

}
