package me.pr3.shitClient.util;

import me.pr3.shitClient.Main;
import org.apache.logging.log4j.LogManager;

public class Logger {

    public static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger("ShitClient");

    public static void logInfo(String message) {
        LOG.info(message);
    }

    public static void logWarn(String message) {
        LOG.warn(message);
    }

    public static void logError(String message) {
        LOG.error(message);
    }

}
