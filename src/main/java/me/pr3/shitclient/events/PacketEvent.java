package me.pr3.shitclient.events;

import net.minecraft.network.Packet;
import net.minecraftforge.fml.common.eventhandler.Event;

public class PacketEvent extends Event {

    public Packet<?> packet;

    protected PacketEvent(Packet<?> packet) {
        this.packet = packet;
    }

    public static class In extends PacketEvent {
        public In(Packet<?> packet) {
            super(packet);
        }
    }

    public static class Out extends PacketEvent {
        public Out(Packet<?> packet) {
            super(packet);
        }
    }

}
