package me.pr3.shitclient.GUI;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.events.KeyPressEvent;
import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;

public class GuiManager {

    public GuiManager(){

        Main.BUS.register(this);

    }

    @Subscribe
    public void onKey(KeyPressEvent e){

        if(e.getKeyId() == Keyboard.KEY_Y){

            Minecraft.getMinecraft().displayGuiScreen(new ClickGUI());

        }else if(e.getKeyId() == Keyboard.KEY_ESCAPE){

            Minecraft.getMinecraft().currentScreen = null;

        }

    }

}
