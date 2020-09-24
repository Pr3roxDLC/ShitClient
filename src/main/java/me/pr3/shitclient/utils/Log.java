package me.pr3.shitclient.utils;

import com.mojang.realmsclient.gui.ChatFormatting;
import me.pr3.shitclient.Main;
import net.minecraft.client.Minecraft;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.TextComponentString;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Minecraft mc = Minecraft.getMinecraft();
    private static final Logger logger = LogManager.getLogger(Main.MOD_ID);
    private static final String deco = "" + ChatFormatting.BOLD + ChatFormatting.DARK_RED + "SHIT -> " + ChatFormatting.RESET;

    public static void debug(String message) {
        debug(message, false);
    }

    public static void debug(String message, boolean chat) {
        log(Level.DEBUG, message);
        if (chat) {
            sendLocalChat(message);
        }
    }

    public static void info(String message) {
        info(message, false);
    }

    public static void info(String message, boolean chat) {
        log(Level.INFO, message);
        if (chat) {
            sendLocalChat(message);
        }
    }

    public static void warn(String message) {
        warn(message, false);
    }

    public static void warn(String message, boolean chat) {
        log(Level.WARN, message);
        if (chat) {
            sendLocalChat(message);
        }
    }

    public static void error(String message) {
        error(message, false);
    }

    public static void error(String message, boolean chat) {
        log(Level.ERROR, message);
        if (chat) {
            sendLocalChat(message);
        }
    }

    private static void log(Level level, String message) {
        logger.log(level, message);
    }

    private static void sendLocalChat(String message) {
        if (mc.player != null && mc.world != null) {
            mc.ingameGUI.addChatMessage(ChatType.CHAT, new TextComponentString(deco + message));
        }
    }

}
