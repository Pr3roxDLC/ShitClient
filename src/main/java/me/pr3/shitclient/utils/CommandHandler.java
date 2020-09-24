package me.pr3.shitclient.utils;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.utils.commands.Command;
import me.pr3.shitclient.utils.commands.DisableCommand;
import me.pr3.shitclient.utils.commands.EnableCommand;
import me.pr3.shitclient.utils.commands.ToggleCommand;
import net.minecraftforge.client.event.ClientChatEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SuppressWarnings("UnstableApiUsage")
public class CommandHandler {

    public static final char COMMAND_PREFIX = '+';
    public static List<Command> commands = new ArrayList<>();

    public CommandHandler() {

        Log.info("Started Command Initialization");

        Main.BUS.register(this);

        commands.add(new EnableCommand());
        commands.add(new DisableCommand());
        commands.add(new ToggleCommand());

        commands.forEach(command -> Log.info("Registered Command: " + command.getName()));

    }

    public void runCommand(String commandStr, List<String> params) {

        for (Command cmd : commands) {
            if (cmd.getName().equalsIgnoreCase(commandStr)) cmd.exec(params);
        }

    }

    @Subscribe
    public void onChat(ClientChatEvent event) {

        if (event.getMessage().charAt(0) == COMMAND_PREFIX) {
            List<String> parts = Arrays.asList(event.getMessage().substring(1).split(" "));
            runCommand(parts.get(0), parts.subList(1, parts.size()));
            event.setCanceled(true);
        }

    }

}
