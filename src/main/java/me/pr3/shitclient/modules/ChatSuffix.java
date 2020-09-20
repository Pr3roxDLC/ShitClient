package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraftforge.client.event.ClientChatEvent;

public class ChatSuffix extends Module{

    public ChatSuffix(){

        setName("ChatSuffix");
        setEnabled(true);

    }

    @Subscribe
    public void onClientChat(ClientChatEvent e ){

        if(e.getMessage().charAt(0) != '+' && e.getMessage().charAt(0) != '/') e.setMessage(e.getOriginalMessage() + " | shitclient");

    }

}
