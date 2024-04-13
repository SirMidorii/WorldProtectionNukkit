package com.archiecraft.events;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import com.archiecraft.configmanager;
import com.archiecraft.worldprotection;
public class BreakEvent implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent event) {
        if (worldprotection.isEnabled == true) {
            String Worldname = event.getBlock().getLevel().getName();

            if (configmanager.getInstance().getEnabledWorlds().contains(Worldname) && !configmanager.getInstance().getDisabledBlocks().contains(event.getBlock().getId())) {
                event.setCancelled(true);
            }
        }
    }
}
