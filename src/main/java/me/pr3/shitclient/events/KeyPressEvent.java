package me.pr3.shitclient.events;

import net.minecraftforge.fml.common.eventhandler.Event;


public class KeyPressEvent extends Event {

    private final int keyId;

    public KeyPressEvent(int keyId) {
        this.keyId = keyId;
    }

    public int getKeyId() {
        return keyId;
    }

}
