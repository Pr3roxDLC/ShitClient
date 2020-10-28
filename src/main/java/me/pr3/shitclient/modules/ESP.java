package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@SuppressWarnings("UnstableApiUsage")
public class ESP extends Module {

    public ESP() {
        super("ESP", false);

    }

    @Override
    protected void onDisable() {
        if (isInGame()) {
            for (Entity ent : mc.world.loadedEntityList) {
                ent.setGlowing(false);
            }
        }
    }

    @Subscribe
    public void onUpdate(TickEvent.ClientTickEvent e) {
        if (isInGame()) {
            for (Entity ent : mc.world.loadedEntityList) {
                ent.setGlowing(true);
            }
        }
    }

}
