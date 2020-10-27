package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.plumbing.CommandHandler;
import net.minecraftforge.client.event.ClientChatEvent;

@SuppressWarnings("UnstableApiUsage")
public class ChatSuffix extends Module {

    public ChatSuffix() {
        super("ChatSuffix", false);
    }

    @Subscribe
    public void onClientChat(ClientChatEvent e) {
        if (e.getMessage().charAt(0) != CommandHandler.COMMAND_PREFIX && e.getMessage().charAt(0) != '/')
            e.setMessage(e.getOriginalMessage() + " | shitclient");
    }

}
