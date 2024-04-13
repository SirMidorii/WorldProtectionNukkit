package com.archiecraft;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.utils.Config;
import cn.nukkit.utils.TextFormat;
import com.archiecraft.commands.DisableCommand;
import com.archiecraft.events.BreakEvent;
import com.archiecraft.events.DropEvent;
import com.archiecraft.events.PhysicsEvent;
import com.archiecraft.events.PlaceEvent;
public class worldprotection extends PluginBase {
    public static boolean isEnabled = true;
    @Override
    public void onLoad() {
        this.getLogger().info(TextFormat.WHITE + "I've been loaded!");
    }

    @Override
    public void onEnable() {
        this.getLogger().info(TextFormat.DARK_GREEN + "World Protection is now enabled!");
        this.registerCommands ();
        this.registerEvents();
        configmanager.getInstance().loadConfig(this);
    }

    @Override
    public void onDisable() {
        this.getLogger().info(TextFormat.DARK_RED + "World Protection is now disabled!");
    }
    private void registerCommands () {
       this.getServer().getCommandMap().register("protection", new DisableCommand());
    }
    private void registerEvents () {
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new BreakEvent(),this);
        pluginManager.registerEvents(new PhysicsEvent(),this);
        pluginManager.registerEvents(new PlaceEvent(),this);
        pluginManager.registerEvents(new DropEvent(),this);
    }

}