package me.pr3.shitclient.modules;

import com.google.common.eventbus.Subscribe;
import net.minecraftforge.event.entity.living.LivingEvent;


@SuppressWarnings("UnstableApiUsage")
public class NameTags extends Module {

    public NameTags() {
        super("NameTags", false);
    }

    @Subscribe
    public void onLiving(LivingEvent e) {
        // e.getEntityLiving().setAlwaysRenderNameTag(true);
        // e.getEntityLiving().setCustomNameTag(e.getEntityLiving().getName()); }
    }

}
