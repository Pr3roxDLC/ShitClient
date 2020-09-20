package me.pr3.shitclient.events;

import net.minecraftforge.fml.common.eventhandler.Event;


public class KeyPressEvent extends Event{
    private int keyID = 0;


    public int getKeyID() {
        return keyID;
    }

    public KeyPressEvent(int keyID){

        this.keyID = keyID;

        System.out.println("KeyID: " + keyID);

    }





}
