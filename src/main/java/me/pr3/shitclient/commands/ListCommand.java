package me.pr3.shitclient.commands;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.pr3.shitclient.plumbing.CommandHandler;
import me.pr3.shitclient.plumbing.ModuleManager;
import me.pr3.shitclient.utils.Log;

import java.util.List;

public class ListCommand extends Command {

    public ListCommand() {
        setName("list");
    }

    @Override
    public void exec(List<String> params) {
        StringBuilder message = new StringBuilder();
        if (params.get(0).toLowerCase().startsWith("com")) {
            CommandHandler.getCommands().forEach(com -> message.append(com.getName()).append(" "));
        } else if (params.get(0).toLowerCase().startsWith("mod")) {
            ModuleManager.getModules().forEach(mod -> message.append(mod.getEnabled() ? ChatFormatting.GREEN + mod.getName() + ChatFormatting.RESET : mod.getName()).append(" "));
        } else {
            return;
        }
        Log.info(message.toString(), true);
    }

}
