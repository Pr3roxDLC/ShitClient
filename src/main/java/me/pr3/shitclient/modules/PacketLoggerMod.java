package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.pr3.shitclient.events.PacketEvent;
import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.Reflections;
import net.minecraft.network.Packet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@SuppressWarnings("UnstableApiUsage")
public class PacketLoggerMod extends Module {

    private static final Format format = Format.JSON;

    private static final Gson gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).setPrettyPrinting().create();

    private File logFile;

    public PacketLoggerMod() {
        setName("PacketLogger");
        setEnabled(true);
    }

    @Override
    public void onEnable() {
        logFile = new File(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS'.log'").format(new Date()));
        try {
            //noinspection ResultOfMethodCallIgnored
            logFile.createNewFile();
        } catch (IOException e) {
            Log.error("Error while creating file: " + logFile.getAbsolutePath());
            e.printStackTrace();
            setEnabled(false);
        }
    }

    @Subscribe
    public void onPacketIn(PacketEvent.In event) {
        logPacket(System.currentTimeMillis(), PacketData.Direction.IN, event.packet);
    }

    @Subscribe
    public void onPacketOut(PacketEvent.Out event) {
        logPacket(System.currentTimeMillis(), PacketData.Direction.OUT, event.packet);
    }

    private void logPacket(long timestamp, PacketData.Direction direction, Packet<?> packet) {
        PacketData data = new PacketData(timestamp, direction,
                packet.getClass().getTypeName(),
                Reflections.dumpFields(packet));
        String dump;
        if (format.equals(Format.JSON)) {
            dump = gson.toJson(data);
        } else {
            dump = data.toString();
        }
        Log.info(dump);
        try {
            Files.write(logFile.toPath(), dump.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            Log.error("Error while writing file: " + logFile.getAbsolutePath());
            e.printStackTrace();
            setEnabled(false);
        }
    }

    public enum Format {
        TXT, JSON
    }

    @SuppressWarnings("FieldCanBeLocal")
    public static class PacketData {

        private final long timestamp;
        private final Direction direction;
        private final String type;
        private final HashMap<String, String[]> fields;

        public PacketData(long timestamp, Direction direction, String type, HashMap<String, String[]> fields) {
            this.timestamp = timestamp;
            this.direction = direction;
            this.type = type;
            this.fields = fields;
        }

        @Override
        public String toString() {
            return timestamp + " | " + direction + " | " + type + " | " + fields.toString();
        }

        public enum Direction {
            IN, OUT
        }

    }

}
