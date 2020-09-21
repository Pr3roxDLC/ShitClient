package me.pr3.shitclient.utils;

import me.pr3.shitclient.Main;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Logger logger = LogManager.getLogger();
    private static final String PREFIX = "[" + Main.MOD_ID.toUpperCase() + "] ";

    private static void log(Level level, String message) {
        logger.log(level, PREFIX + message);
    }

    public static void debug(String message) {
        log(Level.DEBUG, message);
    }

    public static void info(String message) {
        log(Level.INFO, message);
    }

    public static void warn(String message) {
        log(Level.WARN, message);
    }

    public static void error(String message) {
        log(Level.ERROR, message);
    }

}
