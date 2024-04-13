package com.archiecraft;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.Config;
import java.util.List;

public class configmanager {

    private static configmanager instance;
    private Config config;
    private List<String> enabledWorlds;
    private List<Integer> disabledBlocks;

    private configmanager() {}

    public static configmanager getInstance() {
        if (instance == null) {
            instance = new configmanager();
        }
        return instance;
    }

    public void loadConfig(PluginBase plugin) {
        plugin.saveResource("config.yml", false);
        config = new Config(plugin.getDataFolder() + "/config.yml", Config.YAML);
        enabledWorlds = config.getStringList("enabled-worlds");
        disabledBlocks = config.getIntegerList("disabled-blocks");
    }

    public List<String> getEnabledWorlds() {
        return enabledWorlds;
    }
    public List<Integer> getDisabledBlocks() {
        return disabledBlocks;
    }
}