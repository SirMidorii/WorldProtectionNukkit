package com.archiecraft.events;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.block.BlockBreakEvent;
import cn.nukkit.event.player.PlayerDropItemEvent;
import com.archiecraft.configmanager;
import com.archiecraft.worldprotection;

public class DropEvent implements Listener {
    @EventHandler
    public void onDrop(PlayerDropItemEvent event) {
        if (worldprotection.isEnabled == true) {
            String Worldname = event.getPlayer().getLevel().getName();

            if (configmanager.getInstance().getEnabledWorlds().contains(Worldname) && !configmanager.getInstance().getDisabledBlocks().contains(event.getItem().getId())) {
                event.setCancelled(true);
            }
        }
    }
}
