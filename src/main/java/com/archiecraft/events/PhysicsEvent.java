package com.archiecraft.events;
import cn.nukkit.event.Listener;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.player.PlayerInteractEvent;
import com.archiecraft.configmanager;
import com.archiecraft.worldprotection;
public class PhysicsEvent implements Listener {
    @EventHandler
    public void onCrobDestroy (PlayerInteractEvent event){
        if(worldprotection.isEnabled == true) {
            String Worldname = event.getPlayer().getLevel().getName();
            if (event.getAction() == PlayerInteractEvent.Action.PHYSICAL && configmanager.getInstance().getEnabledWorlds().contains(Worldname)) {
                event.setCancelled(true);
            }
        }
    }
}
