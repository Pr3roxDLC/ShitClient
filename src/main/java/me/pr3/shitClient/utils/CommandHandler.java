package me.pr3.shitClient.utils;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitClient.Main;
import net.minecraftforge.client.event.ClientChatEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandHandler {

    public static List<Command> commands = new ArrayList<Command>();

    public CommandHandler() {
        System.out.println("Started Command Initialiation");

        Main.BUS.register(this);

        commands.add(new EnableCommand());
        commands.add(new DisableCommand());

    }

    public void runCommand(String commandStr, String[] params){


        for(Command cmd : commands){

            if(cmd.getName().equalsIgnoreCase(commandStr)) cmd.exec( params);

        }



    }


    @Subscribe
    public void onChat(ClientChatEvent e) {


        if (e.getMessage().charAt(0) == '+') {


            String str = e.getMessage();


            str = str.substring(1);

            String[] subStrings = str.split(" ");
            String cmd = subStrings[0];

            subStrings = Arrays.copyOfRange(subStrings, 1, subStrings.length);

            for(String str2: subStrings)

            System.out.println(str2);

runCommand(cmd, subStrings);


        }

    }


}
