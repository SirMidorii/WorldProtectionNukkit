package com.archiecraft.commands;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import com.archiecraft.worldprotection;

public class DisableCommand extends Command {
    public DisableCommand(){
        super("protection");
        this.setDescription("enable/disable world-protection");
        this.setAliases(new String[]{"prot"});
    }

    @Override
    public boolean execute(CommandSender commandSender, String s, String[] strings) {
        if (!commandSender.isPlayer()){
            return false;
        }
        worldprotection.isEnabled = !worldprotection.isEnabled;
        commandSender.sendMessage("§l§u[§pServer§eProtection§u]§r §7>>§o Server-protection is now set to " + worldprotection.isEnabled);
        return true;
    }
}