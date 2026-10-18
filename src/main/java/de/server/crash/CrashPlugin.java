package de.server.crash;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public final class CrashPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("CrashPlugin wurde aktiviert!");
    }

    @Override
    public boolean onCommand(
            CommandSender sender,
            Command command,
            String label,
            String[] args
    ) {
        if (!command.getName().equalsIgnoreCase("crash")) {
            return false;
        }

        if (!sender.hasPermission("crash.use")) {
            sender.sendMessage(
                ChatColor.RED + "Dafür hast du keine Berechtigung."
            );
            return true;
        }

        if (args.length != 1) {
            sender.sendMessage(
                ChatColor.YELLOW + "Benutzung: /crash <Spieler>"
            );
            return true;
        }

        Player target = Bukkit.getPlayerExact(args[0]);

        if (target == null || !target.isOnline()) {
            sender.sendMessage(
                ChatColor.RED + "Dieser Spieler ist nicht online."
            );
            return true;
        }

        target.kickPlayer(
            ChatColor.RED + "Du wurdest vom Server getrennt."
        );

        sender.sendMessage(
            ChatColor.GREEN + target.getName()
            + " wurde vom Server getrennt."
        );

        getLogger().info(
            sender.getName() + " hat " + target.getName()
            + " vom Server getrennt."
        );

        return true;
    }
}
