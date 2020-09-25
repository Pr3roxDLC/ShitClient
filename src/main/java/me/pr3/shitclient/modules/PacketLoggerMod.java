package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import me.pr3.shitclient.Main;
import me.pr3.shitclient.events.PacketEvent;
import me.pr3.shitclient.utils.Log;
import me.pr3.shitclient.utils.Reflections;
import net.minecraft.network.Packet;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@SuppressWarnings("UnstableApiUsage")
public class PacketLoggerMod extends Module {

    private File logFile;

    public PacketLoggerMod() {
        setName("PacketLogger");
        setEnabled(true);
    }

    @Override
    public void onEnable() {
        Path loggerDir = Paths.get(Main.clientDir + File.separator + "packetlogger");
        //noinspection ResultOfMethodCallIgnored
        loggerDir.toFile().mkdirs();
        logFile = loggerDir.resolve(new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS'.log'").format(new Date())).toFile();
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
                Reflections.dumpPacket(packet));
        try {
            Files.write(logFile.toPath(), (data.toString() + System.lineSeparator()).getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            Log.error("Error while writing file: " + logFile.getAbsolutePath());
            e.printStackTrace();
            setEnabled(false);
        }
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
            StringBuilder sb = new StringBuilder();
            sb.append(timestamp).append("|");
            sb.append(direction).append("|");
            sb.append(type);
            fields.forEach((k, v) -> sb.append("|").append(k).append(" ").append(v[0]).append(" ").append(v[1]));
            return sb.toString();
        }

        public enum Direction {
            IN, OUT
        }

    }

}
